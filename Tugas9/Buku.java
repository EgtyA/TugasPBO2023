/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrudBuku;

/**
 *
 * @author egty
 */
public class Buku {
    private String ISBN;
    private String judul_buku;
    private String tahun_terbit;
    private String penerbit;

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the judul_buku
     */
    public String getJudul_buku() {
        return judul_buku;
    }

    /**
     * @param judul_buku the judul_buku to set
     */
    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    /**
     * @return the tahun_terbit
     */
    public String getTahun_terbit() {
        return tahun_terbit;
    }

    /**
     * @param tahun_terbit the tahun_terbit to set
     */
    public void setTahun_terbit(String tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    /**
     * @return the penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }

    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    
}
