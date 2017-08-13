package sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems;

import com.vaadin.ui.RichTextArea;

public class TextMessage extends RichTextArea {

    public TextMessage(){
        setOptions();
    }

    private void setOptions(){
        setSizeFull();
        setHeight(100,Unit.PERCENTAGE);
    }
}
