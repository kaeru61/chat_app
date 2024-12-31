
package main.java.com.chatapp.internal.application;

import main.java.com.chatapp.internal.domain.ChatRoomModel;
import main.java.com.chatapp.internal.adapter.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ChatRoomApplicationImpl implements ChatRoomApplication {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public ArrayList<ChatRoomModel> getChatRooms() {
        return chatRoomRepository.getChatRooms();
    }

    public ChatRoomModel getChatRoom(int chatRoomID) {
        return chatRoomRepository.getChatRoom(chatRoomID);
    }

    public ArrayList<ChatRoomModel> getChatRoomsByUser(String userID) {
        // TODO: 実装が必要
        return new ArrayList<>();
    }

    public ChatRoomModel createChatRoom(ChatRoomModel chatRoom) {
        return chatRoomRepository.createChatRoom(chatRoom);
    }

    public void updateChatRoom(ChatRoomModel chatRoom) {
        // TODO: 実装が必要
    }

    public void deleteChatRoom(Long id) {
        // TODO: 実装が必要
    }

    public void joinChatRoom(int chatRoomID, String userID) {
        Boolean isMember = chatRoomRepository.isMember(chatRoomID, userID);
        if (!isMember) {
            throw new RuntimeException("You are not a member of this chat room.");
        }
        chatRoomRepository.joinChatRoom(chatRoomID, userID);
    }

    public void leaveChatRoom(int chatRoomID, String userID) {
        // TODO: 実装が必要
    }
}