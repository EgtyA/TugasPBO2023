/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import ClassPersistane.PeminjamanBuku;
import ClassPersistane.PeminjamanSkripsi;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author egty
 */
public class Gui_laporan_peminjaman extends javax.swing.JFrame {

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }

    //untuk tanggal peminjaman dan pengembalian yg ditampilkan di tabel
    public static String date(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
        return format.format(date);
    }

    private void tampilpinjambuku() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PeminjamanBuku> cq = cb.createQuery(PeminjamanBuku.class);

        Root<PeminjamanBuku> pin = cq.from(PeminjamanBuku.class);
        cq.orderBy(cb.asc(pin.get("noPeminjaman")));
        CriteriaQuery<PeminjamanBuku> select = cq.select(pin);
        TypedQuery<PeminjamanBuku> q = em.createQuery(select);
        List<PeminjamanBuku> results = q.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTablepinjambuku.getModel();
        model.setRowCount(0);

        for (PeminjamanBuku data : results) {
            Object[] baris = new Object[10];
            baris[0] = data.getNoPeminjaman();

            if (data.getIdBuku() != null) {
                baris[1] = data.getIdBuku().getIdBuku();
            } else {
                baris[1] = ""; //atau nilai default yg sesuai jika data.getidbuku null
            }

            baris[2] = data.getJudulBuku();
            baris[3] = data.getStatusPeminjaman();
            baris[4] = date(data.getTglPeminjamanBuku());
            baris[5] = date(data.getTglKembaliBuku());
            baris[6] = data.getNamaPeminjam();
            baris[7] = data.getNim();
            baris[8] = data.getProgramStudi();
            baris[9] = data.getAngkatan();

            model.addRow(baris);
        }
        em.getTransaction().commit();
        emf.close();
    }

    private void tampilpinjamskripsi() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PeminjamanSkripsi> cq = cb.createQuery(PeminjamanSkripsi.class);

        Root<PeminjamanSkripsi> pin = cq.from(PeminjamanSkripsi.class);
        cq.orderBy(cb.asc(pin.get("noPeminjamanSkripsi")));
        CriteriaQuery<PeminjamanSkripsi> select = cq.select(pin);
        TypedQuery<PeminjamanSkripsi> q = em.createQuery(select);
