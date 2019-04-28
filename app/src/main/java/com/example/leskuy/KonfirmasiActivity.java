package com.example.leskuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class KonfirmasiActivity extends AppCompatActivity {

    TextView nama, mapel, jadwal, durasi, harga, namaLogo, mapelLogo;
    private Button btn_konfirmasi, btn_batal;
    private DatabaseReference mDatabase;
    private FirebaseDatabase db;
    private FirebaseAuth auth;

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
        btn_konfirmasi = findViewById(R.id.konfirmasi_konfirmasi_button);
        btn_batal = findViewById(R.id.konfirmasi_batal_button);

        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        final Intent intent = getIntent();
        nama.setText(intent.getStringExtra("namaTutor"));
        mapel.setText(intent.getStringExtra("mataPelajaran"));
        jadwal.setText(intent.getStringExtra("jadwal"));
        durasi.setText(intent.getStringExtra("durasi"));
        harga.setText(intent.getStringExtra("harga"));
        namaLogo.setText(intent.getStringExtra("namaTutor"));
        mapelLogo.setText(intent.getStringExtra("mataPelajaran"));

        btn_batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KonfirmasiActivity.this, ActivityOrder2.class));
            }
        });

        btn_konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namaString = intent.getStringExtra("namaTutor");
                String mapelString = intent.getStringExtra("mataPelajaran");
                String jadwalString = intent.getStringExtra("jadwal");
                String durasiString = intent.getStringExtra("durasi");
                String hargaString = intent.getStringExtra("harga");
                HashMap<String, Object> dataMap = new HashMap<String, Object>();
                dataMap.put("nama", namaString);
                dataMap.put("mapel", mapelString);
                dataMap.put("jadwal", jadwalString);
                dataMap.put("durasi", durasiString);
                dataMap.put("harga", hargaString);
                mDatabase.child("Pesanan").child(auth.getCurrentUser().getUid().toString()).push().setValue(dataMap);
                startActivity(new Intent(KonfirmasiActivity.this, AfterOrderListActivity.class));
            }

        });

    }
}
