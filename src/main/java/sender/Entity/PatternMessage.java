package sender.Entity;

import javax.persistence.*;


@Entity
@Table(name = "pattern_message")
public class PatternMessage {

    @Id
    @GeneratedValue
    @Column(name = "pattern_message_id")
    private Long patternMessageId;

    @Column(name = "pattern_message_name")
    private String patternMessageName;

    @Column(name = "pattern_message_text")
    private String patternMessageText;

    public Long getPatternMessageId() {
        return patternMessageId;
    }

    public void setPatternMessageId(Long patternMessageId) {
        this.patternMessageId = patternMessageId;
    }

    public String getPatternMessageText() {
        return patternMessageText;
    }

    public void setPatternMessageText(String patternMessageText) {
        this.patternMessageText = patternMessageText;
    }

    public String getPatternMessageName() {
        return patternMessageName;
    }

    public void setPatternMessageName(String patternMessageName) {
        this.patternMessageName = patternMessageName;
    }
}
