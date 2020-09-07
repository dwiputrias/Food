package com.dwiputri.greatfood.CRUD_Survey;

public class DataSurvey {
    private int id_survey;
    private String nama;
    private String persen;

    public int getId_survey() {
        return id_survey;
    }

    public void setId_survey(int id_survey) {
        this.id_survey = id_survey;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPersen() {
        return persen;
    }

    public void setPersen(String persen) {
        this.persen = persen;
    }
}
