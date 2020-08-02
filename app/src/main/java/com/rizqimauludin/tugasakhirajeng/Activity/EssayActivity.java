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

import com.rizqimauludin.tugasakhirajeng.Adapter.EssayAdapter;
import com.rizqimauludin.tugasakhirajeng.Helper.BaseAPIService;
import com.rizqimauludin.tugasakhirajeng.Helper.UtilsAPI;
import com.rizqimauludin.tugasakhirajeng.Model.Essay.EssayDataItem;
import com.rizqimauludin.tugasakhirajeng.Model.Essay.EssayResponse;
import com.rizqimauludin.tugasakhirajeng.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EssayActivity extends AppCompatActivity {

    private ProgressDialog loading;

    private RecyclerView RvEssay;
    private Context context;
    private RecyclerView.Adapter essayAdapter;
    private List<EssayDataItem> essayDataItems = new ArrayList<>();
    private BaseAPIService baseAPIService;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay);

        RvEssay = findViewById(R.id.essayRv);
        ImageView back = findViewById(R.id.backMain);
        swipeRefreshLayout = findViewById(R.id.swipeEssay);
        context = this;

        back.setOnClickListener(v -> {
            onBackPressed();
        });

        baseAPIService = UtilsAPI.getApiService();

        swipeRefreshLayout.setOnRefreshListener(() -> new Handler().postDelayed(() -> {
            swipeRefreshLayout.setRefreshing(false);
            resultEssay();
        }, 2000));

        setupRecycleView();
        resultEssay();
    }

    private void setupRecycleView() {
        if (essayAdapter == null) {
            essayAdapter = new EssayAdapter(context, essayDataItems);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            RvEssay.setLayoutManager(layoutManager);
            RvEssay.setItemAnimator(new DefaultItemAnimator());
            RvEssay.setHasFixedSize(true);
            RvEssay.setAdapter(essayAdapter);
        } else {
            essayAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void resultEssay() {
        loading = ProgressDialog.show(context, null, "Loading..", true, false);
        baseAPIService.getEssay()
                .enqueue(new Callback<EssayResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<EssayResponse> call, @NotNull Response<EssayResponse> response) {
                        loading.dismiss();
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            essayDataItems = response.body().getData();
                            RvEssay.setAdapter(new EssayAdapter(context, essayDataItems));
                            essayAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<EssayResponse> call, @NotNull Throwable t) {
                        loading.dismiss();
                        Log.d("TAG", "Response = " + t.toString());
                    }
                });


    }
}