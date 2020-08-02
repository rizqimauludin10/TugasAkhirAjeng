package com.rizqimauludin.tugasakhirajeng.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rizqimauludin.tugasakhirajeng.Helper.BaseAPIService;
import com.rizqimauludin.tugasakhirajeng.Helper.UtilsAPI;
import com.rizqimauludin.tugasakhirajeng.Model.Login.Data;
import com.rizqimauludin.tugasakhirajeng.Model.Login.LoginResponse;
import com.rizqimauludin.tugasakhirajeng.R;
import com.rizqimauludin.tugasakhirajeng.Utils.SharedPreferencesUtils;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog loading;
    private Context context;
    Button loginButton;
    TextView toRegister;
    EditText username, password;
    BaseAPIService baseAPIService;
    SharedPreferencesUtils sharedPreferences;
    Data loginResponse;
    String getEmailRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        baseAPIService = UtilsAPI.getApiService();
        sharedPreferences = new SharedPreferencesUtils(this);
        context = this;

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.btn_Login);
        toRegister = findViewById(R.id.toRegister);


        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            getEmailRegister = null;
        } else {
            getEmailRegister = bundle.getString("getEmail");
            username.setText(getEmailRegister);
        }

        loginButton.setOnClickListener(v -> login());

        toRegister.setOnClickListener(v -> toRegister());
    }

    private void toRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void login() {
        loading = ProgressDialog.show(context, null, "Loading..", true, false);
        baseAPIService.getLoginResponse(
                username.getText().toString(),
                password.getText().toString()
        )
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<LoginResponse> call, @NotNull Response<LoginResponse> response) {
                        loading.dismiss();
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            if (response.body().isStatus()) {

                                loginResponse = response.body().getData();

                                String username = loginResponse.getUsers().getName();
                                String email = loginResponse.getUsers().getEmail();
                                String phone = loginResponse.getProfil().getNoHp();
                                Integer id = loginResponse.getUsers().getId();


                                Log.d("Username", "Username" + loginResponse.getUsers().getName());
                                Log.d("Email", "Email" + loginResponse.getUsers().getEmail());

                                sharedPreferences.saveSPString(SharedPreferencesUtils.SP_Username, username);
                                sharedPreferences.saveSPString(SharedPreferencesUtils.SP_Email, email);
                                sharedPreferences.saveSPString(SharedPreferencesUtils.SP_Phone, phone);
                                sharedPreferences.saveSPBoolean(SharedPreferencesUtils.SP_Login, true);
                                sharedPreferences.saveSPString(SharedPreferencesUtils.SP_UserId, String.valueOf(id));

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class)
                                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                finish();
                                startActivity(intent);

                            } else if (!response.body().isStatus()) {
                                String error = response.body().getMessage();
                                Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();

                            }

                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<LoginResponse> call, @NotNull Throwable t) {
                        loading.dismiss();
                        Log.e("Login", "OnFailure: ERROR > " + t.toString());

                    }
                });
    }
}
