package com.rizqimauludin.tugasakhirajeng.Activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.rizqimauludin.tugasakhirajeng.R;

public class AboutActivity extends AppCompatActivity {
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        back = findViewById(R.id.backMainExercise);

        back.setOnClickListener(v -> {
            onBackPressed();
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}