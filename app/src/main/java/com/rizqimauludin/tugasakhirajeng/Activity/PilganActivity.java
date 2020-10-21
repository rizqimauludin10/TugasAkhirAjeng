package com.rizqimauludin.tugasakhirajeng.Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rizqimauludin.tugasakhirajeng.Adapter.PilganAdapter;
import com.rizqimauludin.tugasakhirajeng.Helper.BaseAPIService;
import com.rizqimauludin.tugasakhirajeng.Helper.UtilsAPI;
import com.rizqimauludin.tugasakhirajeng.Model.HasilPilgan.HasilPilganResponse;
import com.rizqimauludin.tugasakhirajeng.Model.Pilgan.PilganDataItem;
import com.rizqimauludin.tugasakhirajeng.Model.Pilgan.PilganResponse;
import com.rizqimauludin.tugasakhirajeng.R;
import com.rizqimauludin.tugasakhirajeng.Utils.SharedPreferencesUtils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PilganActivity extends AppCompatActivity {
    BaseAPIService baseAPIService;
    private TextView viewSkor;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter pilganAdapter;
    private List<PilganDataItem> pilganDataItems = new ArrayList<>();
    private Context context;
    private PilganAdapter pilganAdapterr;
    private double jumlahSoal;
    private double point;
    private double tampung, skor;
    private Button submit, yes, no;
    private ImageView backMain;
    private AlertDialog.Builder builder;
    private LayoutInflater layoutInflater;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilgan);

        recyclerView = findViewById(R.id.pilganRv);
        backMain = findViewById(R.id.backMainExercise);
        //viewSkor = findViewById(R.id.viewSkor);
        submit = findViewById(R.id.submit);
        context = this;
        SharedPreferencesUtils sharedPreferencesUtils = new SharedPreferencesUtils(this);

        pilganAdapterr = new PilganAdapter(context, pilganDataItems);

        id = sharedPreferencesUtils.getSP_UserId();
        baseAPIService = UtilsAPI.getApiService();
        //soalPilgan = findViewById(R.id.soalPilgan);


        setupRecycleView();
        getSoalPilgan();

        submit.setOnClickListener(v -> {
            DialogForm();
        });

        backMain.setOnClickListener(v -> {
            onBackPressed();
        });

    }

    private void setupRecycleView() {
        if (pilganAdapter == null) {
            pilganAdapter = new PilganAdapter(context, pilganDataItems);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(pilganAdapter);
        } else {
            pilganAdapter.notifyDataSetChanged();
        }
    }

    private double getNilai() {
//       tampung = pilganAdapterr.point() * point;
        return tampung;
    }

    private void getSoalPilgan() {
        baseAPIService.getPilganResponse().enqueue(new Callback<PilganResponse>() {
            @Override
            public void onResponse(@NotNull Call<PilganResponse> call, @NotNull Response<PilganResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    if (response.body().isStatus()) {
                        pilganDataItems = response.body().getData();
                        recyclerView.setAdapter(new PilganAdapter(context, pilganDataItems));
                        jumlahSoal = response.body().getJumlahSoal();
                        Log.d("Jumlah Soal => ", String.valueOf(jumlahSoal));

                        point = (100 / jumlahSoal);
                        //tampung = pilganAdapterr.jawaban() * point;


                        pilganAdapter.notifyDataSetChanged();

                    } else if (!response.body().isStatus()) {

                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<PilganResponse> call, @NotNull Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });

    }

    private void DialogForm() {
        AlertDialog builder = new AlertDialog.Builder(PilganActivity.this).create();
        layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog, null);
        builder.setView(view);
        builder.setCancelable(true);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Finish? ");
        yes = view.findViewById(R.id.yes);
        no = view.findViewById(R.id.no);
        viewSkor = view.findViewById(R.id.viewSkor);

        Log.d("Get Score => ", String.valueOf((pilganAdapterr.point())));


        yes.setOnClickListener(v -> {
            baseAPIService.getHasilPilgan(
                    id,
                    String.valueOf(getNilai())
            ).enqueue(new Callback<HasilPilganResponse>() {
                @Override
                public void onResponse(@NotNull Call<HasilPilganResponse> call, @NotNull Response<HasilPilganResponse> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        if (response.body().isStatus()) {
                            builder.dismiss();
                        } else if (!response.body().isStatus()) {
                            Log.d("Failed", "Post Data Failed");
                        }
                    }
                }

                @Override
                public void onFailure(@NotNull Call<HasilPilganResponse> call, @NotNull Throwable t) {

                }
            });

        });

        no.setOnClickListener(v -> {
            builder.dismiss();
        });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}