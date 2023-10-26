/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasPbo;

/**
 *
 * @author egty
 */
public class MakhlukHidup {
    
    //atribut
    protected String nama;
    private String namaIlmiah;
    protected String berkembangbiak;
    protected String alatPernafasan;

    protected String bergerak(){
        return "Hewan dan tumbuhan dapat bergerak";
    }
    
    //construktor
    public MakhlukHidup(){
        this.nama = "berang-berang";
        this.alatPernafasan = "paru-paru";
        this.berkembangbiak = "melahirkan";
        this.bergerak();
    }   
    public MakhlukHidup(String nama){
        this.alatPernafasan = "paru-paru";
        this.nama = nama;
        this.berkembangbiak = "melahirkan";
        this.bergerak();
    }   
    public MakhlukHidup(String alatPernafasan, String berkembangbiak){
        this.berkembangbiak = "melahirkan";
        this.bergerak();
        this.alatPernafasan = "paru-paru";
        this.nama = nama;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the namaIlmiah
     */
    public String getNamaIlmiah() {
        return namaIlmiah;
    }

    /**
     * @param namaIlmiah the namaIlmiah to set
     */
    public void setNamaIlmiah(String namaIlmiah) {
        this.namaIlmiah = namaIlmiah;
    }

    /**
     * @return the berkembangbiak
     */
    public String getBerkembangbiak() {
        return berkembangbiak;
    }

    /**
     * @param berkembangbiak the berkembangbiak to set
     */
    public void setBerkembangbiak(String berkembangbiak) {
        this.berkembangbiak = berkembangbiak;
    }

    /**
     * @return the alatPernafasan
     */
    public String getAlatPernafasan() {
        return alatPernafasan;
    }

    /**
     * @param alatPernafasan the alatPernafasan to set
     */
    public void setAlatPernafasan(String alatPernafasan) {
        this.alatPernafasan = alatPernafasan;
    }
    
    
    

   
    
}
