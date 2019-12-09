package com.fitriI.UAS;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;

public class DetailKhulafaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_khulafa);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Khulafa khulafaditerima = getIntent().getParcelableExtra("key");

        ImageView gamabar = (ImageView)findViewById(R.id.img_item_photo);
        TextView name = (TextView)findViewById(R.id.tv_item_name);
        TextView remarks = (TextView)findViewById(R.id.tv_item_remarks);
        TextView deskripsi = (TextView)findViewById(R.id.content_detail);
        TextView lahir = (TextView)findViewById(R.id.content_lahir);
        TextView wafat = (TextView)findViewById(R.id.content_wafat);

        Glide.with(this).load(khulafaditerima.getPhoto()).override(350,550).into(gamabar);
        name.setText(khulafaditerima.getName());
        remarks.setText(khulafaditerima.getRemarks());
        deskripsi.setText(khulafaditerima.getDeskripsi());
        lahir.setText(khulafaditerima.getLahir());
        wafat.setText(khulafaditerima.getWafat());

        Log.i("photo", khulafaditerima.getPhoto());
        Log.i("deskripsi", khulafaditerima.getDeskripsi());
    }


}
