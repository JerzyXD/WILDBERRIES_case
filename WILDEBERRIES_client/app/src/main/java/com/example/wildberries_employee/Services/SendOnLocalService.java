package com.example.wildberries_employee.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.example.wildberries_employee.ServerConnection.URLSendRequest;

import androidx.annotation.RequiresApi;

import static com.example.wildberries_employee.Activity.MainActivity.getLocalAddress;


public class SendOnLocalService extends Service {
    private static URLSendRequest localURL = new URLSendRequest(getLocalAddress(), 5000);
    final String LOG_TAG = "myLogs";

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand");
        String json = intent.getStringExtra("jsonG");
        sendOnLocalServer(json);
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void sendOnLocalServer(String json) {
        String s = localURL.post("getinfo", "json=" + json);
        System.out.println(s);
        System.out.println(json);
        if (s != null) {
            stopSelf();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
