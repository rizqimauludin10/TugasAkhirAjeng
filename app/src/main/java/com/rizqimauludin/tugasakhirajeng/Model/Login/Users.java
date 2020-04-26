package com.rizqimauludin.tugasakhirajeng.Model.Login;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("password")
    private String password;

    @SerializedName("role_akses")
    private String roleAkses;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("email_verified_at")
    private Object emailVerifiedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("remember_token")
    private String rememberToken;

    @SerializedName("email")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleAkses() {
        return roleAkses;
    }

    public void setRoleAkses(String roleAkses) {
        this.roleAkses = roleAkses;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "Users{" +
                        "password = '" + password + '\'' +
                        ",role_akses = '" + roleAkses + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",name = '" + name + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",email_verified_at = '" + emailVerifiedAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",remember_token = '" + rememberToken + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}