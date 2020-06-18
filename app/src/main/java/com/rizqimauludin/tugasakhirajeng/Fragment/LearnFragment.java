package com.rizqimauludin.tugasakhirajeng.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.rizqimauludin.tugasakhirajeng.R;

public class LearnFragment extends Fragment {

    private PlayerView playerView;
    private Context context;

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

        playerView = view.findViewById(R.id.courseVideo);
        context = getActivity();

    }

    private void init() {
        SimpleExoPlayer simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(context);
        playerView.setPlayer(simpleExoPlayer);
    }


}
