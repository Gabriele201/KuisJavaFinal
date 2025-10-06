package com.gudang.controller;

import com.gudang.model.Barang;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class BarangController {
    @FXML private TextField txtNamaBarang;
    @FXML private TextField txtJumlah;
    @FXML private Button btnTambah;
    @FXML private TableView<Barang> tabelBarang;
    @FXML private TableColumn<Barang, String> kolomNama;
    @FXML private TableColumn<Barang, Integer> kolomJumlah;

    private ObservableList<Barang> daftarBarang = FXCollections.observableArrayList();
    private Barang barangDipilih = null;

    @FXML
    public void initialize() {
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kolomJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        tabelBarang.setItems(daftarBarang);
    }

    @FXML
    private void handleTambah() {
        String nama = txtNamaBarang.getText();
        String jumlahStr = txtJumlah.getText();

        if (nama.isEmpty() || jumlahStr.isEmpty()) {
            showAlert("Error", "Nama Barang dan Jumlah tidak boleh kosong!");
            return;
        }

        try {
            int jumlah = Integer.parseInt(jumlahStr);
            if (barangDipilih != null) {
                barangDipilih.setNama(nama);
                barangDipilih.setJumlah(jumlah);
                tabelBarang.refresh();
                btnTambah.setText("Tambah");
                barangDipilih = null;
            } else {
                daftarBarang.add(new Barang(nama, jumlah));
            }
            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Error", "Jumlah harus berupa angka!");
        }
    }

    @FXML
    private void handleEdit() {
        barangDipilih = tabelBarang.getSelectionModel().getSelectedItem();
        if (barangDipilih != null) {
            txtNamaBarang.setText(barangDipilih.getNama());
            txtJumlah.setText(String.valueOf(barangDipilih.getJumlah()));
            btnTambah.setText("Update");
        } else {
            showAlert("Info", "Pilih barang yang ingin di-edit.");
        }
    }

    @FXML
    private void handleHapus() {
        Barang selected = tabelBarang.getSelectionModel().getSelectedItem();
        if (selected != null) {
            daftarBarang.remove(selected);
        } else {
            showAlert("Info", "Pilih barang yang ingin dihapus.");
        }
    }

    private void clearFields() {
        txtNamaBarang.clear();
        txtJumlah.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}