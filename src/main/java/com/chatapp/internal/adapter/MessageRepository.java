package main.java.com.chatapp.internal.adapter;

import main.java.com.chatapp.internal.domain.MessageModel;
import main.java.com.chatapp.internal.domain.ChatRoomModel;
import java.util.ArrayList;

public interface MessageRepository {
    public MessageModel createMessage(MessageModel message);
    public ArrayList<MessageModel> getMessagesByChatRoomID(int chatRoomID);
}