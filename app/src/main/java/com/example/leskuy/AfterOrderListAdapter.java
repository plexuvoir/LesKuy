package com.example.leskuy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AfterOrderListAdapter extends RecyclerView.Adapter<AfterOrderListAdapter.ViewHolder>{
    private Context context;
    private List<List_After_Order_List> listAfterOrders;

    public AfterOrderListAdapter(Context context, List<List_After_Order_List> my_data) {
        this.context = context;
        this.listAfterOrders = my_data;
    }

    @NonNull
    @Override
    public AfterOrderListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pesanan,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AfterOrderListAdapter.ViewHolder holder, final int position) {
        List_After_Order_List listAfterOrder = listAfterOrders.get(position);
        holder.nama.setText(listAfterOrder.getNama());
        Log.d("nama2", listAfterOrder.getNama());
        holder.matpel.setText(listAfterOrder.getMatpel());
        holder.tanggal.setText(listAfterOrder.getTanggal());
        holder.status.setText(listAfterOrder.getStatus());
    }

    @Override
    public int getItemCount() {
        return listAfterOrders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nama, matpel, tanggal,status;
        public CardView card_pesanan;
        public ViewHolder(View itemView){
            super(itemView);
            card_pesanan= (CardView) itemView.findViewById(R.id.card_pesanan);
            nama = itemView.findViewById(R.id.txt_nama);
            matpel = itemView.findViewById(R.id.txt_matpel);
            tanggal = itemView.findViewById(R.id.txt_tanggal);
            status = itemView.findViewById(R.id.txt_status);
        }
    }
}