//        TypedQuery<PeminjamanSkripsi> querySelectAll = entityManager.createNamedQuery("PeminjamanSkripsi.findAll", PeminjamanSkripsi.class);
        List<PeminjamanSkripsi> results = q.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTable2pinjamskripsi.getModel();
        model.setRowCount(0);
        for (PeminjamanSkripsi data : results) {
            Object[] baris = new Object[10];
            baris[0] = data.getNoPeminjamanSkripsi();

            if (data.getIdSkripsi() != null) {
                baris[1] = data.getIdSkripsi().getIdSkripsi();
            } else {
                baris[1] = ""; //atau nilai default yg sesuai jika data.getidbuku null
            }

            baris[2] = data.getJudulSkripsi();
            baris[3] = data.getStatusPeminjaman();
            baris[4] = date(data.getTglPeminjamanSkripsi());
            baris[5] = date(data.getTglKembaliSkripsi());
            baris[6] = data.getNamaPeminjam();
            baris[7] = data.getNim();
            baris[8] = data.getProgramStudi();
            baris[9] = data.getAngkatan();
            model.addRow(baris);
        }
        em.getTransaction().commit();
        emf.close();
    }

    /**
     * Creates new form Gui_laporan_peminjaman
     */
    public Gui_laporan_peminjaman() {
        initComponents();
        tampilpinjambuku();
        tampilpinjamskripsi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldSbuku = new javax.swing.JTextField();
        jComboBoxbuku = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablepinjambuku = new javax.swing.JTable();
        jButtoncetakbuku = new javax.swing.JButton();
        jButtonhapusbuku = new javax.swing.JButton();
        jButtonkembali1 = new javax.swing.JButton();
        jButtonKembali = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1caritanggalbuku = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton1refresh = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButtonlaporanbuku1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2pinjamskripsi = new javax.swing.JTable();
        jTextfieldcariskripsi = new javax.swing.JTextField();
        jComboBoxcariskripsi = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jButtoncetakskripsi = new javax.swing.JButton();
        jButtonhapusskripsi1 = new javax.swing.JButton();
        jButtonkembali = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButtoncaritanggalskripsi = new javax.swing.JButton();
        jButton1refresh1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButtonlaporanskripsi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(186, 242, 186));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldSbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSbukuActionPerformed(evt);
            }
        });
        jTextFieldSbuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSbukuKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldSbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 180, 30));

        jComboBoxbuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no_peminjaman", "judul", "status_pinjam", "nama", "nim", "prodi", "angkatan", " " }));
        jPanel1.add(jComboBoxbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 130, 30));

        jTablepinjambuku.setBackground(new java.awt.Color(179, 195, 179));
        jTablepinjambuku.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTablepinjambuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No peminjaman", "Id buku", "Judul buku", "Status peminjaman", "Tgl_pinjam", "Tgl_kembali", "Nama peminjam", "Nim", "Prodi", "Angkatan"
            }
        ));
        jTablepinjambuku.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTablepinjambuku.setGridColor(new java.awt.Color(204, 204, 204));
        jTablepinjambuku.setSelectionBackground(new java.awt.Color(0, 102, 51));
        jTablepinjambuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablepinjambukuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablepinjambuku);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1090, 440));

        jButtoncetakbuku.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButtoncetakbuku.setText("Cetak Laporan");
        jButtoncetakbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncetakbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButtoncetakbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 120, 36));

        jButtonhapusbuku.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButtonhapusbuku.setText("Hapus");
        jButtonhapusbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonhapusbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 87, 36));

        jButtonkembali1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonkembali1.setText("Kembali");
        jButtonkembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonkembali1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonkembali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 90, -1));

        jButtonKembali.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButtonKembali.setText("Kembali");
        jButtonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 87, 36));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 140, -1));

        jButton1caritanggalbuku.setText("Cari");
        jButton1caritanggalbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1caritanggalbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1caritanggalbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Cari");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 30, 30));

        jButton1refresh.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButton1refresh.setText("Refresh");
        jButton1refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1refreshActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 87, 36));

        jButton1.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButton1.setText("Cetak Laporan Per Bulan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, -1, 36));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("s/d");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 30, 20));
        jPanel1.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 140, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("tanggal pinjam");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 20));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Cari berdasarkan");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 20));

        jButtonlaporanbuku1.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButtonlaporanbuku1.setText("Cetak Laporan peminjaman buku terbanyak");
        jButtonlaporanbuku1.setBorder(null);
        jButtonlaporanbuku1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonlaporanbuku1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonlaporanbuku1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 260, 36));

        jTabbedPane1.addTab("Laporan Peminjaman Buku", jPanel1);

        jPanel2.setBackground(new java.awt.Color(186, 242, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2pinjamskripsi.setBackground(new java.awt.Color(179, 195, 179));
        jTable2pinjamskripsi.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTable2pinjamskripsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No peminjaman", "Id skripsi", "Judul skripsi", "Status peminjaman", "Tgl_pinjam", "Tgl_kembali", "Nama peminjam", "Nim", "Prodi", "Angkatan"
            }
        ));
        jTable2pinjamskripsi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2pinjamskripsi.setGridColor(new java.awt.Color(204, 204, 204));
        jTable2pinjamskripsi.setSelectionBackground(new java.awt.Color(0, 102, 51));
        jTable2pinjamskripsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2pinjamskripsiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2pinjamskripsi);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 63, 1098, -1));

        jTextfieldcariskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextfieldcariskripsiActionPerformed(evt);
            }
        });
        jTextfieldcariskripsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextfieldcariskripsiKeyReleased(evt);
            }
        });
        jPanel2.add(jTextfieldcariskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 21, 210, 30));

        jComboBoxcariskripsi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no_peminjaman", "judul", "status_pinjam", "nama", "nim", "prodi", "angkatan" }));
        jPanel2.add(jComboBoxcariskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 21, 130, 30));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("s/d");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 30, 20));

        jButtoncetakskripsi.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButtoncetakskripsi.setText("Cetak Laporan");
        jButtoncetakskripsi.setBorder(null);
        jButtoncetakskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncetakskripsiActionPerformed(evt);
            }
        });
        jPanel2.add(jButtoncetakskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 510, 110, 36));

        jButtonhapusskripsi1.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButtonhapusskripsi1.setText("Hapus");
        jButtonhapusskripsi1.setBorder(null);
        jButtonhapusskripsi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusskripsi1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonhapusskripsi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 87, 36));

        jButtonkembali.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButtonkembali.setText("Kembali");
        jButtonkembali.setBorder(null);
        jButtonkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonkembaliActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 90, 36));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("tanggal pinjam");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 20));
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 140, -1));

        jButtoncaritanggalskripsi.setText("Cari");
        jButtoncaritanggalskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncaritanggalskripsiActionPerformed(evt);
            }
        });
        jPanel2.add(jButtoncaritanggalskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jButton1refresh1.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButton1refresh1.setText("Refresh");
        jButton1refresh1.setBorder(null);
        jButton1refresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1refresh1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1refresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 90, 36));

        jButton2.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButton2.setText("Cetak Laporan Per Bulan");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 150, 36));
        jPanel2.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 140, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Cari");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 21, 30, 30));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Cari berdasarkan");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 20));

        jButtonlaporanskripsi.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButtonlaporanskripsi.setText("Cetak Laporan peminjaman skripsi terbanyak");
        jButtonlaporanskripsi.setBorder(null);
        jButtonlaporanskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonlaporanskripsiActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonlaporanskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 260, 36));

        jTabbedPane1.addTab("Laporan Peminjaman Skripsi", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1110, 590));

        jPanel3.setBackground(new java.awt.Color(186, 211, 186));

        jPanel4.setBackground(new java.awt.Color(158, 188, 158));

        jLabel2.setFont(new java.awt.Font("MV Boli", 1, 32)); // NOI18N
        jLabel2.setText("BoSi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Constantia", 1, 36)); // NOI18N
        jLabel3.setText("Laporan Peminjaman");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15))))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablepinjambukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablepinjambukuMouseClicked
        // TODO add your handling code here:
        int baris = jTablepinjambuku.rowAtPoint(evt.getPoint());

        String no_peminjaman = jTablepinjambuku.getValueAt(baris, 0).toString();
        jTextFieldSbuku.setText(no_peminjaman);
    }//GEN-LAST:event_jTablepinjambukuMouseClicked

    private void jTextFieldSbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSbukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSbukuActionPerformed

    private void jTextFieldSbukuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSbukuKeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBoxbuku.getSelectedItem();
            String searchTerm = jTextFieldSbuku.getText().trim();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT p FROM PeminjamanBuku p WHERE ";

            switch (selection) {
                case "no_peminjaman":
                    queryString += "LOWER(p.noPeminjaman) LIKE LOWER (:searchTerm) ";
                    break;
                case "judul":
                    queryString += "LOWER(p.judulBuku) LIKE LOWER (:searchTerm) ";
                    break;
                case "status_pinjam":
                    queryString += "LOWER(p.statusPeminjaman) LIKE LOWER (:searchTerm)";
                    break;
                case "nama":
                    queryString += "LOWER(p.namaPeminjam) LIKE LOWER (:searchTerm)";
                    break;
                case "nim":
                    queryString += "LOWER(p.nim) LIKE LOWER (:searchTerm)";
                    break;
                case "prodi":
                    queryString += "LOWER(p.programStudi) LIKE LOWER (:searchTerm)";
                    break;
                case "angkatan":
                    queryString += "LOWER(p.angkatan) LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }
            queryString += "ORDER BY p.noPeminjaman ASC";
            TypedQuery<PeminjamanBuku> query = em.createQuery(queryString, PeminjamanBuku.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<PeminjamanBuku> results = query.getResultList();

            DefaultTableModel dataModel = new DefaultTableModel();
            // Add columns to the model
            dataModel.addColumn("no peminjaman");
            dataModel.addColumn("id buku");
            dataModel.addColumn("judul");
            dataModel.addColumn("status peminjaman");
            dataModel.addColumn("tgl_pinjam");
            dataModel.addColumn("tgl_kembali");
            dataModel.addColumn("nama");
            dataModel.addColumn("nim");
            dataModel.addColumn("prodi");
            dataModel.addColumn("angkatan");
            // ... tambahkan kolom lain sesuai kebutuhan

            for (PeminjamanBuku data : results) {
                Object[] baris = new Object[10];
                baris[0] = data.getNoPeminjaman();

                if (data.getIdBuku() != null) {
                    baris[1] = data.getIdBuku().getIdBuku();
                } else {
                    baris[1] = ""; //atau nilai default yg sesuai jika data.getidbuku null
                }

                baris[2] = data.getJudulBuku();
                baris[3] = data.getStatusPeminjaman();
                baris[4] = date(data.getTglPeminjamanBuku());
                baris[5] = date(data.getTglKembaliBuku());
                baris[6] = data.getNamaPeminjam();
                baris[7] = data.getNim();
                baris[8] = data.getProgramStudi();
                baris[9] = data.getAngkatan();

                dataModel.addRow(baris);
            }

            // Set jTable1 with the created model
            jTablepinjambuku.setModel(dataModel);
            System.out.println(results);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldSbukuKeyReleased

    private void jButtoncetakbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncetakbukuActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/Laporan/report3Pinjambuku.jrxml";
            String selection = ((String) jComboBoxbuku.getSelectedItem()).toLowerCase();
            String searchTerm = jTextFieldSbuku.getText().trim();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT p FROM PeminjamanBuku p WHERE ";

            switch (selection) {
                case "no_peminjaman":
                    queryString += "LOWER(p.noPeminjaman) LIKE LOWER (:searchTerm) ";
                    break;
                case "judul":
                    queryString += "LOWER(p.judulBuku) LIKE LOWER (:searchTerm) ";
                    break;
                case "status_pinjam":
                    queryString += "LOWER(p.statusPeminjaman) LIKE LOWER (:searchTerm)";
                    break;
                case "nama":
                    queryString += "LOWER(p.namaPeminjam) LIKE LOWER (:searchTerm)";
                    break;
                case "nim":
                    queryString += "LOWER(p.nim) LIKE LOWER (:searchTerm)";
                    break;
                case "prodi":
                    queryString += "LOWER(p.programStudi) LIKE LOWER (:searchTerm)";
                    break;
                case "angkatan":
                    queryString += "LOWER(p.angkatan) LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PeminjamanBuku> cq = cb.createQuery(PeminjamanBuku.class);
            Root<PeminjamanBuku> bok = cq.from(PeminjamanBuku.class);
            cq.select(bok);

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<PeminjamanBuku> q = em.createQuery(cq);
            List<PeminjamanBuku> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<PeminjamanBuku> results = query.getResultList();
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("querySearch", searchTerm);
            parameter.put("searchBy", selection);

            // Menyiapkan data untuk laporan
            List<Object[]> data = new ArrayList<>();
            for (PeminjamanBuku result : results) {
                Object[] rowData = {
                    result.getNoPeminjaman(),
                    result.getIdBuku(),
                    result.getJudulBuku(),
                    result.getStatusPeminjaman(),
                    date(result.getTglPeminjamanBuku()),
                    date(result.getTglKembaliBuku()),
                    result.getNamaPeminjam(),
                    result.getNim(),
                    result.getProgramStudi(),
                    result.getAngkatan(),};
                data.add(rowData);
            }
            em.getTransaction().commit();
            em.close();
            emf.close();

            // Membuat sumber data untuk JasperReports dari data hasil pencarian
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);

            // Memuat file desain laporan (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(Gui_laporan_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtoncetakbukuActionPerformed

    private void jButtonhapusbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapusbukuActionPerformed
        // TODO add your handling code here:
        String no_pinjam = jTextFieldSbuku.getText().trim();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PeminjamanBuku b = em.find(PeminjamanBuku.class, no_pinjam);

        em.remove(b);
        em.getTransaction().commit();
        // akhir persistence

        jTextFieldSbuku.setText("");

        DefaultTableModel model = (DefaultTableModel) jTablepinjambuku.getModel();
        model.setRowCount(0);
        tampilpinjambuku();

        if (!no_pinjam.isEmpty()) {
            if (!no_pinjam.isEmpty()) {
                this.peringatan("Hapus data Berhasil");
            } else {
                this.peringatan("Hapus data Gagal");
            }
        } else {
            this.peringatan("Wajib input id buku");
        }
    }//GEN-LAST:event_jButtonhapusbukuActionPerformed

    private void jTable2pinjamskripsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2pinjamskripsiMouseClicked
        // TODO add your handling code here:
        int baris = jTable2pinjamskripsi.rowAtPoint(evt.getPoint());

        String no_peminjaman = jTable2pinjamskripsi.getValueAt(baris, 0).toString();
        jTextfieldcariskripsi.setText(no_peminjaman);
    }//GEN-LAST:event_jTable2pinjamskripsiMouseClicked

    private void jTextfieldcariskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextfieldcariskripsiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextfieldcariskripsiActionPerformed

    private void jTextfieldcariskripsiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextfieldcariskripsiKeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBoxcariskripsi.getSelectedItem();
            String searchTerm = jTextfieldcariskripsi.getText().trim();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT p FROM PeminjamanSkripsi p WHERE ";

            switch (selection) {
                case "no_peminjaman":
                    queryString += "LOWER(p.noPeminjamanSkripsi) LIKE LOWER (:searchTerm) ";
                    break;
                case "judul":
                    queryString += "LOWER(p.judulSkripsi) LIKE LOWER (:searchTerm) ";
                    break;
                case "status_pinjam":
                    queryString += "LOWER(p.statusPeminjaman) LIKE LOWER (:searchTerm)";
                    break;
                case "nama":
                    queryString += "LOWER(p.namaPeminjam) LIKE LOWER (:searchTerm)";
                    break;
                case "nim":
                    queryString += "LOWER(p.nim) LIKE LOWER (:searchTerm)";
                    break;
                case "prodi":
                    queryString += "LOWER(p.programStudi) LIKE LOWER (:searchTerm)";
                    break;
                case "angkatan":
                    queryString += "LOWER(p.angkatan) LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }
            queryString += "ORDER BY p.noPeminjamanSkripsi ASC";
            TypedQuery<PeminjamanSkripsi> query = em.createQuery(queryString, PeminjamanSkripsi.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<PeminjamanSkripsi> results = query.getResultList();

            DefaultTableModel dataModel = new DefaultTableModel();
            // Add columns to the model
            dataModel.addColumn("no peminjaman");
            dataModel.addColumn("id_skripsi");
            dataModel.addColumn("judul skripsi");
            dataModel.addColumn("status peminjaman");
            dataModel.addColumn("tgl_pinjam");
            dataModel.addColumn("tgl_kembali");
            dataModel.addColumn("nama");
            dataModel.addColumn("nim");
            dataModel.addColumn("prodi");
            dataModel.addColumn("angkatan");
            // ... tambahkan kolom lain sesuai kebutuhan

            for (PeminjamanSkripsi data : results) {
                Object[] baris = new Object[10];
                baris[0] = data.getNoPeminjamanSkripsi();

                if (data.getIdSkripsi() != null) {
                    baris[1] = data.getIdSkripsi().getIdSkripsi();
                } else {
                    baris[1] = ""; //atau nilai default yg sesuai jika data.getidbuku null
                }

                baris[2] = data.getJudulSkripsi();
                baris[3] = data.getStatusPeminjaman();
                baris[4] = date(data.getTglPeminjamanSkripsi());
                baris[5] = date(data.getTglKembaliSkripsi());
                baris[6] = data.getNamaPeminjam();
                baris[7] = data.getNim();
                baris[8] = data.getProgramStudi();
                baris[9] = data.getAngkatan();

                dataModel.addRow(baris);
            }

            // Set jTable1 with the created model
            jTable2pinjamskripsi.setModel(dataModel);
            System.out.println(results);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextfieldcariskripsiKeyReleased

    private void jButtoncetakskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncetakskripsiActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/Laporan/report3Pinjamskripsi.jrxml";
            String selection = ((String) jComboBoxcariskripsi.getSelectedItem()).toLowerCase();
            String searchTerm = jTextfieldcariskripsi.getText().trim();
            Date tanggalMulai = jDateChooser2.getDate();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT p FROM PeminjamanSkripsi p WHERE ";

            switch (selection) {
                case "no_peminjaman":
                    queryString += "LOWER(p.noPeminjamanSkripsi) LIKE LOWER (:searchTerm) ";
                    break;
                case "judul":
                    queryString += "LOWER(p.judulSkripsi) LIKE LOWER (:searchTerm) ";
                    break;
                case "status_pinjam":
                    queryString += "LOWER(p.statusPeminjaman) LIKE LOWER (:searchTerm) ";
                    break;
                case "nama":
                    queryString += "LOWER(p.namaPeminjam) LIKE LOWER (:searchTerm)";
                    break;
                case "nim":
                    queryString += "LOWER(p.nim) LIKE LOWER (:searchTerm)";
                    break;
                case "prodi":
                    queryString += "LOWER(p.programStudi) LIKE LOWER (:searchTerm)";
                    break;
                case "angkatan":
                    queryString += "LOWER(p.angkatan) LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PeminjamanSkripsi> cq = cb.createQuery(PeminjamanSkripsi.class);
            Root<PeminjamanSkripsi> bok = cq.from(PeminjamanSkripsi.class);
            cq.select(bok);

            TypedQuery<PeminjamanSkripsi> q = em.createQuery(cq);
            List<PeminjamanSkripsi> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<PeminjamanSkripsi> results = query.getResultList();
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("querySearch", searchTerm);
            parameter.put("searchBy", selection);

            // Menyiapkan data untuk laporan
            List<Object[]> data = new ArrayList<>();
            for (PeminjamanSkripsi result : results) {
                Object[] rowData = {
                    result.getNoPeminjamanSkripsi(),
                    result.getIdSkripsi(),
                    result.getJudulSkripsi(),
                    result.getStatusPeminjaman(),
                    date(result.getTglPeminjamanSkripsi()),
                    date(result.getTglKembaliSkripsi()),
                    result.getNamaPeminjam(),
                    result.getNim(),
                    result.getProgramStudi(),
                    result.getAngkatan(),};
                data.add(rowData);
            }
            em.getTransaction().commit();
            em.close();
            emf.close();

            // Membuat sumber data untuk JasperReports dari data hasil pencarian
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);

            // Memuat file desain laporan (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            java.util.logging.Logger.getLogger(Gui_laporan_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtoncetakskripsiActionPerformed

    private void jButtonhapusskripsi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapusskripsi1ActionPerformed
        // TODO add your handling code here:
        String no_pinjamSkripsi = jTextfieldcariskripsi.getText().trim();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PeminjamanSkripsi b = em.find(PeminjamanSkripsi.class, no_pinjamSkripsi);

        em.remove(b);
        em.getTransaction().commit();
        // akhir persistence

        jTextfieldcariskripsi.setText("");

        DefaultTableModel model = (DefaultTableModel) jTable2pinjamskripsi.getModel();
        model.setRowCount(0);
        tampilpinjamskripsi();

        if (!no_pinjamSkripsi.isEmpty()) {
            if (!no_pinjamSkripsi.isEmpty()) {
                this.peringatan("Hapus data Berhasil");
            } else {
                this.peringatan("Hapus data Gagal");
            }
        } else {
            this.peringatan("Wajib input id skripsi");
        }
    }//GEN-LAST:event_jButtonhapusskripsi1ActionPerformed

    private void jButtonkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonkembaliActionPerformed
        // TODO add your handling code here:
        Gui_Menu1 menu = new Gui_Menu1();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonkembaliActionPerformed

    private void jButtonkembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonkembali1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonkembali1ActionPerformed

    private void jButtonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKembaliActionPerformed
        // TODO add your handling code here:
        Gui_Menu1 menu = new Gui_Menu1();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonKembaliActionPerformed

    private void jButton1caritanggalbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1caritanggalbukuActionPerformed
        // TODO add your handling code here:
        Date tanggalMulai = jDateChooser1.getDate();
        Date tanggalAkhir = jDateChooser4.getDate();

        if (tanggalMulai == null) {
            JOptionPane.showMessageDialog(this, "Tanggal mulai harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit the method if the date is not selected
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();

        String queryString = "SELECT p FROM PeminjamanBuku p WHERE p.tglPeminjamanBuku BETWEEN :startdate AND :enddate";

        TypedQuery<PeminjamanBuku> query = em.createQuery(queryString, PeminjamanBuku.class);
        query.setParameter("startdate", tanggalMulai);
        query.setParameter("enddate", tanggalAkhir);

        List<PeminjamanBuku> results = query.getResultList();

        DefaultTableModel dataModel = new DefaultTableModel();
        // Add columns to the model
        dataModel.addColumn("No peminjaman");
        dataModel.addColumn("Id buku");
        dataModel.addColumn("Judul");
        dataModel.addColumn("Status peminjaman");
        dataModel.addColumn("Tgl_pinjam");
        dataModel.addColumn("Tgl_kembali");
        dataModel.addColumn("Nama");
        dataModel.addColumn("Nim");
        dataModel.addColumn("Prodi");
        dataModel.addColumn("Angkatan");
        // ... tambahkan kolom lain sesuai kebutuhan

        for (PeminjamanBuku data : results) {
            Object[] baris = new Object[10];
            baris[0] = data.getNoPeminjaman();

            if (data.getIdBuku() != null) {
                baris[1] = data.getIdBuku().getIdBuku();
            } else {
                baris[1] = ""; //atau nilai default yg sesuai jika data.getidbuku null
            }

            baris[2] = data.getJudulBuku();
            baris[3] = data.getStatusPeminjaman();
            baris[4] = date(data.getTglPeminjamanBuku());
            baris[5] = date(data.getTglKembaliBuku());
            baris[6] = data.getNamaPeminjam();
            baris[7] = data.getNim();
            baris[8] = data.getProgramStudi();
            baris[9] = data.getAngkatan();

            dataModel.addRow(baris);
        }

        // Set jTable1 with the created model
        jTablepinjambuku.setModel(dataModel);
        System.out.println(results);
    }//GEN-LAST:event_jButton1caritanggalbukuActionPerformed

    private void jButtoncaritanggalskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncaritanggalskripsiActionPerformed
        // TODO add your handling code here:
        Date tanggalMulai = jDateChooser2.getDate();
        Date tanggalAkhir = jDateChooser3.getDate();

        if (tanggalMulai == null) {
            JOptionPane.showMessageDialog(this, "Tanggal mulai harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit the method if the date is not selected
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();

        String queryString = "SELECT p FROM PeminjamanSkripsi p WHERE p.tglPeminjamanSkripsi <= :startdate";

        TypedQuery<PeminjamanSkripsi> query = em.createQuery(queryString, PeminjamanSkripsi.class);
        query.setParameter("startdate", tanggalMulai);

        List<PeminjamanSkripsi> results = query.getResultList();

        DefaultTableModel dataModel = new DefaultTableModel();
        // Add columns to the model
        dataModel.addColumn("No peminjaman");
        dataModel.addColumn("Id_skripsi");
        dataModel.addColumn("Judul skripsi");
        dataModel.addColumn("Status peminjaman");
        dataModel.addColumn("Tgl_pinjam");
        dataModel.addColumn("Tgl_kembali");
        dataModel.addColumn("Nama");
        dataModel.addColumn("Nim");
        dataModel.addColumn("Prodi");
        dataModel.addColumn("Angkatan");
        // ... tambahkan kolom lain sesuai kebutuhan

        for (PeminjamanSkripsi data : results) {
            Object[] baris = new Object[10];
            baris[0] = data.getNoPeminjamanSkripsi();

            if (data.getIdSkripsi() != null) {
                baris[1] = data.getIdSkripsi().getIdSkripsi();
            } else {
                baris[1] = ""; //atau nilai default yg sesuai jika data.getidbuku null
            }

            baris[2] = data.getJudulSkripsi();
            baris[3] = data.getStatusPeminjaman();
            baris[4] = date(data.getTglPeminjamanSkripsi());
            baris[5] = date(data.getTglKembaliSkripsi());
            baris[6] = data.getNamaPeminjam();
            baris[7] = data.getNim();
            baris[8] = data.getProgramStudi();
            baris[9] = data.getAngkatan();

            dataModel.addRow(baris);
        }

        // Set jTable1 with the created model
        jTable2pinjamskripsi.setModel(dataModel);
        System.out.println(results);
    }//GEN-LAST:event_jButtoncaritanggalskripsiActionPerformed

    private void jButton1refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1refreshActionPerformed
        // TODO add your handling code here:
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        jDateChooser4.setDate(null);
        jTextFieldSbuku.setText("");
        DefaultTableModel model = (DefaultTableModel) jTablepinjambuku.getModel();
        model.setRowCount(0);
        tampilpinjambuku();
    }//GEN-LAST:event_jButton1refreshActionPerformed

    private void jButton1refresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1refresh1ActionPerformed
        // TODO add your handling code here:
        jDateChooser2.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        jDateChooser4.setDate(null);
        jTextfieldcariskripsi.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable2pinjamskripsi.getModel();
        model.setRowCount(0);
        tampilpinjamskripsi();
    }//GEN-LAST:event_jButton1refresh1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        Date tanggalMulai = jDateChooser1.getDate();
//        Date tanggalAkhir = jDateChooser4.getDate();
//
//        // Validate if the date is selected
//        if (tanggalMulai == null) {
//            JOptionPane.showMessageDialog(this, "Tanggal mulai harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;  // Exit the method if the date is not selected
//        }
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            // Format the selected date for display
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String formattedDate = dateFormat.format(tanggalMulai);
//
//           
//            // Use a parameterized query to avoid SQL injection
//            String queryString = "SELECT p FROM PeminjamanBuku p WHERE p.tglPeminjamanBuku BETWEEN :startdate AND :enddate";
//
//            TypedQuery<PeminjamanBuku> query = em.createQuery(queryString, PeminjamanBuku.class);
//            query.setParameter("startdate", tanggalMulai);
//            query.setParameter("enddate", tanggalAkhir);
//
//            List<PeminjamanBuku> results = query.getResultList();
//
//            // Create a JasperReport parameter map
//            Map<String, Object> parameters = new HashMap<>();           
//            parameters.put("startDate", tanggalMulai);
//            parameters.put("enddate", tanggalAkhir);
//            
//
//            // Prepare data for JasperReports
//            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);
//
//            // Load the JasperReport template (replace with your report path)
//            String reportPath = "src/Laporan/report3Pinjambuku.jrxml";
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
//
//            // Fill the report with data
//            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//
//            // Create a JasperViewer to display the report
//            JasperViewer viewer = new JasperViewer(print, false);
//            viewer.setVisible(true);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }

        Untuk_Buku_perbulan lan = new Untuk_Buku_perbulan();
        lan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        Date tanggalMulai = jDateChooser2.getDate();
//        Date tanggalAkhir = jDateChooser3.getDate();
//
//        // Validate if the date is selected
//        if (tanggalMulai == null) {
//            JOptionPane.showMessageDialog(this, "Tanggal mulai harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;  // Exit the method if the date is not selected
//        }
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            // Format the selected date for display
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String formattedDate = dateFormat.format(tanggalMulai);
//
//            // Use a parameterized query to avoid SQL injection
//            String queryString = "SELECT p FROM PeminjamanSkripsi p WHERE p.tglPeminjamanSkripsi <= :startdate";
//
//            TypedQuery<PeminjamanBuku> query = em.createQuery(queryString, PeminjamanBuku.class);
//            query.setParameter("startdate", tanggalMulai);
//
//            List<PeminjamanBuku> results = query.getResultList();
//
//            // Create a JasperReport parameter map
//            Map<String, Object> parameters = new HashMap<>();
//            parameters.put("startDate", tanggalMulai);
//
//            // Prepare data for JasperReports
//            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);
//
//            // Load the JasperReport template (replace with your report path)
//            String reportPath = "src/Laporan/report3Pinjamskripsi.jrxml";
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
//
//            // Fill the report with data
//            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//
//            // Create a JasperViewer to display the report
//            JasperViewer viewer = new JasperViewer(print, false);
//            viewer.setVisible(true);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            em.close();
//            emf.close();
//        }

        Untuk_skripsi_perbulan lan = new Untuk_skripsi_perbulan();
        lan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonlaporanskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonlaporanskripsiActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/Laporan/reportpinjamSkripsiterbanyak.jrxml";
            String selection = ((String) jComboBoxcariskripsi.getSelectedItem()).toLowerCase();
            String searchTerm = jTextfieldcariskripsi.getText().trim();
           
            String queryString = "SELECT p FROM PeminjamanSkripsi p WHERE ";

            switch (jComboBoxcariskripsi.getSelectedIndex()) {
                case 0:
                    queryString += "LOWER(p.noPeminjamanSkripsi) LIKE LOWER (:searchTerm) ";
                    break;
                case 1:
                    queryString += "LOWER(p.judulSkripsi) LIKE LOWER (:searchTerm) ";
                    break;
                case 2:
                    queryString += "LOWER(p.statusPeminjaman) LIKE LOWER (:searchTerm) ";
                    break;
                case 3:
                    queryString += "LOWER(p.namaPeminjam) LIKE LOWER (:searchTerm)";
                    break;
                case 4:
                    queryString += "LOWER(p.nim) LIKE LOWER (:searchTerm)";
                    break;
                case 5:
                    queryString += "LOWER(p.programStudi) LIKE LOWER (:searchTerm)";
                    break;
                case 6:
                    queryString += "LOWER(p.angkatan) LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected. Selected Criteria: " + selection);
            }
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PeminjamanSkripsi> cq = cb.createQuery(PeminjamanSkripsi.class);
            Root<PeminjamanSkripsi> bok = cq.from(PeminjamanSkripsi.class);
            cq.select(bok);
            
            TypedQuery<PeminjamanSkripsi> q = em.createQuery(cq);
            List<PeminjamanSkripsi> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");
            
            List<PeminjamanSkripsi> results = query.getResultList();

            if (results.isEmpty()) {
                System.out.println("No results found for the given criteria.");
                return;
            }

            // Menghitung ISBN yang paling banyak dipinjam
            Map<String, Integer> idCountMap = new HashMap<>();
            String mostFrequentId = "";
            int maxCount = 0;

            for (PeminjamanSkripsi peminjaman : results) {
                String isbn = peminjaman.getIdSkripsi().getIdSkripsi();
                int count = idCountMap.getOrDefault(isbn, 0) + 1;
                idCountMap.put(isbn, count);
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentId = isbn;
                }
            }

           
