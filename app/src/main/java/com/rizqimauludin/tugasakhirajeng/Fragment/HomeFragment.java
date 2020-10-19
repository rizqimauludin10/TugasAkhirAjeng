package com.rizqimauludin.tugasakhirajeng.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rizqimauludin.tugasakhirajeng.Activity.AboutActivity;
import com.rizqimauludin.tugasakhirajeng.Activity.EssayActivity;
import com.rizqimauludin.tugasakhirajeng.Activity.LatihanActivity;
import com.rizqimauludin.tugasakhirajeng.Activity.PilganActivity;
import com.rizqimauludin.tugasakhirajeng.R;
import com.rizqimauludin.tugasakhirajeng.Utils.SharedPreferencesUtils;

import java.util.Objects;

public class HomeFragment extends Fragment {

    LinearLayout essay, latihan, exam, about;
    TextView welcomeName;
    ImageView wa;
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
        about = view.findViewById(R.id.about);
        wa = view.findViewById(R.id.directWa);

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

        about.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AboutActivity.class);
            startActivity(intent);
        });

        wa.setOnClickListener(v -> {
            String phone = "6285822053855";
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://api.whatsapp.com/send?phone=" + phone + "&text=Saya%20perlu%20bantuan%20Admin%2MathStack%20"));
            startActivity(intent);
        });


    }
}
