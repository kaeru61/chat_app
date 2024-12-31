package main.java.com.chatapp.internal.controller;

import main.java.com.chatapp.internal.domain.ChatRoomModel;
import main.java.com.chatapp.internal.application.ChatRoomApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/join")
public class ChatRoomUsersController {
    @Autowired
    private ChatRoomApplication chatRoomApplication;

    @PostMapping("")
    public ResponseEntity<Void> joinChatRoom(@RequestBody JoinRequest req) {
        chatRoomApplication.joinChatRoom(req.getChatRoomID(), req.getUserID());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<Void> leaveChatRoom(@RequestBody JoinRequest req) {
        chatRoomApplication.leaveChatRoom(req.getChatRoomID(), req.getUserID());
        return ResponseEntity.ok().build();
    }
}

class JoinRequest {
    private int chatRoomID;
    private String userID;

    public JoinRequest() {
    }

    public JoinRequest(int chatRoomID, String userID) {
        this.chatRoomID = chatRoomID;
        this.userID = userID;
    }

    public int getChatRoomID() {
        return chatRoomID;
    }

    public void setCahtRoomID(int chatRoomID) {
        this.chatRoomID = chatRoomID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}