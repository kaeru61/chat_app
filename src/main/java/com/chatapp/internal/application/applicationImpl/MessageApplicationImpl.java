package com.chatapp.internal.application.applicationImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.internal.adapter.ChatRoomRepository;
import com.chatapp.internal.adapter.MessageRepository;
import com.chatapp.internal.domain.MessageModel;
import com.chatapp.internal.application.MessageApplication;
import java.util.ArrayList;

@Service
public class MessageApplicationImpl implements MessageApplication {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Override
    public MessageModel createMessage(MessageModel message) {
        Boolean isMember = chatRoomRepository.isMember(message.getChatRoomID(), message.getUserID());
        if (!isMember) {
            throw new RuntimeException("You are not a member of this chat room.");
        }
        return messageRepository.createMessage(message);
    }

    @Override
    public ArrayList<MessageModel> getMessagesByChatRoomID(int chatRoomID) {
        return messageRepository.getMessagesByChatRoomID(chatRoomID);
    }
}