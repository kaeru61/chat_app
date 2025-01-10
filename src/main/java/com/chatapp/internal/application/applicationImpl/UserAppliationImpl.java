package com.chatapp.internal.application.applicationImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.internal.application.UserApplication;
import com.chatapp.internal.domain.*;
import com.chatapp.internal.adapter.UserRepository;

@Service
public class UserAppliationImpl implements UserApplication  {
    private UserRepository userRepository;

    @Autowired
    public UserAppliationImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel login(String email, String password) {
        return userRepository.login(email, password);
    }

    public UserModel register(UserModel user, String password) {
        boolean isEmailExist = userRepository.isEmailExist(user.getEmail());
        if (isEmailExist) {
            throw new RuntimeException("Email already exist");
        }

        return userRepository.register(user, password);
    }

    public UserModel getUser(String userID) {
        return userRepository.getUser(userID);
    }

    public UserModel updateUser(UserModel user) {
        return userRepository.updateUser(user);
    }

    public void deleteUser(String userID) {
        userRepository.deleteUser(userID);
    }
}
