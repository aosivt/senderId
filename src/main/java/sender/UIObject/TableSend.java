package sender.UIObject;

import com.vaadin.ui.Grid;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sender.Entity.SMSSending;
import sender.Entity.SNPStaff;
import sender.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TableSend extends Grid<SMSSending> {

    private List<SMSSending> smsSendings;
    private SMSSending smsSending;
    public TableSend(){
        setOptions();
    }

    public SMSSending getSmsSending() {
        return smsSending;

    }

    public void setSmsSending(SMSSending smsSending) {
        this.smsSending = smsSending;
        setOptions();
    }

    public void addSmsSending(SMSSending smsSending) {
        getSmsSendings().add(smsSending);
        setOptions();
    }

    public List<SMSSending> getSmsSendings() {
        return smsSendings;
    }

    public void setSmsSendings(List<SMSSending> smsSendings) {
        this.smsSendings = smsSendings;
    }

    public void setOptions(){
        setSizeFull();
        removeAllColumns();

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("From SMSSending SS order by SS desc");
        List<SMSSending> resultlist = new ArrayList<>();
        setSmsSendings(resultlist);
        resultlist = (List<SMSSending>) query.list();
        setItems(resultlist);

        session.close();

        addColumn(SMSSending::getId).setCaption("Номер сообщения");
//        addColumn(SMSSending::getPivotTable).setCaption("Телефон");
        addColumn(SMSSending::getDateSend).setCaption("Дата отправки");
        addColumn(SMSSending::getTextMessage).setCaption("Текст сообщения");
        addColumn(SMSSending::getSendMessage).setCaption("Статус сообщения");


        }

}
