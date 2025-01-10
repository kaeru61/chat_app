package com.chatapp.internal.controller;

import com.chatapp.internal.application.MessageApplication;
import com.chatapp.internal.domain.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/message")
public class MessageController {
    private MessageApplication messageApplication;

    @Autowired
    public MessageController(MessageApplication messageApplication) {
        this.messageApplication = messageApplication;
    }

    @GetMapping("/{chatRoomID}")
    public ResponseEntity<List<MessageModel>> getMessagesByChatRoomID(@PathVariable int chatRoomID) {
        List messages = messageApplication.getMessagesByChatRoomID(chatRoomID);
        return ResponseEntity.ok(messages);
    }

    @PostMapping("")
    public ResponseEntity<MessageModel> createMessage(@RequestBody CreateMessageRequest request) {
       try {
            MessageModel message = new MessageModel(0, request.getMessage(), request.getUserID(), request.getChatRoomID(), java.time.LocalDateTime.now().toString());
            MessageModel response = messageApplication.createMessage(message);
            return ResponseEntity.ok(response);
         } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
       }
    }
}

class CreateMessageRequest {
    private String message;
    private String userID;
    private int chatRoomID;

    public CreateMessageRequest() {
    }

    public CreateMessageRequest(String message, String userID, int chatRoomID) {
        this.message = message;
        this.userID = userID;
        this.chatRoomID = chatRoomID;
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
}