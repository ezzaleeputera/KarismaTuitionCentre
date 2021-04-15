package com.example.karismatuitioncentre.jadual;
        import java.io.Serializable;


public class Jadual_Model
{
    String subjek,pengajar,masa;
    Jadual_Model()
    {

    }
    public Jadual_Model(String pengajar, String subjek, String masa) {
        this.subjek = subjek;
        this.pengajar = pengajar;
        this.masa = masa;

    }

    public String getPengajar() {
        return pengajar;
    }

    public void setPengajar(String pengajar) { this.pengajar = pengajar; }

    public String getSubjek() { return subjek; }

    public void setSubjek(String subjek) { this.subjek = subjek; }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }
}
