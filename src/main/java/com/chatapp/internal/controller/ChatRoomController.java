package main.java.com.chatapp.internal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import main.java.com.chatapp.internal.application.ChatRoomApplication;

import java.util.List;

@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {
    
    @Autowired
    private ChatRoomApplication chatRoomApplication;

    @GetMapping
    public ResponseEntity<List<ChatRoom>> getAllChatRooms() {
        return ResponseEntity.ok(chatRoomApplication.getChatRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable int id) {
        return ResponseEntity.ok(chatRoomApplication.getChatRoom(id));
    }

    @PostMapping
    public ResponseEntity<ChatRoom> createChatRoom(@RequestBody ChatRoomRequest req) {
        if (req.getPrivate() && req.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        } else if (req.getPrivate() && req.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else if (req.getPrivate() && req.getPassword().isBlank()) {
            return ResponseEntity.badRequest().build();
        } else if (req.getPrivate() && req.getPassword().length() < 6) {
            return ResponseEntity.badRequest().build();
        } else if (req.getPrivate()) {
            return ResponseEntity.ok(chatRoomApplication.createChatRoom(req.getName(), null, req.getPrivate(), req.getPassword()));
        } else {
            return ResponseEntity.ok(chatRoomApplication.createChatRoom(req.getName(), null, req.getPrivate(), null));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatRoom> updateChatRoom(@PathVariable Long id, @RequestBody ChatRoomRequest chatRoom) {
        chatRoom.setId(id);
        return ResponseEntity.ok(chatRoomService.update(chatRoom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable Long id) {
        chatRoomService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

class ChatRoomRequest {
    private Long id;
    private String name;
    private boolean isPrivate;
    private String password;

    public ChatRoomRequest() {
    }

    public ChatRoomRequest(Long id, String name, boolean isPrivate, String password) {
        this.id = id;
        this.name = name;
        this.isPrivate = isPrivate;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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