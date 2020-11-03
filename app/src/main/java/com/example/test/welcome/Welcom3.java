package com.example.test.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test.R;
import com.example.test.main.Main;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class Welcom3 extends AppCompatActivity {

    @BindView(R.id.welcom1_main_linear)
    LinearLayout welcom1_main_linear;
    @BindView(R.id.textView4)
    TextView Skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom3);
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
                        Intent intent = new Intent(this, Welcom2.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                    }

                    // Right to left swipe action
                    else {

                    }

                } else {
                    // consider as something else - a screen tap for example
                }
                break;
        }

        return true;
    }

    @OnClick(R.id.textView4)
    public void onClick(View v) {

        Intent intent=new Intent(this, Main.class);
        startActivity(intent);

    }




    public void onBackPressed() {

        Intent intent = new Intent(this, Welcom2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
    }

}