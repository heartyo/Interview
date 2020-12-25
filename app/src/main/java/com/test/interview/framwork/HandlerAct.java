package com.test.interview.framwork;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HandlerAct extends AppCompatActivity {


    private Button button;
    private Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        addContentView(linearLayout, params);
        button = new Button(this);
        button.setText("子线程运行Handler");

        button2 = new Button(this);
        button2.setText("子线程发送消息到主线程");
        button.setOnClickListener((v) -> {
            runChildThreadHandler();
        });
        button2.setOnClickListener((v) -> {
            if (handler2 != null) {
                Message message = Message.obtain();
                message.obj = "我是小李";
                handler2.sendMessage(message);
            }
        });
        linearLayout.addView(button);
        linearLayout.addView(button2);
        runChildThreadSendMsg();
    }

    //子线程创建Handler
    private void runChildThreadHandler() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler h = new Handler() {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        Log.d("message==>", "what:" + msg.what);
                    }
                };
                h.sendEmptyMessage(100);
                Looper.loop();

            }
        }).start();
    }


    Handler handler2 = null;
    private void runChildThreadSendMsg(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                handler2 = new Handler(){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);
                        Log.d("message==>", msg.obj.toString());
                    }
                };
                Looper.loop();
            }
        }).start();
    }
}
