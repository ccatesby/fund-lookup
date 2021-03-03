package funds.spring.neo4j.model;

public class Message {
     private String username;
    // private String content;
    private String timestamp;
    private Payload payload;
    public Message() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public Payload getPayload() {
        return payload;
    }

    // public void setSender(String sender) {
    //     this.sender = sender;
    // }

    // public Message(String sender, String content) {
    //     this.sender = sender;
    //     this.content = content;
    // }

    // public String getContent() {
    //     return content;
    // }

    // public void setContent(String content) {
    //     this.content = content;
    // }

    // @Override
    // public String toString() {
    //     return "Message{" +
    //             "sender='" + sender + '\'' +
    //             ", content='" + content + '\'' +
    //             ", timestamp='" + timestamp + '\'' +
    //             '}';
    // }
}