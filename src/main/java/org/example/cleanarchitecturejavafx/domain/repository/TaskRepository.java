package org.example.cleanarchitecturejavafx.domain.repository;

import org.example.cleanarchitecturejavafx.domain.model.Task;

import java.util.List;

public interface TaskRepository {

    // по сути CRUD
    List<Task> findAll();
    Task save(Task task);
    void delete(Long id);
}
