package com.dwiputri.greatfood.WebService;

public class ModelHasilLokasi {
    private int id;
    private String nama_makanan;
    private String asal_makanan;
    private String lokasi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_makanan() {
        return nama_makanan;
    }

    public String getAsal_makanan() {
        return asal_makanan;
    }

    public void setAsal_makanan(String asal_makanan) {
        this.asal_makanan = asal_makanan;
    }

    public void setNama_makanan(String nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}
