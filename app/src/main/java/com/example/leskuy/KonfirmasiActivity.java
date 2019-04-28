package com.example.leskuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class KonfirmasiActivity extends AppCompatActivity {

    TextView nama, mapel, jadwal, durasi, harga, namaLogo, mapelLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);
        nama = findViewById(R.id.konfirmasi_nama_tutor_text_view);
        mapel = findViewById(R.id.konfirmasi_mapel_text_view);
        jadwal = findViewById(R.id.konfirmasi_jadwal_text_view);
        durasi = findViewById(R.id.konfirmasi_durasi_text_view);
        harga = findViewById(R.id.konfirmasi_harga_text_view);
        namaLogo = findViewById(R.id.konfirmasi_nama_tutor_logo);
        mapelLogo = findViewById(R.id.konfirmasi_mapel_tutor_logo);

        Intent intent = getIntent();
        nama.setText(intent.getStringExtra("namaTutor"));
        mapel.setText(intent.getStringExtra("mataPelajaran"));
        jadwal.setText(intent.getStringExtra("jadwal"));
        durasi.setText(intent.getStringExtra("durasi"));
        harga.setText(intent.getStringExtra("harga"));
        namaLogo.setText(intent.getStringExtra("namaTutor"));
        mapelLogo.setText(intent.getStringExtra("mataPelajaran"));

    }
}
