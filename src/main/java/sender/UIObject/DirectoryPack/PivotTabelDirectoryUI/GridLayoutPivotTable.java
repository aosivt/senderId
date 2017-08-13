package sender.UIObject.DirectoryPack.PivotTabelDirectoryUI;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import sender.UIObject.DirectoryPack.PatternMessageDirectoryUI.GridPatternMessage;

public class GridLayoutPivotTable extends GridLayout {
    private GridPivotTable gridPivotTable;


    public GridLayoutPivotTable(){

        setOptionsLayout();
    }


    private void setOptionsLayout(){

        setSizeFull();
        setRows(3);
        setColumns(1);

        setGridPivotTable(new GridPivotTable());


        addComponent(getGridPivotTable(), 0,0,0,2);

//        setRowExpandRatio(0,0.1f);

//        setColumnExpandRatio(0,0.3f);
//        setColumnExpandRatio(1,0.7f);
        setSpacing(true);

        for (int col=0; col<getColumns(); col++) {
            for (int row=0; row<getRows(); row++) {
                Component c = getComponent(col, row);
                setComponentAlignment(c, Alignment.TOP_CENTER);

            }
        }

    }

    public GridPivotTable getGridPivotTable() {
        return gridPivotTable;
    }

    public void setGridPivotTable(GridPivotTable gridPivotTable) {
        this.gridPivotTable = gridPivotTable;
    }
}
