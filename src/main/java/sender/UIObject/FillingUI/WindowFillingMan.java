package sender.UIObject.FillingUI;

import sender.UIObject.FillingUI.WindowItems.FormGridLayoutFilling;
import sender.UIObject.WindowsUI;

public class WindowFillingMan extends WindowsUI {
    FormGridLayoutFilling formGridLayoutFilling;
    public WindowFillingMan() {

        setCaption("Окно заполнения справочника");
        formGridLayoutFilling = new FormGridLayoutFilling();
        setContent(formGridLayoutFilling);

    }

}