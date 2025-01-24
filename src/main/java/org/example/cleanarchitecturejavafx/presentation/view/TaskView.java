package org.example.cleanarchitecturejavafx.presentation.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.cleanarchitecturejavafx.application.dto.TaskDTO;
import org.example.cleanarchitecturejavafx.application.service.TaskService;
import org.example.cleanarchitecturejavafx.presentation.viewmodel.TaskViewModel;

import java.util.List;

public class TaskView extends VBox {
    private final TaskService taskService;
    private final ListView<TaskViewModel> taskList;
    private final TextField titleField;

    public TaskView(TaskService taskService) {
        this.taskService = taskService;

        titleField = new TextField();
        titleField.setPromptText("Enter task title");

        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> addTask());

        taskList = new ListView<>();
        taskList.setCellFactory(param -> new ListCell<>() {
            private final CheckBox checkbox = new CheckBox();
            private final HBox container = new HBox(5);

            {
                container.getChildren().add(checkbox);
            }

            @Override
            protected void updateItem(TaskViewModel viewModel, boolean empty) {
                super.updateItem(viewModel, empty);
                if (empty || viewModel == null) {
                    setGraphic(null);
                } else {
                    checkbox.textProperty().bind(viewModel.titleProperty());
                    checkbox.selectedProperty().bind(viewModel.completedProperty());
                    setGraphic(container);
                }
            }
        });

        setSpacing(10);
        setPadding(new Insets(10));
        getChildren().addAll(titleField, addButton, taskList);

        refreshTasks();
    }

    private void addTask() {
        String title = titleField.getText().trim();
        if (!title.isEmpty()) {
            TaskDTO dto = new TaskDTO();
            dto.setTitle(title);
            dto.setCompleted(false);
            taskService.createTask(dto);
            titleField.clear();
            refreshTasks();
        }
    }

    private void refreshTasks() {
        List<TaskViewModel> viewModels = taskService.getAllTasks()
                .stream()
                .map(TaskViewModel::new)
                .toList();
        taskList.getItems().setAll(viewModels);
    }
}
