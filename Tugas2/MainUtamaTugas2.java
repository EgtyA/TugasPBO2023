/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UtamaTugas2;


import TugasPbo.Berangberang;
import TugasPbo.Berangberang;
import TugasPbo.Hewan;
import TugasPbo.Hewan;
import TugasPbo.Mammalia;
import TugasPbo.Mammalia;
import TugasPbo.Vertebrata;
import TugasPbo.Vertebrata;



/**
 *
 * @author egty
 */
public class MainUtamaTugas2 {
    public static void main(String[] args) {
        
        Hewan bibi = new Hewan();
        bibi.setNamaIlmiah("Lutrinae");
        
        Vertebrata ver = new Vertebrata();
        ver.setBertulangApa("bertulang belakang");
        
        Berangberang be = new Berangberang();
        
        
        System.out.println("nama nya adalah " + be.getNama());
        System.out.println("nama ilmiah nya adalah " + bibi.getNamaIlmiah());
        System.out.println(bibi.getNama() + " bernafas dengan menggunakan " + be.getAlatPernafasan());
        System.out.println(bibi.getNama() + " berkembang biak dengan cara " + be.getBerkembangbiak());      
                
        System.out.println(bibi.getNama() + " kaki nya berjumlah " + be.getJumlahKaki());
        System.out.println("makanan berang berang adalah " + be.getJenisMakanan());
                
        System.out.println("");
        
        System.out.println(be.getNama() + " mengalami pergantian gigi sebanyak " + be.getPergantianGigi() + " kali saja");               
        System.out.println(be.getNama() + " termasuk hewan mamalia");
        System.out.println("Bilik jantung di hewan mamalia berjumlah " + be.getJumlahBilikJantung() + " bilik");
        System.out.println("mamalia memiliki ciri ciri yaitu " + be.getCiriNyaApa());       
        System.out.println("Mammalia termasuk vertebrata yaitu hewan " + ver.getBertulangApa());
        
        
    }
   
    
}
