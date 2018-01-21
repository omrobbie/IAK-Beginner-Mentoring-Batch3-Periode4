package com.omrobbie.myrelativelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupEnv();
    }

    private void setupEnv() {
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
    }

    public void loginClick(View view) {
        String uname = etUsername.getText().toString();
        String upass = etPassword.getText().toString();
        boolean isError = false;

        if (uname.isEmpty()) {
            isError = true;
            etUsername.setError("Username masih kosong!");
        }

        if (upass.isEmpty()) {
            isError = true;
            etPassword.setError("Password masih kosong!");
        }

        if (isError) {
            Toast.makeText(this, "Data anda belum lengkap!", Toast.LENGTH_SHORT).show();
        } else {
            if (uname.equals("admin") && upass.equals("123")) {
                Toast.makeText(this, "Anda berhasil login!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
