package com.example.karismatuitioncentre;

public class Kelas_Hari {
//    private String slot;
    private String subjek;
    private String pengajar;
    private String masa;

//    public String getSlot() {
//        return slot;
//    }
//
//    public void setSlot(String slot) {
//        this.slot = slot;
//    }

    public Kelas_Hari(String subjek, String pengajar, String masa, String slot) {
        this.subjek = subjek;
        this.pengajar = pengajar;
        this.masa = masa;
//        this.slot=slot;
    }

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
}
