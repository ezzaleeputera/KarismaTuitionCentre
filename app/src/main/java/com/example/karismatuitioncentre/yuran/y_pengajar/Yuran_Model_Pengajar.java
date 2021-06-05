package com.example.karismatuitioncentre.yuran.y_pengajar;

public class Yuran_Model_Pengajar
{
    String nama,kp,email;
    Yuran_Model_Pengajar()
    {

    }
    public Yuran_Model_Pengajar(String nama, String kp, String email) {
        this.nama = nama;
        this.kp = kp;
        this.email = email;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
