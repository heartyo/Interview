package com.test.ui.recycleview;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


import com.test.ui.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecycleViewAct extends AppCompatActivity {
    View view1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_act);
        view1 = findViewById(R.id.fl1);

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}
