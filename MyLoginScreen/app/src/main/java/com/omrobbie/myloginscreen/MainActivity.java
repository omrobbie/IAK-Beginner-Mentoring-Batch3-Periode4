package com.omrobbie.myloginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_avatar)
    ImageView iv_avatar;

    @BindView(R.id.et_username)
    EditText et_username;

    @BindView(R.id.et_password)
    EditText et_password;

    @BindView(R.id.btn_login)
    Button btn_login;

    @BindView(R.id.btn_random)
    Button btn_random;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor login_data;

    RequestQueue requestQueue;

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

        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRandomUser();
            }
        });
    }

    public void getRandomUser() {
        requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://randomuser.me/api/",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject APIResponse = new JSONObject(response);
                            JSONArray results = (JSONArray) APIResponse.get("results");
                            JSONObject results_item = (JSONObject) results.get(0);
                            JSONObject results_item_login = (JSONObject) results_item.get("login");
                            JSONObject results_item_picture = (JSONObject) results_item.get("picture");

                            Glide.with(MainActivity.this)
                                    .load(results_item_picture.getString("medium"))
                                    .into(iv_avatar);
                            et_username.setText(results_item_login.getString("username"));
                            et_password.setText(results_item_login.getString("password"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        requestQueue.add(stringRequest);
    }
}
