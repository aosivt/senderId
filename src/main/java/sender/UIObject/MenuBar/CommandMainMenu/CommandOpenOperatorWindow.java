package sender.UIObject.MenuBar.CommandMainMenu;

import com.vaadin.ui.MenuBar;
import sender.MyUI;
import sender.UIObject.OperatorUI.WindowOperator;

public class CommandOpenOperatorWindow implements MenuBar.Command {

    @Override
    public void menuSelected(MenuBar.MenuItem menuItem) {
        WindowOperator windowOperator = new WindowOperator();
        windowOperator.setDraggable(true);
        MyUI.getCurrent().getUI().getUI().addWindow(windowOperator);
    }

}
