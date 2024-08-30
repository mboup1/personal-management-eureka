package com.dame.users_microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserTasksDTO {
    private String username;
    private String email;
    private String password;

    private List<TaskDTO> tasks;

}
