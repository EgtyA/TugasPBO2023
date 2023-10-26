/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas3Pbo;

/**
 *
 * @author egty
 */
public class OrangMedan extends Orang implements Mahasiswa,PenjagaPerpustakaan, Novelis {
    
    public void setDomisili() {
        super.setDomisili("di sebuah daerah yaitu sumatera utara");
    }
    
    //construktor
    public OrangMedan() {
        this.setDomisili();
        this.setHobi("hobi si bibi adalah membaca. ");
    }

    @Override
    public void mengerjakanTugas() {
        System.out.println("mahasiswa yang rajin mengerjakan tugas ");
    }

    @Override
    public void jagaPerpustakaan() {
        System.out.println("mencari pengalaman dengan menjaga perpustakaan "); 
    }

    @Override
    public void menulisCerita() {
        System.out.println("selain itu, ia juga suka menulis cerita novel"); 
    }    
}
