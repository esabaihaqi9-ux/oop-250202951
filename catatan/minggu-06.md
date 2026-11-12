# Catatan Minggu 06: UML dan SOLID

## 1. Yang Saya Kerjakan

Pada minggu keenam, saya mengerjakan dokumentasi desain program Aset Pinjam menggunakan UML (Unified Modeling Language) dan mempelajari penerapan prinsip SOLID dalam pemrograman berorientasi objek.

Pekerjaan yang saya lakukan meliputi pembuatan Class Diagram, Sequence Diagram, dan dokumentasi penjelasan prinsip SOLID. Untuk Class Diagram, saya membaginya menjadi tiga bagian agar hubungan antarclass lebih mudah dibaca dan dipahami, yaitu:

1. Diagram paket `kontrak` dan `model`.
2. Diagram paket `denda`, `jadwal`, `katalog`, `factory`, `config`, dan `exception`.
3. Diagram paket `dao`.

Selain itu, saya membuat Sequence Diagram untuk menggambarkan proses pengajuan peminjaman aset, mulai dari proses pengajuan sampai hasil yang diterima. Diagram tersebut memiliki dua skenario, yaitu pengajuan berhasil dan pengajuan gagal karena terjadi bentrok. Saya menggunakan fragmen `alt` untuk membedakan kedua kondisi tersebut.

Semua diagram dibuat menggunakan Mermaid dengan format file `.mmd`, kemudian diekspor menjadi gambar `.png` agar lebih mudah dilihat. Saya juga membuat dokumentasi prinsip SOLID pada file `solid.md` dan melakukan sedikit perubahan pada class `Aset.java`.

## 2. Keputusan Desain

Dalam pengerjaan minggu keenam, saya membuat beberapa keputusan desain berdasarkan struktur kode program yang sudah tersedia.

- Diagram dibuat mengikuti kondisi kode program saat ini, bukan hanya berdasarkan rancangan ideal. Beberapa method seperti `JadwalPeminjaman.ajukan()` dan `bentrok()` masih dalam tahap TODO dan akan dikerjakan pada minggu berikutnya.
- Saya menggunakan hubungan Aggregation pada `JadwalPeminjaman` dan `KatalogAset` karena objek `Peminjaman` dan `Aset` dibuat dari luar kemudian dimasukkan ke dalam koleksi.
- Saya tidak menggunakan Composition karena objek yang dimiliki masih dapat berdiri sendiri meskipun objek yang menampungnya dihapus.
- Prinsip SOLID yang saya dokumentasikan adalah Open/Closed Principle (OCP) dan Liskov Substitution Principle (LSP).
- Penerapan OCP terlihat pada class `Aset` dan `AturanDenda`, sedangkan LSP diterapkan melalui hubungan pewarisan antara `Aset` dengan subclass `Ruang`, `Laptop`, dan `AlatLab`.

Saya juga melakukan refactor pada method `getJenis()` di class `Aset`. Sebelumnya, method tersebut merupakan method konkret yang melempar `UnsupportedOperationException`. Kemudian saya mengubahnya menjadi method abstract karena setiap subclass sudah memiliki implementasi masing-masing melalui override method `getJenis()`.

## 3. Perbedaan Aggregation dan Composition

Pada minggu ini saya juga mempelajari perbedaan antara Aggregation dan Composition dalam UML.

Aggregation merupakan hubungan kepemilikan yang bersifat lemah, yaitu objek bagian masih dapat berdiri sendiri tanpa bergantung sepenuhnya pada objek utama.

Sedangkan Composition merupakan hubungan kepemilikan yang lebih kuat, yaitu objek bagian memiliki ketergantungan terhadap objek utama sehingga siklus hidupnya berkaitan dengan objek tersebut.

Dalam program Aset Pinjam, saya menggunakan Aggregation pada hubungan `KatalogAset` dengan `Aset` serta `JadwalPeminjaman` dengan `Peminjaman`, karena objek-objek tersebut dibuat dari luar dan dimasukkan ke dalam koleksi.

## 4. Kendala

