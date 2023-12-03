/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPersistane;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author egty
 */
@Entity
@Table(name = "peminjaman_buku")
@NamedQueries({
    @NamedQuery(name = "PeminjamanBuku.findAll", query = "SELECT p FROM PeminjamanBuku p"),
    @NamedQuery(name = "PeminjamanBuku.findByNoPeminjaman", query = "SELECT p FROM PeminjamanBuku p WHERE p.noPeminjaman = :noPeminjaman"),
    @NamedQuery(name = "PeminjamanBuku.findByStatusPeminjaman", query = "SELECT p FROM PeminjamanBuku p WHERE p.statusPeminjaman = :statusPeminjaman"),
    @NamedQuery(name = "PeminjamanBuku.findByTglPeminjamanBuku", query = "SELECT p FROM PeminjamanBuku p WHERE p.tglPeminjamanBuku = :tglPeminjamanBuku"),
    @NamedQuery(name = "PeminjamanBuku.findByTglKembaliBuku", query = "SELECT p FROM PeminjamanBuku p WHERE p.tglKembaliBuku = :tglKembaliBuku"),
    @NamedQuery(name = "PeminjamanBuku.findByNamaPeminjam", query = "SELECT p FROM PeminjamanBuku p WHERE p.namaPeminjam = :namaPeminjam"),
    @NamedQuery(name = "PeminjamanBuku.findByNim", query = "SELECT p FROM PeminjamanBuku p WHERE p.nim = :nim"),
    @NamedQuery(name = "PeminjamanBuku.findByProgramStudi", query = "SELECT p FROM PeminjamanBuku p WHERE p.programStudi = :programStudi"),
    @NamedQuery(name = "PeminjamanBuku.findByAngkatan", query = "SELECT p FROM PeminjamanBuku p WHERE p.angkatan = :angkatan"),
    @NamedQuery(name = "PeminjamanBuku.findByJudulBuku", query = "SELECT p FROM PeminjamanBuku p WHERE p.judulBuku = :judulBuku")})
public class PeminjamanBuku implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "no_peminjaman")
    private String noPeminjaman;
    @Column(name = "status_peminjaman")
    private String statusPeminjaman;
    @Column(name = "tgl_peminjaman_buku")
    @Temporal(TemporalType.DATE)
    private Date tglPeminjamanBuku;
    @Column(name = "tgl_kembali_buku")
    @Temporal(TemporalType.DATE)
    private Date tglKembaliBuku;
    @Column(name = "nama_peminjam")
    private String namaPeminjam;
    @Column(name = "nim")
    private String nim;
    @Column(name = "program_studi")
    private String programStudi;
    @Column(name = "angkatan")
    private String angkatan;
    @Column(name = "judul_buku")
    private String judulBuku;
    @JoinColumn(name = "id_buku", referencedColumnName = "id_buku")
    @ManyToOne
    private DataBuku idBuku;

    public PeminjamanBuku() {
    }

    public PeminjamanBuku(String noPeminjaman) {
        this.noPeminjaman = noPeminjaman;
    }

    public String getNoPeminjaman() {
        return noPeminjaman;
    }

    public void setNoPeminjaman(String noPeminjaman) {
        this.noPeminjaman = noPeminjaman;
    }

    public String getStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void setStatusPeminjaman(String statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }

    public Date getTglPeminjamanBuku() {
        return tglPeminjamanBuku;
    }

    public void setTglPeminjamanBuku(Date tglPeminjamanBuku) {
        this.tglPeminjamanBuku = tglPeminjamanBuku;
    }

    public Date getTglKembaliBuku() {
        return tglKembaliBuku;
    }

    public void setTglKembaliBuku(Date tglKembaliBuku) {
        this.tglKembaliBuku = tglKembaliBuku;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public DataBuku getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(DataBuku idBuku) {
        this.idBuku = idBuku;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noPeminjaman != null ? noPeminjaman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeminjamanBuku)) {
            return false;
        }
        PeminjamanBuku other = (PeminjamanBuku) object;
        if ((this.noPeminjaman == null && other.noPeminjaman != null) || (this.noPeminjaman != null && !this.noPeminjaman.equals(other.noPeminjaman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassPersistane.PeminjamanBuku[ noPeminjaman=" + noPeminjaman + " ]";
    }
    
}
