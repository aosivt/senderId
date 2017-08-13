package sender.UIObject.DirectoryPack.GroupDirectoryUI;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import sender.Entity.DistributionGroups;
import sender.Entity.PivotTable;
import sender.UIObject.DirectoryPack.GroupDirectoryUI.GridPivotTableGroup.BoxListGroup;
import sender.UIObject.DirectoryPack.GroupDirectoryUI.GridPivotTableGroup.GridPivotTableGroupInside;
import sender.UIObject.DirectoryPack.GroupDirectoryUI.GridPivotTableGroup.GridPivotTableGroupOutSide;
import sender.UIObject.DirectoryPack.PivotTabelDirectoryUI.GridPivotTable;

import java.util.Collection;

public class GridLayoutGroup extends GridLayout {
    private GridPivotTableGroupInside gridPivotTableGroupInside;
    private GridPivotTableGroupOutSide gridPivotTableGroupOutSide;


    private BoxListGroup boxListGroup;
    private Label chosenGroup = new Label();

    /*Entity*/
    private DistributionGroups groups;
    private Collection<PivotTable> pivotTablesInside;
    private Collection<PivotTable> pivotTablesOutSide;

    public GridLayoutGroup(){

        setOptionsLayout();
    }


    private void setOptionsLayout(){

        setSizeFull();
        setRows(4);
        setColumns(2);


        setBoxListGroup(new BoxListGroup());
        setGridPivotTableGroupInside(new GridPivotTableGroupInside(1l));
        setGridPivotTableGroupOutSide(new GridPivotTableGroupOutSide());

        addComponent(getBoxListGroup(),0,0);
        addComponent(getChosenGroup(),0,1);
        addComponent(getGridPivotTableGroupInside(), 0,2,0,3);
        addComponent(getGridPivotTableGroupOutSide(), 1,2,1,3);

//        setRowExpandRatio(0,0.1f);

//        setColumnExpandRatio(0,0.3f);
//        setColumnExpandRatio(1,0.7f);
        setSpacing(true);

//        for (int col=0; col<getColumns(); col++) {
//            for (int row=0; row<getRows(); row++) {
//                Component c = getComponent(col, row);
//                setComponentAlignment(c, Alignment.TOP_CENTER);
//
//            }
//        }

    }

    public GridPivotTableGroupInside getGridPivotTableGroupInside() {
        return gridPivotTableGroupInside;
    }

    public void setGridPivotTableGroupInside(GridPivotTableGroupInside gridPivotTableGroupInside) {
        this.gridPivotTableGroupInside = gridPivotTableGroupInside;
    }

    public GridPivotTableGroupOutSide getGridPivotTableGroupOutSide() {
        return gridPivotTableGroupOutSide;
    }

    public void setGridPivotTableGroupOutSide(GridPivotTableGroupOutSide gridPivotTableGroupOutSide) {
        this.gridPivotTableGroupOutSide = gridPivotTableGroupOutSide;
    }

    public BoxListGroup getBoxListGroup() {
        return boxListGroup;
    }

    public void setBoxListGroup(BoxListGroup boxListGroup) {
        this.boxListGroup = boxListGroup;
    }

    public Label getChosenGroup() {
        return chosenGroup;
    }
}
