package sender.UIObject.DirectoryPack;

import sender.UIObject.DirectoryPack.PatternMessageDirectoryUI.GridLayoutPatternMessage;
import sender.UIObject.FillingUI.WindowItems.FormGridLayoutFilling;
import sender.UIObject.WindowsUI;

public class WindowPatternMessageDirectory extends WindowsUI {
    GridLayoutPatternMessage gridLayoutPatternMessage;
    public WindowPatternMessageDirectory() {

        setCaption("Окно заполнения справочника шаблоно сообщения");
        center();
        gridLayoutPatternMessage = new GridLayoutPatternMessage();
        setContent(gridLayoutPatternMessage);

    }

}