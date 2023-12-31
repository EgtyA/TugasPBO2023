/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import ClassPersistane.DataBuku;
import ClassPersistane.DataSkripsi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author egty
 */
public class Gui_Skripsi extends javax.swing.JFrame {
    private Timer refreshTimer;
    

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }

    ArrayList<DataSkripsi> dataSkripsi;

    private void tampil(Connection conn) {
        dataSkripsi.clear();
        try {
            String sql = "select * from data_skripsi";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DataSkripsi data = new DataSkripsi();
                data.setIdSkripsi(String.valueOf(rs.getObject(1)));
                data.setJudul(String.valueOf(rs.getObject(2)));
                data.setSubJudul(String.valueOf(rs.getObject(3)));
                data.setPenulis(String.valueOf(rs.getObject(4)));
                data.setTahun(String.valueOf(rs.getObject(5)));

                data.setJumlahHalaman(BigInteger.valueOf(rs.getLong(6)));

                dataSkripsi.add(data);
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for (DataSkripsi data : dataSkripsi) {

                Object[] baris = new Object[6];
                baris[0] = data.getIdSkripsi();
                baris[1] = data.getJudul();
                baris[2] = data.getSubJudul();
                baris[3] = data.getPenulis();
                baris[4] = data.getTahun();
                baris[5] = data.getJumlahHalaman();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gui_Skripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void kosongkan_form() {
        jTextField1.setEditable(true);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
    }


    /**
     * Creates new form Gui_Skripsi
     */
    public Gui_Skripsi() {
        try {
            dataSkripsi = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Uas_Pbo", "postgres", "123");
            tampil(conn);
            kosongkan_form();

            // Membuat dan mengatur timer untuk auto-refresh setiap 5 detik (5000 milidetik)
            refreshTimer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tampil(conn);
                }
            });
            refreshTimer.start();
        } catch (SQLException ex) {
            Logger.getLogger(Gui_Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1simpan = new javax.swing.JButton();
        jButton2update = new javax.swing.JButton();
        jButton4kembali = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton3hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(190, 216, 190));

        jLabel1.setFont(new java.awt.Font("Candara", 1, 34)); // NOI18N
        jLabel1.setText("Data Skripsi");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\egty\\Pictures\\image 23.jpg")); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 110));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id_skripsi", "Judul", "Subjudul", "Pengarang", "Tahun", "Jumlah halaman"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 830, 370));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("Id_skripsi");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, 30));

        jTextField1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 129, 204, 28));

        jTextField2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 169, 204, 28));

        jTextField3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 215, 204, 28));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Penulis");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 70, 30));

        jTextField4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 220, 28));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setText("Tahun");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 100, 30));

        jTextField5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 180, 28));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setText("Jumlah halaman");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 100, 30));

        jTextField6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 180, 28));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel7.setText("Judul");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 168, 80, 30));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel8.setText("Subjudul");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 218, 90, 30));

        jButton1simpan.setText("Simpan");
        jButton1simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1simpanActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 90, -1));

        jButton2update.setText("Update");
        jButton2update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2updateActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2update, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 90, -1));

        jButton4kembali.setText("Kembali");
        jButton4kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4kembaliActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 90, -1));

        jButton7.setText("Cari");
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 60, -1));

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 180, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_skripsi", "judul", "penulis", "tahun" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 100, -1));

        jButton3hapus.setText("Hapus");
        jButton3hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3hapusActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4kembaliActionPerformed
        // TODO add your handling code here:
         Gui_Menu1 menu = new Gui_Menu1();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4kembaliActionPerformed

    private void jButton1simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1simpanActionPerformed
        // TODO add your handling code here:
        String id_skripsi = jTextField1.getText().trim();
        String judul = jTextField2.getText();
        String subjudul = jTextField3.getText();
        String penulis  = jTextField4.getText();
        String tahun = jTextField5.getText();
        BigInteger jumlahHalaman = new BigInteger(jTextField6.getText());

        // awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("Uas_PBOPU").createEntityManager();
        entityManager.getTransaction().begin();
        DataSkripsi p = new DataSkripsi();
        p.setIdSkripsi(id_skripsi);
        p.setJudul(judul);
        p.setSubJudul(subjudul);
        p.setPenulis(penulis);
        p.setTahun(tahun);
        p.setJumlahHalaman(jumlahHalaman);
        entityManager.persist(p);
        entityManager.getTransaction().commit();
        // akhir persistence

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");    

        if (!id_skripsi.isEmpty()) {
            // TODO add your handling code here:
            if (!judul.isEmpty()) {
                this.peringatan("Simpan Berhasil");
            } else {
                this.peringatan("Simpan Gagal");
            }
        } else {
            this.peringatan("Input Data buku Gagal");
        }
    }//GEN-LAST:event_jButton1simpanActionPerformed

    private void jButton2updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2updateActionPerformed
        // TODO add your handling code here:
        String id_skripsi = jTextField1.getText().trim();
        String judul = jTextField2.getText();
        String subjudul = jTextField3.getText();
        String penulis  = jTextField4.getText();
        String tahun = jTextField5.getText();
        BigInteger jumlahHalaman = new BigInteger(jTextField6.getText());

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        DataSkripsi p = new DataSkripsi();
        p.setIdSkripsi(id_skripsi);
        p.setJudul(judul);
        p.setSubJudul(subjudul);
        p.setPenulis(penulis);
        p.setTahun(tahun);
        p.setJumlahHalaman(jumlahHalaman);
        
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        // akhir persistence

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        

        if (!id_skripsi.isEmpty()) {
            this.peringatan("Update data Berhasil");
        } else {
            this.peringatan("Update data Gagal");
        }
    }//GEN-LAST:event_jButton2updateActionPerformed

    private void jButton3hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3hapusActionPerformed
        // TODO add your handling code here:
        String id_skripsi = jTextField1.getText().trim();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        DataSkripsi p = em.find(DataSkripsi.class, id_skripsi);

        em.remove(p);
        em.getTransaction().commit();
        // akhir persistence

        jTextField1.setText("");
        kosongkan_form();

        if (!id_skripsi.isEmpty()) {
            if (!id_skripsi.isEmpty()) {
                this.peringatan("Hapus data Berhasil");
            } else {
                this.peringatan("Hapus data Gagal");
            }
        } else {
            this.peringatan("Wajib input id buku");
        }
    }//GEN-LAST:event_jButton3hapusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris = jTable1.rowAtPoint(evt.getPoint());

        String id_skripsi = jTable1.getValueAt(baris, 0).toString();
        jTextField1.setText(id_skripsi);

        String judul = jTable1.getValueAt(baris, 1).toString();
        jTextField2.setText(judul);

        String subjudul = jTable1.getValueAt(baris, 2).toString();
        jTextField3.setText(subjudul);

        String penulis = jTable1.getValueAt(baris, 3).toString();
        jTextField4.setText(penulis);

        String tahun = jTable1.getValueAt(baris, 4).toString();
        jTextField5.setText(tahun);

        BigInteger jumlahHalaman = (BigInteger) jTable1.getValueAt(baris, 5);
        jTextField6.setText(jumlahHalaman.toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBox1.getSelectedItem();

            String searchTerm = jTextField7.getText().trim();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT d FROM DataSkripsi d WHERE ";

            switch (selection) {
                case "id_skripsi":
                    queryString += "d.idSkripsi LIKE :searchTerm ";
                    break;
                case "judul":
                    queryString += "d.judul LIKE :searchTerm";
                    break;
                case "penulis":
                    queryString += "d.penulis LIKE :searchTerm";
                    break;
                case "tahun":
                    queryString += "d.tahun LIKE :searchTerm";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            // Create and execute the JPA query
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<DataSkripsi> query = em.createQuery(queryString, DataSkripsi.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<DataSkripsi> results = query.getResultList();
            
            DefaultTableModel dataModel = new DefaultTableModel();

            // Add columns to the model
            dataModel.addColumn("Id_skripsi");
            dataModel.addColumn("Judul");
            dataModel.addColumn("Subjudul");
            dataModel.addColumn("penulis");
            dataModel.addColumn("Tahun");
            dataModel.addColumn("jumlah halaman");
            // ... tambahkan kolom lain sesuai kebutuhan

            // Add rows to the model
            for (DataSkripsi result : results) {
                Object[] rowData = {
                    result.getIdSkripsi(),                  
                    result.getJudul(),
                    result.getSubJudul(),
                    result.getPenulis(),
                    result.getTahun(),
                    result.getJumlahHalaman(),
                };
                dataModel.addRow(rowData);
            }

            // Set jTable1 with the created model
            jTable1.setModel(dataModel);
            System.out.println(results);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextField7KeyReleased

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
            java.util.logging.Logger.getLogger(Gui_Skripsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Skripsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Skripsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Skripsi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_Skripsi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1simpan;
    private javax.swing.JButton jButton2update;
    private javax.swing.JButton jButton3hapus;
    private javax.swing.JButton jButton4kembali;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
