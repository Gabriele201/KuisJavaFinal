package com.gudang.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {
    @FXML
    private void handleManajemenBarang() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Barang.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Manajemen Barang");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML private void handleManajemenSupplier() {}
    @FXML private void handleManajemenCustomer() {}
}