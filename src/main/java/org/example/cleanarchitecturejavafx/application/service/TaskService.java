package org.example.cleanarchitecturejavafx.application.service;

import org.example.cleanarchitecturejavafx.application.dto.TaskDTO;
import org.example.cleanarchitecturejavafx.domain.model.Task;
import org.example.cleanarchitecturejavafx.domain.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskDTO> getAllTasks() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public TaskDTO createTask(TaskDTO dto) {
        Task task = mapToEntity(dto);
        Task savedTask = repository.save(task);
        return mapToDTO(savedTask);
    }

    // маппинг методы
    private TaskDTO mapToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setCompleted(task.isCompleted());
        return taskDTO;
    }

    private Task mapToEntity(TaskDTO dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setCompleted(dto.isCompleted());
        return task;
    }
}
