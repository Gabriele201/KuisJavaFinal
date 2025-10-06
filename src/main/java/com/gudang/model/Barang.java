package com.gudang.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Barang {
    private final SimpleStringProperty nama;
    private final SimpleIntegerProperty jumlah;

    public Barang(String nama, int jumlah) {
        this.nama = new SimpleStringProperty(nama);
        this.jumlah = new SimpleIntegerProperty(jumlah);
    }

    public String getNama() { return nama.get(); }
    public SimpleStringProperty namaProperty() { return nama; }
    public void setNama(String nama) { this.nama.set(nama); }

    public int getJumlah() { return jumlah.get(); }
    public SimpleIntegerProperty jumlahProperty() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah.set(jumlah); }
}