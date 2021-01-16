package com.test.framework;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HandlerThreadActivity extends AppCompatActivity {
    Handler handler ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ImageView imageView = findViewById(R.id.images1);
        ImageView imageView2 = findViewById(R.id.images2);

        HandlerThread thread = new HandlerThread("work");
        thread.start();

         handler = new Handler(thread.getLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1:
                        Bitmap image = getImage((String) msg.obj);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView.setImageBitmap(image);
                            }
                        });
                        break;
                    case 2:
                        Bitmap image2 = getImage("https://i.8kmm.com/2020/09/c860b-6_f1__3b87844441.jpg");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                imageView2.setImageBitmap(image2);
                            }
                        });
                        break;

                }
                return true;
            }
        });

    }



    public void click1(View view) {
        Message message = Message.obtain();
        message.what=1;
        message.obj = "https://i.8kmm.com/2020/09/cc2ea-6_f1__0b534ba5cd.jpg";
        handler.sendMessage(message);
    }
    public Bitmap getImage(String path) {
        URL url = null;
       Bitmap bitmap=null;
        try {
            url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置连接超时为5秒
            conn.setConnectTimeout(5000);
            // 设置请求类型为Get类型
            conn.setRequestMethod("GET");
            // 判断请求Url是否成功
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("请求url失败");
            }
            InputStream inStream = conn.getInputStream();
             byte[] bt = read(inStream);
            inStream.close();
            if (bt != null) {
                bitmap = BitmapFactory.decodeByteArray(bt, 0, bt.length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public  byte[] read(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = inStream.read(buffer)) != -1)
        {
            outStream.write(buffer,0,len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    public void click2(View view) {
        Message message = Message.obtain();
        message.what=2;
        message.obj = "https://i.8kmm.com/2020/09/f0849-6_f1__43592e805a.jpg";
        handler.sendMessage(message);
    }
}
