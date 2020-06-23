package com.rizqimauludin.tugasakhirajeng.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.rizqimauludin.tugasakhirajeng.R;
import com.rizqimauludin.tugasakhirajeng.Services.StatusBar;

public class VideoActivity extends AppCompatActivity {

    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        StatusBar statusBar = new StatusBar();
        statusBar.statusBarFull(VideoActivity.this);

        youTubePlayerView = findViewById(R.id.ytVideo2);

        youTubePlayerView.addFullScreenListener(new YouTubePlayerFullScreenListener() {
            @Override
            public void onYouTubePlayerEnterFullScreen() {
                Log.d("Full", "Yes");
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }

            @Override
            public void onYouTubePlayerExitFullScreen() {
                Log.d("ExitFull", "No");
               /* Intent intent = new Intent(VideoActivity.this, MainActivity.class);
                startActivity(intent);*/
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}