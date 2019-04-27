package com.example.leskuy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        recycler_order = findViewById(R.id.recycler_order);
        recycler_order.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recycler_order.setLayoutManager(linearLayoutManager);

        adapter = new OrderAdapter(this,list_orders);

        recycler_order.setAdapter(adapter);



    }
}
