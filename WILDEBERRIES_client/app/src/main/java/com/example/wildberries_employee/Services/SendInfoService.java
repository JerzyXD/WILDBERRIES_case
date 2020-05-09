package com.example.wildberries_employee.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.wildberries_employee.ServerConnection.URLSendRequest;


public class SendInfoService extends Service {
    private static URLSendRequest url = new URLSendRequest(URLSendRequest.SERVER_IP, 5000);
    final String LOG_TAG = "myLogs";

    public void onCreate() {
        super.onCreate();
        Log.d(LOG_TAG, "onCreate");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(LOG_TAG, "onStartCommand");
        sendOnGlobalServer();
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }


    void sendOnGlobalServer() {
        //String s = url.post();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
