package com.example.orlog;

import com.example.orlog.Menu.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MenuController mc = new MenuController(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}