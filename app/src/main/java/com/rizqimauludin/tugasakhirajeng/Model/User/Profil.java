package com.rizqimauludin.tugasakhirajeng.Model.User;

import com.google.gson.annotations.SerializedName;

public class Profil {

    @SerializedName("jk")
    private String jk;

    @SerializedName("no_hp")
    private String noHp;

    @SerializedName("tempat_lahir")
    private String tempatLahir;

    @SerializedName("foto")
    private Object foto;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("nama_lengkap")
    private String namaLengkap;

    @SerializedName("nis")
    private String nis;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("ket")
    private Object ket;

    @SerializedName("tanggal_lahir")
    private String tanggalLahir;

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public Object getFoto() {
        return foto;
    }

    public void setFoto(Object foto) {
        this.foto = foto;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
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

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @Override
    public String toString() {
        return
                "Profil{" +
                        "jk = '" + jk + '\'' +
                        ",no_hp = '" + noHp + '\'' +
                        ",tempat_lahir = '" + tempatLahir + '\'' +
                        ",foto = '" + foto + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",user_id = '" + userId + '\'' +
                        ",nama_lengkap = '" + namaLengkap + '\'' +
                        ",nis = '" + nis + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",ket = '" + ket + '\'' +
                        ",tanggal_lahir = '" + tanggalLahir + '\'' +
                        "}";
    }
}