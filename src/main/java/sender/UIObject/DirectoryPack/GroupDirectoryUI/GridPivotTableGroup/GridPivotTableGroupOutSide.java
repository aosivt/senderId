package sender.UIObject.DirectoryPack.GroupDirectoryUI.GridPivotTableGroup;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.renderers.TextRenderer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sender.Entity.PivotTable;
import sender.util.HibernateUtil;

import java.util.Collection;

public class GridPivotTableGroupOutSide extends Grid<PivotTable> {
    private Collection<PivotTable> pivotTables;

    private String groupId;
    public GridPivotTableGroupOutSide(){

    }
    private void setPatternMessage() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From PivotTable PM order by PT desc");

        pivotTables = query.list();


        session.close();
        addColumn(PivotTable::getSnpStaffName, new TextRenderer())
//                .setEditorComponent(snpStaffName, PivotTable::setSnpStaffName)
                .setCaption("ФИО")
                .setExpandRatio(2);

        addColumn(PivotTable::getTelephoneNumber, new TextRenderer())
//                .setEditorComponent(telephone, PivotTable::setTelephoneNumber)
                .setCaption("Телефон")
                .setExpandRatio(2);

        setDataProvider(DataProvider.ofCollection(getPivotTablesCollection()));

    }
    public Collection<PivotTable> getPivotTablesCollection() {
        return pivotTables;
    }

    public void setPivotTablesCollection() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From PivotTable PM order by PM desc");

        pivotTables = query.list();

        session.close();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
