package sender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import sender.UIObject.MenuBar.MainMenuBar;
import sender.UIObject.TableSend;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@JavaScript({
        "vaadin://jquery-3.1.1.js",
        "vaadin://sendMessage.js"
})

public class MyUI extends UI {

    public static int count=0;
    public TableSend tableSend;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        count++;
        final VerticalLayout layout = new VerticalLayout();

        tableSend = new TableSend();
        tableSend.setSizeFull();

        layout.addComponent(new MainMenuBar());
        layout.addComponent(tableSend);
        setSizeFull();
        setContent(layout);

        addDetachListener(detachEvent -> {
           System.err.print("Еба выключилась");
        });

        addAttachListener(attachEvent -> {
            System.err.print("Еба drk.");
        });

    }

    public TableSend getTableSend() {
        return tableSend;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

    }



}
