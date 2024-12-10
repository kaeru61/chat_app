/*
 * This file is generated by jOOQ.
 */
package com.chatapp.jooq;


import com.chatapp.jooq.tables.ChatRoomUsers;
import com.chatapp.jooq.tables.ChatRooms;
import com.chatapp.jooq.tables.Messages;
import com.chatapp.jooq.tables.Users;
import com.chatapp.jooq.tables.records.ChatRoomUsersRecord;
import com.chatapp.jooq.tables.records.ChatRoomsRecord;
import com.chatapp.jooq.tables.records.MessagesRecord;
import com.chatapp.jooq.tables.records.UsersRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ChatRoomUsersRecord> CHAT_ROOM_USERS_PKEY = Internal.createUniqueKey(ChatRoomUsers.CHAT_ROOM_USERS, DSL.name("chat_room_users_pkey"), new TableField[] { ChatRoomUsers.CHAT_ROOM_USERS.ID }, true);
    public static final UniqueKey<ChatRoomsRecord> CHAT_ROOMS_PKEY = Internal.createUniqueKey(ChatRooms.CHAT_ROOMS, DSL.name("chat_rooms_pkey"), new TableField[] { ChatRooms.CHAT_ROOMS.ID }, true);
    public static final UniqueKey<MessagesRecord> MESSAGES_PKEY = Internal.createUniqueKey(Messages.MESSAGES, DSL.name("messages_pkey"), new TableField[] { Messages.MESSAGES.ID }, true);
    public static final UniqueKey<UsersRecord> USERS_PKEY = Internal.createUniqueKey(Users.USERS, DSL.name("users_pkey"), new TableField[] { Users.USERS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ChatRoomUsersRecord, ChatRoomsRecord> CHAT_ROOM_USERS__FK_CHAT_ROOM = Internal.createForeignKey(ChatRoomUsers.CHAT_ROOM_USERS, DSL.name("fk_chat_room"), new TableField[] { ChatRoomUsers.CHAT_ROOM_USERS.CHAT_ROOM_ID }, Keys.CHAT_ROOMS_PKEY, new TableField[] { ChatRooms.CHAT_ROOMS.ID }, true);
    public static final ForeignKey<ChatRoomUsersRecord, UsersRecord> CHAT_ROOM_USERS__FK_USER = Internal.createForeignKey(ChatRoomUsers.CHAT_ROOM_USERS, DSL.name("fk_user"), new TableField[] { ChatRoomUsers.CHAT_ROOM_USERS.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
    public static final ForeignKey<MessagesRecord, ChatRoomsRecord> MESSAGES__FK_CHAT_ROOM = Internal.createForeignKey(Messages.MESSAGES, DSL.name("fk_chat_room"), new TableField[] { Messages.MESSAGES.CHAT_ROOM_ID }, Keys.CHAT_ROOMS_PKEY, new TableField[] { ChatRooms.CHAT_ROOMS.ID }, true);
    public static final ForeignKey<MessagesRecord, UsersRecord> MESSAGES__FK_USER = Internal.createForeignKey(Messages.MESSAGES, DSL.name("fk_user"), new TableField[] { Messages.MESSAGES.USER_ID }, Keys.USERS_PKEY, new TableField[] { Users.USERS.ID }, true);
}
