package com.chatapp.internal.domain;

import java.util.UUID;
import java.util.List;
import com.chatapp.internal.domain.UserModel;

public class ChatRoomModel {
    private int chatID;
    private List<UserModel> users;
    private List<MessageModel> messages;
    private String createdAt;
    private String name;
    private boolean isPrivate;
    private String password;

    public ChatRoomModel(int chatID, List<UserModel> users, List<MessageModel> messages, String createdAt, String name, boolean isPrivate, String password) {
        this.chatID = chatID;
        this.users = users;
        this.messages = messages;
        this.createdAt = createdAt;
        this.name = name;
        this.isPrivate = isPrivate;
        this.password = password;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public void setMessages(List<MessageModel> messages) {
        this.messages = messages;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getChatID() {
        return chatID;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public List<MessageModel> getMessages() {
        return messages;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public String getPassword() {
        return password;
    }
}
