/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPbo;

/**
 *
 * @author egty
 */
public class Berangberang extends Mammalia {

    //atribut
    public int menahanNafas;

    //construktor
    public Berangberang() {
        this.jumlahBilikJantung = 4;
        this.jumlahKaki = 4;
        this.pergantianGigi = 1;
        this.jenisMakanan = "ikan";
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "Melahirkan";
        this.bergerak();
        this.ciriNyaApa = "Memiliki kelenjar susu";
    }

    public Berangberang(String ciri) {
        this.jumlahBilikJantung = 4;
        this.jumlahKaki = 4;
        this.pergantianGigi = 1;
        this.jenisMakanan = "ikan";
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "Meelahirkan";
        this.bergerak();
        this.ciriNyaApa = "Berpelukan saat tidur";
    }

    public Berangberang(int jumlahBilikJantung) {
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

}
