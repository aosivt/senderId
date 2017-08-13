package sender.UIObject.MenuBar;


import com.vaadin.server.Sizeable;
import com.vaadin.ui.MenuBar;
import sender.UIObject.MenuBar.MenuItems.FillingMan;

/**
 * Created by alex on 18.04.17.
 */
public class MainMenuBar extends MenuBar{

    public MainMenuBar(){
        this.setWidth(100.0f, Unit.PERCENTAGE);

        FillingMan fillingMan = new FillingMan    (this);

    }

}
