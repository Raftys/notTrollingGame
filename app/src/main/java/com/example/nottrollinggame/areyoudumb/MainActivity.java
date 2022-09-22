package com.example.nottrollinggame.areyoudumb;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nottrollinggame.MainPage;
import com.example.nottrollinggame.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text);
        textView.setText("You really expected for a SECOND question, didn't you?.");

        ImageButton press = findViewById(R.id.press_me);
        MainPage.scaleButton(this,press);

        press.setOnClickListener(view -> {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Byeeeeeeee",
                    Toast.LENGTH_SHORT);
            toast.show();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AreYouDumb1.finish = 1;
            AreYouDumb2.finish = 1;
            MainPage.finish = 1;
            finish();
        });
    }

}