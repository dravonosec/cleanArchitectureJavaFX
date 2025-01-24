package org.example.cleanarchitecturejavafx.presentation.viewmodel;

import javafx.beans.property.*;
import org.example.cleanarchitecturejavafx.application.dto.TaskDTO;

public class TaskViewModel {
    private final StringProperty title = new SimpleStringProperty();
    private final BooleanProperty completed = new SimpleBooleanProperty();
    private final ObjectProperty<TaskDTO> taskDTO = new SimpleObjectProperty<>();

    public TaskViewModel(TaskDTO dto) {
        this.taskDTO.set(dto);
        title.set(dto.getTitle());
        completed.set(dto.isCompleted());

        // Обновление DTO при изменении свойств
        title.addListener((obs, oldVal, newVal) -> {
            TaskDTO current = taskDTO.get();
            current.setTitle(newVal);
        });

        completed.addListener((obs, oldVal, newVal) -> {
            TaskDTO current = taskDTO.get();
            current.setCompleted(newVal);
        });
    }

    public StringProperty titleProperty() {
        return title;
    }

    public BooleanProperty completedProperty() {
        return completed;
    }

    public TaskDTO getTaskDTO() {
        return taskDTO.get();
    }
}
