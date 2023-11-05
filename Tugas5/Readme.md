# GUI (Graphic User Interface)
GUI adalah antarmuka sistem operasi berbasis grafis seperti ikon, tombol, menu, dan representasi visual lainnya untuk mendukung interaksi pengguna dengan sistem.

# Tahapan-tahapan
Untuk source code nya dapat dilihat di GuiKaryawan.java

1. Disini, saya menggunakan database yang sama seperti pada tugas4. Jadi, Cara koneksikan database dengan neatbens dapat dilihat di folder Tugas4
2. Kita buat JFrame Form baru dengan klik kanan pada package TampilanGuiDb. Lalu klik JFrame Form. Lalu beri nama GuiKaryawan
3. Pada Form GuiKaryawan ini, akan dibuat frame yang terdiri dari id_departemen, id_karyawan, Nama, Alamat. Untuk tombol nya terdapat tombol Simpan, Update, Hapus. Lalu, terdapat tabel untuk menampilkan data-data pada tabel Karywan.
4. Lalu, kita bisa membuat Class baru dengan nama Class Karyawan yang nantinya akan digunakan untuk input data pada from GuiKaryawan.
5. Kemudian, kita bisa membuat perintah INSERT, UPDATE, dan DELETE dalam Form GuiKaryawan
6. Lalu, untuk menampilkan data karyawan pada jtable, kita dapat menggunakan perintah SELECT. Lalu, agar data di tabel ketika diklik akan muncul di textbox, maka dapat menggunakan perintah seperti pada bagian JTableKaryawanMouseClicked
7. Selanjutnya, kita akan mengisi Button Simpan ini dengan source code seperti pada bagian jButtonSimpanActionPerformed
8. Selanjutnya, kita akan mengisi Button Update ini dengan source code seperti pada bagian jButton2UpdateActionPerformed
9. Selanjutnya, kita akan mengisi Button Hapus dengan source code seperti pada bagian jButton3ActionPerformed
