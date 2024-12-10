package main.java.com.chatapp.internal.application;

import java.util.ArrayList;

import main.java.com.chatapp.internal.domain.ChatModel;

public interface ChatRoomApplication {
    public void createChatRoom(String chatRoomName, String userID, boolean isPrivate, String password);
    public void deleteChatRoom(int chatRoomID, String userID);
    public void addUserToChatRoom(int chatRoomID, String userID, String requestorID);
    public void removeUserFromChatRoom(int chatRoomID, String userID, String requesterID);
    public void sendMessage(int chatRoomID, String userID, String message);
    public void sendPrivateMessage(int chatRoomID, String userID, String message);
    public void sendImage(int chatRoomID, String userID, String image);
    public void sendPrivateImage(int chatRoomID, String userID, String image);
    public void sendVideo(int chatRoomID, String userID, String video);
    public void sendPrivateVideo(int chatRoomID, String userID, String video);
    public void sendAudio(int chatRoomID, String userID, String audio);
    public void sendPrivateAudio(int chatRoomID, String userID, String audio);
    public ArrayList<ChatRoomModel> getChatRooms();
    public ChatRoomModel getChatRoom(int chatRoomID);
    public ArrayList<ChatRoomModel> getChatRoomsByUser(String userID);
    public void updateChatRoom(ChatRoomModel chatRoom);
}
