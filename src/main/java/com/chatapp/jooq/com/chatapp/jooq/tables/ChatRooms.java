/*
 * This file is generated by jOOQ.
 */
package com.chatapp.jooq.tables;


import com.chatapp.jooq.Keys;
import com.chatapp.jooq.Public;
import com.chatapp.jooq.tables.records.ChatRoomsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Check;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ChatRooms extends TableImpl<ChatRoomsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.chat_rooms</code>
     */
    public static final ChatRooms CHAT_ROOMS = new ChatRooms();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ChatRoomsRecord> getRecordType() {
        return ChatRoomsRecord.class;
    }

    /**
     * The column <code>public.chat_rooms.id</code>.
     */
    public final TableField<ChatRoomsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>public.chat_rooms.name</code>.
     */
    public final TableField<ChatRoomsRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.chat_rooms.created_at</code>.
     */
    public final TableField<ChatRoomsRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>public.chat_rooms.is_deleted</code>.
     */
    public final TableField<ChatRoomsRecord, Boolean> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.BOOLEAN.defaultValue(DSL.field(DSL.raw("false"), SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.chat_rooms.is_private</code>.
     */
    public final TableField<ChatRoomsRecord, Boolean> IS_PRIVATE = createField(DSL.name("is_private"), SQLDataType.BOOLEAN.defaultValue(DSL.field(DSL.raw("false"), SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.chat_rooms.password</code>.
     */
    public final TableField<ChatRoomsRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(255).defaultValue(DSL.field(DSL.raw("NULL::character varying"), SQLDataType.VARCHAR)), this, "");

    private ChatRooms(Name alias, Table<ChatRoomsRecord> aliased) {
        this(alias, aliased, null);
    }

    private ChatRooms(Name alias, Table<ChatRoomsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.chat_rooms</code> table reference
     */
    public ChatRooms(String alias) {
        this(DSL.name(alias), CHAT_ROOMS);
    }

    /**
     * Create an aliased <code>public.chat_rooms</code> table reference
     */
    public ChatRooms(Name alias) {
        this(alias, CHAT_ROOMS);
    }

    /**
     * Create a <code>public.chat_rooms</code> table reference
     */
    public ChatRooms() {
        this(DSL.name("chat_rooms"), null);
    }

    public <O extends Record> ChatRooms(Table<O> child, ForeignKey<O, ChatRoomsRecord> key) {
        super(child, key, CHAT_ROOMS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public Identity<ChatRoomsRecord, Integer> getIdentity() {
        return (Identity<ChatRoomsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<ChatRoomsRecord> getPrimaryKey() {
        return Keys.CHAT_ROOMS_PKEY;
    }

    @Override
    public List<Check<ChatRoomsRecord>> getChecks() {
        return Arrays.asList(
            Internal.createCheck(this, DSL.name("password_required_if_private"), "(((is_private = false) OR ((is_private = true) AND (password IS NOT NULL))))", true)
        );
    }

    @Override
    public ChatRooms as(String alias) {
        return new ChatRooms(DSL.name(alias), this);
    }

    @Override
    public ChatRooms as(Name alias) {
        return new ChatRooms(alias, this);
    }

    @Override
    public ChatRooms as(Table<?> alias) {
        return new ChatRooms(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public ChatRooms rename(String name) {
        return new ChatRooms(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ChatRooms rename(Name name) {
        return new ChatRooms(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public ChatRooms rename(Table<?> name) {
        return new ChatRooms(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, LocalDateTime, Boolean, Boolean, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Integer, ? super String, ? super LocalDateTime, ? super Boolean, ? super Boolean, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Integer, ? super String, ? super LocalDateTime, ? super Boolean, ? super Boolean, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
