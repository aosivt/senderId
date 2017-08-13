package sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubScribePanelItems;

import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Notification;
import sender.Entity.PivotTable;
import sender.UIObject.FillingUI.InfoListUploadPanel.InfoListPatternMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListSubScribeSend extends ListSelect<PivotTable>{

    private List<PivotTable> pivotTables;
    public ListSubScribeSend(){
        setOptions();
    }

    public ListSubScribeSend(InfoListPatternMessage patternMessage){

    }


    public void addNewRow(List<PivotTable> pivotTables){
        this.pivotTables.addAll(pivotTables);
        reloadDataList();
    }
    private void reloadDataList(){
        clear();
//        getPivotTables().stream().
//        setData(getPivotTables());
        setItems(getPivotTables());

    }
    private void setOptions(){

        setHeight(100,Unit.PERCENTAGE);
        setWidth(100.0f,Unit.PERCENTAGE);
        setId("listSubScribeSend");
        setTabIndex(1);

        setPivotTables(new ArrayList<PivotTable>());
        addContextClickListener(event -> {

            if(event.isDoubleClick()){
                Notification.show("Добавленный абонент/группа:",

                        Notification.Type.TRAY_NOTIFICATION);
            }
        });
        addValueChangeListener(event ->{

            event.getValue().stream().forEach(t ->
                    Notification.show("Добавленный абонент/группа:",

                            String.valueOf(
                                    t
                                            .getSnpStaff().getNameStaff())
                            ,Notification.Type.TRAY_NOTIFICATION)

            );

                }

            );

    }

    public List<PivotTable> getPivotTables() {
        return pivotTables;
    }

    public void setPivotTables(List<PivotTable> pivotTables) {
        this.pivotTables = pivotTables;
    }
}
