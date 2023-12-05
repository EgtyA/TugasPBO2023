/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas_pbo;

import ClassPersistane.DataBuku;

import ClassPersistane.PeminjamanBuku;
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

/**
 *
 * @author egty
 */
public class Gui_Peminjaman_Buku extends javax.swing.JFrame {

    public void peringatan(String pesan) {
        JOptionPane.showMessageDialog(rootPane, pesan);
    }
    
    public static String date(Date date){
         SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
         return format.format(date);
    }
       
    private void tampil() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PeminjamanBuku> cq = cb.createQuery(PeminjamanBuku.class);
        
        Root<PeminjamanBuku>pin = cq.from(PeminjamanBuku.class);
        cq.orderBy(cb.asc(pin.get("noPeminjaman")));
        CriteriaQuery<PeminjamanBuku> select = cq.select(pin);
        TypedQuery<PeminjamanBuku> q = em.createQuery(select);
        List<PeminjamanBuku> results = q.getResultList();

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
                
        for (PeminjamanBuku data : results) {
            Object[] baris = new Object[10];
            
            baris[0] = data.getNoPeminjaman();
            
            if (data.getIdBuku() != null) {
                baris[1] = data.getIdBuku().getIdBuku(); 
            }else{
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
    

    private void tampilbuku() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DataBuku> cq = cb.createQuery(DataBuku.class);
        
        Root<DataBuku>d = cq.from(DataBuku.class);
        cq.orderBy(cb.asc(d.get("idBuku")));
        CriteriaQuery<DataBuku> select = cq.select(d);
        TypedQuery<DataBuku> q = em.createQuery(select);
        
        List<DataBuku> results = q.getResultList();
        
        DefaultTableModel model = (DefaultTableModel) jTablebook.getModel();
        model.setRowCount(0);
        for (DataBuku data : results) {
            Object[] baris = new Object[8];
            baris[0] = data.getIdBuku();
            baris[1] = data.getIsbn();
            baris[2] = data.getJudulBuku();
            baris[3] = data.getKategori();
            baris[4] = data.getPengarang();
            baris[5] = data.getPenerbit();
            baris[6] = data.getTahunTerbit();
            baris[7] = data.getJumlahHalaman();
           
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
     * Creates new form Gui_Peminjaman_Buku
     */
    public Gui_Peminjaman_Buku() {
        initComponents(); 
        tampil();
        tampilbuku();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablebook = new javax.swing.JTable();
        jTextField11 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jButtonsimpan = new javax.swing.JButton();
        jButtonupdate = new javax.swing.JButton();
        jButtonhapus = new javax.swing.JButton();
        jButtonkembali = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextFieldcari = new javax.swing.JTextField();
        jComboBoxcari = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jButtonimporbuku = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1caritanggalbuku = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton1refresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        jDialog1.setModalityType(null);
        jDialog1.setSize(new java.awt.Dimension(842, 475));

        jTablebook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_buku", "isbn", "judul_buku", "Kategori", "pengarang", "penerbit", "tahun_terbit", "jumlah_halaman"
            }
        ));
        jTablebook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablebookMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablebook);

        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id_buku", "isbn", "judul", "kategori", "pengarang", "penerbit", "tahunTerbit" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel12.setText("Cari");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(5, 5, 5)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(193, 202, 193));

