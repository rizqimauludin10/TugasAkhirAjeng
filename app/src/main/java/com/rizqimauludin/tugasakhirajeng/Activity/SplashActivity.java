package com.rizqimauludin.tugasakhirajeng.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.rizqimauludin.tugasakhirajeng.R;
import com.rizqimauludin.tugasakhirajeng.Services.StatusBar;
import com.rizqimauludin.tugasakhirajeng.Utils.SharedPreferencesUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        StatusBar statusBar = new StatusBar();
        statusBar.statusBarFull(SplashActivity.this);
        SharedPreferencesUtils sharedPreferencesUtils = new SharedPreferencesUtils(this);

        new Handler().postDelayed(() -> {
            if (sharedPreferencesUtils.getSP_Login().equals(true)) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
