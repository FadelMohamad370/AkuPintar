package com.fadelmohamad.aku_pintar.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fadelmohamad.aku_pintar.Adapter.UniversitasAdapter;
import com.fadelmohamad.aku_pintar.Database.SQLiteHelper;
import com.fadelmohamad.aku_pintar.Model.UniversitasModel;
import com.fadelmohamad.aku_pintar.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvList;

    private SQLiteHelper db;
    private UniversitasAdapter adapter;
    private List<UniversitasModel> univer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new SQLiteHelper(this);

        rvList = findViewById(R.id.rv_univ);

        adapter = new UniversitasAdapter(this);
        rvList.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        rvList.setLayoutManager(layoutManager);
        rvList.setItemAnimator(new DefaultItemAnimator());
        rvList.setAdapter(adapter);


    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    private void getUnivtast(){
        univer = db.getUniv();
        adapter.setUniver(univer);
    }
}