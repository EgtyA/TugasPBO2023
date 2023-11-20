/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import ClassPersistane.DataBuku;
import ClassPersistane.PeminjamanBuku;
import java.math.BigInteger;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author egty
 */
public class Gui_Peminjaman_Buku extends javax.swing.JFrame {
    
     public String tanggal_pinjam;
    public String tanggal_kembali;
    
    private void tampil() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PBOPU").createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<PeminjamanBuku> querySelectAll = entityManager.createNamedQuery("PeminjamanBuku.findAll", PeminjamanBuku.class);
        List<PeminjamanBuku> results = querySelectAll.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        for (PeminjamanBuku data : results) {
            Object[] baris = new Object[9];
            baris[0] = data.getNoPeminjaman();
            baris[1] = data.getIdBuku();
            baris[2] = data.getStatusPeminjaman();
            baris[3] = data.getTglPeminjamanBuku();
            baris[4] = data.getTglKembaliBuku();
            baris[5] = data.getNamaPeminjam();
            baris[6] = data.getNim();
            baris[7] = data.getProgramStudi();
            baris[8] = data.getNoTlp();
           
            model.addRow(baris);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public static Date getTanggalFromTable(JTable table, int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try{
           tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
           
        }catch (ParseException ex){
            
         System.out.println("Error : " + ex.getMessage());    
    }
        return tanggal;
    }


    /**
     * Creates new form Gui_Peminjaman_Buku
     */
    public Gui_Peminjaman_Buku() {
        initComponents();
        tampil();
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
        jButtonsimpan = new javax.swing.JButton();
        jButtonupdate = new javax.swing.JButton();
        jButtonhapus = new javax.swing.JButton();
        jButtonkembali = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("No_peminjaman");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 20));

        jLabel2.setText("Id_buku");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 100, 20));

        jLabel3.setText("Status peminjaman");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 200, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 200, -1));

        jLabel4.setText("Tanggal pinjam");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, 20));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 190, -1));

        jLabel5.setText("Tanggal kembali");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 20));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 190, -1));
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 190, -1));
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 186, -1));

        jLabel6.setText("Nama peminjam");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 90, 20));

        jLabel7.setText("Nim");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 90, -1));

        jLabel8.setText("Prodi");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 90, 20));

        jLabel9.setText("No_telpon");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 90, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dipinjam", "Dikembalikan" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 127, -1));

        jButtonsimpan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonsimpan.setText("Simpan");
        jButtonsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 90, -1));

        jButtonupdate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonupdate.setText("Update");
        jPanel1.add(jButtonupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 90, -1));

        jButtonhapus.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonhapus.setText("Hapus");
        jPanel1.add(jButtonhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 90, -1));

        jButtonkembali.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonkembali.setText("Kembali");
        jPanel1.add(jButtonkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 90, -1));

        jTable2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No peminjaman", "Id buku", "Status peminjaman", "Tgl_pinjam", "Tgl_kembali", "Nama peminjam", "Nim", "Prodi", "No tlp"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 828, 298));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 160, -1));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 160, -1));

        jTabbedPane1.addTab("Peminjaman Buku", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Peminjaman Skripsi", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 79, 850, 620));

        jPanel3.setBackground(new java.awt.Color(190, 216, 190));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        jLabel10.setText("Peminjaman");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(552, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsimpanActionPerformed
        // TODO add your handling code here:
                
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
               
        String no_peminjaman = jTextField1.getText();
        String id_buku = jTextField2.getText();
        String status_pinjam = (String) jComboBox1.getSelectedItem();
        String tanggal_pinjam = format.format(jDateChooser1.getDate());
        String tanggal_kembali = format.format(jDateChooser2.getDate());
        String nama = jTextField6.getText();
        String nim = jTextField7.getText();
        String prodi = jTextField8.getText();
        String no_tlp = jTextField9.getText();
        

        // awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PBOPU").createEntityManager();
        entityManager.getTransaction().begin();
        
        PeminjamanBuku b = new PeminjamanBuku();
        b.setNoPeminjaman(no_peminjaman); 
        b.setIdBuku(id_buku);
        b.setStatusPeminjaman(status_pinjam);
        
       // Set tanggal peminjaman buku
        try {
        Date datePeminjaman = format.parse(tanggal_pinjam);
        Date dateKembali = format.parse(tanggal_kembali);
        b.setTglPeminjamanBuku(datePeminjaman);
        b.setTglKembaliBuku(dateKembali);
        } catch (ParseException e) {
        // Tangani kesalahan jika terjadi kesalahan parsing tanggal
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        }
         
        b.setNamaPeminjam(nama);
        b.setNim(nim);
        b.setProgramStudi(prodi);
        b.setNoTlp(no_tlp);
        
        entityManager.persist(b);
        
        entityManager.getTransaction().commit();
        // akhir persistence

        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.getSelectedItem();
        jDateChooser1.setDateFormatString("");
        jDateChooser2.setDateFormatString("");
        
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        
    }//GEN-LAST:event_jButtonsimpanActionPerformed

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
            java.util.logging.Logger.getLogger(Gui_Peminjaman_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Peminjaman_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Peminjaman_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Peminjaman_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_Peminjaman_Buku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonhapus;
    private javax.swing.JButton jButtonkembali;
    private javax.swing.JButton jButtonsimpan;
    private javax.swing.JButton jButtonupdate;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
