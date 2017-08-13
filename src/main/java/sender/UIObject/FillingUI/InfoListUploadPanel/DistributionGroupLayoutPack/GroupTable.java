package sender.UIObject.FillingUI.InfoListUploadPanel.DistributionGroupLayoutPack;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sender.Entity.DistributionGroups;
import sender.Entity.SMSSending;
import sender.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import static com.vaadin.event.ShortcutAction.KeyCode.ENTER;

public class GroupTable extends Grid<DistributionGroups> {

    private Collection<DistributionGroups> distributionGroups;
    private TextField filterTab;
    ListDataProvider<DistributionGroups> distributionGroupsListDataProvider;
    public GroupTable(){

        setOptions();
    }

    public void setOptions(){
        setSizeFull();


        setDistributionGroups();



        filterTab = new TextField("Фильтр таблици");
        filterTab.setPlaceholder("Введите наименование группы");
        filterTab.addValueChangeListener(valueChangeEvent -> {
            distributionGroupsListDataProvider.setFilter(DistributionGroups::getNameDistribution,
                    name->{
                String nameLower = name == null ? ""
                        : name.toLowerCase(Locale.ENGLISH);
                String filterLower = valueChangeEvent.getValue()
                        .toLowerCase(Locale.ENGLISH);
                return nameLower.contains(filterLower);
                    });
        });
        filterTab.setSizeFull();
        filterTab.addShortcutListener(new ShortcutListener(
                "Execute", ShortcutAction.KeyCode.ENTER, null
                  ) {
                      @Override
                      public void handleAction(Object o, Object o1) {
                          Notification.show(o.toString() + o1.toString());
                          createSubscribeGroup(((TextField)o1).getValue());

                      }
                  }
        );
    }
    public TextField getFilterTab() {
        return filterTab;
    }

    private void createSubscribeGroup(String nameSubscribeGroup){
        Session session = HibernateUtil.getSessionFactory().openSession();

        DistributionGroups distributionGroups = new DistributionGroups();
        distributionGroups.setNameDistribution(nameSubscribeGroup);

        Transaction transaction = session.beginTransaction();
        session.save(distributionGroups);

        transaction.commit();
        session.clear();
        session.close();

        setDistributionGroups();
    }

    public Collection<DistributionGroups> getDistributionGroups() {
        return distributionGroups;
    }

    private void setDistributionGroups() {
        removeAllColumns();
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From DistributionGroups");
        List<DistributionGroups> resultlist = new ArrayList<>();

        distributionGroups = (List<DistributionGroups>) query.list();
        setItems(resultlist);

        session.close();

        addColumn(DistributionGroups::getNameDistribution).setCaption("Наименование группы");
        distributionGroupsListDataProvider
                = DataProvider.ofCollection(distributionGroups);
        setDataProvider(distributionGroupsListDataProvider);
    }
}
