package com.example.karismatuitioncentre.kehadiran;

public class User_Kehadiran_Model {
    String nama,email,userid,kp;

    User_Kehadiran_Model(){

    }

    public User_Kehadiran_Model(String nama, String email, String userid, String kp) {
        this.nama = nama;
        this.email = email;
        this.userid = userid;
        this.kp = kp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }
}
