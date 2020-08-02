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
import com.rizqimauludin.tugasakhirajeng.Model.Register.Data;
import com.rizqimauludin.tugasakhirajeng.Model.Register.RegisterResponse;
import com.rizqimauludin.tugasakhirajeng.R;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private ProgressDialog loading;
    private Context context;
    TextView toLogin;
    Button registerButton;
    EditText username, email, password, phone;
    BaseAPIService baseAPIService;
    Data registerResponse;
    String ID_Code = "62";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;

        baseAPIService = UtilsAPI.getApiService();

        toLogin = findViewById(R.id.toLogin);
        username = findViewById(R.id.et_username_register);
        email = findViewById(R.id.et_email_register);
        password = findViewById(R.id.et_password_register);
        phone = findViewById(R.id.et_phone_register);
        registerButton = findViewById(R.id.btn_Register);

        toLogin.setOnClickListener(v -> toLogin());

        registerButton.setOnClickListener(v -> register());

    }

    private void toLogin() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void register() {
        loading = ProgressDialog.show(context, null, "Loading..", true, false);
        baseAPIService.getRegisterResponse(
                username.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                ID_Code + phone.getText().toString()
        ).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(@NotNull Call<RegisterResponse> call, @NotNull Response<RegisterResponse> response) {
                loading.dismiss();
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().isStatus()) {

                        registerResponse = response.body().getData();

                        Log.d("Email", "Email" + registerResponse.getEmail());
                        String getEmailRegister = registerResponse.getEmail();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.putExtra("getEmail", getEmailRegister);
                        startActivity(intent);
                    } else if (!response.body().isStatus()) {
                        String error = response.body().getMessage();
                        Toast.makeText(RegisterActivity.this, error, Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onFailure(@NotNull Call<RegisterResponse> call, @NotNull Throwable t) {
                loading.dismiss();
                Log.e("Login", "OnFailure: ERROR > " + t.toString());
            }
        });
    }
}
