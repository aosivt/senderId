package sender.UIObject.DirectoryPack.GroupDirectoryUI.GridPivotTableGroup;

import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sender.Entity.DistributionGroups;
import sender.Entity.SNPStaff;
import sender.UIObject.DirectoryPack.GroupDirectoryUI.GridLayoutGroup;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubsribePanel;
import sender.util.HibernateUtil;

import java.util.List;

public class BoxListGroup extends ComboBox<DistributionGroups> {

    public BoxListGroup(){
        setOptions();
    }


    private void setOptions(){


        setId("boxListGroup");

        setWidth(100.0f,Unit.PERCENTAGE);

        Session session = HibernateUtil.getSessionFactory().openSession();
        setItemCaptionGenerator(p -> p.getNameDistribution());

        Query query = session.createQuery("From DistributionGroups DG order by DG desc");

        List<DistributionGroups> resultlist  = (List<DistributionGroups>) query.list();

        setItems(resultlist);
        setItemCaptionGenerator(DistributionGroups::getNameDistribution);

        session.close();


        this.addValueChangeListener(e -> {
            if (e.getValue()!=null) {
                Notification.show("Добавленая группа:",
                        String.valueOf(e.getValue().getDistributionId()
                                + "||" + e.getValue().getNameDistribution())
                        , Notification.Type.TRAY_NOTIFICATION);
                ((GridLayoutGroup)getParent()).getChosenGroup().setValue(e.getValue().getNameDistribution());
            }

        }
        );

    }
}
