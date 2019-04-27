package com.example.leskuy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alex on 3/25/2019.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context context;
    private List<List_Order> my_data;

    public OrderAdapter(Context context, List<List_Order> my_data) {
        this.context = context;
        this.my_data = my_data;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tutor,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
//        holder.nama.setText();
//        holder.harga.setText();
//        holder.alamat.setText();
//        holder.rating.setText();

        holder.card_tutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), CommentActivity.class);
//                intent.putExtra("id", String.valueOf(my_data.get(position).getId()));
//                intent.putExtra("title", String.valueOf(my_data.get(position).getTitle()));
//                intent.putExtra("body", String.valueOf(my_data.get(position).getBody()));
//                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nama, alamat, harga, rating;
        public CardView card_tutor;
        public ViewHolder(View itemView){
            super(itemView);
            card_tutor = (CardView) itemView.findViewById(R.id.card_tutor);
            nama = itemView.findViewById(R.id.txt_nama);
            alamat = itemView.findViewById(R.id.txt_alamat);
            harga = itemView.findViewById(R.id.txt_harga);
            rating = itemView.findViewById(R.id.txt_rating);
        }
    }

}
