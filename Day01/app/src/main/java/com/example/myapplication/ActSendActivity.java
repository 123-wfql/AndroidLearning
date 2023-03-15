package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.util.DataUtil;


public class ActSendActivity extends AppCompatActivity implements View.OnClickListener {


    private int request_count;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_send);

        request_count = 0;
        String request = "给您拜个早年";

        TextView tv_request = findViewById(R.id.tv_request);
        TextView tv_author = findViewById(R.id.tv_author);

        tv_request.setText(request);
        tv_author.setText(R.string.app_author);

        Button btn_send = findViewById(R.id.btn_request);

        btn_send.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_request:
                Intent intent = new Intent(this, ActReceiveActivity.class);
                Bundle bundle = new Bundle();
                TextView tv_request = findViewById(R.id.tv_request);
                bundle.putString("request_time", DataUtil.getNowTime());
                bundle.putString("request_content", tv_request.getText().toString());
                request_count += 1;
                bundle.putString("request_count", Integer.toString(request_count));
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if  (intent!=null && requestCode==0 && resultCode== Activity.RESULT_OK) {
            Bundle bundle = intent.getExtras();
            TextView tv_result = findViewById(R.id.tv_result);
            String respond_time = bundle.getString("respond_time");
            String respond_content = bundle.getString("respond_content");
            String respond_count = bundle.getString("respond_count");
            String result = String.format("收到返回消息：\n应答时间：%s\n应答内容：%s\n应答次数：%s", respond_time, respond_content, respond_count);
            tv_result.setText(result);
        }
    }
}