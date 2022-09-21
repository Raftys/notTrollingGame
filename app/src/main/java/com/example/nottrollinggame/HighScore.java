package com.example.nottrollinggame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        String text="1.The only thing that's high right now, it's ME writing that shit.\n" +
                "2.Don't expect me to make a whole high-score system for that app.\n"+
                "3.There are more chances for you to get a life than me writing sql code right now.\n"+
                "4.Let's be honest, i told you THERE IS NOTHING HERE. Why did you come? Jezzzz.";

        TextView textView = findViewById(R.id.text);
        textView.setText(text);

        ImageButton back = findViewById(R.id.back);

        MainPage.scaleButton(this,back);

        back.setOnClickListener(view -> {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "I mean..I TOLD YOU Dummy...",
                    Toast.LENGTH_SHORT);
            toast.show();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finish();
        });

    }
}