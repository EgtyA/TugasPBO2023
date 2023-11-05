# ireport
iReport adalah utilitas (perkakas) pelaporan, yang dikembangkan di lingkungan Java guna membantu user dan developer untuk mendesain laporan secara visual. Melalui antar muka yang simple namun kaya akan fitur, iReport menyediakan fungsi untuk membuat laporan yang kompleks dengan mudah, sehingga akan menghemat banyak waktu.
iReport ini dapat menampilkan laporan dalam bentuk print preview, melakukan export ke beberapa format dokumen lain (antara lain PDF, HTML, text, Excel), menampilkan gambar, grafik maupun tabel. 

# Tahapan-tahapan
1. Pada form Guikaryawan, tambahkan tombol Cetak untuk menampilkan iReport.
2. Pada libraries projek, dapat ditambahkan jar untuk jasperreport, jar untuk beanutils, jar untuk collection, jar untuk digester, jar untuk loggging
3. Setelah itu, kita bisa membuat report di neatbens dengan klik kanan pada package lalu pilih “new” lalu pilih “report wizard”. Kemudian, kita bisa memilih desain report nya terlebih dahulu. Lalu ketik nama untuk file report nya.
4. Lalu kita akan menkoneksikan report ini dengan database yang kita inginkan, lalu menuliskan query “select * from…” untuk menampilkan tabel dan kolom apa saja yang ingin ditampilkan ke report ini.
5. Jika sudah klik finish, maka otomatis report ini akan terbuat. Lalu kita bisa mendesain kembali untuk tampilan report ini sesuai keinginan kita.
6. Setelah desain report selesai, maka kita bisa Kembali ke Jframe form GuiKaryawan untuk menuliskan codingan dari tombol cetak. Codingan dari tombol cetak akan terlihat seperti pada bagian jButtonCetakActionPerformed.   
