package com.example.karismatuitioncentre;

public class Jadual_Model {

    String subjek, pengajar, masa;

    public String getSubjek() {
        return subjek;
    }

    public void setSubjek(String subjek) {
        this.subjek = subjek;
    }

    public String getPengajar() {
        return pengajar;
    }

    public void setPengajar(String pengajar) {
        this.pengajar = pengajar;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    Jadual_Model() {

    }

    public Jadual_Model(String subjek, String pengajar, String masa) {
        this.subjek = subjek;
        this.pengajar = pengajar;
        this.masa = masa;

    }

}