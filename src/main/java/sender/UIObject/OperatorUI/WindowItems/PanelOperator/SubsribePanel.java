package sender.UIObject.OperatorUI.WindowItems.PanelOperator;

import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubScribePanelItems.BoxListSubScribe;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubScribePanelItems.ListSubScribeSend;



public class SubsribePanel extends Panel {

    private BoxListSubScribe boxListSubScribe;
    private ListSubScribeSend listSubScribeSend;


    public SubsribePanel(){

        setOptions();
    }


    public BoxListSubScribe getBoxListSubScribe() {
        return boxListSubScribe;
    }

    private void setBoxListSubScribe(BoxListSubScribe boxListSubScribe) {
        this.boxListSubScribe = boxListSubScribe;
    }

    public ListSubScribeSend getListSubScribeSend() {
        return listSubScribeSend;
    }

    private void setListSubScribeSend(ListSubScribeSend listSubScribeSend) {
        this.listSubScribeSend = listSubScribeSend;
    }

    private void setOptions(){

        setCaption("Абоненты на отправку сообщения");
        setHeight(100,Unit.PERCENTAGE);
        VerticalLayout componentsPanel = new VerticalLayout();

        setBoxListSubScribe(new BoxListSubScribe());
        setListSubScribeSend(new ListSubScribeSend());

        componentsPanel.addComponent(getBoxListSubScribe());
        componentsPanel.addComponent(getListSubScribeSend());
        setContent(componentsPanel);
    }
}
