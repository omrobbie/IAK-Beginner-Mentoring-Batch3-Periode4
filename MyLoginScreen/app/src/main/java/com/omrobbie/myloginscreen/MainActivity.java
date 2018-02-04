package com.omrobbie.myloginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_username)
    EditText et_username;

    @BindView(R.id.et_password)
    EditText et_password;

    @BindView(R.id.btn_login)
    Button btn_login;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor login_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sharedPreferences = getSharedPreferences("login_data", MODE_PRIVATE);
        login_data = sharedPreferences.edit();

        String prefCheck = sharedPreferences.getString("dataOn", null);
        String prefUsername = sharedPreferences.getString("username", null);

        if (prefCheck != null) {
            et_username.setText(prefUsername);
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = et_username.getText().toString();
                String upass = et_password.getText().toString();

                if (!uname.isEmpty() && !upass.isEmpty()) {
                    login_data.putString("dataOn", "ON");
                    login_data.putString("username", uname);
                    login_data.apply();

                    Toast.makeText(MainActivity.this, "Login berhasil!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Data anda belum lengkap!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