        jPanel1.setBackground(new java.awt.Color(169, 219, 169));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel1.setText("No_peminjaman");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 30));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("Judul buku");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 30));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setText("Status peminjaman");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 110, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 240, 30));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 240, 30));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal pinjam");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, 20));

        jTextField6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 230, 30));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel5.setText("Tanggal kembali");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 100, 20));

        jTextField7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 230, 28));

        jTextField8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 230, 30));

        jTextField2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 240, 30));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel6.setText("Nama peminjam");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 100, 30));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel7.setText("Nim");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 100, 30));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel8.setText("Prodi");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 100, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dipinjam", "Dikembalikan" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 127, -1));

        jButtonsimpan.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonsimpan.setText("Simpan");
        jButtonsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 100, -1));

        jButtonupdate.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonupdate.setText("Update");
        jButtonupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonupdateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 100, -1));

        jButtonhapus.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonhapus.setText("Hapus");
        jButtonhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonhapusActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 100, -1));

        jButtonkembali.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jButtonkembali.setText("Kembali");
        jButtonkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonkembaliActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 200, 100, -1));

        jTable2.setBackground(new java.awt.Color(179, 195, 179));
        jTable2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setGridColor(new java.awt.Color(204, 204, 204));
        jTable2.setSelectionBackground(new java.awt.Color(0, 102, 51));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 1000, 330));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel11.setText("Angkatan");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 100, 30));

        jTextField9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 210, 30));

        jTextFieldcari.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
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
        jPanel1.add(jTextFieldcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 210, 30));

        jComboBoxcari.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jComboBoxcari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no_peminjaman", "judul", "status_pinjam", "nama", "nim", "no_tlp", "angkatan" }));
        jPanel1.add(jComboBoxcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 150, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Cari");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 30, 30));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 40, 30));
        jPanel1.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 160, -1));

        jButtonimporbuku.setText("Impor");
        jButtonimporbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonimporbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonimporbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 100, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 160, -1));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel15.setText("id_buku");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 100, 30));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 140, -1));

        jButton1caritanggalbuku.setText("Cari");
        jButton1caritanggalbuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1caritanggalbukuActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1caritanggalbuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("s/d");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 30, 20));
        jPanel1.add(jDateChooser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 140, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(51, 51, 51));
        jLabel20.setText("tanggal pinjam");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 20));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Cari berdasarkan");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, 20));

        jButton1refresh.setFont(new java.awt.Font("Calisto MT", 0, 12)); // NOI18N
        jButton1refresh.setText("Refresh");
        jButton1refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1refreshActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 240, 100, -1));

        jTabbedPane1.addTab("Peminjaman Buku", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1020, 740));

        jPanel3.setBackground(new java.awt.Color(190, 216, 190));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 32)); // NOI18N
        jLabel10.setText("Peminjaman Buku");

        jPanel4.setBackground(new java.awt.Color(158, 188, 158));

        jLabel14.setFont(new java.awt.Font("MV Boli", 1, 32)); // NOI18N
        jLabel14.setText("BoSi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 541, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsimpanActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");

        String no_peminjaman = jTextField1.getText();
        String status_pinjam = (String) jComboBox1.getSelectedItem();
        String tanggal_pinjam = format.format(jDateChooser3.getDate());
        String tanggal_kembali = format.format(jDateChooser1.getDate());
        String nama = jTextField6.getText();
        String nim = jTextField7.getText();
        String prodi = jTextField8.getText();
        String angkatan = jTextField9.getText();
        String idBuku = jTextField2.getText();
        String judul_buku = jTextField3.getText();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        DataBuku wm = em.find(DataBuku.class, idBuku);
        PeminjamanBuku b = new PeminjamanBuku();

        b.setNoPeminjaman(no_peminjaman);
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
        b.setAngkatan(angkatan);
        b.setIdBuku(wm);
        b.setJudulBuku(judul_buku);
      
        
        em.persist(b);
        em.getTransaction().commit();
        // akhir persistence
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        tampil();
        kosongkan_form();
        
        try {
            if (b != null) {
                JOptionPane.showMessageDialog(this, "Simpan data Berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextFieldcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldcariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       tampilbuku();
       jDialog1.setVisible(true);
       jDialog1.setLocationRelativeTo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablebookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablebookMouseClicked
        // TODO add your handling code here:
        int baris = jTablebook.rowAtPoint(evt.getPoint());

        String id_buku = jTablebook.getValueAt(baris, 0).toString();
        jTextField2.setText(id_buku);  
        
        String judul_buku = jTablebook.getValueAt(baris, 2).toString();
        jTextField3.setText(judul_buku);       
    }//GEN-LAST:event_jTablebookMouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBox2.getSelectedItem();
            String searchTerm = jTextField11.getText().trim();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
            EntityManager em = emf.createEntityManager();

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT d FROM DataBuku d WHERE ";

            switch (selection) {
                case "id_buku":
                queryString += "LOWER(d.idBuku) LIKE LOWER (:searchTerm) ";
                break;
                case "isbn":
                queryString += "LOWER(d.isbn) LIKE LOWER (:searchTerm) ";
                break;
                case "judul":
                queryString += "LOWER(d.judulBuku) LIKE LOWER (:searchTerm)";
                break;
                case "kategori":
                queryString += "LOWER(d.kategori) LIKE LOWER (:searchTerm)";
                break;
                case "pengarang":
                queryString += "LOWER(d.pengarang) LIKE LOWER (:searchTerm)";
                break;
                case "penerbit":
                queryString += "LOWER(d.penerbit) LIKE LOWER (:searchTerm)";
                break;
                case "tahunTerbit":
                queryString += "LOWER(d.tahunTerbit) LIKE LOWER (:searchTerm)";
                break;
                default:
                throw new IllegalArgumentException("No search criteria selected.");
            }

            // Create and execute the JPA query

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }
            queryString += "ORDER BY d.idBuku ASC";
            TypedQuery<DataBuku> query = em.createQuery(queryString, DataBuku.class);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<DataBuku> results = query.getResultList();

            DefaultTableModel dataModel = new DefaultTableModel();

            // Add columns to the model
            dataModel.addColumn("ID");
            dataModel.addColumn("ISBN");
            dataModel.addColumn("Judul");
            dataModel.addColumn("Kategori");
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
                    result.getKategori(),
                    result.getPengarang(),
                    result.getPenerbit(),
                    result.getTahunTerbit(),
                    result.getJumlahHalaman(),
                };
                dataModel.addRow(rowData);
            }

            // Set jTable1 with the created model
            jTablebook.setModel(dataModel);
            System.out.println(results);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButtonupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonupdateActionPerformed
        // TODO add your handling code here:
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MMMM-dd");

        String no_peminjaman = jTextField1.getText();
        String status_pinjam = (String) jComboBox1.getSelectedItem();
        String tanggal_pinjam = format.format(jDateChooser3.getDate());
        String tanggal_kembali = format.format(jDateChooser1.getDate());
        String nama = jTextField6.getText();
        String nim = jTextField7.getText();
        String prodi = jTextField8.getText();
        String angkatan = jTextField9.getText();
        String idBuku = jTextField2.getText();
        String judul_buku = jTextField3.getText();


        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        
        DataBuku wm = em.find(DataBuku.class, idBuku);
        PeminjamanBuku ba = new PeminjamanBuku();
        ba.setNoPeminjaman(no_peminjaman);
        ba.setStatusPeminjaman(status_pinjam); 
        
        try {
            Date datePeminjaman = format.parse(tanggal_pinjam);
            Date dateKembali = format.parse(tanggal_kembali);
            ba.setTglPeminjamanBuku(datePeminjaman);
            ba.setTglKembaliBuku(dateKembali);
        } catch (ParseException e) {
            // Tangani kesalahan jika terjadi kesalahan parsing tanggal
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        } 
         
        ba.setNamaPeminjam(nama);
        ba.setNim(nim);
        ba.setProgramStudi(prodi);
        ba.setAngkatan(angkatan);
        ba.setIdBuku(wm);
        ba.setJudulBuku(judul_buku);
        
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
        jTextField2.setText("");
        jTextField3.setText("");
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        tampil();
        
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
    }//GEN-LAST:event_jButtonupdateActionPerformed

    private void jButtonhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonhapusActionPerformed
        // TODO add your handling code here:
         String no_peminjaman = jTextField1.getText().trim();

        // awal persistence
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Uas_PBOPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        PeminjamanBuku b = em.find(PeminjamanBuku.class, no_peminjaman);

        em.remove(b);
        em.getTransaction().commit();
        // akhir persistence
         
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        tampil();
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
    }//GEN-LAST:event_jButtonhapusActionPerformed

    private void jButtonkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonkembaliActionPerformed
        // TODO add your handling code here:
        Gui_Menu1 menu = new Gui_Menu1();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonkembaliActionPerformed

    private void jTextFieldcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldcariKeyReleased
        // TODO add your handling code here:
        try {
            String selection = (String) jComboBoxcari.getSelectedItem();
            String searchTerm = jTextFieldcari.getText().trim();

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
             dataModel.addColumn("id_buku");
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
            }else{
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
            jTable2.setModel(dataModel);
            System.out.println(results);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextFieldcariKeyReleased

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.rowAtPoint(evt.getPoint());

        String no_peminjaman = jTable2.getValueAt(baris, 0).toString();
        jTextField1.setText(no_peminjaman);
        
        String id_buku = jTable2.getValueAt(baris, 1).toString();
        jTextField2.setText(id_buku);

        String judul_buku  = jTable2.getValueAt(baris, 2).toString();
        jTextField3.setText(judul_buku);

        String status_pinjam = jTable2.getValueAt(baris, 3).toString();
        jComboBox1.setSelectedItem(status_pinjam);
        
        String pinjam = jTable2.getValueAt(baris, 4).toString();        
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            java.util.Date d=format.parse(pinjam);
            jDateChooser3.setDate(d);
        } catch (ParseException e) {
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        } 
        
        String kembali = jTable2.getValueAt(baris, 5).toString();        
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
            java.util.Date d=format.parse(kembali);
            jDateChooser1.setDate(d);
        } catch (ParseException e) {
            e.printStackTrace(); // Gantilah ini dengan penanganan yang sesuai
        } 
 
        String nama = jTable2.getValueAt(baris, 6).toString();
        jTextField6.setText(nama);
        
        String nim = jTable2.getValueAt(baris, 7).toString();
        jTextField7.setText(nim);

        String prodi = jTable2.getValueAt(baris, 8).toString();
        jTextField8.setText(prodi);

        String angkatan = jTable2.getValueAt(baris, 9).toString();
        jTextField9.setText(angkatan);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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

                    String idBukuFromCSV = csvRecord.get(1);

                    DataBuku wm =  entityManager.find(DataBuku.class, idBukuFromCSV);

                    PeminjamanBuku b = new PeminjamanBuku();
                    b.setNoPeminjaman(csvRecord.get(0));

                    b.setJudulBuku(csvRecord.get(2));
                    b.setStatusPeminjaman(csvRecord.get(3));

                    b.setTglPeminjamanBuku(format.parse(csvRecord.get(4)));
                    b.setTglKembaliBuku(format.parse(csvRecord.get(5)));

                    b.setNamaPeminjam(csvRecord.get(6));
                    b.setNim(csvRecord.get(7));
                    b.setProgramStudi(csvRecord.get(8));
                    b.setAngkatan(csvRecord.get(9));
                    entityManager.persist(b);
                }
            } catch (Exception ex) {
                System.out.println("Error in Parsing CSV File");
            }
            entityManager.getTransaction().commit();

            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0);
            tampil();
        }
    }//GEN-LAST:event_jButtonimporbukuActionPerformed

    private void jButton1caritanggalbukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1caritanggalbukuActionPerformed
        // TODO add your handling code here:
        Date tanggalMulai = jDateChooser2.getDate();
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
        jTable2.setModel(dataModel);
        System.out.println(results);
    }//GEN-LAST:event_jButton1caritanggalbukuActionPerformed

    private void jButton1refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1refreshActionPerformed
        // TODO add your handling code here:
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        jDateChooser4.setDate(null);
        jTextFieldcari.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        tampil();
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1caritanggalbuku;
    private javax.swing.JButton jButton1refresh;
    private javax.swing.JButton jButtonhapus;
    private javax.swing.JButton jButtonimporbuku;
    private javax.swing.JButton jButtonkembali;
    private javax.swing.JButton jButtonsimpan;
    private javax.swing.JButton jButtonupdate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxcari;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTablebook;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldcari;
    // End of variables declaration//GEN-END:variables
}
