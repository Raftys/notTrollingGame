package com.example.nottrollinggame.areyoudumb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageButton;
import com.example.nottrollinggame.*;
import java.util.Random;

public class AreYouDumb1 extends AppCompatActivity {

    int clicks;
    static int finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_are_you_dumb1);
        clicks=0;
        finish = 0;

        ImageButton no = findViewById(R.id.no);
        ImageButton yes = findViewById(R.id.yes);

        MainPage.scaleButton(this,no);
        MainPage.scaleButton(this,yes);

        no.setOnClickListener(view -> {
            no.setX(getRandomValue("width"));
            no.setY(getRandomValue("height"));
            clicks++;
        });

        yes.setOnClickListener(view -> {
            Intent intent = new Intent(AreYouDumb1.this,AreYouDumb2.class);
            intent.putExtra("clicks",clicks);
            startActivity(intent);
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        clicks = 0;
        if(finish == 1)
            finish();
    }

    public int getRandomValue(String side) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Random random = new Random();
        int value = -1;
        if(side.equals("height"))
            while(value < 0 || value > displayMetrics.heightPixels-450)
                value = random.nextInt(displayMetrics.heightPixels);
        else if(side.equals("width"))
            while(value < 0 || value > displayMetrics.widthPixels-250)
                value = random.nextInt(displayMetrics.widthPixels);
        return value;
    }
}