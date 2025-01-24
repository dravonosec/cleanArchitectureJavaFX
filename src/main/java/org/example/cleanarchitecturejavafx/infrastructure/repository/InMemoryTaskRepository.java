package org.example.cleanarchitecturejavafx.infrastructure.repository;

import org.example.cleanarchitecturejavafx.domain.model.Task;
import org.example.cleanarchitecturejavafx.domain.repository.TaskRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTaskRepository implements TaskRepository {
    private final Map<Long, Task> tasks = new HashMap<>();
    private Long nextId = 1L;

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(nextId++);
        }
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public void delete(Long id) {}
}
