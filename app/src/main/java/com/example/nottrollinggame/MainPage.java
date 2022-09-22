package com.example.nottrollinggame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.example.nottrollinggame.areyoudumb.AreYouDumb1;

public class MainPage extends AppCompatActivity {

    public static Animation scale_up, scale_down;
    public static int finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        finish = 0;

        ImageButton start = findViewById(R.id.start);
        ImageButton high_score = findViewById(R.id.score);

        scale_up = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scale_down = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        scaleButton(this,start);
        scaleButton(this,high_score);

        start.setOnClickListener(view -> {
            Intent intent = new Intent(MainPage.this, AreYouDumb1.class);
            startActivity(intent);
        });

        high_score.setOnClickListener(view -> {
            AlertDialog alertDialog = new AlertDialog.Builder(MainPage.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("There is nothing here...");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Continue...",
                    (dialog, which) -> {
                        dialog.dismiss();
                        Intent intent = new Intent(MainPage.this,HighScore.class);
                        startActivity(intent);
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "FINE",
                    (dialog, which) -> dialog.dismiss());
            alertDialog.show();
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if(finish == 1)
            finish();
    }

    @SuppressLint("ClickableViewAccessibility")
    public static void scaleButton(Context context, ImageButton imageButton) {
        imageButton.setOnTouchListener((view, motionEvent) -> {
            Animation scale_up = AnimationUtils.loadAnimation(context,R.anim.scale_up);
            Animation scale_down = AnimationUtils.loadAnimation(context,R.anim.scale_down);
            if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                imageButton.startAnimation(scale_up);
            else if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)
                imageButton.startAnimation(scale_down);
            return false;
        });

    }
}