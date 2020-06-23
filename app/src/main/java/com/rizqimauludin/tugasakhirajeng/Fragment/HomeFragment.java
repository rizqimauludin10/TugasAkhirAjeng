package com.rizqimauludin.tugasakhirajeng.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rizqimauludin.tugasakhirajeng.Activity.EssayActivity;
import com.rizqimauludin.tugasakhirajeng.Activity.LatihanActivity;
import com.rizqimauludin.tugasakhirajeng.R;

public class HomeFragment extends Fragment {

    LinearLayout essay, latihan;

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        essay = view.findViewById(R.id.essay);
        latihan = view.findViewById(R.id.latihan);

        essay.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EssayActivity.class);
            startActivity(intent);
        });

        latihan.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LatihanActivity.class);
            startActivity(intent);
        });
    }
}
