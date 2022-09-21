package com.example.nottrollinggame.areyoudumb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nottrollinggame.*;

public class AreYouDumb2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_are_you_dumb2);

        int clicks = getIntent().getIntExtra("clicks",0);

        TextView textView = findViewById(R.id.result);
        ImageButton back = findViewById(R.id.back);
        ImageButton next = findViewById(R.id.next);

        MainPage.scaleButton(this,next);
        MainPage.scaleButton(this,back);

        next.setOnClickListener(view -> alert("Alert","Are You Sure You Wanna Continue Dummy?","Yes","No",0));
        if(clicks>0) {
            textView.setText("Congratulations Dumb. You Needed " + clicks + " Click(s) To Get It.");
            back.setOnClickListener(view -> toastQuit("SIKEEEEEEEEEEEEEE. YOU THOUGHT.",2000));
        }
        else {
            textView.setText("You FUCKING Dumb");
            back.setOnClickListener(view -> finish());
        }
    }


    public void toastQuit(String text, int time) {
        Toast toast = Toast.makeText(getApplicationContext(),
                text,
                Toast.LENGTH_SHORT);
        toast.show();
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AreYouDumb1.finish = 1;
        finish();
    }

    public void alert(String title, String question, String positiveAnswer, String negativeAnswer, int spam) {
        AlertDialog alertDialog = new AlertDialog.Builder(AreYouDumb2.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(question);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, positiveAnswer,
                (dialog, which) -> {
                    dialog.dismiss();
                    if(spam == 0 )
                        alert(title,"Are You ACTUALLY SURE You Wanna Do That?","YES","NO",spam+1);
                    else if(spam == 1)
                        alert(title,"Okay Last Chance To Change Your Mind..","Continue...","FINE. Bye",spam+1);
                    else if (spam == 2) {
                        Intent intent = new Intent(AreYouDumb2.this,MainActivity.class);
                        startActivity(intent);
                    }

                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, negativeAnswer,
                (dialog, which) -> {
                    dialog.dismiss();
                    toastQuit("DUMMY.",1000);
                });
        alertDialog.show();
    }
}