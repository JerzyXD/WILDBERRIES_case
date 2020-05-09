package com.example.wildberries_employee.Classes;

import com.example.wildberries_employee.ServerConnection.URLSendRequest;

import static com.example.wildberries_employee.Activity.LoginActivity.getAddress;

public class DataManager {

     private static URLSendRequest url = new URLSendRequest(URLSendRequest.SERVER_IP, 5000);
     private static URLSendRequest localUrl = new URLSendRequest(URLSendRequest.SERVER_IP, 5000);

    public static String getLocalInfo() {
        return localUrl.get("getInfo?address=" + getAddress());
    }

    /**
     * отправка данных на локальный сервер
     */
    public static String getGlobalInfo() {
        return url.get("getInfo?address=" + getAddress());
    }

}
