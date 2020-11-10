package com.test.interview.android_ui.android_fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.test.interview.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentAct extends AppCompatActivity {
    private String TAG = FragmentA.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "FragmentAct onCreate");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        addContentView(linearLayout, params);
        Button button = new Button(this);
        button.setAllCaps(false);
        button.setText("add fragmentA");
        linearLayout.addView(button);
        Button button1 = new Button(this);
        button1.setText("replace fragmentB");
        button1.setAllCaps(false);
        linearLayout.addView(button1);
        final FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        frameLayout.setId(R.id.id_1);
        linearLayout.addView(frameLayout, params1);
        FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.id_1, new FragmentA(), "fragmentA").commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.add(R.id.id_1, new FragmentA(), "fragmentA").commit();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

