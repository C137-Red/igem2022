package com.example.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class LoadingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        TextView tv=findViewById(R.id.tips_tv);

        Random ra=new Random();
        String[] tips= {"Tips","水源消毒，从源头解决病毒！","Igem2022 welcome you!"};
        tv.setText(tips[ra.nextInt(tips.length)]);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoadingActivity.this, LoginActivity.class); //前者为跳转前页面，后者为跳转后页面
                startActivity(intent);
                finish();//从返回栈中剔除
            }
        }, 2500); //设置时间，自动跳转



    }
}
