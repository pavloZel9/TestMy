package com.example.test.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class Welcom1 extends AppCompatActivity {


    @BindView(R.id.welcom1_main_linear)
    LinearLayout welcom1_main_linear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom1);

        ButterKnife.bind(this);


    }

    private float x1, x2;
    static final int MIN_DISTANCE = 150;

    @OnTouch(R.id.welcom1_main_linear)
    public boolean onTouch(View view, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;

                if (Math.abs(deltaX) > MIN_DISTANCE) {
                    // Left to Right swipe action
                    if (x2 > x1) {

                    }

                    // Right to left swipe action
                    else {
                        Intent intent = new Intent(this, Welcom2.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.enter, R.anim.exit);
                    }

                } else {
                    // consider as something else - a screen tap for example
                }
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {

    }
}