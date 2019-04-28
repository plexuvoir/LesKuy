package com.example.leskuy;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ViewHolder> {

    private Context context;
    private List<List_Jadwal> listJadwals;

    public JadwalAdapter(Context context, List<List_Jadwal> data) {
        this.context = context;
        this.listJadwals = data;
    }

    @Override
    public JadwalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_jadwal, parent, false);
        return new JadwalAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(JadwalAdapter.ViewHolder holder, final int position) {
        List_Jadwal listJadwal = listJadwals.get(position);
        holder.hari.setText(listJadwal.getHari());
        List<List_Jam> singleItem = listJadwal.getListJams();
        JamAdapter jamAdapter = new JamAdapter(context, singleItem);

        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(jamAdapter);

    }

    @Override
    public int getItemCount() {
        return listJadwals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView hari;
        private RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            hari = itemView.findViewById(R.id.list_jadwal_hari_text_view);
            recyclerView = itemView.findViewById(R.id.list_jadwal_horizontal_recycler_view);
        }
    }
}