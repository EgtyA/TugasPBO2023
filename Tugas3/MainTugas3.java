/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainUtama3;

import Tugas3Pbo.Orang;
import Tugas3Pbo.OrangAceh;
import Tugas3Pbo.OrangMedan;

/**
 *
 * @author egty
 */
public class MainTugas3 {
    public static void main(String[] args) {
        
        Orang aba = new Orang();
        System.out.println(aba.menghadiriKuliah(14.00));
        System.out.println(aba.getJenisKelamin());
        System.out.println("ia bernama bibi");
        
        OrangMedan bibi = new OrangMedan();
        System.out.println("bibi seorang mahasiswa di universitas Main, sebuah universitas yang berada " + bibi.getDomisili());       
        System.out.println("alamat kos nya terletak " + aba.getDomisili());
        
        System.out.println("");
               
        System.out.println(bibi.getHobi()); 
        bibi.menulisCerita();
        
        System.out.print("ia adalah "); 
        bibi.mengerjakanTugas();
        System.out.print("saat ini ia sedang "); 
        bibi.jagaPerpustakaan();
        
        System.out.println("");
        
        OrangAceh bia = new OrangAceh();       
        System.out.println("bibi berasal " + bia.getDomisili() + " dan " + bia.getJenisBaju());
        System.out.println("bibi lupa jadwal kuliah nya, sehingga " + bia.menghadiriKuliah());
               
    }    
}
