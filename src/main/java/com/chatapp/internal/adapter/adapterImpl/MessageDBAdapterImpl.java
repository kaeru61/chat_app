
package com.chatapp.internal.adapter.adapterImpl;

import com.chatapp.jooq.tables.Messages;
import com.chatapp.jooq.tables.records.MessagesRecord;
import com.chatapp.internal.adapter.MessageRepository;
import com.chatapp.internal.domain.MessageModel;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Repository
public class MessageDBAdapterImpl implements MessageRepository {
    private final DSLContext dsl;
    private static final Messages MESSAGES = Messages.MESSAGES;

    public MessageDBAdapterImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public MessageModel createMessage(MessageModel message) {
        MessagesRecord record = dsl.insertInto(MESSAGES)
                .set(MESSAGES.MESSAGE, message.getMessage())
                .set(MESSAGES.USER_ID, UUID.fromString(message.getUserID()))
                .set(MESSAGES.CHAT_ROOM_ID, message.getChatRoomID())
                .returning()
                .fetchOne();
        return mapToMessageModel(record);
    }

    public ArrayList<MessageModel> getMessagesByChatRoomID(int chatRoomID) {
        ArrayList<MessageModel> messages = new ArrayList<>();
        dsl.selectFrom(MESSAGES)
                .where(MESSAGES.CHAT_ROOM_ID.eq(chatRoomID))
                .orderBy(MESSAGES.CREATED_AT.asc())
                .fetch()
                .forEach(record -> messages.add(mapToMessageModel(record)));
        return messages;
    }

    private MessageModel mapToMessageModel(MessagesRecord record) {
        return new MessageModel(
                record.getId(),
                record.getMessage(),
                record.getUserId().toString(),
                record.getChatRoomId(),
                record.getCreatedAt().toString()
        );
    }
}