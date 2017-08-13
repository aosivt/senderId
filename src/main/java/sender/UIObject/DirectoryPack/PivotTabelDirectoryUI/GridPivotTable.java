package sender.UIObject.DirectoryPack.PivotTabelDirectoryUI;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.renderers.NumberRenderer;
import com.vaadin.ui.renderers.TextRenderer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sender.Entity.PatternMessage;
import sender.Entity.PivotTable;
import sender.Entity.SNPStaff;
import sender.util.HibernateUtil;

import java.awt.*;
import java.util.Collection;
import java.util.List;

public class GridPivotTable extends Grid<PivotTable> {

    private Collection<PivotTable> pivotTables;

    private TextField snpStaffName = new TextField();
    private TextField telephone = new TextField();
    private TextField email = new TextField();
    private TextField departments = new TextField();
    private TextField post = new TextField();

    public GridPivotTable(){
        setCaption("Для редактирования записи в таблице кликните мышкой два раза)))");
        setSizeFull();
        setSelectionMode(SelectionMode.NONE);
        setPivotTablesCollection();

        addColumn(PivotTable::getPivotTableid, new NumberRenderer("%02d"))
                .setCaption("id")
                .setExpandRatio(1);

        addColumn(PivotTable::getSnpStaffName, new TextRenderer())
                .setEditorComponent(snpStaffName, PivotTable::setSnpStaffName)
                .setCaption("ФИО")
                .setExpandRatio(2);

        addColumn(PivotTable::getTelephoneNumber, new TextRenderer())
                .setEditorComponent(telephone, PivotTable::setTelephoneNumber)
                .setCaption("Телефон")
                .setExpandRatio(2);

        addColumn(PivotTable::getEmailPostName, new TextRenderer())
                .setEditorComponent(email, PivotTable::setEmailPosts)
                .setCaption("E-mail")
                .setExpandRatio(2);

        addColumn(PivotTable::getDepartmentsName, new TextRenderer())
                .setEditorComponent(departments, PivotTable::setDepartmentsName)
                .setCaption("Организация")
                .setExpandRatio(2);

        addColumn(PivotTable::getPostName, new TextRenderer())
                .setEditorComponent(post, PivotTable::setPostsName)
                .setCaption("Должность")
                .setExpandRatio(2);

        getEditor().setEnabled(true);

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
}
