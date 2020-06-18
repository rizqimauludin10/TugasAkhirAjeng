package com.rizqimauludin.tugasakhirajeng.Model.Latihan;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LatihanResponse {

    @SerializedName("data")
    private List<LatihanDataItem> data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public List<LatihanDataItem> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() {
        return status;
    }
}