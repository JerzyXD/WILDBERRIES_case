package com.example.wildberries_employee.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.wildberries_employee.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.wildberries_employee.Activity.LoginActivity.getAddress;
import static com.example.wildberries_employee.Classes.DataManager.getInfo;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(getAddress());
        System.out.println(getInfo());

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
