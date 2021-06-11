package com.example.karismatuitioncentre.prestasi;

public class Prestasi_StudentList_Model {
    String nama, userid, kp;
    int numTest;

    Prestasi_StudentList_Model() {

    }

    public Prestasi_StudentList_Model(String nama, String userid, String kp, int numTest) {
        this.nama = nama;
        this.userid = userid;
        this.kp = kp;
        this.numTest = numTest;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public int getNumTest() {
        return numTest;
    }

    public void setNumTest(int numTest) {
        this.numTest = numTest;
    }
}