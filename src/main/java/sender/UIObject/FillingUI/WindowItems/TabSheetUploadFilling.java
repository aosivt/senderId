package sender.UIObject.FillingUI.WindowItems;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;
import sender.UIObject.FillingUI.DragFileUploadPanel.UploadConfigeFileCSV;
import sender.UIObject.FillingUI.InfoListUploadPanel.DistributionGroupLayout;

public class TabSheetUploadFilling extends TabSheet {

    public TabSheetUploadFilling(){
        setHeight(100f,Unit.PERCENTAGE);

        final Label tabLabelFile = new Label("Загружаемый справочник"
                , ContentMode.HTML);
        tabLabelFile.setWidth(100f,Unit.PERCENTAGE);

        final Label tabLabelInfo = new Label("Информация по загруженным справочникам"
                , ContentMode.HTML);
        tabLabelInfo.setWidth(100f,Unit.PERCENTAGE);

        final VerticalLayout layoutFile = new VerticalLayout(createUploader());


        final VerticalLayout layoutInfo = new VerticalLayout();
        final DistributionGroupLayout subscribeGroup = new DistributionGroupLayout();

        addTab(layoutFile,"Загружаемый справочник");
        addTab(subscribeGroup,"Сопоставление группы к абонентам");
        addTab(layoutInfo,"Информация по справочнику");
    }
    private Upload createUploader(){

        UploadConfigeFileCSV uploadConfigeFileCSV = new UploadConfigeFileCSV();
        uploadConfigeFileCSV.setSlow(true);

        Upload upload =
                new Upload("Загрузка предварительно сформированного файла csv",uploadConfigeFileCSV);
        upload.setImmediateMode(false);
        upload.setButtonCaption("Загрузка csv справочника");
        UploadInfoWindow uploadInfoWindow = new UploadInfoWindow(upload,uploadConfigeFileCSV);
        upload.addStartedListener(event -> {
            if(uploadInfoWindow.getParent() == null){
                UI.getCurrent().addWindow(uploadInfoWindow);
            }
            uploadInfoWindow.setClosable(false);
        });
        return upload;
    }

}
