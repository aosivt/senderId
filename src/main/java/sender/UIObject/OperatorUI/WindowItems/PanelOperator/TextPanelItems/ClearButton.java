package sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import sender.UIObject.OperatorUI.WindowItems.FormGridLayout;

import java.util.ArrayList;

public class ClearButton extends Button{

    public ClearButton(){
        setOptions();
    }

    private void setOptions(){

        setCaption("Очистить поля");
        setId("clearButton");
        setTabIndex(1);
//        setItemCaptionGenerator(
//                p -> p.getStationId()
//        );
        setWidth(100.0f,Unit.PERCENTAGE);
//        setItems(GetFromRestStationsInfo.getReturnStationsInfo().getListReturnStationsInfo());
        addClickListener(this::eraseValueFromField);
    }
    private void eraseValueFromField(ClickEvent event){
        ((TextMessage)
                ((VerticalLayout)getParent()).getComponent(0)
        ).setValue("");
        ((FormGridLayout)getParent().getParent().getParent()).getSubsribePanel()
                .getListSubScribeSend().clear();
        ((FormGridLayout)getParent().getParent().getParent()).getSubsribePanel()
                .getListSubScribeSend().setItems(new ArrayList<>());
        ((FormGridLayout)getParent().getParent().getParent()).getSubsribePanel()
                .getListSubScribeSend().setPivotTables(new ArrayList<>());

        ((FormGridLayout)getParent().getParent().getParent()).getSubsribePanel()
                .getBoxListSubScribe().setValue(null);
    }
}
