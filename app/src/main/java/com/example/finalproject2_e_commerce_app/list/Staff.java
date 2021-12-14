package com.example.finalproject2_e_commerce_app.list;

public class Staff {
    private String idStaff, namaStaff,jabatan,email,password,kontak,gambar;

    public Staff(String idStaff, String namaStaff, String jabatan, String email, String password, String kontak, String gambar){
        this.idStaff = idStaff;
        this.namaStaff = namaStaff;
        this.jabatan = jabatan;
        this.email = email;
        this.password = password;
        this.kontak = kontak;
        this.gambar = gambar;

    }
    public Staff(){

    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getNamaStaff() {
        return namaStaff;
    }

    public void setNamaStaff(String namaStaff) {
        this.namaStaff = namaStaff;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }



}
