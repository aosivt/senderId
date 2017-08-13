package sender.UIObject.FillingUI.InfoListUploadPanel.DistributionGroupLayoutPack;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sender.Entity.DistributionGroups;
import sender.Entity.GroupPivotTable;
import sender.Entity.PivotTable;
import sender.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class GroupSubscribeTable extends Grid<GroupPivotTable> {
    private Collection<GroupPivotTable> subScribe;
    private TextField filterTab;

    public GroupSubscribeTable(){
setOptions();
    }

    public void setOptions(){
        setSizeFull();
        removeAllColumns();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From PivotTable");


        subScribe = (List<GroupPivotTable>) query.list();
        setItems(subScribe);


        session.close();
        addColumn(GroupPivotTable::getPivotTable).setCaption("ФИО абонента");
        ListDataProvider<GroupPivotTable> subScribeListDataProvider
                = DataProvider.ofCollection(subScribe);
        setDataProvider(subScribeListDataProvider);

        filterTab = new TextField("Фильтр таблици");
        filterTab.setPlaceholder("Введите наименование группы");
        filterTab.addValueChangeListener(valueChangeEvent -> {
            subScribeListDataProvider.setFilter(GroupPivotTable::getPivotTable,
                    name->{
                        String nameLower = name.toString() == null ? ""
                                : name.toString().toLowerCase(Locale.ENGLISH);
                        String filterLower = valueChangeEvent.getValue()
                                .toLowerCase(Locale.ENGLISH);
                        return nameLower.contains(filterLower);
                    });
        });
        filterTab.setSizeFull();
    }
    public TextField getFilterTab() {
        return filterTab;
    }
}
