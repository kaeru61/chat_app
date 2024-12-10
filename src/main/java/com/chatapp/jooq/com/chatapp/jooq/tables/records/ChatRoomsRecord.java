/*
 * This file is generated by jOOQ.
 */
package com.chatapp.jooq.tables.records;


import com.chatapp.jooq.tables.ChatRooms;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ChatRoomsRecord extends UpdatableRecordImpl<ChatRoomsRecord> implements Record6<Integer, String, LocalDateTime, Boolean, Boolean, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.chat_rooms.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.chat_rooms.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.chat_rooms.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.chat_rooms.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.chat_rooms.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.chat_rooms.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.chat_rooms.is_deleted</code>.
     */
    public void setIsDeleted(Boolean value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.chat_rooms.is_deleted</code>.
     */
    public Boolean getIsDeleted() {
        return (Boolean) get(3);
    }

    /**
     * Setter for <code>public.chat_rooms.is_private</code>.
     */
    public void setIsPrivate(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.chat_rooms.is_private</code>.
     */
    public Boolean getIsPrivate() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>public.chat_rooms.password</code>.
     */
    public void setPassword(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.chat_rooms.password</code>.
     */
    public String getPassword() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, LocalDateTime, Boolean, Boolean, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, LocalDateTime, Boolean, Boolean, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return ChatRooms.CHAT_ROOMS.ID;
    }

    @Override
    public Field<String> field2() {
        return ChatRooms.CHAT_ROOMS.NAME;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return ChatRooms.CHAT_ROOMS.CREATED_AT;
    }

    @Override
    public Field<Boolean> field4() {
        return ChatRooms.CHAT_ROOMS.IS_DELETED;
    }

    @Override
    public Field<Boolean> field5() {
        return ChatRooms.CHAT_ROOMS.IS_PRIVATE;
    }

    @Override
    public Field<String> field6() {
        return ChatRooms.CHAT_ROOMS.PASSWORD;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public LocalDateTime component3() {
        return getCreatedAt();
    }

    @Override
    public Boolean component4() {
        return getIsDeleted();
    }

    @Override
    public Boolean component5() {
        return getIsPrivate();
    }

    @Override
    public String component6() {
        return getPassword();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public LocalDateTime value3() {
        return getCreatedAt();
    }

    @Override
    public Boolean value4() {
        return getIsDeleted();
    }

    @Override
    public Boolean value5() {
        return getIsPrivate();
    }

    @Override
    public String value6() {
        return getPassword();
    }

    @Override
    public ChatRoomsRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public ChatRoomsRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ChatRoomsRecord value3(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public ChatRoomsRecord value4(Boolean value) {
        setIsDeleted(value);
        return this;
    }

    @Override
    public ChatRoomsRecord value5(Boolean value) {
        setIsPrivate(value);
        return this;
    }

    @Override
    public ChatRoomsRecord value6(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public ChatRoomsRecord values(Integer value1, String value2, LocalDateTime value3, Boolean value4, Boolean value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ChatRoomsRecord
     */
    public ChatRoomsRecord() {
        super(ChatRooms.CHAT_ROOMS);
    }

    /**
     * Create a detached, initialised ChatRoomsRecord
     */
    public ChatRoomsRecord(Integer id, String name, LocalDateTime createdAt, Boolean isDeleted, Boolean isPrivate, String password) {
        super(ChatRooms.CHAT_ROOMS);

        setId(id);
        setName(name);
        setCreatedAt(createdAt);
        setIsDeleted(isDeleted);
        setIsPrivate(isPrivate);
        setPassword(password);
        resetChangedOnNotNull();
    }
}