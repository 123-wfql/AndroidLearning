package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv_hello = findViewById(R.id.tv_hello);
        tv_hello.setText("你好，世界！");
        tv_hello.setTextColor(0xffff0000);
        tv_hello.setBackgroundResource(R.color.purple_200);
    }

    @Override
    protected void onResume() {
        super.onResume();
        goNextPage(); // 跳到下个页面
    }
    // 跳到下个页面
    private void goNextPage() {
        TextView tv_hello = findViewById(R.id.tv_hello);
        tv_hello.setText("3秒后进入下个页面");
// 延迟3秒（3000毫秒）后启动任务mGoNext
        new Handler(Looper.myLooper()).postDelayed(mGoNext, 3000);
    }
    private Runnable mGoNext = new Runnable() {
        @Override
        public void run() {
// 活动页面跳转，从MainActivity跳到Main2Activity
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        }
    };


}