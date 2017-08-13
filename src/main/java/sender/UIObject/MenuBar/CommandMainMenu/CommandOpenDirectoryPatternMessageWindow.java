package sender.UIObject.MenuBar.CommandMainMenu;

import com.vaadin.ui.MenuBar;
import sender.MyUI;
import sender.UIObject.DirectoryPack.WindowPatternMessageDirectory;
import sender.UIObject.OperatorUI.WindowOperator;

public class CommandOpenDirectoryPatternMessageWindow implements MenuBar.Command {

    @Override
    public void menuSelected(MenuBar.MenuItem menuItem) {
        WindowPatternMessageDirectory windowPatternMessageDirectory
                = new WindowPatternMessageDirectory();
        windowPatternMessageDirectory.setDraggable(true);
        MyUI.getCurrent().addWindow(windowPatternMessageDirectory);
    }

}