// Fill the report with data
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("mostFrequentId", mostFrequentId);
            parameter.put("maxCount", maxCount);
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);
            parameter.put("peminjamanDataSource", dataSource);
            
            em.getTransaction().commit();
            em.close();
            emf.close();


            // Memuat file desain laporan (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonlaporanskripsiActionPerformed

    private void jButtonlaporanbuku1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonlaporanbuku1ActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/Laporan/reporpinjamBukuterbanyak.jrxml";
            String selection = ((String) jComboBoxbuku.getSelectedItem()).toLowerCase();
            String searchTerm = jTextFieldSbuku.getText().trim();
           
            String queryString = "SELECT p FROM PeminjamanBuku p WHERE ";

            switch (jComboBoxbuku.getSelectedIndex()) {
                case 0:
                    queryString += "LOWER(p.noPeminjaman) LIKE LOWER (:searchTerm) ";
                    break;
                case 1:
                    queryString += "LOWER(p.judulBuku) LIKE LOWER (:searchTerm) ";
                    break;
                case 2:
                    queryString += "LOWER(p.statusPeminjaman) LIKE LOWER (:searchTerm)";
                    break;
                case 3:
                    queryString += "LOWER(p.namaPeminjam) LIKE LOWER (:searchTerm)";
                    break;
                case 4:
                    queryString += "LOWER(p.nim) LIKE LOWER (:searchTerm)";
                    break;
                case 5:
                    queryString += "LOWER(p.programStudi) LIKE LOWER (:searchTerm)";
                    break;
                case 6:
                    queryString += "LOWER(p.angkatan) LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected. Selected Criteria: " + selection);
            }
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<PeminjamanBuku> cq = cb.createQuery(PeminjamanBuku.class);
            Root<PeminjamanBuku> bok = cq.from(PeminjamanBuku.class);
            cq.select(bok);
            
            TypedQuery<PeminjamanBuku> q = em.createQuery(cq);
            List<PeminjamanBuku> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");
            
            List<PeminjamanBuku> results = query.getResultList();

            if (results.isEmpty()) {
                System.out.println("No results found for the given criteria.");
                return;
            }

            // Menghitung ISBN yang paling banyak dipinjam
            Map<String, Integer> idCountMap = new HashMap<>();
            String mostFrequentId = "";
            int maxCount = 0;

            for (PeminjamanBuku peminjaman : results) {
                String isbn = peminjaman.getIdBuku().getIdBuku();
                int count = idCountMap.getOrDefault(isbn, 0) + 1;
                idCountMap.put(isbn, count);
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequentId = isbn;
                }
            }

           
