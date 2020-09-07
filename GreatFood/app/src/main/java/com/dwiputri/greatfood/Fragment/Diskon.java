package com.dwiputri.greatfood.Fragment;

public class Diskon {
    private String nama;
    private String harga;
    private int gambar;
    private String deskripsi;


    public Diskon(String nama, String harga, int gambar) {
        this.nama = nama;
        this.harga = harga;
        this.gambar = gambar;
    }

    public Diskon(String nama, String harga, int gambar, String deskripsi) {
        this.nama = nama;
        this.harga = harga;
        this.gambar = gambar;
        this.deskripsi = deskripsi;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }


}
