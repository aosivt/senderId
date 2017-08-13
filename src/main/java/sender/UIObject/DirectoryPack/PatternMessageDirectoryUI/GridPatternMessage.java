package sender.UIObject.DirectoryPack.PatternMessageDirectoryUI;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.event.MouseEvents;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.*;
import com.vaadin.ui.renderers.ButtonRenderer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.hibernate.query.Query;
import sender.Entity.DistributionGroups;
import sender.Entity.PatternMessage;
import sender.UIObject.OperatorUI.WindowItems.FormGridLayout;
import sender.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.util.*;

public class GridPatternMessage extends Grid<PatternMessage> {

    private Collection<PatternMessage> patternMessages;
    private TextField filterTab;
    private Button addTextPatternMessage;
    private TextArea textAreaPatternMessage;
    private ListDataProvider<PatternMessage> patternMessageListDataProvider;
    private String titleTextArea = "Введите текст шаблона сообщения";

    private String messageName;
    private String messageText;

    public GridPatternMessage(){

        setOptions();

    }

    public void setOptions(){
        setSizeFull();
        setSelectionMode(SelectionMode.SINGLE);

        setPatternMessage();



        filterTab = new TextField();
        filterTab.setSizeFull();

        textAreaPatternMessage = new TextArea("Введите текст шаблона сообщения");
        textAreaPatternMessage.setSizeFull();
        textAreaPatternMessage.setHeight(100,Unit.PERCENTAGE);
        textAreaPatternMessage.setMaxLength(1000);


        textAreaPatternMessage.addValueChangeListener(valueChangeEvent -> {
            getAddTextPatternMessage().setCaption("Обновить шаблон");
            textAreaPatternMessage.setCaption(
                    titleTextArea +
                            " (Количество символов: "+
                            textAreaPatternMessage.getValue().length() +
                            ")"
            );
            if (textAreaPatternMessage.getValue().length()==0){
                textAreaPatternMessage.setCaption(
                        "Введите текст шаблона сообщения"
                );
            }
        });


        addTextPatternMessage = new Button("Добавить шаблон");
        addTextPatternMessage.setSizeFull();

        filterTab.setPlaceholder("Введите наименование шаблона");
        filterTab.addValueChangeListener(valueChangeEvent -> {
            patternMessageListDataProvider.setFilter(PatternMessage::getPatternMessageName,
                    name->{
                String nameLower = name == null ? ""
                        : name.toLowerCase(Locale.ENGLISH);
                String filterLower = valueChangeEvent.getValue()
                        .toLowerCase(Locale.ENGLISH);
                return nameLower.contains(filterLower);
                    });
        });

        filterTab.addShortcutListener(new ShortcutListener(
                "Execute", ShortcutAction.KeyCode.ENTER, null
                  ) {
                      @Override
                      public void handleAction(Object o, Object o1) {

                          if (addTextPatternMessage.getCaption().equals("Обновить шаблон")) {
                              createPatternMessage(((TextField) o1).getValue(), getTextAreaPatternMessage().getValue());
                          }
                          getFilterTab().setValue("");
                          getTextAreaPatternMessage().setValue("");
                          addTextPatternMessage.setCaption("Добавить шаблон");

                      }
                  }
        );

        addShortcutListener(new ShortcutListener("123", ShortcutAction.KeyCode.ENTER, new int[]{ShortcutAction.ModifierKey.CTRL}) {
            @Override
            public void handleAction(Object o, Object o1) {
                if (addTextPatternMessage.getCaption().equals("Обновить шаблон")) {
                    createPatternMessage(getFilterTab().getValue(), getTextAreaPatternMessage().getValue());
                }


                getFilterTab().setValue("");
                getTextAreaPatternMessage().setValue("");
                addTextPatternMessage.setCaption("Добавить шаблон");
            }
        });

        addTextPatternMessage.addClickListener(clickEvent -> {

            if (addTextPatternMessage.getCaption().equals("Обновить шаблон")) {
                String namePatternMessage = filterTab.getValue() == null ?
                        "" : filterTab.getValue();
                getFilterTab().setValue(namePatternMessage);

                String textPatternMessage = textAreaPatternMessage.getValue() == null ?
                        "" : textAreaPatternMessage.getValue();

                createPatternMessage(namePatternMessage, textPatternMessage);
            }




            getFilterTab().setValue("");
            getTextAreaPatternMessage().setValue("");
            addTextPatternMessage.setCaption("Добавить шаблон");
        });

        addSelectionListener(selectionEvent -> {

            PatternMessage patternMessage = selectionEvent.getFirstSelectedItem().get();

            String namePatternMessage = patternMessage.getPatternMessageName() == null ?
                    "":patternMessage.getPatternMessageName();

            getFilterTab().setValue(namePatternMessage);

            String textPatternMessage = patternMessage.getPatternMessageText() == null ?
                    "":patternMessage.getPatternMessageText();
            getTextAreaPatternMessage().setValue(textPatternMessage);



            fieldindValueFromWindowOperator();

            getAddTextPatternMessage().setCaption("<< Назад");

            patternMessage = null;
        });

        addColumn(colPatternMessage -> "X",
        getDeleteButton());


    }
    public TextField getFilterTab() {
        return filterTab;
    }

