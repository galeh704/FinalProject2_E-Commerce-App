package com.example.finalproject2_e_commerce_app.list;

public class Barang {
    private String idBarang, namaBarang,harga,stock,deskripsi,kategori,gambarBarang;

    public Barang(String idBarang, String namaBarang, String harga, String stock, String deskripsi, String kategori, String gambarBarang){
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.stock = stock;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.gambarBarang = gambarBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDeskripsi() { return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGambarBarang() {
        return gambarBarang;
    }

    public void setGambarBarang(String gambarBarang) {
        this.gambarBarang = gambarBarang;
    }
}
