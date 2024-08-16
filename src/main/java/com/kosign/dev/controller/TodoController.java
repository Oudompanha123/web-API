package com.kosign.dev.controller;

import com.kosign.dev.payload.todo.TodoRequest;
import com.kosign.dev.properties.JwtProperties;
import com.kosign.dev.service.todo.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@ToString
public class TodoController extends AbstractRestController{
    private final TodoService todoService;
    private final JwtProperties jwtProperties;

    @PostMapping()
    public Object createTodo(@RequestBody TodoRequest payload) {
        System.out.println("TodoRequest: " + payload);
        todoService.createTodo(payload);
        return ok();
    }

    @PutMapping("/{id}")
    public Object updateTodo(@PathVariable("id") Long id, @RequestBody TodoRequest payload) {
        todoService.updateTodo(id, payload);
        return ok();
    }

    @GetMapping()
    public Object getTodoList() {
        System.out.println("Get all todo: " + todoService.getTodoList());
        return ok(todoService.getTodoList());
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable(name="id") Long id) {
        System.err.println("test " + id);
        return ok(todoService.getById(id));
    }

    @DeleteMapping("/{id}")
    public Object deleteById(@PathVariable("id") Long id) {
        System.out.println("test delete: " + id);
        todoService.deleteById(id);
        return ok();
    }
}
