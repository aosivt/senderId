package sender.UIObject.DirectoryPack;

import sender.UIObject.DirectoryPack.PivotTabelDirectoryUI.GridLayoutPivotTable;
import sender.UIObject.DirectoryPack.PivotTabelDirectoryUI.GridPivotTable;

import sender.UIObject.WindowsUI;

public class WindowPivotTable extends WindowsUI {
    GridLayoutPivotTable gridLayoutPivotTable;
    public WindowPivotTable() {

        center();
        setSizeFull();
        setCaption("Окно заполнения справочника абонентов");
        gridLayoutPivotTable = new GridLayoutPivotTable();
        setContent(gridLayoutPivotTable);

    }

}