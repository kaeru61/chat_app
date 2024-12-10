package main.java.com.chatapp.internal.domain;


public class MessageModel {
    private String messageID;
    private String message;
    private String senderID;
    private String chatID;
    private String createdAt;

    public MessageModel(String messageID, String message, String senderID, String chatID, String createdAt) {
        this.messageID = messageID;
        this.message = message;
        this.senderID = senderID;
        this.chatID = chatID;
        this.createdAt = createdAt;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getChatID() {
        return chatID;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    
}
