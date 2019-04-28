package com.example.leskuy;

public class List_After_Order_List {
    private String nama, matpel, tanggal, status;

    public List_After_Order_List(String nama, String matpel, String tanggal, String status) {
        this.nama = nama;
        this.matpel = matpel;
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMatpel() {
        return matpel;
    }

    public void setMatpel(String matpel) {
        this.matpel = matpel;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
