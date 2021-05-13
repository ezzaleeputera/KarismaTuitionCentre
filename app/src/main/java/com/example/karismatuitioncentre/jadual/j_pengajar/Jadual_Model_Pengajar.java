package com.example.karismatuitioncentre.jadual.j_pengajar;
        import java.io.Serializable;


public class Jadual_Model_Pengajar
{
    String subjek,pengajar,masa;
    Jadual_Model_Pengajar()
    {

    }
    public Jadual_Model_Pengajar(String pengajar, String subjek, String masa) {
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