// Fill the report with data
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("mostFrequentId", mostFrequentId);
            parameter.put("maxCount", maxCount);
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);
            parameter.put("peminjamanDataSource", dataSource);
            
            em.getTransaction().commit();
            em.close();
            emf.close();


            // Memuat file desain laporan (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, dataSource);

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButtonlaporanbuku1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui_laporan_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_laporan_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_laporan_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_laporan_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_laporan_peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1caritanggalbuku;
    private javax.swing.JButton jButton1refresh;
    private javax.swing.JButton jButton1refresh1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonKembali;
    private javax.swing.JButton jButtoncaritanggalskripsi;
    private javax.swing.JButton jButtoncetakbuku;
    private javax.swing.JButton jButtoncetakskripsi;
    private javax.swing.JButton jButtonhapusbuku;
    private javax.swing.JButton jButtonhapusskripsi1;
    private javax.swing.JButton jButtonkembali;
    private javax.swing.JButton jButtonkembali1;
    private javax.swing.JButton jButtonlaporanbuku1;
    private javax.swing.JButton jButtonlaporanskripsi;
    private javax.swing.JComboBox<String> jComboBoxbuku;
    private javax.swing.JComboBox<String> jComboBoxcariskripsi;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2pinjamskripsi;
    private javax.swing.JTable jTablepinjambuku;
    private javax.swing.JTextField jTextFieldSbuku;
    private javax.swing.JTextField jTextfieldcariskripsi;
    // End of variables declaration//GEN-END:variables
}
