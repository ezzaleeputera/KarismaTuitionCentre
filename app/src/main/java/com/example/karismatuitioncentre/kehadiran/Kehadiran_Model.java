package com.example.karismatuitioncentre.kehadiran;

public class Kehadiran_Model {
    String masaEHour, masaEMin, masaSHour, masaSMin, date, pengajar, subjek;

    Kehadiran_Model() {

    }

    public String getMasaEHour() {
        return masaEHour;
    }

    public void setMasaEHour(String masaEHour) {
        this.masaEHour = masaEHour;
    }

    public String getMasaEMin() {
        return masaEMin;
    }

    public void setMasaEMin(String masaEMin) {
        this.masaEMin = masaEMin;
    }

    public String getMasaSHour() {
        return masaSHour;
    }

    public void setMasaSHour(String masaSHour) {
        this.masaSHour = masaSHour;
    }

    public String getMasaSMin() {
        return masaSMin;
    }

    public void setMasaSMin(String masaSMin) {
        this.masaSMin = masaSMin;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPengajar() {
        return pengajar;
    }

    public void setPengajar(String pengajar) {
        this.pengajar = pengajar;
    }

    public String getSubjek() {
        return subjek;
    }

    public void setSubjek(String subjek) {
        this.subjek = subjek;
    }
}