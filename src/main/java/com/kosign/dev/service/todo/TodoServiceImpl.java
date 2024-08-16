package com.kosign.dev.service.todo;

import com.kosign.dev.domain.todo.TodoRepository;
import com.kosign.dev.exception.CusNotFoundException;
import com.kosign.dev.payload.todo.TodoMainRes;
import com.kosign.dev.payload.todo.TodoRequest;
import com.kosign.dev.payload.todo.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    @Override
    public void createTodo(TodoRequest payload) {
        var entity = todoMapper.mapToTodoEntity(payload);
        todoRepository.save(entity);
    }

    @Override
    public void updateTodo(Long id, TodoRequest payload) {
            var entity = todoRepository.findById(id)
                    .orElseThrow(() -> new CusNotFoundException("Todo Not Found"));
            entity.setTitle(payload.title());
            todoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Todo ID: " + id);
        todoRepository.deleteById(id);
    }

    @Override
    public Object getTodoList() {
       var todoList = todoRepository.findAll();
        List<TodoResponse> todoResponses = todoList.stream()
               .map(todoMapper::mapToTodoResponse)
              .collect(Collectors.toList());
       return new TodoMainRes(todoResponses);

    }

    @Override
    public Object getById(Long id) {

        TodoResponse todoResponse = todoRepository.findById(id)
                .map(todoMapper::mapToTodoResponse)
                .orElseThrow(() -> new CusNotFoundException("Todo Not Found"));

        return todoResponse;
    }
}
