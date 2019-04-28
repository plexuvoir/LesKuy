package com.example.leskuy;


public class List_Jam {
    private String waktuAwal, waktuAkhir;
    private boolean checked = false;

    public List_Jam(String waktuAwal, String waktuAkhir) {
        this.waktuAwal = waktuAwal;
        this.waktuAkhir = waktuAkhir;
    }

    public String getWaktuAwal() {
        return waktuAwal;
    }

    public void setWaktuAwal(String waktuAwal) {
        this.waktuAwal = waktuAwal;
    }

    public String getWaktuAkhir() {
        return waktuAkhir;
    }

    public void setWaktuAkhir(String waktuAkhir) {
        this.waktuAkhir = waktuAkhir;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
