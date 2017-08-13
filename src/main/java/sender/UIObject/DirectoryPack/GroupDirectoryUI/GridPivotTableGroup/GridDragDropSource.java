package sender.UIObject.DirectoryPack.GroupDirectoryUI.GridPivotTableGroup;

import com.vaadin.shared.ui.dnd.DropEffect;

import com.vaadin.shared.ui.dnd.EffectAllowed;
import com.vaadin.shared.ui.grid.DropLocation;
import com.vaadin.shared.ui.grid.DropMode;
import com.vaadin.ui.Grid;
import com.vaadin.ui.components.grid.GridDragSource;
import com.vaadin.ui.components.grid.GridDropTarget;
import sender.Entity.PivotTable;


import java.util.Collection;
import java.util.List;
import java.util.Set;

public class GridDragDropSource {
    private GridPivotTableGroupOutSide gridPivotTableGroupOutSideLeft;
    private GridPivotTableGroupInside gridPivotTableGroupInsideRight;
    private List<PivotTable> pivotTableCollectionOutSideLeft;
    private List<PivotTable> pivotTableCollectionInsideRight;

    private Set<PivotTable> draggedItems;


    public GridDragDropSource(){}
    public GridDragDropSource(
            GridPivotTableGroupOutSide gridPivotTableGroupOutSideLeft,
            GridPivotTableGroupInside gridPivotTableGroupInsideRight,
            List<PivotTable> pivotTableCollectionOutSideLeft,
            Collection<PivotTable> pivotTableCollectionInsideRight
    ){

        GridDragSource<PivotTable> pivotTableGridDragSource =
                addDragSourceExtension(
                  gridPivotTableGroupOutSideLeft,
                        pivotTableCollectionOutSideLeft
                );

    }

    public GridDragSource<PivotTable> addDragSourceExtension(
            Grid<PivotTable> pivotTableGrid,
            List<PivotTable> pivotTableCollection){
                GridDragSource<PivotTable> pivotTableGridDragSource =
                        new GridDragSource<>(pivotTableGrid);

            pivotTableGridDragSource.setEffectAllowed(EffectAllowed.MOVE);

            pivotTableGridDragSource.addGridDragStartListener(event->{
//                event.getDraggedItems();
//                pivotTableGridDragSource =
            });

            pivotTableGridDragSource.addGridDragEndListener(event->{
               if (event.getDropEffect() == DropEffect.MOVE){
//                   if (dragedGrid == null)
//                   {}
//                   pivotTableCollection.removeAll(dragedItems);
                   pivotTableGrid.getDataProvider().refreshAll();

//                   dragedItems = null
//                   draggedGrid = null
               }

            });

                return pivotTableGridDragSource;
    }

    public GridDropTarget<PivotTable> addDropTargetExtension(
            Grid<PivotTable> pivotTableGrid,DropMode dropMode,
            List<PivotTable> pivotTableCollection
    ){
        GridDropTarget<PivotTable> pivotTableGridDropTarget =
                new GridDropTarget<>(pivotTableGrid,dropMode);

        pivotTableGridDropTarget.setDropEffect(DropEffect.MOVE);
        pivotTableGridDropTarget.addGridDropListener(event->{
            int index = pivotTableCollection.size();
            if (event.getDropTargetRow().isPresent()){
                index = pivotTableCollection.indexOf(
                        event.getDropTargetRow().get())+
                        (event.getDropLocation() == DropLocation.BELOW ? 1
                                :0);
            }

//            if (draggedItems == pivotTableGrid){
//                final  int finalIndex = index;
//
//                int offset = (int) draggedItems.stream
//            }else{
//              items.addAll(index,draggedItems)}
        });

        pivotTableGrid.getDataProvider().refreshAll();
                return pivotTableGridDropTarget;
    }

    public GridPivotTableGroupOutSide getGridPivotTableGroupOutSideLeft() {
        return gridPivotTableGroupOutSideLeft;
    }

    public void setGridPivotTableGroupOutSideLeft(GridPivotTableGroupOutSide gridPivotTableGroupOutSideLeft) {
        this.gridPivotTableGroupOutSideLeft = gridPivotTableGroupOutSideLeft;
    }

    public GridPivotTableGroupInside getGridPivotTableGroupInsideRight() {
        return gridPivotTableGroupInsideRight;
    }

    public void setGridPivotTableGroupInsideRight(GridPivotTableGroupInside gridPivotTableGroupInsideRight) {
        this.gridPivotTableGroupInsideRight = gridPivotTableGroupInsideRight;
    }

    public List<PivotTable> getPivotTableCollectionOutSideLeft() {
        return pivotTableCollectionOutSideLeft;
    }

    public void setPivotTableCollectionOutSideLeft(List<PivotTable> pivotTableCollectionOutSideLeft) {
        this.pivotTableCollectionOutSideLeft = pivotTableCollectionOutSideLeft;
    }

    public List<PivotTable> getPivotTableCollectionInsideRight() {
        return pivotTableCollectionInsideRight;
    }

    public void setPivotTableCollectionInsideRight(List<PivotTable> pivotTableCollectionInsideRight) {
        this.pivotTableCollectionInsideRight = pivotTableCollectionInsideRight;
    }
}
