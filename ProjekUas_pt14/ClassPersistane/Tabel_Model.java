/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPersistane;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
/**
 *
 * @author egty
 */
public class Tabel_Model implements Serializable {
    
    private String id_buku;
    public static final String PROP_ID_BUKU = "id_buku";
    
    public String getId_buku() {
        return id_buku;
    }
   
    public void setId_buku(String id_buku) {
        String oldId_buku = this.id_buku;
        this.id_buku = id_buku;
        propertyChangeSupport.firePropertyChange(PROP_ID_BUKU, oldId_buku, id_buku);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    private String isbn;
    public static final String PROP_ISBN = "isbn";

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        String oldIsbn = this.isbn;
        this.isbn = isbn;
        propertyChangeSupport.firePropertyChange(PROP_ISBN, oldIsbn, isbn);
    }

        private String judul_buku;

    public static final String PROP_JUDUL_BUKU = "judul_buku";

    public String getJudul_buku() {
        return judul_buku;
    }

    public void setJudul_buku(String judul_buku) {
        String oldJudul_buku = this.judul_buku;
        this.judul_buku = judul_buku;
        propertyChangeSupport.firePropertyChange(PROP_JUDUL_BUKU, oldJudul_buku, judul_buku);
    }

    private String subjudul;

    public static final String PROP_SUBJUDUL = "subjudul";

    public String getSubjudul() {
        return subjudul;
    }

    public void setSubjudul(String subjudul) {
        String oldSubjudul = this.subjudul;
        this.subjudul = subjudul;
        propertyChangeSupport.firePropertyChange(PROP_SUBJUDUL, oldSubjudul, subjudul);
    }

    private String pengarang;

    public static final String PROP_PENGARANG = "pengarang";

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        String oldPengarang = this.pengarang;
        this.pengarang = pengarang;
        propertyChangeSupport.firePropertyChange(PROP_PENGARANG, oldPengarang, pengarang);
    }

    private String penerbit;

    public static final String PROP_PENERBIT = "penerbit";

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        String oldPenerbit = this.penerbit;
        this.penerbit = penerbit;
        propertyChangeSupport.firePropertyChange(PROP_PENERBIT, oldPenerbit, penerbit);
    }

    private String tahun_terbit;

    public static final String PROP_TAHUN_TERBIT = "tahun_terbit";

    public String getTahun_terbit() {
        return tahun_terbit;
    }

    public void setTahun_terbit(String tahun_terbit) {
        String oldTahun_terbit = this.tahun_terbit;
        this.tahun_terbit = tahun_terbit;
        propertyChangeSupport.firePropertyChange(PROP_TAHUN_TERBIT, oldTahun_terbit, tahun_terbit);
    }

    private String jumlah_halaman;

    public static final String PROP_JUMLAH_HALAMAN = "jumlah_halaman";

    public String getJumlah_halaman() {
        return jumlah_halaman;
    }

    public void setJumlah_halaman(String jumlah_halaman) {
        String oldJumlah_halaman = this.jumlah_halaman;
        this.jumlah_halaman = jumlah_halaman;
        propertyChangeSupport.firePropertyChange(PROP_JUMLAH_HALAMAN, oldJumlah_halaman, jumlah_halaman);
    }

    
}
