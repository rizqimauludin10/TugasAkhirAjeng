package com.rizqimauludin.tugasakhirajeng.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rizqimauludin.tugasakhirajeng.Activity.EssayActivity;
import com.rizqimauludin.tugasakhirajeng.Activity.LatihanActivity;
import com.rizqimauludin.tugasakhirajeng.Activity.PilganActivity;
import com.rizqimauludin.tugasakhirajeng.R;
import com.rizqimauludin.tugasakhirajeng.Utils.SharedPreferencesUtils;

import java.util.Objects;

public class HomeFragment extends Fragment {

    LinearLayout essay, latihan, exam;
    TextView welcomeName;
    SharedPreferencesUtils sharedPreferencesUtils;

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

        sharedPreferencesUtils = new SharedPreferencesUtils(Objects.requireNonNull(getContext()));

        essay = view.findViewById(R.id.essay);
        latihan = view.findViewById(R.id.exercise);
        welcomeName = view.findViewById(R.id.welcomeName);
        exam = view.findViewById(R.id.exam);

        welcomeName.setText(sharedPreferencesUtils.getSp_Username());

        essay.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), EssayActivity.class);
            startActivity(intent);
        });

        latihan.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LatihanActivity.class);
            startActivity(intent);
        });

        exam.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PilganActivity.class);
            startActivity(intent);
        });
    }
}
