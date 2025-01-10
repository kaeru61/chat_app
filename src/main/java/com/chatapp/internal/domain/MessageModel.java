package com.chatapp.internal.domain;


public class MessageModel {
    private int messageID;
    private String message;
    private String userID;
    private int chatRoomID;
    private String createdAt;

    public MessageModel(int messageID, String message, String userID, int chatRoomID, String createdAt) {
        this.messageID = messageID;
        this.message = message;
        this.userID = userID;
        this.chatRoomID = chatRoomID;
        this.createdAt = createdAt;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setChatRoomID(int chatRoomID) {
        this.chatRoomID = chatRoomID;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getMessageID() {
        return messageID;
    }

    public String getMessage() {
        return message;
    }

    public String getUserID() {
        return userID;
    }

    public int getChatRoomID() {
        return chatRoomID;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    
}
