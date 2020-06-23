package com.rizqimauludin.tugasakhirajeng.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.rizqimauludin.tugasakhirajeng.Activity.VideoActivity;
import com.rizqimauludin.tugasakhirajeng.R;

public class LearnFragment extends Fragment {

    private PlayerView playerView;
    private Context context;
    YouTubePlayerView youTubePlayerView;
    private RelativeLayout videoClick;
    private Button full;

    public LearnFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_learn, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //playerView = view.findViewById(R.id.courseVideo);
        videoClick = view.findViewById(R.id.videoClick);
        //full = view.findViewById(R.id.fullscreen);
        context = getActivity();

        youTubePlayerView = view.findViewById(R.id.ytVideo);


        videoClick.setOnClickListener(v -> {

        });

        /*full.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), VideoActivity.class);
            startActivity(intent);


        });*/

        youTubePlayerView.addFullScreenListener(new YouTubePlayerFullScreenListener() {
            @Override
            public void onYouTubePlayerEnterFullScreen() {
                Log.d("Full", "Yes");
                //Objects.requireNonNull(getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                startActivity(intent);
            }

            @Override
            public void onYouTubePlayerExitFullScreen() {
                Log.d("ExitFull", "No");
                //Objects.requireNonNull(getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                startActivity(intent);

            }
        });

    }

    private void init() {
        SimpleExoPlayer simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(context);
        //playerView.setPlayer(simpleExoPlayer);
    }


}
