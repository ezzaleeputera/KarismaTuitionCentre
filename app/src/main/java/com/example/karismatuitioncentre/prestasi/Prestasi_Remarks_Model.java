package com.example.karismatuitioncentre.prestasi;

public class Prestasi_Remarks_Model {
    String titleR,descR,dateR;

    Prestasi_Remarks_Model(){

    }

    public Prestasi_Remarks_Model(String titleR, String descR, String dateR) {
        this.titleR = titleR;
        this.descR = descR;
        this.dateR = dateR;
    }

    public String getTitleR() {
        return titleR;
    }

    public void setTitleR(String titleR) {
        this.titleR = titleR;
    }

    public String getDescR() {
        return descR;
    }

    public void setDescR(String descR) {
        this.descR = descR;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }
}
