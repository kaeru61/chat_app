package com.chatapp.internal.application;

import org.springframework.stereotype.Service;

import com.chatapp.internal.domain.UserModel;

@Service
public interface UserApplication {
    public UserModel login(String email, String password);
    public UserModel register(UserModel user, String password);
    public UserModel getUser(String userID);
    public UserModel updateUser(UserModel user);
    public void deleteUser(String userID);
}
