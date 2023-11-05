/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas1Pbo;

/**
 *
 * @author egty
 */
public class BerangBerang {
    public static void main(String[] args) {
        
        Hewan berangBerang = new Hewan();
        berangBerang.setNama("berang-berang");
        berangBerang.setNamaIlmiah("Lutrinae");
        berangBerang.setOrdo("karnivora");
        berangBerang.setKelas("Mammalia");
        berangBerang.setAlatPernafasan("paru-paru");
        berangBerang.setHabitat("Ekosistem lahan basah");
        berangBerang.setMakanan("ikan, serangga air, dll");
        
        System.out.println("nama nya adalah " + berangBerang.getNama());
        System.out.println("nama ilmiah nya = " + berangBerang.getNamaIlmiah());
        System.out.println("hewan ini termasuk ordo " + berangBerang.getOrdo());
        System.out.println("berang-berang termasuk ke dalam kelas " + berangBerang.getKelas());
        System.out.println("hewan ini bernafas dengan menggunakan = " + berangBerang.getAlatPernafasan());
        System.out.println("habitat berang-berang biasanya ada di" + berangBerang.getHabitat());
        System.out.println("hewan ini biasanya memakan " + berangBerang.getMakanan());
                
        System.out.println(berangBerang.bergerak());
        System.out.println(berangBerang.beraktivitas());
        System.out.println(berangBerang.berkembangbiak());
}
}
