package com.fitriI.UAS;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Khulafa>listKhulafa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        listKhulafa = new ArrayList<>();
        listKhulafa.addAll(KhulafaData.getListData());
        showRecyclerCardView();

    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardView cardViewPresidentAdapter= new CardView(listKhulafa, this);
        cardViewPresidentAdapter.setListKhulafa(listKhulafa);
        rvCategory.setAdapter(cardViewPresidentAdapter);

    }

}
