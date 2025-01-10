package com.chatapp.internal.adapter;

import com.chatapp.internal.domain.ChatRoomModel;
import java.util.ArrayList;

public interface ChatRoomRepository {
    public ChatRoomModel createChatRoom(ChatRoomModel chatRoom);
    public ChatRoomModel getChatRoom(int chatRoomID);
    public ArrayList<ChatRoomModel> getChatRooms();
    public void joinChatRoom(int chatRoomID, String userID);
    public Boolean isMember(int chatRoomID, String userID);
    public ArrayList<ChatRoomModel> getChatRoomsByUser(String userID);
}

