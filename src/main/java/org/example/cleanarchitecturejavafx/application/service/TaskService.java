package org.example.cleanarchitecturejavafx.application.service;

import org.example.cleanarchitecturejavafx.application.dto.TaskDTO;
import org.example.cleanarchitecturejavafx.domain.model.Task;
import org.example.cleanarchitecturejavafx.domain.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

// Use Case
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
        return null;
    }

    private Task mapToEntity(TaskDTO dto) {
        return null;
    }
}
