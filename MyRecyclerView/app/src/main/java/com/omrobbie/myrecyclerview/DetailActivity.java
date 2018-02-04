package com.omrobbie.myrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView iv_avatar;
    private TextView tv_judul;
    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        int avatar = intent.getIntExtra("avatar", R.drawable.iak);
        String judul = intent.getStringExtra("judul");
        String content = intent.getStringExtra("content");

        iv_avatar = (ImageView) findViewById(R.id.iv_avatar);
        tv_judul = (TextView) findViewById(R.id.tv_judul);
        tv_content = (TextView) findViewById(R.id.tv_content);

        iv_avatar.setImageResource(avatar);
        tv_judul.setText(judul);
        tv_content.setText(content);
    }
}
