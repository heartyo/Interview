package com.test.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


import com.test.ui.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentAct extends AppCompatActivity {
    private String TAG = FragmentA.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "FragmentAct onCreate");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        addContentView(linearLayout, params);


        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        final FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        frameLayout.setId(R.id.id_1);

        final FrameLayout frameLayout2 = new FrameLayout(this);
        frameLayout2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        frameLayout2.setId(R.id.id_2);


        addButton(linearLayout,"add fragmentA", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.id_1, new FragmentA(), "fragmentA").commit();
            }
        });
        addButton(linearLayout,"replace fragmentB", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.id_2, new FragmentB(), "fragmentB").commit();
            }
        });

        linearLayout.addView(frameLayout,layoutParams);
        linearLayout.addView(frameLayout2,layoutParams);
    }

    private Button addButton(LinearLayout linearLayout,String text, View.OnClickListener listener) {
        Button button1 = new Button(this);
        button1.setText(text);
        button1.setAllCaps(false);
        linearLayout.addView(button1);
        button1.setOnClickListener(listener);
        return button1;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "FragmentAct onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "FragmentAct onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "FragmentAct onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "FragmentAct onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "FragmentAct onDestroy");
    }
}

