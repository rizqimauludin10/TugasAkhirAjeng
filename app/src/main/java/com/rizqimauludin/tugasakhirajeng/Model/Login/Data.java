package com.rizqimauludin.tugasakhirajeng.Model.Login;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("profil")
    private Profil profil;

    @SerializedName("users")
    private Users users;

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return
                "Data{" +
                        "profil = '" + profil + '\'' +
                        ",users = '" + users + '\'' +
                        "}";
    }
}