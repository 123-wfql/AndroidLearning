package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Button btn_jumpActivity2 = findViewById(R.id.btn_jumpActivity2);
        Button btn_jumpActivity3 = findViewById(R.id.btn_jumpActivity3);
        Button btn_jumpActivity4 = findViewById(R.id.btn_jumpActivity4);


        btn_jumpActivity2.setOnClickListener(this);
        btn_jumpActivity3.setOnClickListener(this);
        btn_jumpActivity4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_jumpActivity2) {
            Intent intent = new Intent(this, Main2Activity.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            //Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else if (view.getId() == R.id.btn_jumpActivity3) {
            Intent intent = new Intent(this, Main3Activity.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
        } else if (view.getId() == R.id.btn_jumpActivity4) {
            Intent intent = new Intent(this, MainActivity4.class);
            //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }
}