package main.java.com.chatapp.internal.adapter.adapterImpl;

import com.chatapp.jooq.tables.ChatRooms;
import com.chatapp.jooq.tables.ChatRoomUsers;
import com.chatapp.jooq.tables.records.ChatRoomsRecord;
import main.java.com.chatapp.internal.domain.ChatRoomModel;
import main.java.com.chatapp.internal.domain.UserModel;
import main.java.com.chatapp.internal.domain.MessageModel;
import main.java.com.chatapp.internal.adapter.ChatRoomRepository;
import org.springframework.stereotype.Repository;
import org.jooq.DSLContext;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ChatRoomDBAdapterImpl implements ChatRoomRepository {
    private final DSLContext dsl;
    private static final ChatRooms CHAT_ROOMS = com.chatapp.jooq.tables.ChatRooms.CHAT_ROOMS;
    private static final ChatRoomUsers ChatRoomUsers = com.chatapp.jooq.tables.ChatRoomUsers.CHAT_ROOM_USERS;

    public ChatRoomDBAdapterImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public ChatRoomModel createChatRoom(ChatRoomModel chatRoom) {
        if (chatRoom.getIsPrivate() == true) {
            if (chatRoom.getPassword() == null) {
                throw new IllegalArgumentException("Password is required for private chat room");
            } else {
                ChatRoomsRecord record = dsl.insertInto(CHAT_ROOMS)
                    .set(CHAT_ROOMS.NAME, chatRoom.getName())
                    .set(CHAT_ROOMS.PASSWORD, chatRoom.getPassword())
                    .set(CHAT_ROOMS.IS_PRIVATE, chatRoom.getIsPrivate())
                    .returning()
                    .fetchOne();
                return mapToUserModel(record);
            }
        } else {
            ChatRoomsRecord record = dsl.insertInto(CHAT_ROOMS)
                    .set(CHAT_ROOMS.NAME, chatRoom.getName())
                    .returning()
                    .fetchOne();
            return mapToUserModel(record);
        }
    }

   public ChatRoomModel getChatRoom(int chatRoomID) {
        ChatRoomsRecord record = dsl.selectFrom(CHAT_ROOMS)
                .where(CHAT_ROOMS.ID.eq(chatRoomID))
                .fetchOne();
        return record != null ? mapToUserModel(record) : null;
    }

    public ArrayList<ChatRoomModel> getChatRooms() {
        ArrayList<ChatRoomModel> chatRooms = new ArrayList<>();
        dsl.selectFrom(CHAT_ROOMS)
                .fetch()
                .forEach(record -> chatRooms.add(mapToUserModel(record)));
        return chatRooms;
    }

    public void joinChatRoom(int id, String userID) {
        dsl.insertInto(ChatRoomUsers.CHAT_ROOM_USERS)
                .set(ChatRoomUsers.CHAT_ROOM_ID, id)
                .set(ChatRoomUsers.USER_ID, UUID.fromString(userID))
                .execute();
    }

    public Boolean isMember(int chatRoomID, String userID) {
        Boolean isMember = dsl.selectFrom(ChatRoomUsers.CHAT_ROOM_USERS)
                .where(ChatRoomUsers.CHAT_ROOM_ID.eq(chatRoomID))
                .and(ChatRoomUsers.USER_ID.eq(UUID.fromString(userID)))
                .fetchOne() != null;
        return isMember;
    }

    private ChatRoomModel mapToUserModel(ChatRoomsRecord record) {
        return new ChatRoomModel(
                record.getId(), 
                new ArrayList<UserModel>(),  // Use ArrayList instead of List
                new ArrayList<MessageModel>(),  // Use ArrayList instead of List
                record.getCreatedAt().toString(),
                record.getName(),
                record.getIsPrivate(),
                record.getPassword()
        );
    }
}