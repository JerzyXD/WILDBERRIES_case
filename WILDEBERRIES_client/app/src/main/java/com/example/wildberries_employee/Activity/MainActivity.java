package com.example.wildberries_employee.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wildberries_employee.R;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static SharedPreferences settings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView serverAddress = findViewById(R.id.serverAddress);
        settings = getSharedPreferences("test", Context.MODE_PRIVATE);
        serverAddress.setText(settings.getString("serverAddress", " "));
    }

    @Override
    protected void onPause() {
        super.onPause();
        TextView serverAddress = findViewById(R.id.serverAddress);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("serverAddress", serverAddress.getText().toString());
        editor.apply();
    }

    @Override
    public void onBackPressed() {

    }
}
