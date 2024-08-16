package com.kosign.dev.service.todo.user;

import com.kosign.dev.domain.todo.user.User;
import com.kosign.dev.domain.todo.user.UserRepository;
import com.kosign.dev.payload.todo.user.UserRequest;
import com.kosign.dev.payload.todo.user.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User mapToUserEntity(UserRequest userRequest) {
      return User.builder()
                .username(userRequest.userName())         // record type can not use for getter, setter
                .gender(userRequest.gender())
                .build();}

    public UserResponse mapToUserResponse(User user) {
        UserResponse userResponse = new UserResponse(user);
        userResponse.setUserName(user.getUsername());
        userResponse.setGender(user.getGender());
        return userResponse;
    }
}
