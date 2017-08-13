package sender.UIObject.DirectoryPack.PatternMessageDirectoryUI;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;


public class GridLayoutPatternMessage extends GridLayout {

    private GridPatternMessage gridPatternMessage;


    public GridLayoutPatternMessage(){

        setOptionsLayout();
    }


    private void setOptionsLayout(){

        setSizeFull();
        setRows(3);
        setColumns(2);

        setGridPatternMessage(new GridPatternMessage());


        addComponent(getGridPatternMessage().getFilterTab(), 0,0);

        setRowExpandRatio(0,0.1f);

        addComponent(getGridPatternMessage().getAddTextPatternMessage(),    0,1);

        setRowExpandRatio(1,0.1f);

        addComponent(getGridPatternMessage(), 0,2);

        setRowExpandRatio(2,0.8f);

        addComponent(getGridPatternMessage().getTextAreaPatternMessage(), 1,0,1,2);

        setColumnExpandRatio(0,0.3f);
        setColumnExpandRatio(1,0.7f);
        setSpacing(true);

        for (int col=0; col<getColumns(); col++) {
            for (int row=0; row<getRows(); row++) {
                Component c = getComponent(col, row);
                setComponentAlignment(c, Alignment.TOP_CENTER);

            }
        }

    }

    public GridPatternMessage getGridPatternMessage() {
        return gridPatternMessage;
    }

    public void setGridPatternMessage(GridPatternMessage gridPatternMessage) {
        this.gridPatternMessage = gridPatternMessage;
    }


}
