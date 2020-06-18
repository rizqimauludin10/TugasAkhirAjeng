package com.rizqimauludin.tugasakhirajeng.Model.Latihan;

import com.google.gson.annotations.SerializedName;

public class LatihanDataItem {

    @SerializedName("soal")
    private String soal;

    @SerializedName("updated_at")
    private Object updatedAt;

    @SerializedName("materi_id")
    private int materiId;

    @SerializedName("created_at")
    private Object createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("jawaban")
    private String jawaban;

    @SerializedName("ket")
    private String ket;

    public String getSoal() {
        return soal;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public int getMateriId() {
        return materiId;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public String getJawaban() {
        return jawaban;
    }

    public String getKet() {
        return ket;
    }
}