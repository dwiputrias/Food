package com.dwiputri.greatfood.CRUD_Survey;


import java.util.List;

public class ResponsSurvey {
    String  kode, pesan;
    List<DataSurvey> result;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<DataSurvey> getResult() {
        return result;
    }

    public void setResult(List<DataSurvey> result) {
        this.result = result;
    }
}
