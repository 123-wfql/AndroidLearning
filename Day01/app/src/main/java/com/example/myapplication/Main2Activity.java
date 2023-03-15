package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

        private static TextView tv_hello;

        int[] mArray = {
                R.drawable.little_sun_1,
                R.drawable.little_sun_2,
                R.drawable.juaner_1,
                R.drawable.juaner_2,
                R.drawable.yuanzai,
                R.drawable.quanzai,
                R.drawable.tingzai};



        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_hello = findViewById(R.id.tv_hello2);
        tv_hello.setText("再好，世界！");
        ImageView iv_random = findViewById(R.id.iv_random);

        Button btn_one = findViewById(R.id.btn_one);
        Button btn_two = findViewById(R.id.btn_two);
        Button btn_able = findViewById(R.id.btn_able);
        Button btn_xml = findViewById(R.id.btn_xml);
        Button btn_bigger = findViewById(R.id.btn_random);
        Button btn_backtomain = findViewById(R.id.btn_backtomain);
        Button btn_jumpActivity2 = findViewById(R.id.btn_jumpActivity2);
        Button btn_jumpActivity3 = findViewById(R.id.btn_jumpActivity3);
        Button btn_jumpActivity4 = findViewById(R.id.btn_jumpActivity4);

        btn_one.setOnClickListener(new MyOnClickListener());
        btn_two.setOnClickListener(this);
        btn_one.setOnLongClickListener(this);
        btn_two.setOnLongClickListener(this);
        btn_able.setOnClickListener(this);
        btn_bigger.setOnClickListener(this);
        btn_backtomain.setOnClickListener(this);
        btn_jumpActivity2.setOnClickListener(this);
        btn_jumpActivity3.setOnClickListener(this);
        btn_jumpActivity4.setOnClickListener(this);



        }



        @Override
        public void onClick(View v) {
                if (v.getId() == R.id.btn_able) {
                        Button btn_xml = findViewById(R.id.btn_xml);
                        Button btn_able = findViewById(R.id.btn_able);
                        if (btn_xml.isEnabled()) {
                                btn_xml.setTextColor(Color.GRAY);
                                btn_xml.setEnabled(false);
                                btn_able.setText("启用");
                        }else{
                                btn_xml.setTextColor(Color.BLACK);
                                btn_xml.setEnabled(true);
                                btn_able.setText("禁用");
                        }
                } else if (v.getId() == R.id.btn_random){
                        ImageView iv_random = findViewById(R.id.iv_random);
                        Random random = new Random();
                        int index = random.nextInt(7);
                        iv_random.setImageResource(mArray[index]);
                } else if (v.getId() == R.id.btn_backtomain) {
                        //startActivity(new Intent(this, MainActivity.class));
                        finish();
                } else if (v.getId() == R.id.btn_jumpActivity3) {
                        Intent intent = new Intent(this, Main3Activity.class);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                } else if (v.getId() == R.id.btn_jumpActivity2) {
                        Intent intent = new Intent(this, Main2Activity.class);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                        //Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                } else if (v.getId() == R.id.btn_jumpActivity4) {
                        Intent intent = new Intent(this, MainActivity4.class);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                } else {
                        String desc = String.format("页面监听点击了按钮：%s",  ((Button) v).getText());
                        tv_hello.setText(desc);
                }

        }

        public boolean onLongClick(View v) {
                String desc = String.format("页面监听长按了按钮：%s",  ((Button) v).getText());
                tv_hello.setText(desc);
                return true;
        }



        static class MyOnClickListener implements View.OnClickListener {
                @Override
                public void onClick(View view) {
                        String desc = String.format("新建监听点击了按钮：%s",  ((Button) view).getText());
                        tv_hello.setText(desc);
                }

        }
        public void doClick(View view) {
                String desc = String.format("您点击了按钮：%s",  ((Button) view).getText());
                tv_hello.setText(desc); // 设置文本视图的文本内容
        }


}
