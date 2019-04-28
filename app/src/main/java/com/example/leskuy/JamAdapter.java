package com.example.leskuy;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class JamAdapter extends RecyclerView.Adapter<JamAdapter.ViewHolder> {

    private Context context;
    private List<List_Jam> listJams;

    public JamAdapter(Context context, List<List_Jam> data) {
        this.context = context;
        this.listJams = data;
    }

    @Override
    public JamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_jam, parent, false);
        return new JamAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final JamAdapter.ViewHolder holder, final int position) {
        final List_Jam listJam = listJams.get(position);
        holder.waktuAwal.setText(listJam.getWaktuAwal());
        holder.waktuAkhir.setText(String.valueOf(listJam.getWaktuAkhir()));
        holder.checked = false;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.checked) {
                    holder.linearLayout.setBackgroundResource(R.drawable.round_card_off);
                    holder.waktuAwal.setTextColor(Color.parseColor("#7A66FC"));
                    holder.waktuAkhir.setTextColor(Color.parseColor("#7A66FC"));
                    holder.tandaMinus.setTextColor(Color.parseColor("#7A66FC"));
                    holder.checked = false;
                } else {
                    holder.linearLayout.setBackgroundResource(R.drawable.round_card_on);
                    holder.waktuAwal.setTextColor(Color.parseColor("#FFFFFF"));
                    holder.waktuAkhir.setTextColor(Color.parseColor("#FFFFFF"));
                    holder.tandaMinus.setTextColor(Color.parseColor("#FFFFFF"));
                    holder.checked = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView waktuAwal, waktuAkhir, tandaMinus;
        public LinearLayout linearLayout;
        private boolean checked = false;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.list_jam_linear_layout);
            waktuAwal = itemView.findViewById(R.id.list_jam_waktu_awal_text_view);
            waktuAkhir = itemView.findViewById(R.id.list_jam_waktu_akhir_text_view);
            tandaMinus = itemView.findViewById(R.id.list_jam_tanda_minus);
        }
    }
}