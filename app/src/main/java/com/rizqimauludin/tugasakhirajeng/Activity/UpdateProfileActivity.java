package com.rizqimauludin.tugasakhirajeng.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.rizqimauludin.tugasakhirajeng.Helper.BaseAPIService;
import com.rizqimauludin.tugasakhirajeng.Helper.UtilsAPI;
import com.rizqimauludin.tugasakhirajeng.Model.UpdateProfile.UpdateProfileResponse;
import com.rizqimauludin.tugasakhirajeng.Model.User.UserResponse;
import com.rizqimauludin.tugasakhirajeng.R;
import com.rizqimauludin.tugasakhirajeng.Utils.SharedPreferencesUtils;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateProfileActivity extends AppCompatActivity {

    EditText dateOfBirth, fullName, nis, placeBirth, phoneNumber;
    RadioGroup genderRg;
    ImageView datePicker, backProfile;
    Button btUpdateData;
    String id, gender;
    String genderDefault = "0";
    SharedPreferencesUtils sharedPreferences;
    BaseAPIService baseAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        sharedPreferences = new SharedPreferencesUtils(this);
        baseAPIService = UtilsAPI.getApiService();

        id = sharedPreferences.getSP_UserId();
        Log.e("User ID", "ID" + id);

        datePicker = findViewById(R.id.datePicker);
        genderRg = findViewById(R.id.genderRg);

        backProfile = findViewById(R.id.backProfile);

        fullName = findViewById(R.id.updateFullName);
        nis = findViewById(R.id.updateNis);
        placeBirth = findViewById(R.id.updatePlaceOfBirth);
        dateOfBirth = findViewById(R.id.updateDateOfBirth);
        phoneNumber = findViewById(R.id.updatePhoneNumber);
        btUpdateData = findViewById(R.id.btn_UpdateData);

        RadioButton male = findViewById(R.id.rgMale);
        RadioButton female = findViewById(R.id.rgWomen);

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Select a Date");
        final MaterialDatePicker materialDatePicker = builder.build();

        datePicker.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int date = calendar.get(Calendar.DAY_OF_MONTH);

            Locale id = new Locale("id", "ID");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", id);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year1, month1, dayOfMonth) -> {
                calendar.set(year1, month1, dayOfMonth);
                dateOfBirth.setText(simpleDateFormat.format(calendar.getTime()));
            }, year, month, date);
            datePickerDialog.setTitle("Select A Date");
            datePickerDialog.show();
            //materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");


        });

        genderRg.setOnCheckedChangeListener((group, checkedId) -> {
            if (male.isChecked()) {
                genderDefault = "1";
                gender = "L";
            } else if (female.isChecked()) {
                genderDefault = "0";
                gender = "P";

            }
        });

        checkDataId();

        btUpdateData.setOnClickListener(v -> {
            updateUserData();
        });

        backProfile.setOnClickListener(v -> {
            onBackPressed();
        });
    }


    private void updateUserData() {
        baseAPIService.getUpdateProfile(
                id,
                fullName.getText().toString(),
                phoneNumber.getText().toString(),
                nis.getText().toString(),
                gender,
                placeBirth.getText().toString(),
                dateOfBirth.getText().toString()
        ).enqueue(new Callback<UpdateProfileResponse>() {
            @Override
            public void onResponse(@NotNull Call<UpdateProfileResponse> call, @NotNull Response<UpdateProfileResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        Log.d("Success", "Update Data Success");
                    } else if (!response.body().isStatus()) {
                        Log.d("Failed", "Update Data Failed");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<UpdateProfileResponse> call, @NotNull Throwable t) {
                Log.e("Login", "OnFailure: ERROR > " + t.toString());
            }
        });
    }


    private void checkDataId() {
        baseAPIService.getUser(
                id
        ).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserResponse> call, @NotNull Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        fullName.setText(response.body().getData().getProfil().getNamaLengkap());
                        phoneNumber.setText(response.body().getData().getProfil().getNoHp());
                        nis.setText(response.body().getData().getProfil().getNis());
                        placeBirth.setText(response.body().getData().getProfil().getTempatLahir());
                        dateOfBirth.setText(response.body().getData().getProfil().getTanggalLahir());
                    } else if (!response.body().isStatus()) {
                        Log.d("Failed", "Update Data Failed");
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<UserResponse> call, @NotNull Throwable t) {
                Log.e("Login", "OnFailure: ERROR > " + t.toString());
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}