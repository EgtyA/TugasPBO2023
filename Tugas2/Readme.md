# Construktor
Constructor adalah method khusus yang akan dieksekusi pada saat pembuatan objek (instance).

# Tahapan-tahapan
1. Pertama buat diagram mengenai Class yang ingin saya buat. Class yang akan saya buat terdiri dari 5 Class, yaitu Class MakhlukHidup, Class Hewan, Class Vertebrata, Class Mammalia, dan Class Berangberang.
2. Selanjutnya, buat Class dengan nama MakhlukHidup. Class ini meruapakan superclass yang sifatnya akan diturunkan kepada kelas turunannya.
3. Dalam Class MakhlukHidup kita buat method dan atribut seperti protected nama, private namaIlmiah, protected alatPernafasan, protected berkembangbiak, dan protected bergerak. Pada Class ini saya akan menuliskan 3 construktor
4. Kita buat class lagi dengan nama Hewan dan di extends dengan Class MakhlukHidup. Dalam Class ini akan berisi atribut dan 3 construktor
5. Kita buat lagi class dengan nama Vertebrata di extends dengan Class hewan. Dalam Class ini akan berisi atribut dan 3 construktor
6. Kita buat lagi class dengan nama Mammalia di extends dengan Class Vertebrata. Dalam Class ini akan berisi atribut dan 3 construktor
7. Kita buat lagi class nama Berangberang di extends dengan Class Mammalia. Dalam Class ini akan berisi atribut dan 3 construktor
8. Selanjutnya, saya akan membuat Class lagi yang digunakan sebagai main utama yaitu Class dengan nama Class MainUtamaTugas2 di package yang berbeda.  
9. Di semua Class tadi, saya membuat 3 buah constructor. Constructor sendiri adalah method yang berfungsi untuk menginisialisasi variabel-variabel instans yang akan dimiliki oleh objek. Ciri constructor yaitu memilki nama yang sama dengan nama Class.
10. Biasanya, pada constructor akan menggunakan kata kunci this dan super. This dan super memilki fungsi tersendiri. This biasa digunakan sebagai referensi dari class itu sendiri. Jadi this hanya bisa digunakan di dalam Class itu saja.
11. Untuk kata kunci super digunakan untuk merepresentasikan objek dari class induk. Misal, Dalam Class MakhlukHidup terdapat atribut String nama. Lalu di Class hewan, saya memanggil String nama dengan menggunakan super. Maka saat di Class main utama dimana saya akan memanggil nama, maka akan muncul nama “berang-berang” yang dituliskan di Class MakhlukHidup
  
