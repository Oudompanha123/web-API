package com.kosign.dev.service.todo;

import com.kosign.dev.payload.todo.TodoRequest;

public interface TodoService {
    void createTodo(TodoRequest payload);

    Object getTodoList();

    Object getById(Long id);

    void updateTodo(Long id, TodoRequest payload);

    void deleteById(Long id);
}
