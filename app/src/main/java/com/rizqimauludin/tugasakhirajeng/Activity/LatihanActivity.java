package com.rizqimauludin.tugasakhirajeng.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

    private ProgressDialog loading;
    private Context context;
    private RecyclerView Rvlatihan;
    private RecyclerView.Adapter latihanAdapter;
    private List<LatihanDataItem> latihanDataItems = new ArrayList<>();
    private BaseAPIService baseAPIService;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        Rvlatihan = findViewById(R.id.latihanRv);
        ImageView back = findViewById(R.id.backMainExercise);
        swipeRefreshLayout = findViewById(R.id.swipeExcercise);
        context = this;

        baseAPIService = UtilsAPI.getApiService();

        swipeRefreshLayout.setOnRefreshListener(() -> new Handler().postDelayed(() -> {
            swipeRefreshLayout.setRefreshing(false);
            resultLatihan();
        }, 2000));

        back.setOnClickListener(v -> {
            onBackPressed();
        });

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void resultLatihan() {
        loading = ProgressDialog.show(context, null, "Loading..", true, false);
        baseAPIService.getLatihan()
                .enqueue(new Callback<LatihanResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<LatihanResponse> call, @NotNull Response<LatihanResponse> response) {
                        loading.dismiss();
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            latihanDataItems = response.body().getData();
                            Rvlatihan.setAdapter(new LatihanAdapter(context, latihanDataItems));
                            latihanAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<LatihanResponse> call, @NotNull Throwable t) {
                        loading.dismiss();
                        Log.d("TAG", "Response = " + t.toString());
                    }
                });

    }
}