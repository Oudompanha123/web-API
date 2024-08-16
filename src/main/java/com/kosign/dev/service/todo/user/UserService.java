package com.kosign.dev.service.todo.user;
;
import com.kosign.dev.payload.todo.user.UserRequest;

public interface UserService {
    void createUser(UserRequest payload);

    Object getUserList();

    Object getById(Integer id);

    void updateUserById(Integer id, UserRequest payload);

    void deleteUserById(Integer id);
}
