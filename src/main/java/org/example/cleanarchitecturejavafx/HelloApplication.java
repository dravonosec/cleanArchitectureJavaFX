package org.example.cleanarchitecturejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.cleanarchitecturejavafx.application.service.TaskService;
import org.example.cleanarchitecturejavafx.domain.repository.TaskRepository;
import org.example.cleanarchitecturejavafx.infrastructure.repository.InMemoryTaskRepository;
import org.example.cleanarchitecturejavafx.presentation.view.TaskView;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        TaskRepository repository = new InMemoryTaskRepository();
        TaskService service = new TaskService(repository);

        TaskView taskView = new TaskView(service);
        Scene scene = new Scene(taskView, 400, 600);

        stage.setTitle("Todo List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}