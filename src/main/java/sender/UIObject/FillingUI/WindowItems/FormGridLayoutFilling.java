package sender.UIObject.FillingUI.WindowItems;

import com.vaadin.ui.GridLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import sender.UIObject.FillingUI.DragFileUploadPanel.UploadConfigeFileCSV;

public class FormGridLayoutFilling extends GridLayout {

    public FormGridLayoutFilling(){

        addComponent(new TabSheetUploadFilling());

    }
}