    private void createPatternMessage(String namePatternMessage, String textPatternMessage){

        textPatternMessage = textPatternMessage == null ? "":textPatternMessage;
        namePatternMessage = namePatternMessage == null ? "":namePatternMessage;

        if (namePatternMessage.equals(""))
        {

            Notification.show("Поле наименование шаблона не заполненно");

            return;
        }

        PatternMessage patternMessage = new PatternMessage();
        patternMessage.setPatternMessageName(namePatternMessage);
        patternMessage.setPatternMessageText(textPatternMessage);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        if ((patternMessage = checExistPatternMessage(patternMessage)) != null){
            patternMessage.setPatternMessageText(textPatternMessage);
            session.update(patternMessage);
//            session.merge(patternMessage);
            transaction.commit();
            session.clear();
            session.close();
            setPatternMessage();
            getAddTextPatternMessage().setCaption("Добавить шаблон");
            return;
        }

        patternMessage = new PatternMessage();
        patternMessage.setPatternMessageName(namePatternMessage);
        patternMessage.setPatternMessageText(textPatternMessage);

        session.save(patternMessage);

        transaction.commit();
        session.clear();
        session.close();

        setPatternMessage();
        getAddTextPatternMessage().setCaption("Добавить шаблон");
    }

    private void setPatternMessage() {
//        removeAllColumns();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From PatternMessage PM order by PM desc");

        patternMessages = (List<PatternMessage>) query.list();

        try{
            setItems(patternMessages);
        }catch (Exception e){
            clearSortOrder();
        }

        session.close();

        addColumn(PatternMessage::getPatternMessageName).setCaption("Наименование шаблона");
        patternMessageListDataProvider
                = DataProvider.ofCollection(patternMessages);
        setDataProvider(patternMessageListDataProvider);
    }

    public Collection<PatternMessage> getPatternMessages() {
        return patternMessages;
    }

    private void setPatternMessages(Collection<PatternMessage> patternMessages) {
        this.patternMessages = patternMessages;
    }

    private void setFilterTab(TextField filterTab) {
        this.filterTab = filterTab;
    }

    public Button getAddTextPatternMessage() {
        return addTextPatternMessage;
    }

    private void setAddTextPatternMessage(Button addTextPatternMessage) {
        this.addTextPatternMessage = addTextPatternMessage;
    }

    public ListDataProvider<PatternMessage> getPatternMessageListDataProvider() {
        return patternMessageListDataProvider;
    }

    private void setPatternMessageListDataProvider(ListDataProvider<PatternMessage> patternMessageListDataProvider) {
        this.patternMessageListDataProvider = patternMessageListDataProvider;
    }

    public TextArea getTextAreaPatternMessage() {
        return textAreaPatternMessage;
    }

    private void setTextAreaPatternMessage(TextArea textAreaPatternMessage) {
        this.textAreaPatternMessage = textAreaPatternMessage;
    }

    private PatternMessage checExistPatternMessage(PatternMessage _patternMessage){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.
                createQuery(
                    "From PatternMessage PM where PM.patternMessageName like :name"
                );
        query.setParameter("name",_patternMessage.getPatternMessageName());

        _patternMessage = query.getResultList().size()!=0?
                            (PatternMessage)query.getResultList().get(0):
                            null;
        session.close();

        return _patternMessage;
    }

    public void fieldindValueFromWindowOperator(){
        messageName = filterTab.getValue() == null ?
                "" : filterTab.getValue();


        messageText = textAreaPatternMessage.getValue() == null ?
                "" : textAreaPatternMessage.getValue();
        try{
            ((FormGridLayout)getParent()).getTextPanel().getTextMessage().setValue(getMessageText());
            getFilterTab().setValue("");
        }catch (Exception e){
            return;
        }
    }

    private void deletePatternMessageFromDB(PatternMessage patternMessage){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

            session.delete(patternMessage);

            transaction.commit();
            session.clear();
            session.close();
            setPatternMessage();
            return;
    }
    private ButtonRenderer getDeleteButton(){
        ButtonRenderer br = new ButtonRenderer<>(rendererClickEvent -> {
            getPatternMessages().remove(rendererClickEvent.getItem());
            deletePatternMessageFromDB((PatternMessage)rendererClickEvent.getItem());
            setItems(getPatternMessages());
        });

        return  br;
    }

    public String getMessageName() {
        return messageName;
    }

    private void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
