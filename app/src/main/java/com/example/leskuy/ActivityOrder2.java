package com.example.leskuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityOrder2 extends AppCompatActivity {
    List<List_Jadwal> listJadwal;
    List<List_Jam> listJam;
    RecyclerView verticalRecycler, horizontalRecycler;
    JadwalAdapter jadwalAdapter;
    Button pesan;
    TextView namaTutor, mataPelajaranTutor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);

        pesan = findViewById(R.id.order2_pesan_button);

        listJam = new ArrayList<>();
        listJadwal = new ArrayList<>();

        verticalRecycler = findViewById(R.id.order2_vertical_recycler_view);
        verticalRecycler.setHasFixedSize(true);
        verticalRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        horizontalRecycler = findViewById(R.id.list_jadwal_horizontal_recycler_view);

        // data to populate the RecyclerView with
        listJam.add(new List_Jam("00.00", "01.00"));
        listJam.add(new List_Jam("01.00", "02.00"));
        listJam.add(new List_Jam("02.00", "03.00"));
        listJam.add(new List_Jam("03.00", "04.00"));
        listJam.add(new List_Jam("04.00", "05.00"));
        listJam.add(new List_Jam("05.00", "06.00"));
        listJam.add(new List_Jam("06.00", "07.00"));
        listJam.add(new List_Jam("07.00", "08.00"));
        listJam.add(new List_Jam("08.00", "09.00"));
        listJam.add(new List_Jam("09.00", "10.00"));
        listJadwal.add(new List_Jadwal("Senin", listJam.subList(0, 5)));
        listJadwal.add(new List_Jadwal("Selasa", listJam.subList(6, 10)));

        jadwalAdapter = new JadwalAdapter(ActivityOrder2.this, listJadwal);
        verticalRecycler.setAdapter(jadwalAdapter);

//        Intent intent = new Intent(ActivityOrder2.this, AfterOrderListActivity.class);
//        startActivity(intent);

        namaTutor = findViewById(R.id.order2_nama_tutor_text_view);
        Intent intent = getIntent();
        namaTutor.setText(intent.getStringExtra("nama"));
    }


}
