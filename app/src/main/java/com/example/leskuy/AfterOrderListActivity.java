package com.example.leskuy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AfterOrderListActivity extends AppCompatActivity {

    public List<List_After_Order_List> list_after_orders = new ArrayList<List_After_Order_List>();
    public RecyclerView recycler_after_order;
    public RecyclerView.Adapter adapter_after_order;
    private FirebaseDatabase db;
    private LinearLayoutManager linearLayoutManager;
    private FirebaseAuth auth;
    HashMap<String, String> after_order = new HashMap<>();
    private AfterOrderListAdapter adapter;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_order_list);
        recycler_after_order = findViewById(R.id.recycler_after_order);
        recycler_after_order.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recycler_after_order.setLayoutManager(linearLayoutManager);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        db.getReference("Pesanan").child(auth.getCurrentUser().getUid().toString()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot sn : dataSnapshot.getChildren()) {
                    String nama = sn.child("nama").getValue(String.class);
                    Log.d("nama", nama);
                    String matpel = sn.child("mapel").getValue(String.class);
                    Log.d("mapel", matpel);
                    list_after_orders.add(new List_After_Order_List(nama,matpel,"28 April 2019","Belum Dikonfirmasi"));
                }
                adapter = new AfterOrderListAdapter(AfterOrderListActivity.this, list_after_orders);
                recycler_after_order.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
