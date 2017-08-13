package sender.UIObject.DirectoryPack;

import sender.UIObject.DirectoryPack.GroupDirectoryUI.GridLayoutGroup;
import sender.UIObject.FillingUI.WindowItems.FormGridLayoutFilling;
import sender.UIObject.WindowsUI;

public class WindowGroupDirectory extends WindowsUI {
    GridLayoutGroup gridLayoutGroup;
    public WindowGroupDirectory() {

        center();
        setCaption("Окно заполнения справочника групп абонентов");
        gridLayoutGroup = new GridLayoutGroup();
        setContent(gridLayoutGroup);

    }

}