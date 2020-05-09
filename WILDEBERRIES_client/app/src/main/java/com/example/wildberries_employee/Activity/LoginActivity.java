package com.example.wildberries_employee.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wildberries_employee.R;
import com.example.wildberries_employee.ServerConnection.URLSendRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginActivity extends AppCompatActivity {

    static SharedPreferences settings;
    private URLSendRequest url = new URLSendRequest(URLSendRequest.SERVER_IP, 5000);

    @SuppressLint("ShowToast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        settings = getSharedPreferences("test", Context.MODE_PRIVATE);

        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(v -> {

            TextView loginText = findViewById(R.id.login);
            TextView passwordText = findViewById(R.id.password);
            String login =  loginText.getText().toString();
            String password = passwordText.getText().toString();

                try {
                    String s = url.get("log?login=" + login + "&password=" + password);
                    System.out.println(s);
                    JSONObject jsonObject = new JSONObject(s);

                    switch (jsonObject.getString("err")) {
                        case "0":
                            Logger.getLogger("intlog").log(Level.INFO, s);

                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("login", jsonObject.getString("login"));
                        editor.putString("position", jsonObject.getString("position"));
                        editor.putString("address", jsonObject.getString("address"));
                        editor.apply();

                            Intent intent = new Intent(this, MainActivity.class);
                            startActivity(intent);
                            break;
                        case "1":
                            makeToast(getString(R.string.login_err1));
                            break;
                        case "2":
                            makeToast(getString(R.string.login_err2));
                            break;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

        });
    }

    private void makeToast(String text) {
        Toast toast = Toast.makeText(getApplicationContext(),
                text,
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public static String getAddress() {
       return settings.getString("address", "  ");
    }
}
