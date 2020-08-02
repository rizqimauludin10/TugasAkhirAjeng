package com.rizqimauludin.tugasakhirajeng.Model.Pilgan;

import com.google.gson.annotations.SerializedName;

public class PilganDataItem {

    @SerializedName("pilihan_a")
    private String pilihanA;

    @SerializedName("soal")
    private String soal;

    @SerializedName("pilihan_c")
    private String pilihanC;

    @SerializedName("pilihan_b")
    private String pilihanB;

    @SerializedName("pilihan_e")
    private String pilihanE;

    @SerializedName("pilihan_d")
    private String pilihanD;

    @SerializedName("jawaban")
    private String jawaban;

    public String getPilihanA() {
        return pilihanA;
    }

    public void setPilihanA(String pilihanA) {
        this.pilihanA = pilihanA;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getPilihanC() {
        return pilihanC;
    }

    public void setPilihanC(String pilihanC) {
        this.pilihanC = pilihanC;
    }

    public String getPilihanB() {
        return pilihanB;
    }

    public void setPilihanB(String pilihanB) {
        this.pilihanB = pilihanB;
    }

    public String getPilihanE() {
        return pilihanE;
    }

    public void setPilihanE(String pilihanE) {
        this.pilihanE = pilihanE;
    }

    public String getPilihanD() {
        return pilihanD;
    }

    public void setPilihanD(String pilihanD) {
        this.pilihanD = pilihanD;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    @Override
    public String toString() {
        return
                "DataItem{" +
                        "pilihan_a = '" + pilihanA + '\'' +
                        ",soal = '" + soal + '\'' +
                        ",pilihan_c = '" + pilihanC + '\'' +
                        ",pilihan_b = '" + pilihanB + '\'' +
                        ",pilihan_e = '" + pilihanE + '\'' +
                        ",pilihan_d = '" + pilihanD + '\'' +
                        ",jawaban = '" + jawaban + '\'' +
                        "}";
    }
}