package sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems;

import com.vaadin.server.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sender.Entity.SMSSending;
import sender.MyUI;
import sender.UIObject.OperatorUI.WindowItems.FormGridLayout;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubsribePanel;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanel;
import sender.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;

public class SendButton extends Button{

    public SendButton(){
        setOptions();
    }


    private void setOptions(){

        setCaption("Отправить");
        setId("sendButton");
        setTabIndex(1);
        addClickListener(this::sendMesage);
        setWidth(100.0f, Sizeable.Unit.PERCENTAGE);

    }

    private void sendMesage(ClickEvent event){
        ((FormGridLayout)getParent().getParent().getParent()).getSubsribePanel()
                .getListSubScribeSend()
                .getPivotTables().stream().forEach(pivotTable ->
        {
            SMSSending smsSending = new SMSSending();
            smsSending.setDateSend(new Date());
            smsSending.setTextMessage(
                    ((TextMessage)
                            ((VerticalLayout)getParent()).getComponent(0)
                    ).getValue()
            );
            smsSending.setPivotTable(pivotTable);
            saveSendingMessage(smsSending);
            ((MyUI)UI.getCurrent()).getTableSend().addSmsSending(smsSending);

            com.vaadin.ui.JavaScript.getCurrent().execute("testSend('" +
                            pivotTable.getTelephone() + " - " +
                            ((TextMessage)
                                    ((VerticalLayout)getParent()).getComponent(0)
                            ).getValue() + "');");
        });
        ((FormGridLayout)getParent().getParent().getParent()).getSubsribePanel()
                .getListSubScribeSend().setItems(new ArrayList<>());
        ((FormGridLayout)getParent().getParent().getParent()).getSubsribePanel()
                .getListSubScribeSend().setPivotTables(new ArrayList<>());

        ((FormGridLayout)getParent().getParent().getParent()).getSubsribePanel()
                .getBoxListSubScribe().setValue(null);


        ((TextMessage)
                ((VerticalLayout)getParent()).getComponent(0)
        ).setValue("");


    }
    private void saveSendingMessage(SMSSending smsSending){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(smsSending);
        transaction.commit();
        session.clear();
        session.close();
//        org.hsqldb.DatabaseManager.closeDatabases(0);
    }
}
