package com.gudang.controller;

import com.gudang.model.Supplier;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormSupplierController {
    @FXML private TextField txtKode;
    @FXML private TextField txtNama;
    @FXML private TextField txtAlamat;
    @FXML private TextField txtTelepon;

    private Supplier supplierToEdit = null;
    private ObservableList<Supplier> daftarSupplier;
    private boolean isEditMode = false;

    public void setSupplierData(Supplier supplier, ObservableList<Supplier> daftarSupplier) {
        this.daftarSupplier = daftarSupplier;
        if (supplier != null) {
            this.supplierToEdit = supplier;
            this.isEditMode = true;
            txtKode.setText(supplier.getKode());
            txtKode.setDisable(true); 
            txtNama.setText(supplier.getNama());
            txtAlamat.setText(supplier.getAlamat());
            txtTelepon.setText(supplier.getTelepon());
        }
    }

    @FXML
    private void handleSimpan() {
        String kode = txtKode.getText();
        String nama = txtNama.getText();
        String telepon = txtTelepon.getText();

        if (kode.isEmpty() || nama.isEmpty() || telepon.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Field Kode, Nama, dan Telepon wajib diisi.");
            return;
        }

        if (isEditMode) {
            supplierToEdit.setNama(nama);
            supplierToEdit.setAlamat(txtAlamat.getText());
            supplierToEdit.setTelepon(telepon);
        } else {
            for (Supplier s : daftarSupplier) {
                if (s.getKode().equals(kode)) {
                    showAlert(Alert.AlertType.ERROR, "Error", "Kode supplier sudah ada.");
                    return;
                }
            }
            Supplier newSupplier = new Supplier(kode, nama, txtAlamat.getText(), telepon);
            daftarSupplier.add(newSupplier);
        }

        Stage stage = (Stage) txtKode.getScene().getWindow();
        stage.close();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}