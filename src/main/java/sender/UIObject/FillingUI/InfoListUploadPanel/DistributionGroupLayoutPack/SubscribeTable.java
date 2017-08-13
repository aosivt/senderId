package sender.UIObject.FillingUI.InfoListUploadPanel.DistributionGroupLayoutPack;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sender.Entity.DistributionGroups;
import sender.Entity.PivotTable;
import sender.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class SubscribeTable extends Grid<PivotTable> {

    private Collection<PivotTable> subScribe;
    private TextField filterTab;
    public SubscribeTable(){
    setOptions();
    }

    public void setOptions(){
        setSizeFull();
        removeAllColumns();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From PivotTable");
        List<DistributionGroups> resultlist = new ArrayList<>();

        subScribe = (List<PivotTable>) query.list();
        setItems(subScribe);


        session.close();
        addColumn(PivotTable::getSnpStaff).setCaption("ФИО абонента");
        ListDataProvider<PivotTable> subScribeListDataProvider
                = DataProvider.ofCollection(subScribe);
        setDataProvider(subScribeListDataProvider);

        filterTab = new TextField("Фильтр таблици");
        filterTab.setPlaceholder("Введите ФИО абонента");
        filterTab.addValueChangeListener(valueChangeEvent -> {
            subScribeListDataProvider.setFilter(PivotTable::getSnpStaff,
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
