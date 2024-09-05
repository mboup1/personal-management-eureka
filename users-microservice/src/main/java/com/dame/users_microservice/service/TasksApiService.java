package com.dame.users_microservice.service;

import com.dame.users_microservice.dto.TaskDTO;
import com.dame.users_microservice.dto.UserTasksDTO;
import com.dame.users_microservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TasksApiService {
    public static final String BASE_URL = "http://tasks-microservice:8081/";
//    public static final String BASE_URL = "http://localhost:8081/";

    private RestClient restClient = RestClient.builder().baseUrl(BASE_URL).build();

    private final UserService userService;

    public UserTasksDTO getUserTasksDTO(Long id) {
        List<TaskDTO> taskDTOList = restClient.get().uri("api/tasks").retrieve().body(new ParameterizedTypeReference<List<TaskDTO>>() {
        });

        Optional<User> userOptional = userService.getUserById(id);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with id : " + id);
        }

        User user = userOptional.get();

        return UserTasksDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .tasks(taskDTOList)
                .build();
    }

}
