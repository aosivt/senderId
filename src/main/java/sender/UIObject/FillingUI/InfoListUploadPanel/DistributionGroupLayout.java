package sender.UIObject.FillingUI.InfoListUploadPanel;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import sender.UIObject.FillingUI.InfoListUploadPanel.DistributionGroupLayoutPack.GroupSubscribeTable;
import sender.UIObject.FillingUI.InfoListUploadPanel.DistributionGroupLayoutPack.GroupTable;
import sender.UIObject.FillingUI.InfoListUploadPanel.DistributionGroupLayoutPack.SubscribeTable;


public class DistributionGroupLayout extends GridLayout {

    private SubscribeTable subsribePanel;
    private GroupTable groupTable;
    private GroupSubscribeTable groupSubscribeTable;

    public DistributionGroupLayout(){

        setOptionsLayout();
    }


    private void setOptionsLayout(){

        addStyleName("outlined");
        setWidth(1000.0f, Unit.PIXELS);
        setSizeFull();
        setRows(2);
        setColumns(3);

        setGroupSubscribeTable(new GroupSubscribeTable());
        setGroupTable(new GroupTable());
        setSubsribePanel(new SubscribeTable());

        addComponent(getSubsribePanel().getFilterTab(), 0,0);
        addComponent(getGroupTable().getFilterTab(),    1,0);
        addComponent(getGroupSubscribeTable().getFilterTab(),    2,0);

        addComponent(getSubsribePanel(), 0,1);
        addComponent(getGroupTable(),    1,1);
        addComponent(getGroupSubscribeTable(),    2,1);


        for (int col=0; col<getColumns(); col++) {
            for (int row=0; row<getRows(); row++) {
                Component c = getComponent(col, row);
                setComponentAlignment(c, Alignment.TOP_CENTER);

            }
        }

    }

    public SubscribeTable getSubsribePanel() {
        return subsribePanel;
    }

    public void setSubsribePanel(SubscribeTable subsribePanel) {
        this.subsribePanel = subsribePanel;
    }

    public GroupTable getGroupTable() {
        return groupTable;
    }

    public void setGroupTable(GroupTable groupTable) {
        this.groupTable = groupTable;
    }

    public GroupSubscribeTable getGroupSubscribeTable() {
        return groupSubscribeTable;
    }

    public void setGroupSubscribeTable(GroupSubscribeTable groupSubscribeTable) {
        this.groupSubscribeTable = groupSubscribeTable;
    }
}
