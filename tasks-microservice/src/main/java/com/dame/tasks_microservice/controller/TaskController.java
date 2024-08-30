package com.dame.tasks_microservice.controller;

import com.dame.tasks_microservice.entity.Task;
import com.dame.tasks_microservice.service.TaskService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
//service
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Optional<Task> optionalTask = taskService.getTaskById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setDueDate(taskDetails.getDueDate());
            taskService.saveTask(task);
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
