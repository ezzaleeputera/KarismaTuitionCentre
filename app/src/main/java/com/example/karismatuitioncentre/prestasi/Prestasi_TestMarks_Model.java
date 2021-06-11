package com.example.karismatuitioncentre.prestasi;

public class Prestasi_TestMarks_Model {
    int xValue, yValue;

    String userid,dateTest;

    Prestasi_TestMarks_Model() {

    }

    public Prestasi_TestMarks_Model(int xValue, int yValue, String userid, String dateTest) {
        this.xValue = xValue;
        this.yValue = yValue;
        this.userid = userid;
        this.dateTest = dateTest;
    }


    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDateTest() {
        return dateTest;
    }

    public void setDateTest(String dateTest) {
        this.dateTest = dateTest;
    }
}