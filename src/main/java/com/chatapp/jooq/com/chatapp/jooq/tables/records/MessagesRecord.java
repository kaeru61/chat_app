/*
 * This file is generated by jOOQ.
 */
package com.chatapp.jooq.tables.records;


import com.chatapp.jooq.tables.Messages;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MessagesRecord extends UpdatableRecordImpl<MessagesRecord> implements Record5<Integer, Integer, UUID, String, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.messages.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.messages.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.messages.chat_room_id</code>.
     */
    public void setChatRoomId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.messages.chat_room_id</code>.
     */
    public Integer getChatRoomId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.messages.user_id</code>.
     */
    public void setUserId(UUID value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.messages.user_id</code>.
     */
    public UUID getUserId() {
        return (UUID) get(2);
    }

    /**
     * Setter for <code>public.messages.message</code>.
     */
    public void setMessage(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.messages.message</code>.
     */
    public String getMessage() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.messages.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.messages.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, UUID, String, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, Integer, UUID, String, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Messages.MESSAGES.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Messages.MESSAGES.CHAT_ROOM_ID;
    }

    @Override
    public Field<UUID> field3() {
        return Messages.MESSAGES.USER_ID;
    }

    @Override
    public Field<String> field4() {
        return Messages.MESSAGES.MESSAGE;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Messages.MESSAGES.CREATED_AT;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getChatRoomId();
    }

    @Override
    public UUID component3() {
        return getUserId();
    }

    @Override
    public String component4() {
        return getMessage();
    }

    @Override
    public LocalDateTime component5() {
        return getCreatedAt();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getChatRoomId();
    }

    @Override
    public UUID value3() {
        return getUserId();
    }

    @Override
    public String value4() {
        return getMessage();
    }

    @Override
    public LocalDateTime value5() {
        return getCreatedAt();
    }

    @Override
    public MessagesRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public MessagesRecord value2(Integer value) {
        setChatRoomId(value);
        return this;
    }

    @Override
    public MessagesRecord value3(UUID value) {
        setUserId(value);
        return this;
    }

    @Override
    public MessagesRecord value4(String value) {
        setMessage(value);
        return this;
    }

    @Override
    public MessagesRecord value5(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public MessagesRecord values(Integer value1, Integer value2, UUID value3, String value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MessagesRecord
     */
    public MessagesRecord() {
        super(Messages.MESSAGES);
    }

    /**
     * Create a detached, initialised MessagesRecord
     */
    public MessagesRecord(Integer id, Integer chatRoomId, UUID userId, String message, LocalDateTime createdAt) {
        super(Messages.MESSAGES);

        setId(id);
        setChatRoomId(chatRoomId);
        setUserId(userId);
        setMessage(message);
        setCreatedAt(createdAt);
        resetChangedOnNotNull();
    }
}