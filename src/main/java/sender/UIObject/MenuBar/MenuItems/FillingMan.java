package sender.UIObject.MenuBar.MenuItems;

import com.vaadin.ui.MenuBar;
import sender.UIObject.MenuBar.CommandMainMenu.*;

public class FillingMan {

    private MenuBar.MenuItem itemsMenu;
    private MenuBar.MenuItem directoryMenu;

    public FillingMan(MenuBar _mainMenu){

        itemsMenu = _mainMenu.addItem("Меню",null,null);
        itemsMenu.addItem("Оператор",null,new CommandOpenOperatorWindow());
        itemsMenu.addItem("Справочник",null,new CommandOpenFillengManWindow());

        directoryMenu = _mainMenu.addItem("Справочники",null,null);
        directoryMenu.addItem("Абоненты",null,new CommandOpenDirectoryPivotTable());
        directoryMenu.addItem("Группы",null,new CommandOpenGroupDirectoryWindow());
        directoryMenu.addItem("Шаблоны сообщения",null,new CommandOpenDirectoryPatternMessageWindow());

    }
}
