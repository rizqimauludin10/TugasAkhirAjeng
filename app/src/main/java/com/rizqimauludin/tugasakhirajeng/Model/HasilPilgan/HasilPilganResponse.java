package com.rizqimauludin.tugasakhirajeng.Model.HasilPilgan;

import com.google.gson.annotations.SerializedName;

public class HasilPilganResponse {

    @SerializedName("data")
    private HasilPilganDataItem hasilPilganDataItem;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    public HasilPilganDataItem getHasilPilganDataItem() {
        return hasilPilganDataItem;
    }

    public void setHasilPilganDataItem(HasilPilganDataItem hasilPilganDataItem) {
        this.hasilPilganDataItem = hasilPilganDataItem;
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

    @Override
    public String toString() {
        return
                "HasilPilganResponse{" +
                        "data = '" + hasilPilganDataItem + '\'' +
                        ",message = '" + message + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}