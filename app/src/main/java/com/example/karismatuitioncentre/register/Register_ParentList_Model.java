package com.example.karismatuitioncentre.register;

public class Register_ParentList_Model {
    String nama,email,kp,parentid;

    Register_ParentList_Model(){

    }

    public Register_ParentList_Model(String nama, String email, String kp, String parentid) {
        this.nama = nama;
        this.email = email;
        this.kp = kp;
        this.parentid = parentid;
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

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
}
