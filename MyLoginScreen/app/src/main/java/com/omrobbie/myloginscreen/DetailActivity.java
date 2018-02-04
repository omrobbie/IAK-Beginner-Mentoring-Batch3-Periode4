package com.omrobbie.myloginscreen;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        sharedPreferences = getSharedPreferences("login_data", MODE_PRIVATE);

        String prefCheck = sharedPreferences.getString("dataOn", null);
        String prefUsername = sharedPreferences.getString("username", null);

        if (prefCheck != null) {
            tv_username.setText(prefUsername);
        }
    }
}
