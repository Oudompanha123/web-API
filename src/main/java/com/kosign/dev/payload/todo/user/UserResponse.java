package com.kosign.dev.payload.todo.user;

import com.kosign.dev.domain.todo.Todo;
import com.kosign.dev.domain.todo.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private Integer userId;
    private String userName;
    private String gender;

    @Builder
    public UserResponse(Integer id, String title, String gender) {
        this.userId = id;
        this.userName = title;
        this.gender = gender;
    }

    public UserResponse(User user) {
        this.userId = Integer.valueOf(user.getUserId().toString());
        this.userName = user.getUsername();
        this.gender = user.getGender();
    }
}
