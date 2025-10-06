package com.gudang.model;

import javafx.beans.property.SimpleStringProperty;

public class Supplier {
    private final SimpleStringProperty kode;
    private final SimpleStringProperty nama;
    private final SimpleStringProperty alamat;
    private final SimpleStringProperty telepon;

    public Supplier(String kode, String nama, String alamat, String telepon) {
        this.kode = new SimpleStringProperty(kode);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.telepon = new SimpleStringProperty(telepon);
    }

    public String getKode() { return kode.get(); }
    public String getNama() { return nama.get(); }
    public String getAlamat() { return alamat.get(); }
    public String getTelepon() { return telepon.get(); }

    public void setNama(String nama) { this.nama.set(nama); }
    public void setAlamat(String alamat) { this.alamat.set(alamat); }
    public void setTelepon(String telepon) { this.telepon.set(telepon); }

    public SimpleStringProperty kodeProperty() { return kode; }
    public SimpleStringProperty namaProperty() { return nama; }
    public SimpleStringProperty alamatProperty() { return alamat; }
    public SimpleStringProperty teleponProperty() { return telepon; }
}