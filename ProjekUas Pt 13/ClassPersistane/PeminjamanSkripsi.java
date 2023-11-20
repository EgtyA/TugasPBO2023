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
@Table(name = "peminjaman_skripsi")
@NamedQueries({
    @NamedQuery(name = "PeminjamanSkripsi.findAll", query = "SELECT p FROM PeminjamanSkripsi p"),
    @NamedQuery(name = "PeminjamanSkripsi.findByNoPeminjamanSkripsi", query = "SELECT p FROM PeminjamanSkripsi p WHERE p.noPeminjamanSkripsi = :noPeminjamanSkripsi"),
    @NamedQuery(name = "PeminjamanSkripsi.findByStatusPeminjaman", query = "SELECT p FROM PeminjamanSkripsi p WHERE p.statusPeminjaman = :statusPeminjaman"),
    @NamedQuery(name = "PeminjamanSkripsi.findByTglPeminjamanSkripsi", query = "SELECT p FROM PeminjamanSkripsi p WHERE p.tglPeminjamanSkripsi = :tglPeminjamanSkripsi"),
    @NamedQuery(name = "PeminjamanSkripsi.findByTglKembaliSkripsi", query = "SELECT p FROM PeminjamanSkripsi p WHERE p.tglKembaliSkripsi = :tglKembaliSkripsi"),
    @NamedQuery(name = "PeminjamanSkripsi.findByNamaPeminjam", query = "SELECT p FROM PeminjamanSkripsi p WHERE p.namaPeminjam = :namaPeminjam"),
    @NamedQuery(name = "PeminjamanSkripsi.findByNim", query = "SELECT p FROM PeminjamanSkripsi p WHERE p.nim = :nim"),
    @NamedQuery(name = "PeminjamanSkripsi.findByProgramStudi", query = "SELECT p FROM PeminjamanSkripsi p WHERE p.programStudi = :programStudi"),
    @NamedQuery(name = "PeminjamanSkripsi.findByNoTlp", query = "SELECT p FROM PeminjamanSkripsi p WHERE p.noTlp = :noTlp")})
public class PeminjamanSkripsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "no_peminjaman_skripsi")
    private String noPeminjamanSkripsi;
    @Column(name = "status_peminjaman")
    private String statusPeminjaman;
    @Column(name = "tgl_peminjaman_skripsi")
    @Temporal(TemporalType.DATE)
    private Date tglPeminjamanSkripsi;
    @Column(name = "tgl_kembali_skripsi")
    @Temporal(TemporalType.DATE)
    private Date tglKembaliSkripsi;
    @Column(name = "nama_peminjam")
    private String namaPeminjam;
    @Column(name = "nim")
    private String nim;
    @Column(name = "program_studi")
    private String programStudi;
    @Column(name = "no_tlp")
    private String noTlp;
    @JoinColumn(name = "id_skripsi", referencedColumnName = "id_skripsi")
    @ManyToOne
    private DataSkripsi idSkripsi;

    public PeminjamanSkripsi() {
    }

    public PeminjamanSkripsi(String noPeminjamanSkripsi) {
        this.noPeminjamanSkripsi = noPeminjamanSkripsi;
    }

    public String getNoPeminjamanSkripsi() {
        return noPeminjamanSkripsi;
    }

    public void setNoPeminjamanSkripsi(String noPeminjamanSkripsi) {
        this.noPeminjamanSkripsi = noPeminjamanSkripsi;
    }

    public String getStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void setStatusPeminjaman(String statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }

    public Date getTglPeminjamanSkripsi() {
        return tglPeminjamanSkripsi;
    }

    public void setTglPeminjamanSkripsi(Date tglPeminjamanSkripsi) {
        this.tglPeminjamanSkripsi = tglPeminjamanSkripsi;
    }

    public Date getTglKembaliSkripsi() {
        return tglKembaliSkripsi;
    }

    public void setTglKembaliSkripsi(Date tglKembaliSkripsi) {
        this.tglKembaliSkripsi = tglKembaliSkripsi;
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

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    public DataSkripsi getIdSkripsi() {
        return idSkripsi;
    }

    public void setIdSkripsi(DataSkripsi idSkripsi) {
        this.idSkripsi = idSkripsi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noPeminjamanSkripsi != null ? noPeminjamanSkripsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeminjamanSkripsi)) {
            return false;
        }
        PeminjamanSkripsi other = (PeminjamanSkripsi) object;
        if ((this.noPeminjamanSkripsi == null && other.noPeminjamanSkripsi != null) || (this.noPeminjamanSkripsi != null && !this.noPeminjamanSkripsi.equals(other.noPeminjamanSkripsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassPersistane.PeminjamanSkripsi[ noPeminjamanSkripsi=" + noPeminjamanSkripsi + " ]";
    }
    
}
