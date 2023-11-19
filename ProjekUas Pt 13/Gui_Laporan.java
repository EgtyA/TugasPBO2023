/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import ClassPersistane.DataBuku;
import ClassPersistane.DataSkripsi;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author egty
 */
public class Gui_Laporan extends javax.swing.JFrame {
    

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    
    ArrayList<DataBuku> dataBuku;
    
    private void tampil(Connection conn) {
        dataBuku.clear();
        try {
            String sql = "select * from data_buku";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DataBuku data = new DataBuku();
                data.setIdBuku(String.valueOf(rs.getObject(1)));
                data.setIsbn(String.valueOf(rs.getObject(2)));
                data.setJudulBuku(String.valueOf(rs.getObject(3)));
                data.setSubjudul(String.valueOf(rs.getObject(4)));
                data.setPengarang(String.valueOf(rs.getObject(5)));
                data.setPenerbit(String.valueOf(rs.getObject(6)));
                data.setTahunTerbit(String.valueOf(rs.getObject(7)));               
                data.setJumlahHalaman(String.valueOf(rs.getObject(8)));

                dataBuku.add(data);
            }

            DefaultTableModel model = (DefaultTableModel) jTablebuku.getModel();
            model.setRowCount(0);
            for (DataBuku data : dataBuku) {

                Object[] baris = new Object[8];
                baris[0] = data.getIdBuku() ;
                baris[1] = data.getIsbn();
                baris[2] = data.getJudulBuku();
                baris[3] = data.getSubjudul();
                baris[4] = data.getPengarang();
                baris[5] = data.getPenerbit();
                baris[6] = data.getTahunTerbit();
                baris[7] = data.getJumlahHalaman();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gui_Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    ArrayList<DataSkripsi> dataSkripsi;
    
    private void tampil2(Connection conn) {
        
        try {
            String sql = "select * from data_skripsi";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DataSkripsi dataa = new DataSkripsi();
                dataa.setIdSkripsi(String.valueOf(rs.getObject(1)));
                dataa.setJudul(String.valueOf(rs.getObject(2)));
                dataa.setSubJudul(String.valueOf(rs.getObject(3)));
                dataa.setPenulis(String.valueOf(rs.getObject(4)));
                dataa.setTahun(String.valueOf(rs.getObject(5)));
                dataa.setJumlahHalaman(String.valueOf(rs.getObject(5)));
                dataSkripsi.add(dataa);
            }

            DefaultTableModel model = (DefaultTableModel) jTableskripsi.getModel();
            model.setRowCount(0);
            for (DataSkripsi dataa : dataSkripsi) {

                Object[] baris = new Object[6];
                baris[0] = dataa.getIdSkripsi();
                baris[1] = dataa.getJudul();
                baris[2] = dataa.getSubJudul();
                baris[3] = dataa.getPenulis();
                baris[4] = dataa.getTahun();
                baris[5] = dataa.getJumlahHalaman();

                model.addRow(baris);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gui_Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    


    /**
     * Creates new form Gui_Laporan
     */
    public Gui_Laporan() {
        try {
            dataBuku = new ArrayList<>();
            dataSkripsi = new ArrayList<>();
            initComponents();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Uas_Pbo", "postgres", "123");
            tampil(conn);
            tampil2(conn);
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

        tabel_Model1 = new ClassPersistane.Tabel_Model();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablebuku = new javax.swing.JTable();
        jButtoncetak = new javax.swing.JButton();
        jButtonimpor = new javax.swing.JButton();
        jTextFieldbuku = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableskripsi = new javax.swing.JTable();
        jButtoncetak2 = new javax.swing.JButton();
        jButtonimpor2 = new javax.swing.JButton();
        jTextFieldskripsi = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        tabel_Model1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabel_Model1PropertyChange(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(190, 229, 190));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablebuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_buku", "ISBN", "Judul", "Subjudul", "Pengarang", "Penerbit", "Tahun terbit", "Jumlah halaman"
            }
        ));
        jScrollPane1.setViewportView(jTablebuku);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 72, 870, 410));

        jButtoncetak.setText("Cetak");
        jButtoncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncetakActionPerformed(evt);
            }
        });
        jPanel1.add(jButtoncetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 87, 36));

        jButtonimpor.setText("Impor");
        jButtonimpor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonimporActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonimpor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 87, 36));

        jTextFieldbuku.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldbukuKeyReleased(evt);
            }
        });
        jPanel1.add(jTextFieldbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 20, 230, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_buku", "isbn", "judul", "subjudul", "pengarang", "penerbit", "tahun" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 124, 30));

        jTabbedPane1.addTab("Laporan Data Buku", jPanel1);

        jPanel2.setBackground(new java.awt.Color(181, 224, 181));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableskripsi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableskripsi);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 870, 394));

        jButtoncetak2.setText("Cetak");
        jButtoncetak2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncetak2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtoncetak2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 87, 36));

        jButtonimpor2.setText("Impor");
        jPanel2.add(jButtonimpor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 87, 36));

        jTextFieldskripsi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldskripsiKeyReleased(evt);
            }
        });
        jPanel2.add(jTextFieldskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 19, 250, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_skripsi", "judul", "subjudul", "penulis", "tahun" }));
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 19, 117, 30));

        jTabbedPane1.addTab("Laporan Data Skripsi", jPanel2);

        jPanel3.setBackground(new java.awt.Color(188, 214, 188));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(158, 188, 158));

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 32)); // NOI18N
        jLabel1.setText("BoSi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Constantia", 1, 36)); // NOI18N
        jLabel2.setText("Laporan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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
                        .addComponent(jLabel2)
                        .addGap(14, 14, 14))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonimporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonimporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonimporActionPerformed

    private void tabel_Model1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tabel_Model1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_Model1PropertyChange

    private void jButtoncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncetakActionPerformed
        // TODO add your handling code here:
            try {
            String reportPath = "src/Laporan/report1.jrxml";
            String selection = ((String) jComboBox1.getSelectedItem()).toLowerCase();
            String searchTerm = jTextFieldbuku.getText().trim();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT d FROM DataBuku d WHERE ";

            switch (selection) {
                case "id_buku":
                    queryString += "d.idBuku LIKE LOWER (:searchTerm) ";
                    break;
                case "isbn":
                    queryString += "d.isbn LIKE LOWER (:searchTerm) ";
                    break;
                case "judul":
                    queryString += "d.judulBuku LIKE LOWER (:searchTerm)";
                    break;
                case "subjudul":
                    queryString += "d.subjudul LIKE LOWER (:searchTerm)";
                    break;
                case "pengarang":
                    queryString += "d.pengarang LIKE LOWER (:searchTerm)";
                    break;
                case "penerbit":
                    queryString += "d.penerbit LIKE LOWER (:searchTerm)";
                    break;
                case "tahun":
                    queryString += "d.tahunTerbit LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<DataBuku> cq = cb.createQuery(DataBuku.class);
            Root<DataBuku> bok = cq.from(DataBuku.class);
            cq.select(bok);

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<DataBuku> q = em.createQuery(cq);
            List<DataBuku> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<DataBuku> results = query.getResultList();

            // Menyiapkan data untuk laporan
            List<Object[]> data = new ArrayList<>();
            for (DataBuku result : results) {
                Object[] rowData = {
                    result.getIdBuku(),
                    result.getIsbn(),
                    result.getJudulBuku(),
                    result.getSubjudul(),
                    result.getPengarang(),
                    result.getPenerbit(),
                    result.getTahunTerbit(),
                    result.getJumlahHalaman(),};
                data.add(rowData);
            }
            em.getTransaction().commit();
            em.close();
            emf.close();

            // Membuat sumber data untuk JasperReports dari data hasil pencarian
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);

            // Memuat file desain laporan (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Gui_Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtoncetakActionPerformed

    private void jButtoncetak2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncetak2ActionPerformed
        // TODO add your handling code here:
        try {
            String reportPath = "src/Laporan/report2.jrxml";

            String selection = (String) jComboBox2.getSelectedItem();
            String searchTerm = jTextFieldskripsi.getText().trim();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT d FROM DataSkripsi d WHERE ";

            switch (selection.toLowerCase()) {
                case "id_skripsi":
                    queryString += "LOWER (d.idSkripsi) LIKE LOWER (:searchTerm) ";
                    break;
                case "judul":
                    queryString += "LOWER (d.judul) LIKE LOWER (:searchTerm)";
                    break;
                case "subjudul":
                    queryString += "LOWER (d.subJudul) LIKE LOWER (:searchTerm)";
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

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<DataSkripsi> cq = cb.createQuery(DataSkripsi.class);
            Root<DataSkripsi> bok = cq.from(DataSkripsi.class);
            cq.select(bok);

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<DataSkripsi> q = em.createQuery(cq);
            List<DataSkripsi> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");
            
            List<DataSkripsi> results = query.getResultList();

            // Menyiapkan data untuk laporan
            List<Object[]> data = new ArrayList<>();
            for (DataSkripsi result : results) {
                Object[] rowData = {
                    result.getIdSkripsi(),
                    result.getJudul(),
                    result.getSubJudul(),
                    result.getPenulis(),
                    result.getTahun(),
                    result.getJumlahHalaman(),};
                data.add(rowData);
            }
            em.getTransaction().commit();
            em.close();
            emf.close();

            // Membuat sumber data untuk JasperReports dari data hasil pencarian
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);

            // Memuat file desain laporan (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Gui_laporan_Skripsi.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_jButtoncetak2ActionPerformed

    private void jTextFieldbukuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldbukuKeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBox1.getSelectedItem();
            String searchTerm = jTextFieldbuku.getText().trim();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT d FROM DataBuku d WHERE ";

            switch (selection) {
                case "id_buku":
                    queryString += "d.idBuku LIKE LOWER (:searchTerm) ";
                    break;
                case "isbn":
                    queryString += "d.isbn LIKE LOWER (:searchTerm) ";
                    break;
                case "judul":
                    queryString += "d.judulBuku LIKE LOWER (:searchTerm)";
                    break;
                case "subjudul":
                    queryString += "d.subjudul LIKE LOWER (:searchTerm)";
                    break;
                case "pengarang":
                    queryString += "d.pengarang LIKE LOWER (:searchTerm)";
                    break;
                case "penerbit":
                    queryString += "d.penerbit LIKE LOWER (:searchTerm)";
                    break;
                case "tahun":
                    queryString += "d.tahunTerbit LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("No search criteria selected.");
            }

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<DataBuku> query = em.createQuery(queryString, DataBuku.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<DataBuku> results = query.getResultList();

            DefaultTableModel dataModel = new DefaultTableModel();
            // Add columns to the model
            dataModel.addColumn("ID");
            dataModel.addColumn("ISBN");
            dataModel.addColumn("Judul");
            dataModel.addColumn("Subjudul");
            dataModel.addColumn("pengarang");
            dataModel.addColumn("penerbit");
            dataModel.addColumn("TahunTerbit");
            dataModel.addColumn("jumlah halaman");
            // ... tambahkan kolom lain sesuai kebutuhan

            // Add rows to the model
            for (DataBuku result : results) {
                Object[] rowData = {
                    result.getIdBuku(),
                    result.getIsbn(),
                    result.getJudulBuku(),
                    result.getSubjudul(),
                    result.getPengarang(),
                    result.getPenerbit(),
                    result.getTahunTerbit(),
                    result.getJumlahHalaman(),};
                dataModel.addRow(rowData);
            }

            // Set jTable1 with the created model
            jTablebuku.setModel(dataModel);
            System.out.println(results);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldbukuKeyReleased

    private void jTextFieldskripsiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldskripsiKeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBox2.getSelectedItem();

            String searchTerm = jTextFieldskripsi.getText().trim();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT d FROM DataSkripsi d WHERE ";

            switch (selection.toLowerCase()) {
                case "id_skripsi":
                    queryString += "LOWER (d.idSkripsi) LIKE LOWER (:searchTerm) ";
                    break;
                case "judul":
                    queryString += "LOWER (d.judul) LIKE LOWER (:searchTerm)";
                    break;
                case "subjudul":
                    queryString += "LOWER (d.subJudul) LIKE LOWER (:searchTerm)";
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
                    result.getJumlahHalaman(),};
                dataModel.addRow(rowData);
            }

            // Set jTable1 with the created model
            jTableskripsi.setModel(dataModel);
            System.out.println(results);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldskripsiKeyReleased

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
            java.util.logging.Logger.getLogger(Gui_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoncetak;
    private javax.swing.JButton jButtoncetak2;
    private javax.swing.JButton jButtonimpor;
    private javax.swing.JButton jButtonimpor2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTablebuku;
    private javax.swing.JTable jTableskripsi;
    private javax.swing.JTextField jTextFieldbuku;
    private javax.swing.JTextField jTextFieldskripsi;
    private ClassPersistane.Tabel_Model tabel_Model1;
    // End of variables declaration//GEN-END:variables
}
