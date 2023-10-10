package com.example.practica6_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private TextView contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          /* Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animationView.cancelAnimation();
            }
        },10000);
        esto me va ayudar xd  */
        LottieAnimationView animationView=findViewById(R.id.animacion);
        animationView.setAnimation(R.raw.mono);
        animationView.setRepeatCount(4);
        animationView.playAnimation();

        contador = (TextView) findViewById(R.id.contador);
        new CountDownTimer(6000,1000)
        {
            public void onTick(long millisUntilFinished)
            {
                contador.setText(""+millisUntilFinished/1000);
            }
            public void onFinish()
            {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        }.start();

    }

}