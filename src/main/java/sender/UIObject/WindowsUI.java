package sender.UIObject;

import com.vaadin.ui.Window;

public abstract class WindowsUI extends Window{

    public WindowsUI(){
        this.setOptions();
    }
    private void setOptions()
    {
        this.setDraggable(true);
        this.setResizable(false);
        this.setClosable(true);
        this.setWidth(1000.0f, Unit.PIXELS);
        this.setHeight(520.0f, Unit.PIXELS);
    }
}
