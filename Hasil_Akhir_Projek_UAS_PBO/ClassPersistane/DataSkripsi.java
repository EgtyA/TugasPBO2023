/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPersistane;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author egty
 */
@Entity
@Table(name = "data_skripsi")
@NamedQueries({
    @NamedQuery(name = "DataSkripsi.findAll", query = "SELECT d FROM DataSkripsi d"),
    @NamedQuery(name = "DataSkripsi.findByIdSkripsi", query = "SELECT d FROM DataSkripsi d WHERE d.idSkripsi = :idSkripsi"),
    @NamedQuery(name = "DataSkripsi.findByJudul", query = "SELECT d FROM DataSkripsi d WHERE d.judul = :judul"),
    @NamedQuery(name = "DataSkripsi.findByKataKunci", query = "SELECT d FROM DataSkripsi d WHERE d.kataKunci = :kataKunci"),
    @NamedQuery(name = "DataSkripsi.findByPenulis", query = "SELECT d FROM DataSkripsi d WHERE d.penulis = :penulis"),
    @NamedQuery(name = "DataSkripsi.findByTahun", query = "SELECT d FROM DataSkripsi d WHERE d.tahun = :tahun"),
    @NamedQuery(name = "DataSkripsi.findByJumlahHalaman", query = "SELECT d FROM DataSkripsi d WHERE d.jumlahHalaman = :jumlahHalaman")})
public class DataSkripsi implements Serializable {

    @OneToMany(mappedBy = "idSkripsi")
    private Collection<PeminjamanSkripsi> peminjamanSkripsiCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_skripsi")
    private String idSkripsi;
    @Column(name = "judul")
    private String judul;
    @Column(name = "kata_kunci")
    private String kataKunci;
    @Column(name = "penulis")
    private String penulis;
    @Column(name = "tahun")
    private String tahun;
    @Column(name = "jumlah_halaman")
    private String jumlahHalaman;

    public DataSkripsi() {
    }

    public DataSkripsi(String idSkripsi) {
        this.idSkripsi = idSkripsi;
    }

    public String getIdSkripsi() {
        return idSkripsi;
    }

    public void setIdSkripsi(String idSkripsi) {
        this.idSkripsi = idSkripsi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKataKunci() {
        return kataKunci;
    }

    public void setKataKunci(String kataKunci) {
        this.kataKunci = kataKunci;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
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
        hash += (idSkripsi != null ? idSkripsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataSkripsi)) {
            return false;
        }
        DataSkripsi other = (DataSkripsi) object;
        if ((this.idSkripsi == null && other.idSkripsi != null) || (this.idSkripsi != null && !this.idSkripsi.equals(other.idSkripsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassPersistane.DataSkripsi[ idSkripsi=" + idSkripsi + " ]";
    }

    public Collection<PeminjamanSkripsi> getPeminjamanSkripsiCollection() {
        return peminjamanSkripsiCollection;
    }

    public void setPeminjamanSkripsiCollection(Collection<PeminjamanSkripsi> peminjamanSkripsiCollection) {
        this.peminjamanSkripsiCollection = peminjamanSkripsiCollection;
    }
    
}
