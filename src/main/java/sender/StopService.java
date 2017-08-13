package sender;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.hibernate.Session;
import sender.UIObject.MenuBar.MainMenuBar;
import sender.UIObject.TableSend;
import sender.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */


public class StopService extends UI {


    @Override
    protected void init(VaadinRequest vaadinRequest) {

        HibernateUtil.shutdown();
        HibernateUtil.shutdownFactory();
        System.exit(0);


    }



    @WebServlet(urlPatterns = "/stop", name = "StopService", asyncSupported = true)
    @VaadinServletConfiguration(ui = StopService.class, productionMode = false)
    public static class StopServlet extends VaadinServlet {
        {

//            System.err.print("Приложение остановлено");
//            System.err.print(MyUI.count);
//            System.exit(0);
        }


    }



}
