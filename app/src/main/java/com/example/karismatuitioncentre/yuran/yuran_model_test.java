package com.example.karismatuitioncentre.yuran;

public class yuran_model_test
{
    String nama,kp,email;
    yuran_model_test()
    {

    }
    public yuran_model_test(String nama, String kp, String email) {
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
