package com.example.karismatuitioncentre.register_login;

public class RegisterLogin_Model {
    String email,kl,kp,nama,to_User,userid;
    RegisterLogin_Model(){

    }

    public RegisterLogin_Model(String email, String kl, String kp, String nama, String to_User, String userid) {
        this.email = email;
        this.kl = kl;
        this.kp = kp;
        this.nama = nama;
        this.to_User = to_User;
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKl() {
        return kl;
    }

    public void setKl(String kl) {
        this.kl = kl;
    }

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTo_User() {
        return to_User;
    }

    public void setTo_User(String to_User) {
        this.to_User = to_User;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
