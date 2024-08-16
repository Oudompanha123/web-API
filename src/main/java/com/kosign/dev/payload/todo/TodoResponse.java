package com.kosign.dev.payload.todo;

import com.kosign.dev.domain.todo.Todo;
import com.kosign.dev.payload.todo.user.UserResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TodoResponse {

    private Long id;
    private String title;
    private boolean status;
    private UserResponse user;

    @Builder
    public TodoResponse(Long id, String title, boolean status, UserResponse user){
        this.id = id;
        this.title = title;
        this.status = status;
        this.user = user;
    }

    public TodoResponse(Todo todo, UserResponse userResponse){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.status = todo.getStatus();
        this.user = userResponse;
    }
}
