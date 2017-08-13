package sender.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sms_sending")
public class SMSSending {
    @Id
    @GeneratedValue
    @Column(name = "sms_sending_id")
    private Long smsSendingId;

    @ManyToOne//(targetEntity = PivotTable.class)
//    @JoinColumn(name = "pivot_table_id")
    private PivotTable pivotTable;

    @Column(name = "send_message")
    private Boolean sendMessage;

    @Column(name = "text_message")
    private String textMessage;

    @Column(name = "date_send")
    private Date dateSend;

    public Long getId() {
        return smsSendingId;
    }

    public void setId(Long smsSendingId) {
        this.smsSendingId = smsSendingId;
    }

    public PivotTable getPivotTable() {
        return pivotTable;
    }

    public void setPivotTable(PivotTable pivotTable) {
        this.pivotTable = pivotTable;
    }

    public Boolean getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(Boolean sendMessage) {
        this.sendMessage = sendMessage;
    }

    public Date getDateSend() {
        return dateSend;
    }

    public void setDateSend(Date dateSend) {
        this.dateSend = dateSend;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}
