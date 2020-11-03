package com.example.test.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;

public class Welcom2 extends AppCompatActivity {
    @BindView(R.id.welcom1_main_linear)
    LinearLayout welcom1_main_linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom2);

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
                        Intent intent = new Intent(this, Welcom1.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                    }

                    // Right to left swipe action
                    else {
                        Intent intent = new Intent(this, Welcom3.class);
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
        Intent intent = new Intent(this, Welcom1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

}