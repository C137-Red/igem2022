package com.example.myapplication;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            Button loginButton = findViewById(R.id.lg_login);
            EditText usn = findViewById(R.id.lg_username);//用户名
            EditText pw = findViewById(R.id.lg_password);//密码
            CheckBox cb = findViewById(R.id.lg_rememberPsd);//记住密码

            //登录
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(usn.getText().toString().equals("igem") && pw.getText().toString().equals("2022"))
                    {
                        Toast.makeText(getApplicationContext(), "欢迎，igem2022",
                                Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(LoginActivity.this, WikiActivity.class);
                        //账号密码正确则登入主界面
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "账号或密码不正确",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //注册跳转
            TextView register = findViewById(R.id.lg_register);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivityForResult(intent, 1);
                }
            });
        }

        //接受传回来的账号
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            switch (requestCode) {
                case 1:
                    if (resultCode == RESULT_OK) {
                        final EditText loginUsername = findViewById(R.id.lg_username);
                        String returnUsername = data.getStringExtra("username");
                        loginUsername.setText(returnUsername);
                        loginUsername.setSelection(returnUsername.length());
                    }
                    break;
                default:
            }
        }

    }
