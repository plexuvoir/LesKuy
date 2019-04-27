package com.example.leskuy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Button daftar;
    EditText edit_nama, edit_email, edit_password, edit_confirm_password, edit_no_hp;
    LinearLayout siswa, tutor;
    Spinner kelamin;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_nama = findViewById(R.id.edit_nama);
        edit_email = findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        edit_confirm_password = findViewById(R.id.edit_confirm_password);
        edit_no_hp = findViewById(R.id.edit_no_hp);

        daftar = findViewById(R.id.register_daftar_button);
        siswa = findViewById(R.id.register_siswa_linear_layout);
        tutor = findViewById(R.id.register_tutor_linear_layout);
        kelamin = findViewById(R.id.register_spinner);

        auth = FirebaseAuth.getInstance();
//        mDatabase = FirebaseDatabase.getInstance().getReference("Users");
        db = FirebaseDatabase.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                db.getReference("Users").child("123").child("1").setValue("TES9999");
                if (edit_nama.getText().toString().equalsIgnoreCase("")) {
                    edit_nama.setError("Tidak boleh kosong");
                } else if (edit_email.getText().toString().equalsIgnoreCase("")) {
                    edit_email.setError("Tidak boleh kosong");
                } else if (edit_password.getText().toString().equalsIgnoreCase("")) {
                    edit_password.setError("Tidak boleh kosong");
                } else if (edit_confirm_password.getText().toString().equalsIgnoreCase("")) {
                    edit_confirm_password.setError("Tidak boleh kosong");
                } else if (edit_no_hp.getText().toString().equalsIgnoreCase("")) {
                    edit_no_hp.setError("Tidak boleh kosong");
                } else if (!edit_password.getText().toString().equals(edit_confirm_password.getText().toString())) {
                    edit_confirm_password.setError("Password tidak cocok");
                }else if(kelamin.getSelectedItem().toString().trim().equalsIgnoreCase("Jenis Kelamin")){
                    Toast.makeText(RegisterActivity.this, "Jenis kelamin tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String emailString = edit_email.getText().toString().trim();
                    String passwordString = edit_password.getText().toString().trim();
                    Log.d("cekEmail", emailString);
                    auth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(RegisterActivity.this, "Alex ganteng", Toast.LENGTH_SHORT).show();
                            String retypePasswordString = edit_confirm_password.getText().toString().trim();
                            String namaString = edit_nama.getText().toString().trim();
                            String emailString = edit_email.getText().toString().trim();
                            String jenisKelaminString = kelamin.getSelectedItem().toString().trim();
                            String nomorHPString = edit_no_hp.getText().toString().trim();
                            //                         UserModel user = new UserModel(namaString, emailString, jenisKelaminString, nomorHPString);
//                            Map<String, Object> userDetail = user.dataToMap();
//                            Map<String, Object> childUpdates = new HashMap<>();
//                            childUpdates.put("ALEX GANTENG",userDetail);
//                            mDatabase.updateChildren(childUpdates);
//                            Log.d("alex",user.toString());
                            HashMap<String, Object> dataMap = new HashMap<String, Object>();
                            dataMap.put("nama", namaString);
                            dataMap.put("email", emailString);
                            dataMap.put("jenis_kelamin", jenisKelaminString);
                            dataMap.put("nomorHP", nomorHPString);
//                            Map<String, Object> childUpdates = new HashMap<>();
//                            childUpdates.put(auth.getCurrentUser().getUid(), dataMap);
//                            mDatabase.updateChildren(childUpdates);
                            int color = Color.TRANSPARENT;
                            Drawable background = siswa.getBackground();
                            if (background instanceof ColorDrawable)
                                color = ((ColorDrawable) background).getColor();
                            if (color == Color.parseColor("#A5A3B4")) {
                                mDatabase.child("Users").child("Siswa").child(auth.getCurrentUser().getUid().toString()).setValue(dataMap);
                            } else {
                                mDatabase.child("Users").child("Tutor").child(auth.getCurrentUser().getUid().toString()).setValue(dataMap);
                            }

//                            mDatabase.child("1").setValue(dataMap);
//                            Log.d("data", "onComplete: "+dataMap.toString());
//                            Log.d("tesss", auth.getCurrentUser().getUid().toString());
                            Toast.makeText(RegisterActivity.this, "Akun berhasil dibuat, silakan sign in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, SignInActivity.class));
                            finish();
                        }
                    });
//
                }
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
