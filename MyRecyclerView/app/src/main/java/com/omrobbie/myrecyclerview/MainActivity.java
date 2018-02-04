package com.omrobbie.myrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
        rv_list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv_list.setAdapter(adapter);

        loadDummyData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Anda mengklik tombol " + item.toString(), Toast.LENGTH_SHORT).show();

        switch (item.getItemId()) {
            case R.id.mn_1:
                break;

            case R.id.mn_2:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void loadDummyData() {
        for (int i = 1; i < 10; i++) {
            itemData.add(new ItemData(R.drawable.iak, "Data " + String.valueOf(i), "Content data " + String.valueOf(i)));
        }
    }
}
