/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas3Pbo;

/**
 *
 * @author egty
 */
public class Orang {

    private String hobi;
    private String jenisKelamin;
    protected String jenisBaju;
    private String domisili;
    
    //construktor
    public Orang() {
        this.domisili = "Di sebuah kota yang bernama public";
        this.jenisKelamin = "ia adalah seorang perempuan";
    }
    
    public Orang(String jenisKelamin){
        this.jenisKelamin = "ia adalah seorang perempuan";
        this.domisili = "Di sebuah kota yang bernama public";
        
    } 
    
    
    //method overload
    public String  menghadiriKuliah() {
        return "ia datang ke kampus main untuk menghadiri kuliah ";
    }

    public String  menghadiriKuliah(String jam) {
        return "ia menghadiri kuliah " + "pada waktu " + jam;
    }

    public String menghadiriKuliah(int jam) {
        return "ia menghadiri kuliah " + "dijam " + String.valueOf(jam);
    }

    public String menghadiriKuliah(double jam) {
        return "ia akan menghadiri kuliah " + "pada jam " + String.valueOf(jam);
    }
    
    
    
    //untuk menyatakan get set
    /**
     * @return the hobi
     */
    public String getHobi() {
        return hobi;
    }

    /**
     * @param hobi the hobi to set
     */
    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    /**
     * @return the jenisKelamin
     */
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    /**
     * @param jenisKelamin the jenisKelamin to set
     */
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    /**
     * @return the jenisBaju
     */
    public String getJenisBaju() {
        return jenisBaju;
    }

    /**
     * @param jenisBaju the jenisBaju to set
     */
    public void setJenisBaju(String jenisBaju) {
        this.jenisBaju = jenisBaju;
    }

    /**
     * @return the domisili
     */
    public String getDomisili() {
        return domisili;
    }

    /**
     * @param domisili the domisili to set
     */
    public void setDomisili(String domisili) {
        this.domisili = domisili;
    }

}
