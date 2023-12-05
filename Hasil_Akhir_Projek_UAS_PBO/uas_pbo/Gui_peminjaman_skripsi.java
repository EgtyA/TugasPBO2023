/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import ClassPersistane.DataSkripsi;
import ClassPersistane.PeminjamanBuku;
import ClassPersistane.PeminjamanSkripsi;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
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
         SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
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
            
            if (data.getIdSkripsi() != null) {
                baris[1] = data.getIdSkripsi().getIdSkripsi(); 
            }else{
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
        jTextField3.setText("");
        jComboBox1.getSelectedItem();
        jDateChooser3.setDate(null);
        jDateChooser1.setDate(null);
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField2.setText("");
        jTextField9.setText("");
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
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
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
        jButtonimporskripsi = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButtoncaritanggalskripsi = new javax.swing.JButton();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jButton1refresh = new javax.swing.JButton();

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        jLabel10.setText("Peminjaman Skripsi");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 25, 383, -1));

        jPanel4.setBackground(new java.awt.Color(158, 188, 158));

        jLabel14.setFont(new java.awt.Font("MV Boli", 1, 32)); // NOI18N
        jLabel14.setText("BoSi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, 60));

        jPanel2.setBackground(new java.awt.Color(169, 216, 169));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel1.setText("No_peminjaman");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 110, 20));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("Judul skripsi");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 100, 30));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setText("Status peminjaman");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 110, 30));

        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 240, -1));

        jTextField3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 240, 30));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal pinjam");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, 20));

        jTextField6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 230, 30));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setText("Tanggal kembali");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 100, 20));

        jTextField7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 220, 28));

        jTextField8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 220, 30));

        jTextField2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 240, 30));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setText("Nama peminjam");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 100, 30));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel7.setText("Nim");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 90, 30));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel8.setText("Prodi");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 90, 30));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel9.setText("Id skripsi");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, 30));

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dipinjam", "Dikembalikan" }));
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 127, 30));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel11.setText("Angkatan");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 90, 30));

        jTextField9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel2.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 220, 30));

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
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 40, 30));
        jPanel2.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 160, -1));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 160, -1));

        jButtonsimpan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonsimpan.setText("Simpan");
        jButtonsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 90, 30));

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
                "No peminjaman", "Id skripsi", "Judul skripsi", "Status peminjaman", "Tgl_pinjam", "Tgl_kembali", "Nama peminjam", "Nim", "Prodi", "Angkatan"
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 1040, 330));

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
        jPanel2.add(jTextFieldcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 220, 30));

        jComboBoxcari.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jComboBoxcari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no_peminjaman", "judul", "status_pinjam", "nama", "nim", "prodi", "angkatan" }));
        jPanel2.add(jComboBoxcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 150, 30));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Cari");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 30, 30));

        jButtonupdate1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonupdate1.setText("Update");
        jButtonupdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonupdate1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonupdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 90, 30));

        jButtonhapus1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonhapus1.setText("Hapus");
        jButtonhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapus1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonhapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 90, 30));

        jButtonkembali1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonkembali1.setText("Kembali");
        jButtonkembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonkembali1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonkembali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 200, 90, 30));

        jButtonimporskripsi.setText("Impor");
        jButtonimporskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonimporskripsiActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonimporskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 90, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("s/d");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, 30, 20));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("tanggal pinjam");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 90, 20));
        jPanel2.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 140, -1));

        jButtoncaritanggalskripsi.setText("Cari");
        jButtoncaritanggalskripsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncaritanggalskripsiActionPerformed(evt);
            }
        });
        jPanel2.add(jButtoncaritanggalskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 310, -1, -1));
        jPanel2.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 140, -1));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Cari berdasarkan");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 100, 20));

        jButton1refresh.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButton1refresh.setText("Refresh");
        jButton1refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1refreshActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
        String judul_skripsi = jTextField3.getText();
        String status_pinjam = (String) jComboBox1.getSelectedItem();
        String tanggal_pinjam = format.format(jDateChooser3.getDate());
        String tanggal_kembali = format.format(jDateChooser1.getDate());
        String nama = jTextField6.getText();
        String nim = jTextField7.getText();
        String prodi = jTextField8.getText();
        String angkatan = jTextField9.getText();
        String idSkripsi = jTextField2.getText();
        
        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        DataSkripsi wm = em.find(DataSkripsi.class, idSkripsi);
        
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
        s.setAngkatan(angkatan); 
        s.setIdSkripsi(wm);
               
        em.persist(s);
        em.getTransaction().commit();
        // akhir persistence
        
        DefaultTableModel model = (DefaultTableModel) jTable2pinjam.getModel();
        model.setRowCount(0);
        tampilskripsi();
        kosongkan_form();
        
        try {
            if (s != null) {
                JOptionPane.showMessageDialog(this, "Simpan Berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak berhasil disimpan", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            Logger.getLogger(Gui_Buku_1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_jButtonsimpanActionPerformed

    private void jTable2pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2pinjamMouseClicked
        // TODO add your handling code here:
        int baris = jTable2pinjam.rowAtPoint(evt.getPoint());

        String no_peminjaman = jTable2pinjam.getValueAt(baris, 0).toString();
        jTextField1.setText(no_peminjaman);
        
        String id_skripsi = jTable2pinjam.getValueAt(baris, 1).toString();
        jTextField2.setText(id_skripsi);

        String judul_buku  = jTable2pinjam.getValueAt(baris, 2).toString();
        jTextField3.setText(judul_buku);

        String status_pinjam = jTable2pinjam.getValueAt(baris, 3).toString();
        jComboBox1.setSelectedItem(status_pinjam);

        String pinjam = jTable2pinjam.getValueAt(baris, 4).toString();        
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            java.util.Date d=format.parse(pinjam);
            jDateChooser3.setDate(d);
        } catch (ParseException e) {
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        } 
        
        String kembali = jTable2pinjam.getValueAt(baris, 5).toString();        
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            java.util.Date d=format.parse(kembali);
            jDateChooser1.setDate(d);
        } catch (ParseException e) {
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        } 
        
        String nama = jTable2pinjam.getValueAt(baris, 6).toString();
        jTextField6.setText(nama);

        String nim = jTable2pinjam.getValueAt(baris, 7).toString();
        jTextField7.setText(nim);

        String prodi = jTable2pinjam.getValueAt(baris, 8).toString();
        jTextField8.setText(prodi);
        
        String angkatan = jTable2pinjam.getValueAt(baris, 9).toString();
        jTextField9.setText(angkatan);
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
                if (data.getIdSkripsi() != null) {
                baris[1] = data.getIdSkripsi().getIdSkripsi(); 
                }else{
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
        String judul_skripsi = jTextField3.getText();
        String status_pinjam = (String) jComboBox1.getSelectedItem();
        String tanggal_pinjam = format.format(jDateChooser3.getDate());
        String tanggal_kembali = format.format(jDateChooser1.getDate());
        String nama = jTextField6.getText();
        String nim = jTextField7.getText();
        String prodi = jTextField8.getText();
        String angkatan = jTextField9.getText();
        String idSkripsi = jTextField2.getText();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();

        DataSkripsi wm = em.find(DataSkripsi.class, idSkripsi);
        
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
        ba.setAngkatan(angkatan);
        ba.setIdSkripsi(wm);
       
        em.getTransaction().begin();
        em.merge(ba);
        em.getTransaction().commit();
        // akhir persistence

        DefaultTableModel model = (DefaultTableModel) jTable2pinjam.getModel();
        model.setRowCount(0);
        tampilskripsi();
        kosongkan_form();

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

        String id_skripsi = jTableskripsi.getValueAt(baris, 0).toString();
        jTextField2.setText(id_skripsi); 
        
        String judul_skripsi = jTableskripsi.getValueAt(baris, 1).toString();
        jTextField3.setText(judul_skripsi); 
    }//GEN-LAST:event_jTableskripsiMouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

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
                    //                    s.setIdSkripsi(csvRecord.get(8));
                    s.setAngkatan(csvRecord.get(9));
                    entityManager.persist(s);
                }
            } catch (Exception ex) {
                System.out.println("Error in Parsing CSV File");
            }
            entityManager.getTransaction().commit();

            DefaultTableModel model = (DefaultTableModel) jTable2pinjam.getModel();
            model.setRowCount(0);
            tampilskripsi();
        }
    }//GEN-LAST:event_jButtonimporskripsiActionPerformed

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
        jTable2pinjam.setModel(dataModel);
        System.out.println(results);
    }//GEN-LAST:event_jButtoncaritanggalskripsiActionPerformed

    private void jButton1refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1refreshActionPerformed
        // TODO add your handling code here:
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        jDateChooser4.setDate(null);
        jTextFieldcari.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable2pinjam.getModel();
        model.setRowCount(0);
        tampilskripsi();
    }//GEN-LAST:event_jButton1refreshActionPerformed

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
    private javax.swing.JButton jButton1refresh;
    private javax.swing.JButton jButtoncaritanggalskripsi;
    private javax.swing.JButton jButtonhapus1;
    private javax.swing.JButton jButtonimporskripsi;
    private javax.swing.JButton jButtonkembali1;
    private javax.swing.JButton jButtonsimpan;
    private javax.swing.JButton jButtonupdate1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2data;
    private javax.swing.JComboBox<String> jComboBoxcari;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField3data;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldcari;
    // End of variables declaration//GEN-END:variables
}
