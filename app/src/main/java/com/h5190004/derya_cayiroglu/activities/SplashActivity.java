package com.h5190004.derya_cayiroglu.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import com.h5190004.derya_cayiroglu.R;

public class SplashActivity extends AppCompatActivity {
    View logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        countDownTimerBaslat();
    }

    private void init(){
        logo = findViewById(R.id.imgLogo1);
    }

    private void countDownTimerBaslat(){
        CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {
                Intent GirisActivityIntent = new Intent(getApplicationContext(),GirisActivity.class);
                startActivity(GirisActivityIntent);
                finish();
            }
        }.start();
    }
}
