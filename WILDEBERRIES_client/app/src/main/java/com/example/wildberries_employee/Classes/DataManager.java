package com.example.wildberries_employee.Classes;

import com.example.wildberries_employee.ServerConnection.URLSendRequest;

import static com.example.wildberries_employee.Activity.LoginActivity.getAddress;
import static com.example.wildberries_employee.Activity.MainActivity.getLocalAddress;

public class DataManager {

     private static URLSendRequest url = new URLSendRequest(URLSendRequest.SERVER_IP, 5000);
     private static URLSendRequest localUrl = new URLSendRequest(getLocalAddress(), 5000);

    /**
     * Получение данных с локального сервера
     * @return строка, полученная с сервера
     */

    public static String getLocalInfo() {
            String  s = localUrl.get("getinfo?address=" + getAddress());
            System.out.println("Get Local Info: " + s);
            return s;
    }

    /**
     * получение данных с глобального сервера
     * @return строка, полученная с сервера
     */
    public static String getGlobalInfo() {
        String s = url.get("getinfo?address=" + getAddress());
        System.out.println("Get global info" + s);
        return s;
    }

}
