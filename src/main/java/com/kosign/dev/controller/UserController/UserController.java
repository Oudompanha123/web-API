package com.kosign.dev.controller.UserController;

import com.kosign.dev.controller.AbstractRestController;
import com.kosign.dev.payload.todo.user.UserRequest;
import com.kosign.dev.properties.JwtProperties;
import com.kosign.dev.service.todo.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController extends AbstractRestController {
    private final UserService userService;
    private final JwtProperties jwtProperties;

    @GetMapping()
    public Object getUserList() {
        return ok(userService.getUserList());
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable("id") Integer id) {
        System.out.println("User ID: " + id);
        return ok(userService.getById(id));
    }

    @PostMapping()
    public Object createTodo(@RequestBody UserRequest payload) {
        userService.createUser(payload);
        return ok();
    }

    @PutMapping("/{id}")
    public Object updateTodo(@PathVariable("id") Integer id, @RequestBody UserRequest payload) {
        System.out.println("Update by UserID: " + id);
        userService.updateUserById(id, payload);
        return ok();
    }

    @DeleteMapping("/{id}")
    public Object deleteById(@PathVariable("id") Integer id) {
        System.out.println("Delete by UserID: " + id);
        userService.deleteUserById(id);
        return ok();
    }

}
