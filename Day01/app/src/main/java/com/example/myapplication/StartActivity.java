package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btn_androidStart = findViewById(R.id.btn_androidStart);
        Button btn_sendAndReceive = findViewById(R.id.btn_sendAndReceive);


        btn_androidStart.setOnClickListener(this);
        btn_sendAndReceive.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_androidStart:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.btn_sendAndReceive:
                startActivity(new Intent(this, ActSendActivity.class));
                break;
            default:
                break;
        }
    }


}