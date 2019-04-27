package com.example.leskuy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    Button daftar;
    LinearLayout siswa, tutor;
    Spinner kelamin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        daftar = findViewById(R.id.register_daftar_button);
        siswa = findViewById(R.id.register_siswa_linear_layout);
        tutor = findViewById(R.id.register_tutor_linear_layout);
        kelamin = findViewById(R.id.register_spinner);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        siswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutor.setBackgroundColor(Color.parseColor("#E0E0E4"));
                siswa.setBackgroundColor(Color.parseColor("#A5A3B4"));

            }
        });

        tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutor.setBackgroundColor(Color.parseColor("#A5A3B4"));
                siswa.setBackgroundColor(Color.parseColor("#E0E0E4"));
            }
        });


        // Initializing a String Array
        String[] jenisKelamin = new String[]{
                "Jenis Kelamin",
                "Laki-laki",
                "Perempuan"
        };

        final List<String> kelaminList = new ArrayList<>(Arrays.asList(jenisKelamin));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, kelaminList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        kelamin.setAdapter(spinnerArrayAdapter);
    }
}
