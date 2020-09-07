package com.dwiputri.greatfood.WebService;

import java.util.List;

public class ResponseHasilLokasi {
    private String error;
    private List<ModelHasilLokasi> lokasi;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ModelHasilLokasi> getLokasi() {
        return lokasi;
    }

    public void setLokasi(List<ModelHasilLokasi> lokasi) {
        this.lokasi = lokasi;
    }
}
