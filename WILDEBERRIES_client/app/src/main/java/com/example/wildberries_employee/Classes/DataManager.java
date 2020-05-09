package com.example.wildberries_employee.Classes;

import com.example.wildberries_employee.ServerConnection.URLSendRequest;

import static com.example.wildberries_employee.Activity.LoginActivity.getAddress;
import static com.example.wildberries_employee.Activity.MainActivity.getLocalAddress;

public class DataManager {

     private static URLSendRequest url = new URLSendRequest(URLSendRequest.SERVER_IP, 5000);
     private static URLSendRequest localUrl = new URLSendRequest(getLocalAddress(), 5000);

    public static String getLocalInfo() {
            String s;
            s = localUrl.get("getinfo?address=" + getAddress());
            System.out.println("Get Local Info: " + s);
            return s;
    }

    /**
     * отправка данных на локальный сервер
     */
    public static String getGlobalInfo() {
        return url.get("getinfo?address=" + getAddress());
    }

}
