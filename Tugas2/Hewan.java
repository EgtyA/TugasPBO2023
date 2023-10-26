/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPbo;

/**
 *
 * @author egty
 */
public class Hewan extends MakhlukHidup {
    
    //atribut
    protected String jenisMakanan;
    protected int jumlahKaki;
    private String penutupTubuh;
    
    //subclass contruktor
    public Hewan(){
        super();
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.jenisMakanan = "ikan";
        this.jumlahKaki = 4;
    }
    
    public Hewan(String nama){
        this.jenisMakanan = "ikan";
        super.nama = "Berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.jumlahKaki = 4;
    }
    
    public Hewan(int jumlahKaki){
        this.jumlahKaki = 4;
        super.nama = nama;
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.jenisMakanan = "ikan";       
    }
    
    
    
    
    /**
     * @return the jenisMakanan
     */
    public String getJenisMakanan() {
        return jenisMakanan;
    }

    /**
     * @param jenisMakanan the jenisMakanan to set
     */
    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    /**
     * @return the jumlahKaki
     */
    public int getJumlahKaki() {
        return jumlahKaki;
    }

    /**
     * @param jumlahKaki the jumlahKaki to set
     */
    public void setJumlahKaki(int jumlahKaki) {
        this.jumlahKaki = jumlahKaki;
    }

       
    public void display(){
        System.out.println("semua makhluk hidup seperti " + this.bergerak());
      
    }

    /**
     * @return the penutupTubuh
     */
    public String getPenutupTubuh() {
        return penutupTubuh;
    }

    /**
     * @param penutupTubuh the penutupTubuh to set
     */
    public void setPenutupTubuh(String penutupTubuh) {
        this.penutupTubuh = penutupTubuh;
    }


}
    
    
    
  

   
   
