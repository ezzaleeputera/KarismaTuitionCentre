package com.example.karismatuitioncentre.yuran;

public class putPdf {

    public String namaPembayar, namaBank, jumlahPembayaran,tarikh;
    public String name,url;

    public putPdf(){

    }

    public putPdf(String namaPembayar, String namaBank, String jumlahPembayaran, String tarikh,/* String name,*/String url){
        this.jumlahPembayaran=jumlahPembayaran;
        this.namaBank=namaBank;
        this.namaPembayar=namaPembayar;
        this.tarikh=tarikh;
        this.url=url;
 /*       this.name=name;*/
    }

    public String getNamaPembayar() {
        return namaPembayar;
    }

    public void setNamaPembayar(String namaPembayar) {
        this.namaPembayar = namaPembayar;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getJumlahPembayaran() {
        return jumlahPembayaran;
    }

    public void setJumlahPembayaran(String jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }

    public String getTarikh() {
        return tarikh;
    }

    public void setTarikh(String tarikh) {
        this.tarikh = tarikh;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
/*    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/


}
