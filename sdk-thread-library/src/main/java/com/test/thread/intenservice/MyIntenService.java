package com.test.thread.intenservice;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntenService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntenService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("MyIntenService", Thread.currentThread().getName());
        String data = intent.getStringExtra("data");
        if (!TextUtils.isEmpty(data)) {
            int count=0;
            while (count < 100) {
                try {
                    Thread.sleep(50);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
