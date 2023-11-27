/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import ClassPersistane.DataSkripsi;
import ClassPersistane.PeminjamanBuku;
import ClassPersistane.PeminjamanSkripsi;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static uas_pbo.Gui_Peminjaman_Buku.date;

/**
 *
 * @author egty
 */
public class Gui_peminjaman_skripsi extends javax.swing.JFrame {
    
     public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
     
     public static String date(Date date){
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");
         return format.format(date);
    }
     
     private void tampilskripsi() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PeminjamanSkripsi> cq = cb.createQuery(PeminjamanSkripsi.class);
        
        Root<PeminjamanSkripsi>pin = cq.from(PeminjamanSkripsi.class);
        cq.orderBy(cb.asc(pin.get("noPeminjamanSkripsi")));
        CriteriaQuery<PeminjamanSkripsi> select = cq.select(pin);
        TypedQuery<PeminjamanSkripsi> q = em.createQuery(select);
//        TypedQuery<PeminjamanSkripsi> querySelectAll = entityManager.createNamedQuery("PeminjamanSkripsi.findAll", PeminjamanSkripsi.class);
        List<PeminjamanSkripsi> results = q.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTable2pinjam.getModel();
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
        em.getTransaction().commit();
        emf.close();
    }
     
    private void tampil() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DataSkripsi> cq = cb.createQuery(DataSkripsi.class);
        
        Root<DataSkripsi>d = cq.from(DataSkripsi.class);
        cq.orderBy(cb.asc(d.get("idSkripsi")));
        CriteriaQuery<DataSkripsi> select = cq.select(d);
        TypedQuery<DataSkripsi> q = em.createQuery(select);
        
        List<DataSkripsi> results = q.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTableskripsi.getModel();
        model.setRowCount(0);
        for (DataSkripsi data : results) {
            Object[] baris = new Object[8];
            baris[0] = data.getIdSkripsi();
            baris[1] = data.getJudul();
            baris[2] = data.getKataKunci();
            baris[3] = data.getPenulis();
            baris[4] = data.getTahun();
            baris[5] = data.getJumlahHalaman();
           
            model.addRow(baris);
        }
        em.getTransaction().commit();
        emf.close();
    }
     
     private void kosongkan_form() {
        jTextField1.setEditable(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.getSelectedItem();
        jDateChooser3.setDate(null);
        jDateChooser1.setDate(null);
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
    }


    /**
     * Creates new form Gui_peminjaman_skripsi
     */
    public Gui_peminjaman_skripsi() {
        initComponents();
        tampilskripsi();
        tampil();
        kosongkan_form();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableskripsi = new javax.swing.JTable();
        jTextField3data = new javax.swing.JTextField();
        jComboBox2data = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButtonsimpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2pinjam = new javax.swing.JTable();
        jTextFieldcari = new javax.swing.JTextField();
        jComboBoxcari = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jButtonupdate1 = new javax.swing.JButton();
        jButtonhapus1 = new javax.swing.JButton();
        jButtonkembali1 = new javax.swing.JButton();

        jDialog1.setSize(new java.awt.Dimension(903, 561));

        jTableskripsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_skripsi", "Judul", "Kata kunci", "Penulis", "Tahun", "Jumlah halaman"
            }
        ));
        jTableskripsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableskripsiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableskripsi);

        jTextField3data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3dataKeyReleased(evt);
            }
        });

        jComboBox2data.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_skripsi", "judul", "kata kunci", "penulis", "tahun", " " }));
        jComboBox2data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2dataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField3data, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2data, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(188, 214, 194));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        jLabel10.setText("Peminjaman Skripsi");

        jPanel4.setBackground(new java.awt.Color(158, 188, 158));

        jLabel14.setFont(new java.awt.Font("MV Boli", 1, 32)); // NOI18N
        jLabel14.setText("BoSi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(169, 216, 169));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("No_peminjaman");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 20));

        jLabel2.setText("Judul skripsi");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 100, 20));

        jLabel3.setText("Status peminjaman");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 240, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 240, -1));

        jLabel4.setText("Tanggal pinjam");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, 20));
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 220, -1));

        jLabel5.setText("Tanggal kembali");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 100, 20));
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 220, -1));
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 220, -1));
        jPanel2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 220, -1));

        jLabel6.setText("Nama peminjam");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 90, 20));

        jLabel7.setText("Nim");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 90, -1));

        jLabel8.setText("Prodi");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 90, 20));

        jLabel9.setText("No_telpon");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 90, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dipinjam", "Dikembalikan" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 127, -1));

        jLabel11.setText("Angkatan");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 90, -1));
        jPanel2.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 200, -1));

        jButton1.setText("...");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 40, -1));
        jPanel2.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, -1));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));

        jButtonsimpan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonsimpan.setText("Simpan");
        jButtonsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 90, -1));

        jTable2pinjam.setBackground(new java.awt.Color(179, 195, 179));
        jTable2pinjam.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTable2pinjam.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2pinjam.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2pinjam.setGridColor(new java.awt.Color(204, 204, 204));
        jTable2pinjam.setSelectionBackground(new java.awt.Color(0, 102, 51));
        jTable2pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2pinjamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable2pinjam);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 308, 970, 324));

        jTextFieldcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldcariActionPerformed(evt);
            }
        });
        jTextFieldcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldcariKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 210, 30));

        jComboBoxcari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no_peminjaman", "judul", "status_pinjam", "nama", "nim", "prodi", "no_tlp", "angkatan" }));
        jPanel2.add(jComboBoxcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 130, 30));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Cari");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 30, 30));

        jButtonupdate1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonupdate1.setText("Update");
        jButtonupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonupdate1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonupdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 90, -1));

        jButtonhapus1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonhapus1.setText("Hapus");
        jButtonhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapus1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonhapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 140, 90, -1));

        jButtonkembali1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonkembali1.setText("Kembali");
        jButtonkembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonkembali1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonkembali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       tampilskripsi();
       jDialog1.setVisible(true);
       jDialog1.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsimpanActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");

        String no_peminjaman = jTextField1.getText();
        String judul_skripsi = jTextField2.getText();
        String status_pinjam = (String) jComboBox1.getSelectedItem();
        String tanggal_pinjam = format.format(jDateChooser3.getDate());
        String tanggal_kembali = format.format(jDateChooser1.getDate());
        String nama = jTextField6.getText();
        String nim = jTextField7.getText();
        String prodi = jTextField8.getText();
        String no_tlp = jTextField9.getText();
        String angkatan = jTextField10.getText();
        

        // awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PBOPU").createEntityManager();
        entityManager.getTransaction().begin();

        PeminjamanSkripsi s = new PeminjamanSkripsi();

        s.setNoPeminjamanSkripsi(no_peminjaman);
        s.setJudulSkripsi(judul_skripsi);
        s.setStatusPeminjaman(status_pinjam);

        // Set tanggal peminjaman buku
        try {
            Date datePeminjaman = format.parse(tanggal_pinjam);
            Date dateKembali = format.parse(tanggal_kembali);
            s.setTglPeminjamanSkripsi(datePeminjaman);
            s.setTglKembaliSkripsi(dateKembali);
        } catch (ParseException e) {
            // Tangani kesalahan jika terjadi kesalahan parsing tanggal
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        }

        s.setNamaPeminjam(nama);
        s.setNim(nim);
        s.setProgramStudi(prodi);
        s.setNoTlp(no_tlp);
        s.setAngkatan(angkatan);      
        entityManager.persist(s);

        entityManager.getTransaction().commit();
        // akhir persistence

        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.getSelectedItem();
        jDateChooser3.setDate(null);
        jDateChooser1.setDate(null);

        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        
        DefaultTableModel model = (DefaultTableModel) jTable2pinjam.getModel();
        model.setRowCount(0);
        tampilskripsi();

    }//GEN-LAST:event_jButtonsimpanActionPerformed

    private void jTable2pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2pinjamMouseClicked
        // TODO add your handling code here:
        int baris = jTable2pinjam.rowAtPoint(evt.getPoint());

        String no_peminjaman = jTable2pinjam.getValueAt(baris, 0).toString();
        jTextField1.setText(no_peminjaman);

        String judul_buku  = jTable2pinjam.getValueAt(baris, 1).toString();
        jTextField2.setText(judul_buku);

        String status_pinjam = jTable2pinjam.getValueAt(baris, 2).toString();
        jComboBox1.setSelectedItem(status_pinjam);

        String pinjam = jTable2pinjam.getValueAt(baris, 3).toString();        
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");
            java.util.Date d=format.parse(pinjam);
            jDateChooser3.setDate(d);
        } catch (ParseException e) {
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        } 
        
        String kembali = jTable2pinjam.getValueAt(baris, 4).toString();        
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");
            java.util.Date d=format.parse(kembali);
            jDateChooser1.setDate(d);
        } catch (ParseException e) {
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        } 
        
        String nama = jTable2pinjam.getValueAt(baris, 5).toString();
        jTextField6.setText(nama);

        String nim = jTable2pinjam.getValueAt(baris, 6).toString();
        jTextField7.setText(nim);

        String prodi = jTable2pinjam.getValueAt(baris, 7).toString();
        jTextField8.setText(prodi);

        String no_tlp = jTable2pinjam.getValueAt(baris, 8).toString();
        jTextField9.setText(no_tlp);

        String angkatan = jTable2pinjam.getValueAt(baris, 9).toString();
        jTextField10.setText(angkatan);
    }//GEN-LAST:event_jTable2pinjamMouseClicked

    private void jTextField3dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3dataKeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBox2data.getSelectedItem();
            String searchTerm = jTextField3data.getText().trim();
            
             // Create and execute the JPA query
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT d FROM DataSkripsi d WHERE ";

            switch (selection.toLowerCase()) {
                case "id_skripsi":
                queryString += "LOWER (d.idSkripsi) LIKE LOWER (:searchTerm) ";
                break;
                case "judul":
                queryString += "LOWER (d.judul) LIKE LOWER (:searchTerm)";
                break;
                case "kata kunci":
                queryString += "LOWER (d.kataKunci) LIKE LOWER (:searchTerm)";
                break;
                case "penulis":
                queryString += "LOWER (d.penulis) LIKE LOWER (:searchTerm)";
                break;
                case "tahun":
                queryString += "LOWER (d.tahun) LIKE LOWER (:searchTerm)";
                break;
                default:
                throw new IllegalArgumentException("No search criteria selected.");
            }

            queryString += "ORDER BY p.noPeminjamanSkripsi ASC";
            TypedQuery<DataSkripsi> query = em.createQuery(queryString, DataSkripsi.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<DataSkripsi> results = query.getResultList();

            DefaultTableModel dataModel = new DefaultTableModel();

            // Add columns to the model
            dataModel.addColumn("Id_skripsi");
            dataModel.addColumn("Judul");
            dataModel.addColumn("Kata kunci");
            dataModel.addColumn("penulis");
            dataModel.addColumn("Tahun");
            dataModel.addColumn("jumlah halaman");
            // ... tambahkan kolom lain sesuai kebutuhan

            // Add rows to the model
            for (DataSkripsi result : results) {
                Object[] rowData = {
                    result.getIdSkripsi(),
                    result.getJudul(),
                    result.getKataKunci(),
                    result.getPenulis(),
                    result.getTahun(),
                    result.getJumlahHalaman(),};
                dataModel.addRow(rowData);
            }

            // Set jTable1 with the created model
            jTableskripsi.setModel(dataModel);
            System.out.println(results);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextField3dataKeyReleased

    private void jComboBox2dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2dataActionPerformed

    private void jTextFieldcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldcariActionPerformed

    private void jTextFieldcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcariKeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBoxcari.getSelectedItem();
            String searchTerm = jTextFieldcari.getText().trim();

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
                case "no_tlp":
                queryString += "LOWER(p.noTlp) LIKE LOWER (:searchTerm)";
                break;
                case "angkatan":
                queryString += "LOWER(p.angkatan) LIKE LOWER (:searchTerm)";
                break;
                default:
                throw new IllegalArgumentException("No search criteria selected.");
            }
            queryString += "ORDER BY p.noPeminjamanSkripsi ASC";
            TypedQuery<PeminjamanSkripsi> query = em.createQuery(queryString, PeminjamanSkripsi.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<PeminjamanSkripsi> results = query.getResultList();

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
            jTable2pinjam.setModel(dataModel);
            System.out.println(results);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldcariKeyReleased

    private void jButtonupdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonupdate1ActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");

        String no_peminjaman = jTextField1.getText();
        String judul_skripsi = jTextField2.getText();
        String status_pinjam = (String) jComboBox1.getSelectedItem();
        String tanggal_pinjam = format.format(jDateChooser3.getDate());
        String tanggal_kembali = format.format(jDateChooser1.getDate());
        String nama = jTextField6.getText();
        String nim = jTextField7.getText();
        String prodi = jTextField8.getText();
        String no_tlp = jTextField9.getText();
        String angkatan = jTextField10.getText();
        

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();

        PeminjamanSkripsi ba = new PeminjamanSkripsi();
        ba.setNoPeminjamanSkripsi(no_peminjaman);
        ba.setJudulSkripsi(judul_skripsi);
        ba.setStatusPeminjaman(status_pinjam);

        try {
            Date datePeminjaman = format.parse(tanggal_pinjam);
            Date dateKembali = format.parse(tanggal_kembali);
            ba.setTglPeminjamanSkripsi(datePeminjaman);
            ba.setTglKembaliSkripsi(dateKembali);
        } catch (ParseException e) {
            // Tangani kesalahan jika terjadi kesalahan parsing tanggal
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        }

        ba.setNamaPeminjam(nama);
        ba.setNim(nim);
        ba.setProgramStudi(prodi);
        ba.setNoTlp(no_tlp);
        ba.setAngkatan(angkatan);
       

        em.getTransaction().begin();
        em.merge(ba);
        em.getTransaction().commit();
        // akhir persistence

        jTextField1.setText("");
        jComboBox1.getSelectedItem();
        jDateChooser3.setDate(null);
        jDateChooser1.setDate(null);

        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");

        jTextField2.setText("");

        DefaultTableModel model = (DefaultTableModel) jTable2pinjam.getModel();
        model.setRowCount(0);
        tampilskripsi();

        try {
            if (ba != null) {
                JOptionPane.showMessageDialog(this, "Update Berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(Gui_Buku_1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_jButtonupdate1ActionPerformed

    private void jButtonhapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapus1ActionPerformed
        // TODO add your handling code here:
        String no_peminjaman = jTextField1.getText().trim();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PeminjamanSkripsi b = em.find(PeminjamanSkripsi.class, no_peminjaman);

        em.remove(b);
        em.getTransaction().commit();
        // akhir persistence

        jTextField1.setText("");

        DefaultTableModel model = (DefaultTableModel) jTable2pinjam.getModel();
        model.setRowCount(0);
        tampilskripsi();
        kosongkan_form();

        try {
            if (b != null) {
                JOptionPane.showMessageDialog(this, "Hapus data Berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(Gui_Buku_1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_jButtonhapus1ActionPerformed

    private void jButtonkembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonkembali1ActionPerformed
        // TODO add your handling code here:
        Gui_Menu1 menu = new Gui_Menu1();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonkembali1ActionPerformed

    private void jTableskripsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableskripsiMouseClicked
        // TODO add your handling code here:
        int baris = jTableskripsi.rowAtPoint(evt.getPoint());

        String judul_skripsi = jTableskripsi.getValueAt(baris, 1).toString();
        jTextField2.setText(judul_skripsi); 
    }//GEN-LAST:event_jTableskripsiMouseClicked

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
            java.util.logging.Logger.getLogger(Gui_peminjaman_skripsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_peminjaman_skripsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_peminjaman_skripsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_peminjaman_skripsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_peminjaman_skripsi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonhapus1;
    private javax.swing.JButton jButtonkembali1;
    private javax.swing.JButton jButtonsimpan;
    private javax.swing.JButton jButtonupdate1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2data;
    private javax.swing.JComboBox<String> jComboBoxcari;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2pinjam;
    private javax.swing.JTable jTableskripsi;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3data;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldcari;
    // End of variables declaration//GEN-END:variables
}
