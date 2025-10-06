package com.gudang.controller;

import com.gudang.model.Supplier;
import java.io.IOException;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SupplierController {
    @FXML private TableView<Supplier> tabelSupplier;
    @FXML private TableColumn<Supplier, String> kolomKode;
    @FXML private TableColumn<Supplier, String> kolomNama;
    @FXML private TableColumn<Supplier, String> kolomAlamat;
    @FXML private TableColumn<Supplier, String> kolomTelepon;

    private ObservableList<Supplier> daftarSupplier = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        kolomKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        kolomTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));
        tabelSupplier.setItems(daftarSupplier);
    }

    @FXML
    private void handleTambah() {
        showForm(null);
    }

    @FXML
    private void handleEdit() {
        Supplier selected = tabelSupplier.getSelectionModel().getSelectedItem();
        if (selected != null) {
            showForm(selected);
        } else {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih supplier yang ingin di-edit.");
        }
    }

    @FXML
    private void handleHapus() {
        Supplier selected = tabelSupplier.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Konfirmasi Hapus");
            confirm.setHeaderText("Apakah Anda yakin ingin menghapus supplier: " + selected.getNama() + "?");
            Optional<ButtonType> option = confirm.showAndWait();
            if (option.isPresent() && option.get() == ButtonType.OK) {
                daftarSupplier.remove(selected);
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih supplier yang ingin dihapus.");
        }
    }

    private void showForm(Supplier supplier) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FormSupplier.fxml"));
            Parent root = loader.load();

            FormSupplierController controller = loader.getController();
            controller.setSupplierData(supplier, daftarSupplier);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(supplier == null ? "Tambah Supplier Baru" : "Edit Supplier");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            tabelSupplier.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}