package com.rizqimauludin.tugasakhirajeng.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rizqimauludin.tugasakhirajeng.Activity.SplashActivity;
import com.rizqimauludin.tugasakhirajeng.Activity.UpdateProfileActivity;
import com.rizqimauludin.tugasakhirajeng.R;
import com.rizqimauludin.tugasakhirajeng.Utils.SharedPreferencesUtils;

import java.util.Objects;

public class ProfileFragment extends Fragment {

    SharedPreferencesUtils sharedPreferences;
    private RelativeLayout toPersonalData, toSetting, toSignOut;
    private TextView username, email;

    public ProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = new SharedPreferencesUtils(Objects.requireNonNull(getContext()));
        username = view.findViewById(R.id.myProfileName);
        email = view.findViewById(R.id.myEmail);

        toPersonalData = view.findViewById(R.id.toPersonalData);
        //toSetting = view.findViewById(R.id.toSetting);
        toSignOut = view.findViewById(R.id.toSignOut);

        username.setText(sharedPreferences.getSp_Username());
        email.setText(sharedPreferences.getSp_Email());

        toPersonalData.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), UpdateProfileActivity.class);
            startActivity(intent);
        });

        toSignOut.setOnClickListener(v -> {
            sharedPreferences.saveSPBoolean(SharedPreferencesUtils.SP_Login, false);
            startActivity(new Intent(getContext(), SplashActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        });


    }
}
