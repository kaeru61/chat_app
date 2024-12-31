package main.java.com.chatapp.internal.application;

import main.java.com.chatapp.internal.domain.MessageModel;
import java.util.ArrayList;

public interface MessageApplication {
    public MessageModel createMessage(MessageModel message);
    public ArrayList<MessageModel> getMessagesByChatRoomID(int chatRoomID);
}