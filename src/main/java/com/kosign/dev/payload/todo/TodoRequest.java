package com.kosign.dev.payload.todo;

import com.kosign.dev.payload.todo.user.UserRequest;
import lombok.ToString;

public record TodoRequest(String title , Boolean status, Integer userId) {

}
