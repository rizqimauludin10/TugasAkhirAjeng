package com.rizqimauludin.tugasakhirajeng.Model.HasilPilgan;

import com.google.gson.annotations.SerializedName;

public class HasilPilganDataItem {

    @SerializedName("updated_at")
    private Object updatedAt;

    @SerializedName("pilgan")
    private int pilgan;

    @SerializedName("essay")
    private Object essay;

    @SerializedName("created_at")
    private Object createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("ket")
    private Object ket;

    @SerializedName("profil_id")
    private int profilId;

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getPilgan() {
        return pilgan;
    }

    public void setPilgan(int pilgan) {
        this.pilgan = pilgan;
    }

    public Object getEssay() {
        return essay;
    }

    public void setEssay(Object essay) {
        this.essay = essay;
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

    public Object getKet() {
        return ket;
    }

    public void setKet(Object ket) {
        this.ket = ket;
    }

    public int getProfilId() {
        return profilId;
    }

    public void setProfilId(int profilId) {
        this.profilId = profilId;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "updated_at = '" + updatedAt + '\'' +
                        ",pilgan = '" + pilgan + '\'' +
                        ",essay = '" + essay + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",ket = '" + ket + '\'' +
                        ",profil_id = '" + profilId + '\'' +
                        "}";
    }
}