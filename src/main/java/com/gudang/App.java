package com.gudang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resourceUrl = App.class.getResource("/view/Login.fxml");
        Parent root = FXMLLoader.load(resourceUrl);
        primaryStage.setTitle("Login - Aplikasi Gudang");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}