package com.chatapp.internal.adapter;

import com.chatapp.internal.domain.UserModel;

public interface UserRepository {
    UserModel login(String email, String password);
    UserModel register(UserModel user, String password);
    UserModel getUser(String userID);
    UserModel updateUser(UserModel user);
    void deleteUser(String userID);
    boolean isEmailExist(String email);
}
