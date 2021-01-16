package com.example.karismatuitioncentre;
import java.io.Serializable;


public class MaklumBalas_Model
{
    String title,desc;
    MaklumBalas_Model()
    {

    }
    public MaklumBalas_Model(String title, String desc) {
        this.title = title;
        this.desc = desc;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
