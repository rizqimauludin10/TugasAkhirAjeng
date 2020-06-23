package com.rizqimauludin.tugasakhirajeng.Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rizqimauludin.tugasakhirajeng.Adapter.LatihanAdapter;
import com.rizqimauludin.tugasakhirajeng.Helper.BaseAPIService;
import com.rizqimauludin.tugasakhirajeng.Helper.UtilsAPI;
import com.rizqimauludin.tugasakhirajeng.Model.Latihan.LatihanDataItem;
import com.rizqimauludin.tugasakhirajeng.Model.Latihan.LatihanResponse;
import com.rizqimauludin.tugasakhirajeng.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LatihanActivity extends AppCompatActivity {

    private RecyclerView Rvlatihan;
    private Context context;
    private RecyclerView.Adapter latihanAdapter;
    private List<LatihanDataItem> latihanDataItems = new ArrayList<>();
    private BaseAPIService baseAPIService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        Rvlatihan = findViewById(R.id.latihanRv);

        baseAPIService = UtilsAPI.getApiService();

        setupRecycleView();
        resultLatihan();
    }

    private void setupRecycleView() {
        if (latihanAdapter == null) {
            latihanAdapter = new LatihanAdapter(context, latihanDataItems);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            Rvlatihan.setLayoutManager(layoutManager);
            Rvlatihan.setItemAnimator(new DefaultItemAnimator());
            Rvlatihan.setHasFixedSize(true);
            Rvlatihan.setAdapter(latihanAdapter);
        } else {
            latihanAdapter.notifyDataSetChanged();
        }

    }

    private void resultLatihan() {
        baseAPIService.getLatihan()
                .enqueue(new Callback<LatihanResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<LatihanResponse> call, @NotNull Response<LatihanResponse> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            latihanDataItems = response.body().getData();
                            Rvlatihan.setAdapter(new LatihanAdapter(context, latihanDataItems));
                            latihanAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<LatihanResponse> call, @NotNull Throwable t) {
                        Log.d("TAG", "Response = " + t.toString());
                    }
                });

    }
}