Beberapa kendala yang saya temui selama pengerjaan minggu keenam adalah:

1. Saya perlu memahami kembali hubungan antarclass agar Class Diagram yang dibuat sesuai dengan struktur kode program.
2. Saya sempat mengalami kesulitan dalam menentukan penggunaan relasi Aggregation dan Composition karena keduanya sama-sama menggambarkan hubungan kepemilikan antarobjek.
3. Saya perlu menyesuaikan Sequence Diagram dengan alur program yang sebenarnya, terutama karena beberapa method masih dalam tahap TODO.
4. Saya juga perlu membagi Class Diagram menjadi beberapa bagian agar diagram tidak terlalu padat dan hubungan antarclass lebih mudah dibaca.

Untuk mengatasi kendala tersebut, saya memeriksa kembali struktur package, atribut, method, serta hubungan inheritance pada kode program. Saya juga mempelajari kembali fungsi masing-masing relasi UML dan menggunakan Mermaid untuk membuat serta mengekspor diagram.

## 5. Hasil Pengujian

Pada minggu keenam, pengujian dilakukan untuk memastikan berkas dokumentasi UML sudah tersedia sesuai dengan ketentuan tugas.

Berkas yang dibuat dan disimpan dalam folder `docs/uml/` meliputi:

- Class Diagram dalam format `.mmd`.
- Hasil ekspor Class Diagram dalam format `.png`.
- Sequence Diagram pengajuan peminjaman dalam format `.mmd`.
- Hasil ekspor Sequence Diagram dalam format `.png`.
- Dokumentasi prinsip SOLID pada file `solid.md`.

Selain itu, dilakukan perubahan pada method `getJenis()` di class `Aset.java` menjadi abstract.

Pengujian otomatis menggunakan perintah berikut:

`powershell -ExecutionPolicy Bypass -File .\scripts\uji.ps1 -Minggu 6`

Pengujian ini memeriksa keberadaan file Class Diagram, Sequence Diagram, dan dokumentasi `solid.md` dengan panjang minimal 300 karakter.

**Status pengujian:** Menunggu hasil menjalankan perintah pengujian Minggu 06.

## 6. Penggunaan AI

Dalam pengerjaan minggu keenam, saya menggunakan bantuan AI, yaitu Claude (Anthropic), untuk membantu proses pengerjaan dan penyusunan dokumentasi.

Bagian yang dibantu oleh AI meliputi:

1. Membantu membuat draf Class Diagram menggunakan Mermaid.
2. Membantu membuat draf Sequence Diagram pengajuan peminjaman.
3. Membantu menyusun dokumentasi prinsip SOLID pada file `solid.md`.
4. Membantu melakukan refactor method `Aset.getJenis()` menjadi abstract.
5. Membantu menyusun catatan dan laporan kegiatan Minggu 06.

Prompt utama yang saya gunakan adalah:

"Bantu saya mengerjakan dan mengarahkan cara mengerjakan minggu 6 dan membuat diagramnya ", disertai tautan repository GitHub sebagai referensi pengerjaan.

Setelah mendapatkan bantuan AI, saya tetap perlu memeriksa kembali hasil diagram dan kode program agar sesuai dengan struktur program Aset Pinjam. Saya juga menyesuaikan hubungan antarclass, penggunaan Aggregation, serta perubahan method `getJenis()` agar sesuai dengan kebutuhan program.

## 7. Kesimpulan

Dari pengerjaan minggu keenam, saya mendapatkan pemahaman mengenai penggunaan UML untuk menggambarkan struktur dan alur kerja sebuah program. Saya juga lebih memahami perbedaan Aggregation dan Composition serta penerapan prinsip SOLID, khususnya OCP dan LSP.

Melalui pembuatan Class Diagram dan Sequence Diagram, saya dapat melihat hubungan antarclass serta memahami alur pengajuan peminjaman aset dengan lebih jelas. Selain itu, perubahan method `getJenis()` menjadi abstract membantu membuat struktur pewarisan class menjadi lebih sesuai dengan konsep pemrograman berorientasi objek.