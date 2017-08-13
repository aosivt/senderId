package sender.UIObject.OperatorUI;

import sender.UIObject.OperatorUI.WindowItems.FormGridLayout;
import sender.UIObject.WindowsUI;

public class WindowOperator extends WindowsUI {

    private FormGridLayout operatorLayout;

    public WindowOperator() {
        setOptions();

    }

    public FormGridLayout getOperatorLayout() {
        return operatorLayout;
    }

    public void setOperatorLayout(FormGridLayout operatorLayout) {
        this.operatorLayout = operatorLayout;
    }

    private void setOptions(){

        setCaption("Оператор");
        setOperatorLayout(new FormGridLayout(this));
        setContent(getOperatorLayout());

    }


}