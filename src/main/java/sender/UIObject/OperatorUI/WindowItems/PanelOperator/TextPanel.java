package sender.UIObject.OperatorUI.WindowItems.PanelOperator;

import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems.ClearButton;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems.SendButton;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems.TextMessage;

public class TextPanel extends Panel {
    private ClearButton clearButton;
    private SendButton sendButton;
    private TextMessage textMessage;

    public TextPanel(){
        setOptions();
    }

    public ClearButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(ClearButton clearButton) {
        this.clearButton = clearButton;
    }

    public SendButton getSendButton() {
        return sendButton;
    }

    public void setSendButton(SendButton sendButton) {
        this.sendButton = sendButton;
    }

    public TextMessage getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(TextMessage textMessage) {
        this.textMessage = textMessage;
    }

    private void setOptions(){

        setCaption("Текст сообщения");
        setHeight(100,Unit.PERCENTAGE);
        VerticalLayout componentsPanel = new VerticalLayout();

        setClearButton(new ClearButton());
        setSendButton(new SendButton());
        setTextMessage(new TextMessage());

        componentsPanel.addComponent(getTextMessage());
        componentsPanel.addComponent(getClearButton());
        componentsPanel.addComponent(getSendButton());
        setContent(componentsPanel);
    }
}
