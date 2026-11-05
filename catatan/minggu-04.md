# Catatan Minggu 04: Polymorphism

## 1. Yang Saya Kerjakan

Pada minggu keempat, saya mempelajari dan menerapkan konsep Polymorphism pada program Aset Pinjam. Pekerjaan yang saya lakukan adalah meng-override metode `hitungDenda(int)` pada tiga subclass, yaitu `Ruang`, `Laptop`, dan `AlatLab`.

Setiap jenis aset memiliki perhitungan denda yang berbeda. Rumus yang digunakan adalah jumlah hari keterlambatan dikalikan multiplier jenis aset dan tarif denda per hari dari varian yang sedang aktif.

Multiplier yang digunakan:
- Ruang: 1 kali tarif denda.
- Laptop: 2 kali tarif denda.
- AlatLab: 4 kali tarif denda.

Selain itu, saya membuat dua metode pencarian atau overloading pada kelas `KatalogAset`, yaitu `cari(String kata)` dan `cari(String kata, JenisAset jenis)`. Kedua metode tersebut digunakan untuk mencari aset berdasarkan nama dan berdasarkan nama sekaligus jenis aset.

## 2. Keputusan Desain

Dalam pengerjaan minggu ini, saya membuat beberapa keputusan desain agar kode lebih mudah dipahami dan tidak terjadi pengulangan kode.

- Saya membuat metode `protected final dendaDenganMultiplier(...)` pada kelas `Aset` untuk menangani rumus perhitungan denda dan validasi hari keterlambatan.
- Setiap subclass tetap memiliki metode `hitungDenda(int)` masing-masing dengan multiplier yang berbeda.
- Perhitungan denda menggunakan tipe data `long` untuk mengurangi risiko terjadinya overflow ketika jumlah hari keterlambatan besar.
- Metode `cari(kata, jenis)` menggunakan hasil dari `cari(kata)` kemudian menyaringnya berdasarkan jenis aset.
- Pencarian nama menggunakan `toLowerCase(Locale.ROOT)` agar tidak bergantung pada pengaturan bahasa komputer.
- Jika parameter `kata` atau `jenis` bernilai `null`, program akan melempar `IllegalArgumentException` agar kesalahan dapat diketahui dengan jelas.

## 3. Perbedaan Overloading dan Overriding

Dari pengerjaan minggu ini, saya memahami bahwa overloading dan overriding merupakan dua konsep yang berbeda dalam Java.

**Overriding** adalah proses ketika subclass membuat ulang metode dari superclass dengan nama dan parameter yang sama, tetapi memiliki implementasi yang berbeda. Contohnya adalah metode `hitungDenda(int)` pada kelas `Ruang`, `Laptop`, dan `AlatLab`.

**Overloading** adalah penggunaan beberapa metode dengan nama yang sama, tetapi memiliki parameter yang berbeda. Contohnya adalah dua metode `cari()` pada kelas `KatalogAset`, yaitu `cari(String kata)` dan `cari(String kata, JenisAset jenis)`.

## 4. Kendala

Kendala yang saya temui pada minggu ini adalah saat menjalankan pengujian menggunakan script `uji.ps1`. Awalnya PowerShell tidak mengenali perintah script karena harus menggunakan awalan `.\`. Setelah itu, script tidak bisa dijalankan karena Execution Policy membatasi eksekusi file PowerShell. Saya mengatasinya dengan menggunakan `ExecutionPolicy Bypass`.

Kendala berikutnya adalah perintah `mvn` tidak dikenali oleh PowerShell, meskipun Maven sudah terpasang sebelumnya. Setelah diperiksa, ternyata lokasi folder Maven belum masuk ke PATH karena berada di dalam folder `maven-3.10.0\bin`. Saya kemudian menambahkan lokasi tersebut ke PATH secara manual sehingga Maven 3.10.0 dan Java 21 berhasil terdeteksi.

Setelah masalah konfigurasi tersebut ditemukan, saya dapat melanjutkan proses pengujian Minggu 4.

## 5. Hasil Pengujian

Pengujian dilakukan menggunakan script `uji.ps1` dengan parameter Minggu 4.

Perintah yang digunakan:

`powershell -ExecutionPolicy Bypass -File .\scripts\uji.ps1 -Minggu 4`

Pengujian mencakup Minggu 1 sampai Minggu 4, yaitu week1, week2, week3, dan week4.

**Status hasil pengujian:** Menunggu hasil akhir pengujian Maven.

## 6. Penggunaan AI

- **Alat yang digunakan:** Claude (Anthropic).
- **Bagian yang dibantu AI:** Implementasi metode `hitungDenda` pada kelas `Aset`, `Ruang`, `Laptop`, dan `AlatLab`, dua metode `cari` pada kelas `KatalogAset`, serta penyusunan draf catatan Minggu 4.
- **Prompt utama:** " disertai tautan repository GitHub.Tolong arahkan saya dan cara menggerjakan mingggu ke 4"
**Yang saya ubah atau tolak dari saran AI, dan alasannya:**

Saya memeriksa kembali kode yang diberikan AI dan menyesuaikannya dengan struktur program yang sudah dibuat pada minggu sebelumnya. Saya juga memastikan bahwa setiap subclass memiliki multiplier denda yang berbeda dan menggunakan metode dari kelas induk agar kode tidak ditulis berulang kali.

**Satu hal yang saya pahami lebih baik sekarang:**

Saya menjadi lebih memahami konsep polymorphism dalam Java, terutama perbedaan overriding dan overloading. Overriding memungkinkan subclass memiliki implementasi metode sendiri, sedangkan overloading memungkinkan beberapa metode memiliki nama yang sama dengan parameter berbeda.

## 7. Pengumpulan

Setelah seluruh pengujian berhasil, perubahan akan disimpan menggunakan commit dengan format:

`minggu-04: ringkasan`

Selanjutnya, perubahan akan di-push ke repository GitHub dan hasil pengujian CI akan diperiksa untuk memastikan proses build berhasil.