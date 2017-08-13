package sender.UIObject.OperatorUI.WindowItems;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import sender.UIObject.DirectoryPack.PatternMessageDirectoryUI.GridPatternMessage;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubScribePanelItems.BoxListSubScribe;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubScribePanelItems.ListSubScribeSend;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.SubsribePanel;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanel;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems.ClearButton;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems.SendButton;
import sender.UIObject.OperatorUI.WindowItems.PanelOperator.TextPanelItems.TextMessage;
import sender.UIObject.OperatorUI.WindowOperator;

public class FormGridLayout extends GridLayout {

    private WindowOperator windowOperator;

    private SubsribePanel subsribePanel;
    private TextPanel textPanel;
    private GridPatternMessage gridPatternMessage;

    public FormGridLayout(){}

    public FormGridLayout(WindowOperator windowOperator){

        this.windowOperator = windowOperator;
        setOptionsLayout();

    }

    public WindowOperator getWindowOperator() {
        return windowOperator;
    }

    public void setWindowOperator(WindowOperator windowOperator) {
        this.windowOperator = windowOperator;
    }

    public SubsribePanel getSubsribePanel() {
        return subsribePanel;
    }

    public void setSubsribePanel(SubsribePanel subsribePanel) {
        this.subsribePanel = subsribePanel;
    }

    public TextPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }

    public GridPatternMessage getGridPatternMessage() {
        return gridPatternMessage;
    }

    public void setGridPatternMessage(GridPatternMessage gridPatternMessage) {
        this.gridPatternMessage = gridPatternMessage;
    }

    private void setOptionsLayout(){

        addStyleName("outlined");

        setSizeFull();
        setRows(3);
        setColumns(2);
        setSpacing(true);


        setSubsribePanel(new SubsribePanel());
        setTextPanel(new TextPanel());
        setGridPatternMessage(new GridPatternMessage());

        getGridPatternMessage().getColumns().get(1).setHidden(true);

        addComponent(getSubsribePanel(), 0,0);
        setRowExpandRatio(0,0.5f);
        addComponent(getTextPanel(),    1,0,1,2);
        addComponent(getGridPatternMessage().getFilterTab(),0,1);
        setRowExpandRatio(1,0.1f);
        addComponent(getGridPatternMessage(),0,2);
        setRowExpandRatio(2,0.3f);

        setColumnExpandRatio(0,0.4f);
        setColumnExpandRatio(1,0.6f);

        for (int col=0; col<getColumns(); col++) {
            for (int row=0; row<getRows(); row++) {
                Component c = getComponent(col, row);
                setComponentAlignment(c, Alignment.TOP_CENTER);

            }
        }

    }

}
