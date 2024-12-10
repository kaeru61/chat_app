package main.java.com.chatapp.internal.adapter.adapterImpl;

import com.chatapp.jooq.tables.Users;
import com.chatapp.jooq.tables.records.UsersRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import main.java.com.chatapp.internal.adapter.UserRepository;
import main.java.com.chatapp.internal.domain.UserModel;

@Repository
public class UserDBAdapterImpl implements UserRepository {
    private final DSLContext dsl;
    private static final Users USERS = Users.USERS;

    public UserDBAdapterImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public UserModel login(String email, String password) {
        UsersRecord record = dsl.selectFrom(USERS)
                .where(USERS.EMAIL.eq(email))
                .and(USERS.PASSWORD.eq(password))
                .fetchOne();
        return record != null ? mapToUserModel(record) : null;
    }

    public UserModel register(UserModel user, String password) {
        UsersRecord record = dsl.insertInto(USERS)
                .set(USERS.ID, UUID.randomUUID())
                .set(USERS.EMAIL, user.getEmail())
                .set(USERS.PASSWORD, password)
                .set(USERS.USERNAME, user.getUserName())
                .returning()
                .fetchOne();
        return mapToUserModel(record);
    }

    public UserModel getUser(String userID) {
        UsersRecord record = dsl.selectFrom(USERS)
                .where(USERS.ID.eq(UUID.fromString(userID)))
                .fetchOne();
        return record != null ? mapToUserModel(record) : null;
    }

    public UserModel updateUser(UserModel user) {
        dsl.update(USERS)
                .set(USERS.EMAIL, user.getEmail())
                .set(USERS.USERNAME, user.getUserName())
                .where(USERS.ID.eq(UUID.fromString(user.getId().toString())))
                .execute();
        return user;
    }

    public void deleteUser(String userID) {
        dsl.deleteFrom(USERS)
                .where(USERS.ID.eq(UUID.fromString(userID)))
                .execute();
    }

    public boolean isEmailExist(String email) {
        return dsl.fetchExists(
                dsl.selectFrom(USERS)
                        .where(USERS.EMAIL.eq(email))
        );
    }

    private UserModel mapToUserModel(UsersRecord record) {
        return new UserModel(
            record.getUsername(),
            record.getId(),
            record.getEmail(),
            record.getCreatedAt().toString()
        );
    }
}