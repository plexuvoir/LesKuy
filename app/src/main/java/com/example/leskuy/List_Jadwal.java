package com.example.leskuy;

import android.support.v7.widget.RecyclerView;

import java.util.List;

public class List_Jadwal {
    private String hari;
    private List<List_Jam> listJams;

    public List_Jadwal() {
    }

    public List_Jadwal(String hari, List<List_Jam> listJams) {
        this.hari = hari;
        this.listJams = listJams;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public List<List_Jam> getListJams() {
        return listJams;
    }

    public void setListJams(List<List_Jam> listJams) {
        this.listJams = listJams;
    }
}
