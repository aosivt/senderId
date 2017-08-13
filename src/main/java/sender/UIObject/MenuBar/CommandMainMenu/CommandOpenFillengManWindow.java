package sender.UIObject.MenuBar.CommandMainMenu;

import com.vaadin.ui.MenuBar;
import sender.MyUI;
import sender.UIObject.FillingUI.WindowFillingMan;
import sender.UIObject.OperatorUI.WindowOperator;

public class CommandOpenFillengManWindow implements MenuBar.Command {

    @Override
    public void menuSelected(MenuBar.MenuItem menuItem) {
        WindowFillingMan windowFillingManWindow= new WindowFillingMan();
        windowFillingManWindow.setDraggable(true);
        MyUI.getCurrent().getUI().getUI().addWindow(windowFillingManWindow);
    }
}