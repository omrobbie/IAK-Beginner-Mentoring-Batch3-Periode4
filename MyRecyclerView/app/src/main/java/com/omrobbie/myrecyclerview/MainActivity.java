package com.omrobbie.myrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_list;
    private ItemAdapter adapter;

    private List<ItemData> itemData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ItemAdapter(itemData);

        rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setLayoutManager(new LinearLayoutManager(this));
        rv_list.setAdapter(adapter);

        loadDummyData();
    }

    private void loadDummyData() {
        for (int i= 1; i<10; i++) {
            itemData.add(new ItemData(R.drawable.iak, "Data " + String.valueOf(i), "Content data " + String.valueOf(i)));
        }
    }
}
