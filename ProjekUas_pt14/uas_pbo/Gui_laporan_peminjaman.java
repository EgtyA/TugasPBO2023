/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import ClassPersistane.DataBuku;
import ClassPersistane.PeminjamanBuku;
import ClassPersistane.PeminjamanSkripsi;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import static uas_pbo.Gui_peminjaman_skripsi.date;


/**
 *
 * @author egty
 */
public class Gui_laporan_peminjaman extends javax.swing.JFrame {
    
    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    
    //untuk tanggal peminjaman dan pengembalian yg ditampilkan di tabel
    public static String date(Date date){
         SimpleDateFormat format = new SimpleDateFormat("dd-MMMM-yyyy");
         return format.format(date);
    }
    
    private void tampilpinjambuku() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PBOPU").createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<PeminjamanBuku> querySelectAll = entityManager.createNamedQuery("PeminjamanBuku.findAll", PeminjamanBuku.class);
        List<PeminjamanBuku> results = querySelectAll.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTablepinjambuku.getModel();
        model.setRowCount(0);
        
        for (PeminjamanBuku data : results) {
            Object[] baris = new Object[10];
            baris[0] = data.getNoPeminjaman();
            baris[1] = data.getJudulBuku();
            baris[2] = data.getStatusPeminjaman();
            baris[3] = date(data.getTglPeminjamanBuku());
            baris[4] = date(data.getTglKembaliBuku());
            baris[5] = data.getNamaPeminjam();
            baris[6] = data.getNim();
            baris[7] = data.getProgramStudi();
            baris[8] = data.getNoTlp();
            baris[9] = data.getAngkatan();
           
            model.addRow(baris);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    private void tampilpinjamskripsi() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PBOPU").createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<PeminjamanSkripsi> querySelectAll = entityManager.createNamedQuery("PeminjamanSkripsi.findAll", PeminjamanSkripsi.class);
        List<PeminjamanSkripsi> results = querySelectAll.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTable2pinjamskripsi.getModel();
        model.setRowCount(0);
        for (PeminjamanSkripsi data : results) {
            Object[] baris = new Object[10];
            baris[0] = data.getNoPeminjamanSkripsi();
            baris[1] = data.getJudulSkripsi();
            baris[2] = data.getStatusPeminjaman();
            baris[3] = date(data.getTglPeminjamanSkripsi());
            baris[4] = date(data.getTglKembaliSkripsi());
            baris[5] = data.getNamaPeminjam();
            baris[6] = data.getNim();
            baris[7] = data.getProgramStudi();
            baris[8] = data.getNoTlp();
            baris[9] = data.getAngkatan();
            model.addRow(baris);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
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
        jLabel13 = new javax.swing.JLabel();
        jButtoncetakbuku = new javax.swing.JButton();
        jButtonimporbuku = new javax.swing.JButton();
        jButtonhapusbuku = new javax.swing.JButton();
        jButtonkembali1 = new javax.swing.JButton();
        jButtonhapusbuku1 = new javax.swing.JButton();
        jButtonKembali = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1caritanggalbuku = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2pinjamskripsi = new javax.swing.JTable();
        jTextfieldcariskripsi = new javax.swing.JTextField();
        jComboBoxcariskripsi = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jButtoncetakskripsi = new javax.swing.JButton();
        jButtonimporskripsi = new javax.swing.JButton();
        jButtonhapusskripsi1 = new javax.swing.JButton();
        jButtonkembali = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButtoncaritanggalskripsi = new javax.swing.JButton();
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

        jComboBoxbuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no_peminjaman", "judul", "status_pinjam", "nama", "nim", "no_tlp", "angkatan" }));
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
                "No peminjaman", "Judul buku", "Status peminjaman", "Tgl_pinjam", "Tgl_kembali", "Nama peminjam", "Nim", "Prodi", "No tlp", "Angkatan"
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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1090, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Cari berdasarkan tanggal");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 20));

        jButtoncetakbuku.setText("Cetak");
        jButtoncetakbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncetakbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButtoncetakbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 87, 36));

