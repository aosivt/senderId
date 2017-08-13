package sender.UIObject.MenuBar.CommandMainMenu;

import com.vaadin.ui.MenuBar;
import sender.MyUI;
import sender.UIObject.DirectoryPack.WindowGroupDirectory;


public class CommandOpenGroupDirectoryWindow implements MenuBar.Command {

    @Override
    public void menuSelected(MenuBar.MenuItem menuItem) {
        WindowGroupDirectory windowGroupDirectory
                = new WindowGroupDirectory();
        windowGroupDirectory.setDraggable(true);
        MyUI.getCurrent().addWindow(windowGroupDirectory);
    }

}
