package com.example.leskuy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private EditText edit_email, edit_password;
    private Button btn_masuk;
    private TextView txt_daftar;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edit_email =  findViewById(R.id.edit_email);
        edit_password = findViewById(R.id.edit_password);
        btn_masuk =  findViewById(R.id.btn_masuk);
        txt_daftar = findViewById(R.id.txt_daftar);
        FirebaseApp.initializeApp(SignInActivity.this);
        auth = FirebaseAuth.getInstance();

        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_email.getText().toString().matches("") || edit_password.getText().toString().matches("")){
                    Toast.makeText(SignInActivity.this, "Mohon isi Email/Password!", Toast.LENGTH_SHORT).show();
                }
                else{
                    auth.signInWithEmailAndPassword(edit_email.getText().toString(),edit_password.getText().toString()).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                startActivity(new Intent(SignInActivity.this, Main2Activity.class));
                                finish();
                            }
                            else {
                                Toast.makeText(SignInActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}
