/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas3Pbo;

/**
 *
 * @author egty
 */
public class OrangAceh extends Orang {
    
    public void setDomisili() {
        super.setDomisili("dari daerah yaitu Aceh");
    }
       
    //construktor
    public OrangAceh() {
        this.setDomisili();
        this.jenisBaju = " baju adat orang aceh adalah Ulee Balang ";
    }
    
    public OrangAceh(String jenisBaju){
        this.jenisBaju = jenisBaju;
        this.setDomisili();
    }
    
   
    
    
    @Override
    public String menghadiriKuliah() {
        return "untuk mengetahui jam masuk kuliah lihat di public";
    }
    
}
