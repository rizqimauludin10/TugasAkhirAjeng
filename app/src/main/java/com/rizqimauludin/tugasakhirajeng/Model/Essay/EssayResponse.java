package com.rizqimauludin.tugasakhirajeng.Model.Essay;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EssayResponse {

    @SerializedName("data")
    private List<EssayDataItem> data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public List<EssayDataItem> getData() {
        return data;
    }

    public void setData(List<EssayDataItem> data) {
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
}