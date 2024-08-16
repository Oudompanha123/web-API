package com.kosign.dev.service.todo;

import com.kosign.dev.domain.todo.Todo;
import com.kosign.dev.domain.todo.TodoRepository;
import com.kosign.dev.domain.todo.user.UserRepository;
import com.kosign.dev.payload.todo.TodoRequest;
import com.kosign.dev.payload.todo.TodoResponse;
import com.kosign.dev.payload.todo.user.UserResponse;
import com.kosign.dev.service.todo.user.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final UserMapper userMapper;

    public TodoMapper(UserRepository userRepository, TodoRepository todoRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
        this.userMapper = userMapper;
    }

    public Todo mapToTodoEntity(TodoRequest todoRequest) {
        Todo todo = todoRepository.findByUser_UserId(todoRequest.userId());
        return Todo.builder()
                .title(todoRequest.title())         // record type can not use for getter, setter
                .status(todoRequest.status())
                .user(todo.getUser())
                .build();
    }

    public TodoResponse mapToTodoResponse(Todo todo) {
        System.out.println("User Data: " + todo.getUser().toString());

        UserResponse userResponse =  userMapper.mapToUserResponse(todo.getUser());
        return TodoResponse.builder()
                .id(todo.getId())
                .status(todo.getStatus())
                .title(todo.getTitle())
                .user(userResponse)
                .build();
    }
}
