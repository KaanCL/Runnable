package com.example.runnablehadler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

   TextView textView;
    int number;
    Runnable runnable;

    Handler handler;

    Button button;

    View mainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        mainLayout=findViewById(R.id.back);


        number =0;
    }

    public void start (View view){

        handler=new Handler();

        runnable=new Runnable() {
            @Override
            public void run() {
                textView.setText("Time: "+number);
                number++;
                textView.setText("Time: "+number);
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);

    }
    public void stop(View view){

        button.setEnabled(true);

        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("Time: "+number);
        //mainLayout.setBackgroundColor(Color.parseColor("#A52A2A"));

    }

}