package sender.UIObject.FillingUI.WindowItems;

import com.vaadin.ui.*;

import sender.UIObject.FillingUI.DragFileUploadPanel.CreataRowAllDB;
import sender.UIObject.FillingUI.DragFileUploadPanel.UploadConfigeFileCSV;


public class UploadInfoWindow extends Window implements
        Upload.StartedListener, Upload.ProgressListener,
        Upload.FailedListener, Upload.SucceededListener,
        Upload.FinishedListener{

    private final Label state = new Label();
    private final Label result = new Label();
    private final Label fileName = new Label();
    private final Label textualProgress = new Label();

    private final ProgressBar progressBar = new ProgressBar();
    private final Button cancelButton;
    private final UploadConfigeFileCSV counter;

    protected UploadInfoWindow(final Upload upload, final UploadConfigeFileCSV lineBreakCounter){
        super("Status");
        this.counter = lineBreakCounter;

        setResizable(false);
        setDraggable(true);
        setClosable(false);

        addStyleName("upload-info");

        final FormLayout uploadInfoLayout = new FormLayout();
        setContent(uploadInfoLayout);
        uploadInfoLayout.setMargin(true);

        final HorizontalLayout stateLayout = new HorizontalLayout();
        stateLayout.setSpacing(true);
        stateLayout.addComponent(state);

        cancelButton = new Button("Отмена");
        cancelButton.addClickListener(event -> upload.interruptUpload());
        cancelButton.setVisible(false);
        cancelButton.setStyleName("small");
        stateLayout.addComponent(cancelButton);

        stateLayout.setCaption("Текущее состояние процесса загрузки");
        state.setValue("Idle");
        uploadInfoLayout.addComponent(stateLayout);

        fileName.setCaption("Имя файла");
        uploadInfoLayout.addComponent(fileName);

        result.setCaption("Line break counted");
        uploadInfoLayout.addComponent(result);

        progressBar.setCaption("Прогресс");
        progressBar.setVisible(false);
        uploadInfoLayout.addComponent(progressBar);

        textualProgress.setVisible(false);
        uploadInfoLayout.addComponent(textualProgress);

        upload.addStartedListener(this);
        upload.addProgressListener(this);
        upload.addFailedListener(this);
        upload.addSucceededListener(this);
        upload.addFinishedListener(this);

    }

    @Override
    public void uploadFailed(Upload.FailedEvent event) {
        result.setValue(counter.getLineBreakCount()
                + " ( couting interrupted at "
                + Math.round(100 * progressBar.getValue()) + "%)");
        setClosable(true);

    }

    @Override
    public void uploadFinished(Upload.FinishedEvent event) {
        state.setValue("Idle");
        progressBar.setVisible(false);
        textualProgress.setVisible(false);
        cancelButton.setVisible(false);
        counter.createRow(new CreataRowAllDB());
        setClosable(true);

    }

    @Override
    public void updateProgress(long readBytes, long contentLength) {
        progressBar.setValue(readBytes/(float) contentLength);
        textualProgress.setValue("Загруженно "+readBytes+ " байт из " + contentLength);
        result.setValue(counter.getLineBreakCount() + " (подсчет)");
    }

    @Override
    public void uploadStarted(Upload.StartedEvent event) {
        progressBar.setValue(0f);
        progressBar.setVisible(true);
        UI.getCurrent().setPollInterval(500);
        textualProgress.setVisible(true);
        state.setValue("Загрузка");
        fileName.setValue(event.getFilename());

        cancelButton.setVisible(true);
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent event) {
        result.setValue((counter.getLineBreakCount()+1) + " (всего)");

    }


}
