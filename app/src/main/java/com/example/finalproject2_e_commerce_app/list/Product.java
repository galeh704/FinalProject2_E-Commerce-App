package com.example.finalproject2_e_commerce_app.list;

public class Product {
    public Product(String idProduct, String namaProduct, String harga, String stock, String deskripsi, String kategori, String gambarProduct) {
        this.idProduct = idProduct;
        this.namaProduct = namaProduct;
        this.harga = harga;
        this.stock = stock;
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.gambarProduct = gambarProduct;
    }

    private String idProduct, namaProduct , harga,stock, deskripsi, kategori , gambarProduct;

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        this.namaProduct = namaProduct;
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

    public String getDeskripsi() {
        return deskripsi;
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

    public String getGambarProduct() {
        return gambarProduct;
    }

    public void setGambarProduct(String gambarProduct) {
        this.gambarProduct = gambarProduct;
    }
}
