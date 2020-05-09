package com.example.wildberries_employee.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wildberries_employee.R;
import com.example.wildberries_employee.ServerConnection.URLSendRequest;
import com.example.wildberries_employee.Services.SendOnGlobalServer;
import com.example.wildberries_employee.Services.SendOnLocalService;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.wildberries_employee.Activity.LoginActivity.getAddress;
import static com.example.wildberries_employee.Classes.DataManager.getGlobalInfo;
import static com.example.wildberries_employee.Classes.DataManager.getLocalInfo;

public class MainActivity extends AppCompatActivity {
    static SharedPreferences settings;
    public static String serverAddressText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView serverAddress = findViewById(R.id.serverAddress);
        settings = getSharedPreferences("test", Context.MODE_PRIVATE);
        serverAddress.setText(settings.getString("serverAddress", " "));
        serverAddressText = serverAddress.getText().toString();
        System.out.println(getLocalAddress());

           String jsonLocal = getLocalInfo();
                  String jsonGlobal = getGlobalInfo();
                  System.out.println(jsonGlobal);
                  System.out.println(jsonLocal);
                  System.out.println(getLocalAddress());

                  if (jsonGlobal != null) {
                      startService(new Intent(this, SendOnLocalService.class).putExtra("jsonG", jsonGlobal));
                      System.out.println("Отправка на локальный");
                  }

                  if (jsonLocal != null) {
                     startService(new Intent(this, SendOnGlobalServer.class).putExtra("jsonL", jsonLocal));
                      System.out.println("Отправка на глобальный");
                  }

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

    public static String getLocalAddress() {
        return serverAddressText;
    }
}
