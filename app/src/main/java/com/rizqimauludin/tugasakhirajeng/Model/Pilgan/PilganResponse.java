package com.rizqimauludin.tugasakhirajeng.Model.Pilgan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PilganResponse {

    @SerializedName("data")
    private List<PilganDataItem> data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    @SerializedName("jumlah_soal")
    private int jumlahSoal;

    public List<PilganDataItem> getData() {
        return data;
    }

    public void setData(List<PilganDataItem> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getJumlahSoal() {
        return jumlahSoal;
    }

    public void setJumlahSoal(int jumlahSoal) {
        this.jumlahSoal = jumlahSoal;
    }

    @Override
    public String toString() {
        return
                "PilganResponse{" +
                        "data = '" + data + '\'' +
                        ",message = '" + message + '\'' +
                        ",status = '" + status + '\'' +
                        ",jumlah_soal = '" + jumlahSoal + '\'' +
                        "}";
    }
}