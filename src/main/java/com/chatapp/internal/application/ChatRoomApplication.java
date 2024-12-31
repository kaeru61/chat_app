package main.java.com.chatapp.internal.application;

import main.java.com.chatapp.internal.domain.ChatRoomModel;
import java.util.ArrayList;

public interface ChatRoomApplication {
    ArrayList<ChatRoomModel> getChatRooms();
    ChatRoomModel getChatRoom(int chatRoomID);
    ArrayList<ChatRoomModel> getChatRoomsByUser(String userID);
    ChatRoomModel createChatRoom(ChatRoomModel chatRoom);
    void updateChatRoom(ChatRoomModel chatRoom);
    void deleteChatRoom(Long id);
    void joinChatRoom(int chatRoomID, String userID);
    void leaveChatRoom(int chatRoomID, String userID);
}
