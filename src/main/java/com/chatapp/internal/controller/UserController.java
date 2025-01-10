package com.chatapp.internal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.internal.application.UserApplication;
import com.chatapp.internal.domain.UserModel;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserApplication iUserApplication;

    @Autowired
    public UserController(UserApplication iUserApplication) {
        this.iUserApplication = iUserApplication;
    }

    @GetMapping("/health")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }
    
    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody LoginRequest loginRequest) {
        try {
            UserModel newUser = iUserApplication.login(loginRequest.getEmail(), loginRequest.getPassword());
            if (newUser == null) {
                return ResponseEntity.badRequest().body(null);
            }
            System.out.println(newUser);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody RegisterRequest registerRequest) {
        try {
            UserModel userReq = new UserModel(registerRequest.getUsername(), null, registerRequest.getUserIconURL(), registerRequest.getEmail());
            UserModel newUser = iUserApplication.register(userReq, registerRequest.getPassword());
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
}


class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

class RegisterRequest {
    private String email;
    private String password;
    private String username;
    private String userIconURL;

    public RegisterRequest() {
    }

    public RegisterRequest(String email, String password, String username, String userIconURL) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.userIconURL = userIconURL;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getUserIconURL() {
        return userIconURL;
    }
}