/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPbo;

/**
 *
 * @author egty
 */
public class Mammalia extends Vertebrata{
    
    //atribut
    protected String ciriNyaApa;
    protected int jumlahBilikJantung;
    private boolean memilkiAnggotaTubuh;
    
    
    //construktor
    public Mammalia(String ciri){
        this.ciriNyaApa = "Berpelukan saat tidur";
        this.jumlahKaki = 4;
        this.pergantianGigi = 1;
        this.jenisMakanan = "ikan";
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.jumlahBilikJantung = 4;
    }
    
    public Mammalia(){
        this.jumlahBilikJantung = 4;
        this.jumlahKaki = 4;
        this.pergantianGigi = 1;
        this.jenisMakanan = "ikan";
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.ciriNyaApa = "Memiliki kelenjar susu";
    }
    
    public Mammalia(int jumlahBilikJantung){
        this.jumlahBilikJantung = 4;
        this.jumlahKaki = 4;
        this.pergantianGigi = 1;
        this.jenisMakanan = "ikan";
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.ciriNyaApa = "Berpelukan saat tidur";
    }

    /**
     * @return the ciriNyaApa
     */
    public String getCiriNyaApa() {
        return ciriNyaApa;
    }

    /**
     * @param ciriNyaApa the ciriNyaApa to set
     */
    public void setCiriNyaApa(String ciriNyaApa) {
        this.ciriNyaApa = ciriNyaApa;
    }

    /**
     * @return the jumlahBilikJantung
     */
    public int getJumlahBilikJantung() {
        return jumlahBilikJantung;
    }

    /**
     * @param jumlahBilikJantung the jumlahBilikJantung to set
     */
    public void setJumlahBilikJantung(int jumlahBilikJantung) {
        this.jumlahBilikJantung = jumlahBilikJantung;
    }

    /**
     * @return the memilkiAnggotaTubuh
     */
    public boolean isMemilkiAnggotaTubuh() {
        return memilkiAnggotaTubuh;
    }

    /**
     * @param memilkiAnggotaTubuh the memilkiAnggotaTubuh to set
     */
    public void setMemilkiAnggotaTubuh(boolean memilkiAnggotaTubuh) {
        this.memilkiAnggotaTubuh = memilkiAnggotaTubuh;
    }
    

    }
   