        jButtonimporbuku.setText("Impor");
        jButtonimporbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonimporbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonimporbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, 87, 36));

        jButtonhapusbuku.setText("Hapus");
        jButtonhapusbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonhapusbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 87, 36));

        jButtonkembali1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonkembali1.setText("Kembali");
        jButtonkembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonkembali1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonkembali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 90, -1));

        jButtonhapusbuku1.setText("Hapus");
        jButtonhapusbuku1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusbuku1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonhapusbuku1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 510, 87, 36));

        jButtonKembali.setText("Kembali");
        jButtonKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 87, 36));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 140, -1));

        jButton1caritanggalbuku.setText("Cari");
        jButton1caritanggalbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1caritanggalbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1caritanggalbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Cari");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 30, 30));

        jTabbedPane1.addTab("Laporan Peminajam Buku", jPanel1);

        jPanel2.setBackground(new java.awt.Color(186, 242, 186));

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
                "No peminjaman", "Judul skripsi", "Status peminjaman", "Tgl_pinjam", "Tgl_kembali", "Nama peminjam", "Nim", "Prodi", "No tlp", "Angkatan"
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

        jComboBoxcariskripsi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no_peminjaman", "judul", "status_pinjam", "nama", "nim", "prodi", "no_tlp", "angkatan" }));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Cari");

        jButtoncetakskripsi.setText("Cetak");
        jButtoncetakskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncetakskripsiActionPerformed(evt);
            }
        });

        jButtonimporskripsi.setText("Impor");
        jButtonimporskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonimporskripsiActionPerformed(evt);
            }
        });

        jButtonhapusskripsi1.setText("Hapus");
        jButtonhapusskripsi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusskripsi1ActionPerformed(evt);
            }
        });

        jButtonkembali.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonkembali.setText("Kembali");
        jButtonkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonkembaliActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Cari berdasarkan tanggal");

        jButtoncaritanggalskripsi.setText("Cari");
        jButtoncaritanggalskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncaritanggalskripsiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtoncaritanggalskripsi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextfieldcariskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jComboBoxcariskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButtoncetakskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButtonimporskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButtonhapusskripsi1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonkembali, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextfieldcariskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxcariskripsi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtoncaritanggalskripsi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtoncetakskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButtonimporskripsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonhapusskripsi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

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
                case "tanggal_kembali":
                queryString += "p.tglKembaliBuku LIKE LOWER :searchTerm";
                break;
                case "nama":
                queryString += "LOWER(p.namaPeminjam) LIKE LOWER (:searchTerm)";
                break;
                case "nim":
                queryString += "LOWER(p.nim) LIKE LOWER (:searchTerm)";
                break;
                case "no_tlp":
                queryString += "LOWER(p.noTlp) LIKE LOWER (:searchTerm)";
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
            dataModel.addColumn("judul");
            dataModel.addColumn("status peminjaman");
            dataModel.addColumn("tgl_pinjam");
            dataModel.addColumn("tgl_kembali");
            dataModel.addColumn("nama");
            dataModel.addColumn("nim");
            dataModel.addColumn("prodi");
            dataModel.addColumn("no_tlp");
            dataModel.addColumn("angkatan");
            // ... tambahkan kolom lain sesuai kebutuhan

            for (PeminjamanBuku data : results) {
                Object[] baris = new Object[10];
                baris[0] = data.getNoPeminjaman();
                baris[1] = data.getJudulBuku();
                baris[2] = data.getStatusPeminjaman();
                baris[3] = date(data.getTglPeminjamanBuku());
                baris[4] = date(data.getTglKembaliBuku());
                baris[5] = data.getNamaPeminjam();
                baris[6] = data.getNim();
                baris[7] = data.getProgramStudi();
                baris[8] = data.getNoTlp();
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
            String reportPath = "src/Laporan/reportpinjambuku.jrxml";
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
                case "tanggal_pinjam":
                queryString += "p.tglPeminjamanBuku LIKE :searchTerm";
                break;
                case "tanggal_kembali":
                queryString += "p.tglKembaliBuku LIKE LOWER :searchTerm";
                break;
                case "nama":
                queryString += "LOWER(p.namaPeminjam) LIKE LOWER (:searchTerm)";
                break;
                case "nim":
                queryString += "LOWER(p.nim) LIKE LOWER (:searchTerm)";
                break;
                case "no_tlp":
                queryString += "LOWER(p.noTlp) LIKE LOWER (:searchTerm)";
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
            Map<String,Object> parameter = new HashMap<>();
            parameter.put("querySearch", searchTerm);
            parameter.put("searchBy",selection);

            // Menyiapkan data untuk laporan
             List<Object[]> data = new ArrayList<>();
            for (PeminjamanBuku result : results) {
                Object[] rowData = {
                    result.getNoPeminjaman(),
                    result.getJudulBuku(),
                    result.getStatusPeminjaman(),
                    date(result.getTglPeminjamanBuku()),
                    date(result.getTglKembaliBuku()),
                    result.getNamaPeminjam(),
                    result.getNim(),
                    result.getProgramStudi(),
                    result.getNoTlp(),
                    result.getAngkatan(),
                };
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

    private void jButtonimporbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonimporbukuActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        int i = filechooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {

            EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PBOPU").createEntityManager();
            entityManager.getTransaction().begin();

            File f = filechooser.getSelectedFile();
            String filepath = f.getPath();
            String fi = f.getName();
            //Parsing CSV Data
            System.out.print(filepath);
            DefaultTableModel csv_data = new DefaultTableModel();

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
                org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
                for (CSVRecord csvRecord : csvParser) {

                    PeminjamanBuku b = new PeminjamanBuku();
                    b.setNoPeminjaman(csvRecord.get(0));
                    b.setJudulBuku(csvRecord.get(1));
                    b.setStatusPeminjaman(csvRecord.get(2));
                                     
                    b.setTglPeminjamanBuku(format.parse(csvRecord.get(3)));
                    b.setTglKembaliBuku(format.parse(csvRecord.get(4)));
                  
                    b.setNamaPeminjam(csvRecord.get(5));
                    b.setNim(csvRecord.get(6));
                    b.setProgramStudi(csvRecord.get(7));
                    b.setNoTlp(csvRecord.get(8));
                    b.setAngkatan(csvRecord.get(9));
                    entityManager.persist(b);
                }
            } catch (Exception ex) {
                System.out.println("Error in Parsing CSV File");
            }
            entityManager.getTransaction().commit();

            DefaultTableModel model = (DefaultTableModel) jTablepinjambuku.getModel();
            model.setRowCount(0);
            tampilpinjambuku();
        }
    }//GEN-LAST:event_jButtonimporbukuActionPerformed

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
                case "tanggal_pinjam":
                queryString += "p.tglPeminjamanSkripsi LIKE :searchTerm";
                break;
                case "tanggal_kembali":
                queryString += "p.tglKembaliSkripsi LIKE LOWER :searchTerm";
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
                case "no_tlp":
                queryString += "LOWER(p.noTlp) LIKE LOWER (:searchTerm)";
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
            dataModel.addColumn("judul skripsi");
            dataModel.addColumn("status peminjaman");
            dataModel.addColumn("tgl_pinjam");
            dataModel.addColumn("tgl_kembali");
            dataModel.addColumn("nama");
            dataModel.addColumn("nim");
            dataModel.addColumn("prodi");
            dataModel.addColumn("no_tlp");
            dataModel.addColumn("angkatan");
            // ... tambahkan kolom lain sesuai kebutuhan

            for (PeminjamanSkripsi data : results) {
                Object[] baris = new Object[10];
                baris[0] = data.getNoPeminjamanSkripsi();
                baris[1] = data.getJudulSkripsi();
                baris[2] = data.getStatusPeminjaman();
                baris[3] = date(data.getTglPeminjamanSkripsi());
                baris[4] = date(data.getTglKembaliSkripsi());
                baris[5] = data.getNamaPeminjam();
                baris[6] = data.getNim();
                baris[7] = data.getProgramStudi();
                baris[8] = data.getNoTlp();
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
            String reportPath = "src/Laporan/reportpinjamskripsi.jrxml";
            String selection = ((String) jComboBoxcariskripsi.getSelectedItem()).toLowerCase();
            String searchTerm = jTextfieldcariskripsi.getText().trim();

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
                case "tanggal_pinjam":
                queryString += "p.tglPeminjamanSkripsi = :searchTerm";
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
                case "no_tlp":
                queryString += "LOWER(p.noTlp) LIKE LOWER (:searchTerm)";
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

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<PeminjamanSkripsi> q = em.createQuery(cq);
            List<PeminjamanSkripsi> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<PeminjamanSkripsi> results = query.getResultList();
            Map<String,Object> parameter = new HashMap<>();
            parameter.put("querySearch", searchTerm);
            parameter.put("searchBy",selection);

            // Menyiapkan data untuk laporan
             List<Object[]> data = new ArrayList<>();
            for (PeminjamanSkripsi result : results) {
                Object[] rowData = {
                    result.getNoPeminjamanSkripsi(),
                    result.getJudulSkripsi(),
                    result.getStatusPeminjaman(),
                    date(result.getTglPeminjamanSkripsi()),
                    date(result.getTglKembaliSkripsi()),
                    result.getNamaPeminjam(),
                    result.getNim(),
                    result.getProgramStudi(),
                    result.getNoTlp(),
                    result.getAngkatan(),
                };
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

    private void jButtonimporskripsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonimporskripsiActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        int i = filechooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {

            EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PBOPU").createEntityManager();
            entityManager.getTransaction().begin();

            File f = filechooser.getSelectedFile();
            String filepath = f.getPath();
            String fi = f.getName();
            //Parsing CSV Data
            System.out.print(filepath);
            DefaultTableModel csv_data = new DefaultTableModel();

            try {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
                org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
                for (CSVRecord csvRecord : csvParser) {

                    PeminjamanSkripsi s = new PeminjamanSkripsi();
                    s.setNoPeminjamanSkripsi(csvRecord.get(0));
                    s.setJudulSkripsi(csvRecord.get(1));
                    s.setStatusPeminjaman(csvRecord.get(2));
                                     
                    s.setTglPeminjamanSkripsi(format.parse(csvRecord.get(3)));
                    s.setTglKembaliSkripsi(format.parse(csvRecord.get(4)));
                  
                    s.setNamaPeminjam(csvRecord.get(5));
                    s.setNim(csvRecord.get(6));
                    s.setProgramStudi(csvRecord.get(7));
                    s.setNoTlp(csvRecord.get(8));
                    s.setAngkatan(csvRecord.get(9));
                    entityManager.persist(s);
                }
            } catch (Exception ex) {
                System.out.println("Error in Parsing CSV File");
            }
            entityManager.getTransaction().commit();

            DefaultTableModel model = (DefaultTableModel) jTable2pinjamskripsi.getModel();
            model.setRowCount(0);
            tampilpinjamskripsi();
        }
    }//GEN-LAST:event_jButtonimporskripsiActionPerformed

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

    private void jButtonhapusbuku1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapusbuku1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonhapusbuku1ActionPerformed

    private void jButtonKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKembaliActionPerformed
        // TODO add your handling code here:
     Gui_Menu1 menu = new Gui_Menu1();
        menu.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_jButtonKembaliActionPerformed

    private void jButton1caritanggalbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1caritanggalbukuActionPerformed
        // TODO add your handling code here:
        Date tanggalMulai = jDateChooser1.getDate();
        
        if (tanggalMulai == null) {
            JOptionPane.showMessageDialog(this, "Tanggal mulai harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit the method if the date is not selected
            }
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();
            
            String queryString = "SELECT p FROM PeminjamanBuku p WHERE p.tglPeminjamanBuku <= :startdate";
            
            TypedQuery<PeminjamanBuku> query = em.createQuery(queryString, PeminjamanBuku.class);           
            query.setParameter("startdate", tanggalMulai);
                        
            List<PeminjamanBuku> results = query.getResultList();

            DefaultTableModel dataModel = new DefaultTableModel();
            // Add columns to the model
            dataModel.addColumn("no peminjaman");
            dataModel.addColumn("judul");
            dataModel.addColumn("status peminjaman");
            dataModel.addColumn("tgl_pinjam");
            dataModel.addColumn("tgl_kembali");
            dataModel.addColumn("nama");
            dataModel.addColumn("nim");
            dataModel.addColumn("prodi");
            dataModel.addColumn("no_tlp");
            dataModel.addColumn("angkatan");
            // ... tambahkan kolom lain sesuai kebutuhan

            for (PeminjamanBuku data : results) {
                Object[] baris = new Object[10];
                baris[0] = data.getNoPeminjaman();
                baris[1] = data.getJudulBuku();
                baris[2] = data.getStatusPeminjaman();
                baris[3] = date(data.getTglPeminjamanBuku());
                baris[4] = date(data.getTglKembaliBuku());
                baris[5] = data.getNamaPeminjam();
                baris[6] = data.getNim();
                baris[7] = data.getProgramStudi();
                baris[8] = data.getNoTlp();
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
            dataModel.addColumn("no peminjaman");
            dataModel.addColumn("judul skripsi");
            dataModel.addColumn("status peminjaman");
            dataModel.addColumn("tgl_pinjam");
            dataModel.addColumn("tgl_kembali");
            dataModel.addColumn("nama");
            dataModel.addColumn("nim");
            dataModel.addColumn("prodi");
            dataModel.addColumn("no_tlp");
            dataModel.addColumn("angkatan");
            // ... tambahkan kolom lain sesuai kebutuhan

            for (PeminjamanSkripsi data : results) {
                Object[] baris = new Object[10];
                baris[0] = data.getNoPeminjamanSkripsi();
                baris[1] = data.getJudulSkripsi();
                baris[2] = data.getStatusPeminjaman();
                baris[3] = date(data.getTglPeminjamanSkripsi());
                baris[4] = date(data.getTglKembaliSkripsi());
                baris[5] = data.getNamaPeminjam();
                baris[6] = data.getNim();
                baris[7] = data.getProgramStudi();
                baris[8] = data.getNoTlp();
                baris[9] = data.getAngkatan();

                dataModel.addRow(baris);
            }

            // Set jTable1 with the created model
            jTable2pinjamskripsi.setModel(dataModel);
            System.out.println(results);
          
    }//GEN-LAST:event_jButtoncaritanggalskripsiActionPerformed

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
    private javax.swing.JButton jButton1caritanggalbuku;
    private javax.swing.JButton jButtonKembali;
    private javax.swing.JButton jButtoncaritanggalskripsi;
    private javax.swing.JButton jButtoncetakbuku;
    private javax.swing.JButton jButtoncetakskripsi;
    private javax.swing.JButton jButtonhapusbuku;
    private javax.swing.JButton jButtonhapusbuku1;
    private javax.swing.JButton jButtonhapusskripsi1;
    private javax.swing.JButton jButtonimporbuku;
    private javax.swing.JButton jButtonimporskripsi;
    private javax.swing.JButton jButtonkembali;
    private javax.swing.JButton jButtonkembali1;
    private javax.swing.JComboBox<String> jComboBoxbuku;
    private javax.swing.JComboBox<String> jComboBoxcariskripsi;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
