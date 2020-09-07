package com.dwiputri.greatfood.Fragment;

public class Terbaru {
    private String nama1;
    private String harga1;
    private int gambar1;
    private String deskripsi1;


    public Terbaru(String nama1, String harga1, int gambar1) {
        this.nama1 = nama1;
        this.harga1 = harga1;
        this.gambar1 = gambar1;
    }

    public Terbaru(String nama1, String harga1, int gambar1, String deskripsi1) {
        this.nama1 = nama1;
        this.harga1 = harga1;
        this.gambar1 = gambar1;
        this.deskripsi1 = deskripsi1;
    }

    public String getDeskripsi1() {
        return deskripsi1;
    }

    public void setDeskripsi1(String deskripsi1) {
        this.deskripsi1 = deskripsi1;
    }

    public String getNama1() {
        return nama1;
    }

    public void setNama1(String nama1) {
        this.nama1 = nama1;
    }

    public String getHarga1() {
        return harga1;
    }

    public void setHarga1(String harga1) {
        this.harga1 = harga1;
    }

    public int getGambar1() {
        return gambar1;
    }

    public void setGambar1(int gambar1) {
        this.gambar1 = gambar1;
    }

}
