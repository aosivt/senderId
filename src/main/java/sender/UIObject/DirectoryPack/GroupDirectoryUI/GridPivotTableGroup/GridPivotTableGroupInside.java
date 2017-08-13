package sender.UIObject.DirectoryPack.GroupDirectoryUI.GridPivotTableGroup;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.components.grid.GridDragSource;
import com.vaadin.ui.renderers.TextRenderer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sender.Entity.PatternMessage;
import sender.Entity.PivotTable;
import sender.util.HibernateUtil;

import java.util.Collection;
import java.util.List;

public class GridPivotTableGroupInside extends Grid<PivotTable>{

    private Collection<PivotTable> pivotTables;

    private Long groupId;

    public GridPivotTableGroupInside(){}
    public GridPivotTableGroupInside(Long groupId){
//        setCaption("Для редактирования записи в таблице кликните мышкой два раза)))");
        setGroupId(groupId);
        setSizeFull();
        setSelectionMode(SelectionMode.NONE);
        setPivotTablesCollection();
        addColumn(PivotTable::getSnpStaffName, new TextRenderer())
//                .setEditorComponent(snpStaffName, PivotTable::setSnpStaffName)
                .setCaption("ФИО")
//                .setExpandRatio(2)
        ;
        addColumn(PivotTable::getTelephoneNumber, new TextRenderer())
//                .setEditorComponent(telephone, PivotTable::setTelephoneNumber)
                .setCaption("Телефон")
//                .setExpandRatio(2)
        ;

        setDataProvider(DataProvider.ofCollection(getPivotTablesCollection()));
    }

    public Collection<PivotTable> getPivotTablesCollection() {
        return pivotTables;
    }

    public void setPivotTablesCollection() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.
                createQuery(
                    "select PT From PivotTable PT inner join PT.groupPivotTable GPT " +
                        " inner join GPT.distributionGroups DG" +
                        " where DG.distributionId like :id"
                );
        query.setParameter("id", getGroupId());

        pivotTables = query.list();

        session.close();
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
