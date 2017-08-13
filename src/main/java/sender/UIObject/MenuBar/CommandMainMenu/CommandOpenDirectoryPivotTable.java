package sender.UIObject.MenuBar.CommandMainMenu;

import com.vaadin.ui.MenuBar;
import sender.MyUI;
import sender.UIObject.DirectoryPack.WindowPatternMessageDirectory;
import sender.UIObject.DirectoryPack.WindowPivotTable;

public class CommandOpenDirectoryPivotTable implements MenuBar.Command {

    @Override
    public void menuSelected(MenuBar.MenuItem menuItem) {
        WindowPivotTable windowPivotTable
                = new WindowPivotTable ();
        windowPivotTable.setDraggable(true);
        MyUI.getCurrent().addWindow(windowPivotTable);
    }

}
