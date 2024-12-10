create table users (
    id UUID primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    created_at timestamp default current_timestamp
);

create table chat_rooms (
    id serial primary key,
    name varchar(255) not null,
    created_at timestamp default current_timestamp,
    is_deleted boolean default false,
    is_private boolean default false,
    password varchar(255) default null,
    CONSTRAINT password_required_if_private CHECK (
        (is_private = false) OR (is_private = true AND password IS NOT NULL)
    )
);

create table chat_room_users (
    id serial primary key,
    chat_room_id integer not null,
    user_id UUID not null,
    created_at timestamp default current_timestamp,
    CONSTRAINT fk_chat_room FOREIGN KEY (chat_room_id) REFERENCES chat_rooms(id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

create table messages (
    id serial primary key,
    chat_room_id integer not null,
    user_id UUID not null,
    message text not null,
    created_at timestamp default current_timestamp,
    CONSTRAINT fk_chat_room FOREIGN KEY (chat_room_id) REFERENCES chat_rooms(id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);