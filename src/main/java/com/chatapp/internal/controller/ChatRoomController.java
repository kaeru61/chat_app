package com.chatapp.internal.controller;

import com.chatapp.internal.domain.ChatRoomModel;
import com.chatapp.internal.application.ChatRoomApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {
    @Autowired
    private ChatRoomApplication chatRoomApplication;

    @GetMapping
    public ResponseEntity<List<ChatRoomModel>> getAllChatRooms() {
        return ResponseEntity.ok(chatRoomApplication.getChatRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatRoomModel> getChatRoomById(@PathVariable int id) {
        return ResponseEntity.ok(chatRoomApplication.getChatRoom(id));
    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<List<ChatRoomModel>> getChatRoomsByUser(@PathVariable String userID) {
        return ResponseEntity.ok(chatRoomApplication.getChatRoomsByUser(userID));
    }

    @GetMapping("/ismember/{chatRoomID}/{userID}")
    public ResponseEntity<Boolean> isMember(@PathVariable int chatRoomID, @PathVariable String userID) {
        return ResponseEntity.ok(chatRoomApplication.isMember(chatRoomID, userID));
    }

    @PostMapping("")
    public ResponseEntity<ChatRoomModel> createChatRoom(@RequestBody ChatRoomRequest req) {
        try {
            ChatRoomModel chatRoom = new ChatRoomModel(0, null, null, 
                java.time.LocalDateTime.now().toString(), 
                req.getName(), 
                req.getPrivate(),
                req.getPassword()
            );
            return ResponseEntity.ok(chatRoomApplication.createChatRoom(chatRoom));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatRoomModel> updateChatRoom(@PathVariable Long id, @RequestBody ChatRoomRequest req) {
        ChatRoomModel chatRoom = chatRoomApplication.getChatRoom(id.intValue());
        if (chatRoom == null) {
            return ResponseEntity.notFound().build();
        }
        chatRoom.setName(req.getName());
        chatRoom.setIsPrivate(req.getPrivate());
        chatRoomApplication.updateChatRoom(chatRoom);
        return ResponseEntity.ok(chatRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable Long id) {
        chatRoomApplication.deleteChatRoom(id);
        return ResponseEntity.ok().build();
    }
}

class ChatRoomRequest {
    private int id;
    private String name;
    private boolean isPrivate;
    private String password;

    public ChatRoomRequest() {
    }

    public ChatRoomRequest(int id, String name, boolean isPrivate, String password) {
        this.id = id;
        this.name = name;
        this.isPrivate = isPrivate;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
