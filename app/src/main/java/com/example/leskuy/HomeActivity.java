package com.example.leskuy;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements BottomSheetDialog.BottomSheetListener {

    Button pilihKelas;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.commit();


        HomeKosongFragment fragment = new HomeKosongFragment();
        fragmentTransaction.add(R.id.home_mata_pelajaran_fragment, fragment);

        pilihKelas = findViewById(R.id.home_pilih_kelas_button);
        pilihKelas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(),"bottomSheet");

            }
        });
    }

    @Override
    public void onButtonClicked(String text) {
        pilihKelas.setText(text);
//        startActivity(new Intent(HomeActivity.this, SignInActivity.class));
    }
}