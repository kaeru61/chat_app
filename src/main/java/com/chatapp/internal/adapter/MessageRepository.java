package com.chatapp.internal.adapter;

import com.chatapp.internal.domain.MessageModel;
import com.chatapp.internal.domain.ChatRoomModel;
import java.util.ArrayList;

public interface MessageRepository {
    public MessageModel createMessage(MessageModel message);
    public ArrayList<MessageModel> getMessagesByChatRoomID(int chatRoomID);
}