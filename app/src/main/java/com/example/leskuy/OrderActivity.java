package com.example.leskuy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    public List<List_Order> list_orders = new ArrayList<List_Order>();
    public RecyclerView recycler_order;
    public RecyclerView.Adapter adapter_order;
    private FirebaseDatabase db;
    private LinearLayoutManager linearLayoutManager;
    private FirebaseAuth auth;
    ArrayList<String> tanggalSet;
    HashMap<String, String> order = new HashMap<>();
    private OrderAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        recycler_order = findViewById(R.id.recycler_order);
        recycler_order.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recycler_order.setLayoutManager(linearLayoutManager);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();



        db.getReference("Users").child("Tutor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot sn : dataSnapshot.getChildren()) {
                    String nama = sn.child("nama").getValue(String.class);
                    Log.d("nama", nama);
                    list_orders.add(new List_Order(nama, "malang", 50000, 5));
                }
                adapter = new OrderAdapter(OrderActivity.this,list_orders);
                recycler_order.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
