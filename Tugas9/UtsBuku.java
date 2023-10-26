/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CrudBuku;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author egty
 */
public class UtsBuku extends javax.swing.JFrame {

    private Timer refreshTimer;

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }

    ArrayList<Buku> dataBuku;

    private int masukkanData(Connection conn, String Isbn, String judul_buku, String tahun_terbit, String penerbit) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO buku (isbn, judul_buku, tahun_terbit, penerbit) VALUES(?,?,?,?)");
        pst.setString(1, Isbn);
        pst.setString(2, judul_buku);
        pst.setString(3, tahun_terbit);
        pst.setString(4, penerbit);
        return pst.executeUpdate();
    }

    private int updateData(Connection conn, String Isbn, String judul_buku, String tahun_terbit, String penerbit) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("UPDATE buku set judul_buku = ?, tahun_terbit = ?, penerbit = ? WHERE isbnGu = ?");

        pst.setString(1, judul_buku);
        pst.setString(2, tahun_terbit);
        pst.setString(3, penerbit);
        pst.setString(4, Isbn);
        return pst.executeUpdate();
    }

    private int hapusData(Connection conn, String judul_buku) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("DELETE FROM buku WHERE judul_buku = ?");
        pst.setString(1, judul_buku);
        return pst.executeUpdate();
    }

    private void tampil(Connection conn) {
        dataBuku.clear();
        try {
            String sql = "select * from buku";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Buku data = new Buku();
                data.setISBN(String.valueOf(rs.getObject(1)));
                data.setJudul_buku(String.valueOf(rs.getObject(2)));
                data.setTahun_terbit(String.valueOf(rs.getObject(3)));
                data.setPenerbit(String.valueOf(rs.getObject(4)));
                dataBuku.add(data);
            }

            DefaultTableModel model = (DefaultTableModel) jTableBuku.getModel();
            model.setRowCount(0);
            for (Buku data : dataBuku) {

                Object[] baris = new Object[4];
                baris[0] = data.getISBN();
                baris[1] = data.getJudul_buku();
                baris[2] = data.getTahun_terbit();
                baris[3] = data.getPenerbit();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtsBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void kosongkan_form() {
        jTextFieldisbn.setEditable(true);
        jTextFieldisbn.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
    }

    /**
     * Creates new form UtsBuku
     */
    public UtsBuku() {
        try {
            dataBuku = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Uts_PBO", "postgres", "123");
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
            Logger.getLogger(UtsBuku.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextFieldisbn = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBuku = new javax.swing.JTable();
        jButtonsimpan = new javax.swing.JButton();
        jButtonupdate = new javax.swing.JButton();
        jButtonhapus = new javax.swing.JButton();
        jButtoncetak = new javax.swing.JButton();
        jButtonImporCSV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("STSong", 1, 24)); // NOI18N
        jLabel1.setText("DAFTAR BUKU");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("ISBN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tahun Terbit");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Judul Buku");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Penerbit");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "Judul Buku", "Tahun Terbit", "Penerbit"
            }
        ));
        jTableBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBuku);

        jButtonsimpan.setText("Simpan");
        jButtonsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsimpanActionPerformed(evt);
            }
        });

        jButtonupdate.setText("Update");
        jButtonupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonupdateActionPerformed(evt);
            }
        });

        jButtonhapus.setText("Hapus");
        jButtonhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusActionPerformed(evt);
            }
        });

        jButtoncetak.setText("Cetak");
        jButtoncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncetakActionPerformed(evt);
            }
        });

        jButtonImporCSV.setText("Impor");
        jButtonImporCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImporCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(26, 26, 26)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonsimpan)
                                    .addGap(33, 33, 33)
                                    .addComponent(jButtonupdate)
                                    .addGap(42, 42, 42)
                                    .addComponent(jButtonhapus)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButtoncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jButtonImporCSV)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonsimpan)
                            .addComponent(jButtonupdate)
                            .addComponent(jButtonhapus))
                        .addGap(18, 18, 18)
                        .addComponent(jButtoncetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonImporCSV))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsimpanActionPerformed
        // TODO add your handling code here:
        String ISBN = jTextFieldisbn.getText().trim();
        String judul_buku = jTextField2.getText();
        String tahun_terbit = jTextField3.getText();
        String penerbit = jTextField4.getText();

        // awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("TugasUtsPU").createEntityManager();
        entityManager.getTransaction().begin();
        Buku_1 b = new Buku_1();
        b.setIsbn(ISBN);
        b.setJudulBuku(judul_buku);
        b.setTahunTerbit(tahun_terbit);
        b.setPenerbit(penerbit);
        entityManager.persist(b);
        entityManager.getTransaction().commit();
        // akhir persistence

        jTextFieldisbn.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_jButtonsimpanActionPerformed

    private void jButtonupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonupdateActionPerformed
        // TODO add your handling code here:
        String ISBN = jTextFieldisbn.getText().trim();
        String judul_buku = jTextField2.getText();
        String tahun_terbit = jTextField3.getText();
        String penerbit = jTextField4.getText();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TugasUtsPU");
        EntityManager em = emf.createEntityManager();
        Buku_1 b = new Buku_1();
        b.setIsbn(ISBN);
        b.setJudulBuku(judul_buku);
        b.setTahunTerbit(tahun_terbit);
        b.setPenerbit(penerbit);

        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
        // akhir persistence

        jTextFieldisbn.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_jButtonupdateActionPerformed

    private void jButtonhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapusActionPerformed
        // TODO add your handling code here:
        String ISBN = jTextFieldisbn.getText().trim();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TugasUtsPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Buku_1 b = em.find(Buku_1.class, ISBN);

        em.remove(b);
        em.getTransaction().commit();
        // akhir persistence

        jTextFieldisbn.setText("");
        kosongkan_form();
    }//GEN-LAST:event_jButtonhapusActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jButtoncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncetakActionPerformed
        // TODO add your handling code here:
        InputStream reportTemplate = Buku_1.class.getResourceAsStream("report1.jrxml");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TugasUtsPU");
        EntityManager em = emf.createEntityManager();

        List<Buku_1> data = em.createQuery("SELECT d FROM Buku_1 d", Buku_1.class).getResultList();
        JasperReport jasperReport;
        try {
            jasperReport = JasperCompileManager.compileReport(reportTemplate);
            Map<String, Object> parameters = null;
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(dataBuku));
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException ex) {
            ex.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
    }//GEN-LAST:event_jButtoncetakActionPerformed

    private void jTableBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBukuMouseClicked
        // TODO add your handling code here:
        int baris = jTableBuku.rowAtPoint(evt.getPoint());

        String Isbn = jTableBuku.getValueAt(baris, 0).toString();
        jTextFieldisbn.setText(Isbn);

        String judul_buku = jTableBuku.getValueAt(baris, 1).toString();
        jTextField2.setText(judul_buku);

        String tahun_terbit = jTableBuku.getValueAt(baris, 2).toString();
        jTextField3.setText(tahun_terbit);

        String penerbit = jTableBuku.getValueAt(baris, 3).toString();
        jTextField4.setText(penerbit);
    }//GEN-LAST:event_jTableBukuMouseClicked

    private void jButtonImporCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImporCSVActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();

                int i = filechooser.showOpenDialog(null);
                if (i == JFileChooser.APPROVE_OPTION) {
                    
                    EntityManager entityManager = Persistence.createEntityManagerFactory("TugasUtsPU").createEntityManager();
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

                        Buku_1 b = new Buku_1();
                        b.setIsbn(csvRecord.get(0));
                        b.setJudulBuku(csvRecord.get(1));
                        b.setTahunTerbit(csvRecord.get(2));
                        b.setPenerbit(csvRecord.get(3));
                        entityManager.persist(b);
                        
                        }
                        
                    } catch (Exception ex) {
                        System.out.println("Error in Parsing CSV File");
                    }
                    
                    entityManager.getTransaction().commit();}
    }//GEN-LAST:event_jButtonImporCSVActionPerformed

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
            java.util.logging.Logger.getLogger(UtsBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UtsBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UtsBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UtsBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UtsBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonImporCSV;
    private javax.swing.JButton jButtoncetak;
    private javax.swing.JButton jButtonhapus;
    private javax.swing.JButton jButtonsimpan;
    private javax.swing.JButton jButtonupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBuku;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldisbn;
    // End of variables declaration//GEN-END:variables

}
