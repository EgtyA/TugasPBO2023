/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TampilanGuiDbPertemuan6;

import TampilanGuiDbPertemuan6.GuiKaryawan;
import TampilanGuiDbPertemuan5.Karyawan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author egty
 */
public class GuiKaryawan extends javax.swing.JFrame {
    
    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    
    ArrayList<Karyawan> dataKaryawan;
    private int masukkanData(Connection conn, String id_dep, String id_kar, String nama, String alamat) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO karyawan (id_dep, id_karyawan, nama, alamat) VALUES(?,?,?,?)");
        pst.setString(1, id_dep);
        pst.setString(2, id_kar);
        pst.setString(3, nama);
        pst.setString(4, alamat);
        return pst.executeUpdate();
    }
    private int updateData(Connection conn, String id_dep, String id_kar, String nama, String alamat) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("UPDATE karyawan set id_dep = ?, nama = ?, alamat = ? WHERE id_karyawan = ?");
       
        pst.setString(1, id_dep);
        pst.setString(2, nama);
        pst.setString(3, alamat);
         pst.setString(4, id_kar);
        return pst.executeUpdate();
    }
    
    private int hapusData(Connection conn, String id_kar) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("DELETE FROM karyawan WHERE id_karyawan = ?");       
        pst.setString(1, id_kar);
        return pst.executeUpdate();
    }
    
    private void tampil(Connection conn) {
        dataKaryawan.clear();
        try {
            String sql = "select * from karyawan order by id_karyawan ASC";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Karyawan data = new Karyawan();
                data.setIdDep(String.valueOf(rs.getObject(1)));
                data.setIdKaryawan(String.valueOf(rs.getObject(2)));
                data.setNama(String.valueOf(rs.getObject(3)));
                data.setAlamat(String.valueOf(rs.getObject(4)));
                dataKaryawan.add(data);
            }
            
            DefaultTableModel model = (DefaultTableModel) jTableKaryawan.getModel();
            model.setRowCount(0);
            for (Karyawan data : dataKaryawan) {

                Object[] baris = new Object[4];
                baris[0] = data.getIdDep();
                baris[1] = data.getIdKaryawan();
                baris[2] = data.getNama();
                baris[3] = data.getAlamat();
                
                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuiKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Creates new form GuiKaryawan
     */
    public GuiKaryawan() {
        try {
            dataKaryawan = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Pbo_Tugas", "postgres", "123");
            tampil(conn);
        } catch (SQLException ex) {
            Logger.getLogger(GuiKaryawan.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabelId_kar = new javax.swing.JLabel();
        jLabelNama = new javax.swing.JLabel();
        jLabelAlamat = new javax.swing.JLabel();
        jTextFieldId_dep = new javax.swing.JTextField();
        TextFieldID_kar = new javax.swing.JTextField();
        jLabelId_dep = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldAlamat = new javax.swing.JTextField();
        jButtonSimpan = new javax.swing.JButton();
        jButton2Update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableKaryawan = new javax.swing.JTable();
        jButtonCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelId_kar.setText("Id Karyawan");

        jLabelNama.setText("Nama");

        jLabelAlamat.setText("Alamat");

        jTextFieldId_dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldId_depActionPerformed(evt);
            }
        });

        TextFieldID_kar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldID_karActionPerformed(evt);
            }
        });

        jLabelId_dep.setText("Id Departemen");

        jButtonSimpan.setText("Simpan");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jButton2Update.setText("Update");
        jButton2Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2UpdateActionPerformed(evt);
            }
        });

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Departemen", "Id Karyawan", "Nama", "Alamat"
            }
        ));
        jTableKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKaryawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableKaryawan);

        jButtonCetak.setText("Cetak");
        jButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelId_kar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelAlamat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelId_dep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldId_dep, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAlamat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jTextFieldNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextFieldID_kar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jButtonSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2Update)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jButtonCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelId_dep, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldId_dep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelId_kar)
                            .addComponent(TextFieldID_kar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNama))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAlamat))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSimpan)
                            .addComponent(jButton2Update)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCetak)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldId_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldId_depActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldId_depActionPerformed

    private void TextFieldID_karActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldID_karActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldID_karActionPerformed

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        // TODO add your handling code here:
        String id_dep = jTextFieldId_dep.getText().trim();
        String id_kar = TextFieldID_kar.getText();
        String nama = jTextFieldNama.getText();
        String alamat = jTextFieldAlamat.getText();
        
        if (!id_kar.isEmpty() && !nama.isEmpty()) {
            try {
                // TODO add your handling code here:
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Pbo_Tugas", "postgres", "123");
                int k = masukkanData(conn, id_dep, id_kar, nama, alamat);
                if (k > 0) {
                    tampil(conn);
                    this.peringatan("Simpan Berhasil");
                } else {
                    this.peringatan("Simpan Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuiKaryawan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Input Data Karyawan Gagal");
        }
        jTextFieldId_dep.setText("");
        TextFieldID_kar.setText("");      
        jTextFieldNama.setText("");
        jTextFieldAlamat.setText("");
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jButton2UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2UpdateActionPerformed
        // TODO add your handling code here:
        String id_dep = jTextFieldId_dep.getText().trim();
        String id_kar = TextFieldID_kar.getText();
        String nama = jTextFieldNama.getText();
        String alamat = jTextFieldAlamat.getText();
        
        if (!id_kar.isEmpty() && !nama.isEmpty()) {
            try {
                // TODO add your handling code here:
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Pbo_Tugas", "postgres", "123");
                int k = updateData(conn, id_dep, id_kar, nama, alamat);
                if (k > 0) {
                    tampil(conn);
                    this.peringatan("Update Berhasil");
                } else {
                    this.peringatan("Update Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuiKaryawan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Update Data Karyawan Gagal");
        }
        jTextFieldId_dep.setText("");
        TextFieldID_kar.setText("");      
        jTextFieldNama.setText("");
        jTextFieldAlamat.setText("");
    }//GEN-LAST:event_jButton2UpdateActionPerformed

    private void jTableKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKaryawanMouseClicked
        // TODO add your handling code here:
        int baris = jTableKaryawan.rowAtPoint(evt.getPoint());

        String id_dep = jTableKaryawan.getValueAt(baris, 0).toString();
        jTextFieldId_dep.setText(id_dep);

        String id_kar = jTableKaryawan.getValueAt(baris, 1).toString();
        TextFieldID_kar.setText(id_kar);

        String nama = jTableKaryawan.getValueAt(baris, 2).toString();
        jTextFieldNama.setText(nama);

        String alamat = jTableKaryawan.getValueAt(baris, 3).toString();
        jTextFieldAlamat.setText(alamat);
    }//GEN-LAST:event_jTableKaryawanMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id_kar = TextFieldID_kar.getText().trim();
               
        if (!id_kar.isEmpty()) {
            try {
                // TODO add your handling code here:
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Pbo_Tugas", "postgres", "123");
                int k = hapusData(conn, id_kar);
                if (k > 0) {
                    tampil(conn);
                    this.peringatan("Hapus data Berhasil");
                } else {
                    this.peringatan("Hapus data Gagal");
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuiKaryawan.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.peringatan("Wajib input Id Karyawan");
        }
        
        TextFieldID_kar.setText("");      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Pbo_Tugas", "postgres", "123");

            //File jasperFile = new File("src/pbopertemuan6/mahasiswa.jasper");
            // JasperPrint jp = JasperFillManager.fillReport(jasperFile.getPath(), null, conn);
            String jrxmlFile = new String("src/TampilanGuiDbPertemuan6/reportKaryawan.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jrxmlFile);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException ex) {
            Logger.getLogger(GuiKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GuiKaryawan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCetakActionPerformed

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
            java.util.logging.Logger.getLogger(GuiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFieldID_kar;
    private javax.swing.JButton jButton2Update;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCetak;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JLabel jLabelAlamat;
    private javax.swing.JLabel jLabelId_dep;
    private javax.swing.JLabel jLabelId_kar;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableKaryawan;
    private javax.swing.JTextField jTextFieldAlamat;
    private javax.swing.JTextField jTextFieldId_dep;
    private javax.swing.JTextField jTextFieldNama;
    // End of variables declaration//GEN-END:variables
}
