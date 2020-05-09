package com.example.wildberries_employee.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.example.wildberries_employee.ServerConnection.URLSendRequest;

import androidx.annotation.RequiresApi;


public class SendInfoService extends Service {
    private static URLSendRequest url = new URLSendRequest(URLSendRequest.SERVER_IP, 5000);
    final String LOG_TAG = "myLogs";

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand");
        sendOnGlobalServer("123");
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void sendOnGlobalServer(String json) {
        String s = url.post("getInfo", "json=" + json);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
