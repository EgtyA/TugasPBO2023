/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CrudBuku;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author egty
 */
@Entity
@Table(name = "buku")
@NamedQueries({
    @NamedQuery(name = "Buku_1.findAll", query = "SELECT b FROM Buku_1 b"),
    @NamedQuery(name = "Buku_1.findByIsbn", query = "SELECT b FROM Buku_1 b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Buku_1.findByJudulBuku", query = "SELECT b FROM Buku_1 b WHERE b.judulBuku = :judulBuku"),
    @NamedQuery(name = "Buku_1.findByTahunTerbit", query = "SELECT b FROM Buku_1 b WHERE b.tahunTerbit = :tahunTerbit"),
    @NamedQuery(name = "Buku_1.findByPenerbit", query = "SELECT b FROM Buku_1 b WHERE b.penerbit = :penerbit")})
public class Buku_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "judul_buku")
    private String judulBuku;
    @Column(name = "tahun_terbit")
    private String tahunTerbit;
    @Column(name = "penerbit")
    private String penerbit;

    public Buku_1() {
    }

    public Buku_1(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buku_1)) {
            return false;
        }
        Buku_1 other = (Buku_1) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CrudBuku.Buku_1[ isbn=" + isbn + " ]";
    }
    
}
