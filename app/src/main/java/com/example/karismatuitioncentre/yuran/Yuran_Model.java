package com.example.karismatuitioncentre.yuran;

public class Yuran_Model
{
    String nama,kp,email;
    Yuran_Model()
    {

    }
    public Yuran_Model(String nama, String kp, String email) {
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
