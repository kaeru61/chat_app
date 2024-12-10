package main.java.com.chatapp.internal.adapter;

import main.java.com.chatapp.internal.domain.ChatRoomModel;
import java.util.ArrayList;

public interface ChatRooMRepository {
    public ChatRoomModel createChatRoom(ChatRoomModel chatRoom);
    public ChatRoomModel getChatRoom(int chatRoomID);
    public ArraylList<ChatRoomModel> getChatRooms();
}
