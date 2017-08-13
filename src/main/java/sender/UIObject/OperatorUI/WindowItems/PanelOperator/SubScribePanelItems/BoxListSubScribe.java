package sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubScribePanelItems;

import com.vaadin.ui.ComboBox;

import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sender.Entity.PivotTable;
import sender.Entity.SNPStaff;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubsribePanel;
import sender.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BoxListSubScribe extends ComboBox<SNPStaff> {

    public BoxListSubScribe(){
        setOptions();
    }


    private void setOptions(){


        setId("boxListSubScribe");
//        setTabIndex(1);
//        setItemCaptionGenerator(
//                p -> p.getStationId()
//        );
        setWidth(100.0f,Unit.PERCENTAGE);

        Session session = HibernateUtil.getSessionFactory().openSession();
        setItemCaptionGenerator(p -> p.getNameStaff());

        Query query = session.createQuery("From SNPStaff");

        List<SNPStaff> resultlist  = (List<SNPStaff>) query.list();

        setItems(resultlist);
        setItemCaptionGenerator(SNPStaff::getNameStaff);

        session.close();


        this.addValueChangeListener(e -> {
            if (e.getValue()!=null) {
                Notification.show("Добавленный абонент/группа:",
                        String.valueOf(e.getValue().getNameStaff()
                                + e.getValue().getStaffid())
                        , Notification.Type.TRAY_NOTIFICATION);
                ((SubsribePanel) ((VerticalLayout) getParent())
                        .getParent()).getListSubScribeSend()
                        .addNewRow(
                                e.getValue()
                                        .getPivot_tables()
                        );
            }

        }
        );

    }
}
