package com.omrobbie.myloginscreen;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_avatar)
    ImageView iv_avatar;

    @BindView(R.id.tv_username)
    TextView tv_username;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor login_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        sharedPreferences = getSharedPreferences("login_data", MODE_PRIVATE);
        login_data = sharedPreferences.edit();

        String prefCheck = sharedPreferences.getString("dataOn", null);
        String prefUsername = sharedPreferences.getString("username", null);

        if (prefCheck != null) {
            tv_username.setText(prefUsername);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_logout:
                login_data.clear();
                login_data.apply();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
