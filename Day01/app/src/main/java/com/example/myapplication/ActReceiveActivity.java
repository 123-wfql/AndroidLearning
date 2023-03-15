package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.util.DataUtil;

public class ActReceiveActivity extends AppCompatActivity implements View.OnClickListener {

    private String respond = "给您回个礼";
    private int respond_count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_receive);

        TextView tv_respond = findViewById(R.id.tv_respond);


        tv_respond.setText(respond);


        Button btn_respond = findViewById(R.id.btn_respond);

        btn_respond.setOnClickListener(this);

        showMetaData();

        TextView tv_receive = findViewById(R.id.tv_receive);
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");
        String request_count = bundle.getString("request_count");
        String result = String.format("收到请求消息：\n请求时间：%s\n请求内容：%s\n请求次数：%s", request_time, request_content, request_count);
        tv_receive.setText(result);
    }

    private void showMetaData() {
        try {
            TextView tv_author = findViewById(R.id.tv_author);
            PackageManager pm = getPackageManager();
            ActivityInfo act = pm.getActivityInfo(getComponentName(),PackageManager.GET_META_DATA);
            Bundle bundle = act.metaData;
            String value = bundle.getString("author");
            tv_author.setText("作者是：" + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_respond:
                Intent intent = new Intent(this, ActSendActivity.class);
                Bundle bundle = new Bundle();
                TextView tv_respond = findViewById(R.id.tv_respond);
                bundle.putString("respond_time", DataUtil.getNowTime());
                bundle.putString("respond_content", tv_respond.getText().toString());
                respond_count += 1;
                bundle.putString("respond_count", Integer.toString(respond_count));
                intent.putExtras(bundle);
                setResult(Activity.RESULT_OK, intent);
                finish();
            default:
                break;
        }
    }
}