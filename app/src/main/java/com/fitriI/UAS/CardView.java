package com.fitriI.UAS;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class CardView extends RecyclerView.Adapter<CardView.CardViewHolder> {

    private ArrayList<Khulafa>ListKhulafa;
    private Context context;
    private Activity activity;
    private ArrayList<Khulafa> listKhulafa;

    public CardView(ArrayList<Khulafa> listKhulafa, Context context) {
        ListKhulafa = listKhulafa;
        this.context = context; }
    public ArrayList<Khulafa> getListKhulafa() {
        return listKhulafa;
    }

    public void setListKhulafa(ArrayList<Khulafa> listKhulafa) {
        this.listKhulafa = listKhulafa;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_khulafa, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        final Khulafa k = getListKhulafa().get(position);
        Glide.with(context).load(k.getPhoto()).override(350,550).into(holder.imgPhoto);
        holder.tvname.setText(k.getName());
        holder.tvremarks.setText(k.getRemarks());
        holder.khulafa = k;



        holder.btnsahre.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share"+getListKhulafa().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));


    }

    @Override
    public int getItemCount() {
        return getListKhulafa().size();
    }

    public void startactivity(Intent intent){

    }
    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvname, tvremarks;
        Button btndetail, btnsahre;
        Khulafa khulafa;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvname = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvremarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnsahre = (Button)itemView.findViewById(R.id.btn_set_share);
            btndetail = (Button)itemView.findViewById(R.id.btn_set_detail);
            btndetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailKhulafaActivity.class);
            intent.putExtra("key", khulafa);
            context.startActivity(intent);
        }
    }
}




