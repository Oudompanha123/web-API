package com.kosign.dev.service.todo.user;

import com.kosign.dev.domain.todo.user.UserRepository;
import com.kosign.dev.exception.CusNotFoundException;
import com.kosign.dev.payload.todo.user.UserMainRes;
import com.kosign.dev.payload.todo.user.UserRequest;
import com.kosign.dev.payload.todo.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

   @Override
   public void createUser(UserRequest payload) {
        var entity = userMapper.mapToUserEntity(payload);
        userRepository.save(entity);
   }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUserById(Integer id, UserRequest payload) {
            var entity = userRepository.findById(id)
                    .orElseThrow(() -> new CusNotFoundException("Todo Not Found"));

            entity.setUsername(payload.userName());
            userRepository.save(entity);
    }

    @Override
    public Object getUserList() {
        var users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream()
                .map(userMapper::mapToUserResponse)
                .collect(Collectors.toList());
        return new UserMainRes(userResponses);
    }

    @Override
    public Object getById(Integer userId) {
        return userRepository.findById(userId)
                .map(userMapper::mapToUserResponse)
                .orElseThrow(() -> new CusNotFoundException("User ID " + userId + " Not Found"));
    }
}
