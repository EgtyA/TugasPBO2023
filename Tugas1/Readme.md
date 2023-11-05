# Public, Private, Protected
Public berarti seluruh kode program di luar maupun didalam dari class bisa mengakses atribut maupun method tersebut, termasuk juga untuk class turunannya. 
Private berarti yang bisa mengaksesnya adalah hanya class itu sendiri. Class lain maupun class turunannya tidak bisa mengakses atribut atau method tersebut.
protected berarti yang bisa mengaksesnya adalah class itu sendiri ataupun turunan dari class tersebut.

# Tahapan-tahapan
1. Buat main projek terlebih dahulu dengan nama PboClass. Lalu buat package dengan nama TugasPbo
2. Dalam package TugasPbo buat Class baru dengan nama MakhlukHidup. Class MakhlukHidup ini meruapakan superclass yang sifatnya akan diturunkan kepada kelas turunannya.
3. Dalam Class MakhlukHidup terdapat atribut dan method seperti public nama, public namaIlmiah, public ordo, public kelas, public alatPernafasan, public habitat, protected berkembangbiak, protected bergerak, protected beraktivitas.
4. Agar public nama, public namaIlmiah, public ordo, public kelas, public alatPernafasan, public habitat bisa dibatasi hak akses nya dengan dibuat menjadi private. Caranya kita bisa melakukan refactor dengan klik kanan pada mouse/kursor lalu akan muncul beberapa menu termasuk refactor. Lalu kita pilih refactor lalu pilih encapsulate fields.
5. Pada encapsulate field akan muncul seperti gambar dibawah ini. Kita bisa menklik get dan set untuk atribut atau method yang ingin dijadikan private. Untuk protected bergerak, protected berkembangbiak, dan protected beraktivitas tidak perlu di get&set.
6. Fungsi get dan set adalah untuk memanggil nilai variabel dan untuk menuliskan isi variabel di dalam maupun luar Class MakhlukHidup.   
7. Lalu, agar method protected dari Class MakhlukHidup dapat diturunkan di Class lain, kita bisa melakukan extend dengan membuat Class baru dengan nama Hewan. Lalu pada pilihan super class kita klik browse dan ketik MakhlukHidup. Lalu finish
8. Class hewan extend MakhlukHidup ini akan menjadi turunan dari Class MakhlukHidup dan class turunan ini yang dapat meakses method protected dari Class MakhlukHidup.
9. Selanjutnya, kita bisa membuat Class baru dimana class ini akan menjadi main utama. Kita bisa membuat Class baru lagi dengan nama Berangberang. 
10. Pada Class Berangberang bisa dituliskan main, lalu tuliskan juga isi dari variable variabel dengan menggunakan set. Setelah itu, kita tuliskan juga kode untuk memanggil variabel variabel nya. Untuk yang protected bisa dituliskan variabel nya tanpa get&set.
11. Jika Class Berangberang di run, maka akan muncul seperti gambar dibawah ini.
12. Walaupun menggunakan private, masih bisa diakses pada Class lain karena menggunakan get dan set untuk memanggil nya. Method yang menggunakan protected juga bisa diakses karena Class Hewan sudah di extends dengan Class MakhlukHidup. Class MakhlukHidup, Class hewan dan Class Berangberang juga berada pada package yang sama. 
