package com.example.leskuy;

public class List_Order {
    private String nama, alamat;
    private double harga, rating;

    public List_Order(String nama, String alamat, double harga, double rating) {
        this.nama = nama;
        this.alamat = alamat;
        this.harga = harga;
        this.rating = rating;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
