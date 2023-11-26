/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPersistane;

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
@Table(name = "data_buku")
@NamedQueries({
    @NamedQuery(name = "DataBuku.findAll", query = "SELECT d FROM DataBuku d"),
    @NamedQuery(name = "DataBuku.findByIdBuku", query = "SELECT d FROM DataBuku d WHERE d.idBuku = :idBuku"),
    @NamedQuery(name = "DataBuku.findByIsbn", query = "SELECT d FROM DataBuku d WHERE d.isbn = :isbn"),
    @NamedQuery(name = "DataBuku.findByJudulBuku", query = "SELECT d FROM DataBuku d WHERE d.judulBuku = :judulBuku"),
    @NamedQuery(name = "DataBuku.findByKategori", query = "SELECT d FROM DataBuku d WHERE d.kategori = :kategori"),
    @NamedQuery(name = "DataBuku.findByPengarang", query = "SELECT d FROM DataBuku d WHERE d.pengarang = :pengarang"),
    @NamedQuery(name = "DataBuku.findByPenerbit", query = "SELECT d FROM DataBuku d WHERE d.penerbit = :penerbit"),
    @NamedQuery(name = "DataBuku.findByTahunTerbit", query = "SELECT d FROM DataBuku d WHERE d.tahunTerbit = :tahunTerbit"),
    @NamedQuery(name = "DataBuku.findByJumlahHalaman", query = "SELECT d FROM DataBuku d WHERE d.jumlahHalaman = :jumlahHalaman")})
public class DataBuku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_buku")
    private String idBuku;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "judul_buku")
    private String judulBuku;
    @Column(name = "kategori")
    private String kategori;
    @Column(name = "pengarang")
    private String pengarang;
    @Column(name = "penerbit")
    private String penerbit;
    @Column(name = "tahun_terbit")
    private String tahunTerbit;
    @Column(name = "jumlah_halaman")
    private String jumlahHalaman;

    public DataBuku() {
    }

    public DataBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
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

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getJumlahHalaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(String jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBuku != null ? idBuku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataBuku)) {
            return false;
        }
        DataBuku other = (DataBuku) object;
        if ((this.idBuku == null && other.idBuku != null) || (this.idBuku != null && !this.idBuku.equals(other.idBuku))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassPersistane.DataBuku[ idBuku=" + idBuku + " ]";
    }
    
}
