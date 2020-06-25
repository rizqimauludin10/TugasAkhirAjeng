package com.rizqimauludin.tugasakhirajeng.Model.User;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("profil")
    private Profil profil;

    @SerializedName("user")
    private User user;

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "profil = '" + profil + '\'' +
                        ",user = '" + user + '\'' +
                        "}";
    }
}