package com.chatapp.internal.domain;

import java.util.UUID;

public class UserModel {
    private String userName;
    private UUID userID;
    private String userIconURL;
    private String email;

    public UserModel(String userName, UUID userID, String userIconURL, String email) {
        this.userName = userName;
        this.userID = userID;
        this.userIconURL = userIconURL;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserIconURL(String userIconURL) {
        this.userIconURL = userIconURL;
    }

    public String getUserName() {
        return userName;
    }

    public UUID getId() {
        return userID;
    }

    public String getUserIconURL() {
        return userIconURL;
    }

    public String getEmail() {
        return email;
    }
}
