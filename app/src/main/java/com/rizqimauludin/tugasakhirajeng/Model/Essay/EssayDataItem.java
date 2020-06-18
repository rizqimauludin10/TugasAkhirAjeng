package com.rizqimauludin.tugasakhirajeng.Model.Essay;

import com.google.gson.annotations.SerializedName;

public class EssayDataItem {

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
    private Object ket;

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getMateriId() {
        return materiId;
    }

    public void setMateriId(int materiId) {
        this.materiId = materiId;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public Object getKet() {
        return ket;
    }

    public void setKet(Object ket) {
        this.ket = ket;
    }
}