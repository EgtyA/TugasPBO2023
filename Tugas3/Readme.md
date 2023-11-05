# Interface
Interface adalah Class yang tidak memilki tubuh pada method-methodnya karena method tersebut harus diimplementasikan dalam kelas turunan nya. 
Jadi, interface berfungsi sebagai penghubung antara sesuatu yang ‘abstrak’ dengan sesuatu yang nyata. 

# Method Override dan Method Overload
Method override adalah sebuah situasi dimana method class turunan menimpa method milik parent class. Ini bisa terjadi jika terdapat nama method yang sama baik di child class dan juga parent class.

Method overload adalah method yang memilki nama variabel yang sama dalam satu Class namun, parameternya yang berbeda.

# Tahapan-tahapan
1. Pertama buat diagram mengenai Class yang ingin saya buat. Jadi, Class yang akan saya buat terdiri dari 3 Class, yaitu Class Orang sebagai kelas parent. Subclass nya adalah Class OrangMedan, Class OrangAceh.
   Pada Class OrangMedan nantinya akan diimplementasikan dengan 3 interface yaitu Mahasiswa, PenjagaPerpustakaan, Novelis.
2. Kemudian, buat Class baru dengan nama Class Orang. Dalam Class Orang kita buat atribut, construktor, dan method seperti Private String hobi, Private String jenisKelamin, Protected String jenisBaju, Private String domisili,
   Constructor, dan method public String menghadiriKuliah.
3. Kita buat class lagi (subClass) dengan nama OrangMedan dan di extends dengan Class Orang. Dalam subClass ini akan berisi 2 construktor.
4. Kita buat class lagi (subClass) dengan nama OrangAceh dan di extends dengan Class Orang. Dalam subClass ini akan berisi 2 constructor.
5. Kemudian saya akan membuat 3 interface yaitu Mahasiswa, PenjagaPerpustakaan, Novelis. Dalam interface Mahasiswa terdapat method mengerjakanTugas. Dalam interface PenjagaPerpustakaan terdapat method jagaPerpustakaan. Dalam interface Novelis terdapat method menulisCerita.
6. Interface yang sudah dibuat tadi akan saya implementasikan kedalam Class OrangMedan. Cara meimplementasikannya yaitu dengan menambahkan kata “implements Mahasiswa, PenjagaPerpustakaan, Novelis” disebelah kata extends Orang. Kemudian dibawahnya dituliskan perintah dari method yang terdapat pada interface Mahasiswa, PenjagaPerpustakaan, dan Novelis.   
       
