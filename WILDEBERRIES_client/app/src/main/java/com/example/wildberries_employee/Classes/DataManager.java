package com.example.wildberries_employee.Classes;

import com.example.wildberries_employee.Activity.LoginActivity;
import com.example.wildberries_employee.ServerConnection.URLSendRequest;

import org.json.JSONObject;

import static com.example.wildberries_employee.Activity.LoginActivity.getAddress;

public class DataManager {

     private static URLSendRequest url = new URLSendRequest(URLSendRequest.SERVER_IP, 5000);

    public static String getInfo() {
        return url.get("getInfo?address=" + getAddress());
    }

    /**
     * отправка данных на локальный сервер
     */
    public static void sendOnLocalServer() {

    }


}
