/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPbo;

/**
 *
 * @author egty
 */
public class Vertebrata extends Hewan{
    
    //atribut
    private String bertulangApa;
    protected int pergantianGigi;
    
    
    //construktor
    public Vertebrata(){
        super(4);
        this.jenisMakanan = "ikan";
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.jumlahKaki = 4;
    }
    
    public Vertebrata(int pergantianGigi){
        super(4);
        this.pergantianGigi = 1;
        this.jenisMakanan = "ikan";
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
    }
    
    public Vertebrata(String berkembangBiak){
        super(4);
        this.jenisMakanan = "ikan";
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.pergantianGigi = 1;
    }
    
    
    
    /**
     * @return the bertulangApa
     */
    public String getBertulangApa() {
        return bertulangApa;
    }

    /**
     * @param bertulangApa the bertulangApa to set
     */
    public void setBertulangApa(String bertulangApa) {
        this.bertulangApa = bertulangApa;
    }

    /**
     * @return the pergantianGigi
     */
    public int getPergantianGigi() {
        return pergantianGigi;
    }

    /**
     * @param pergantianGigi the pergantianGigi to set
     */
    public void setPergantianGigi(int pergantianGigi) {
        this.pergantianGigi = pergantianGigi;
    }
    
    
}
