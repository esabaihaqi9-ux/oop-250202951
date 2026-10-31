# Catatan Minggu 03: Inheritance

## Yang Saya Kerjakan

Pada minggu ketiga, saya mengerjakan tiga subclass dari `Aset`, yaitu `Ruang`, `Laptop`, dan `AlatLab`.

- `Ruang` memiliki field `kapasitas`.
- `Laptop` memiliki field `spesifikasi` dan `nomorInventaris`.
- `AlatLab` memiliki field `laboratorium` dan `tingkatRisiko`.

Ketiga class tersebut menggunakan `extends Aset` dan memanggil `super(kode, nama)` pada konstruktornya. Setelah itu, masing-masing konstruktor melakukan validasi terhadap field yang dimiliki.

Saya juga menambahkan override pada metode `getJenis()` dengan nilai `RUANG`, `LAPTOP`, dan `ALAT_LAB` sesuai jenis asetnya.

## Keputusan Desain

Saya memilih untuk meletakkan field yang berbeda-beda di masing-masing subclass, bukan di class `Aset`. Alasannya, setiap jenis aset memiliki informasi yang berbeda. Contohnya, `Ruang` membutuhkan kapasitas, sedangkan `Laptop` membutuhkan spesifikasi dan nomor inventaris.

Field yang digunakan bersama, seperti kode, nama, status, dan kondisi, tetap berada di class induk `Aset`.

Untuk field pada subclass, saya menggunakan `private final` karena nilainya tidak perlu diubah setelah objek dibuat. Jadi, saya tidak menambahkan setter.

Pada class `Laptop`, saya membuat metode validasi sendiri untuk memastikan data tidak kosong. Hal ini karena metode validasi di `Aset` menggunakan akses `private`, sehingga tidak bisa langsung digunakan oleh subclass.

Untuk `hitungDenda()` dan `bisaDipinjam()`, belum saya kerjakan karena keduanya merupakan materi untuk minggu berikutnya.

## Contoh Inheritance yang Kurang Tepat Dibandingkan Komposisi

Menurut saya, aturan denda merupakan contoh yang kurang cocok jika dibuat menggunakan inheritance.

Misalnya, setiap jenis aset dibuatkan subclass baru untuk aturan denda flat dan progresif. Nantinya jumlah class akan semakin banyak karena setiap jenis aset memiliki beberapa kemungkinan aturan denda.

Menurut saya, lebih baik menggunakan komposisi dengan membuat objek `AturanDenda` yang bisa digunakan oleh berbagai jenis aset. Dengan begitu, aturan denda bisa diganti tanpa harus membuat subclass baru.

Inheritance lebih cocok digunakan untuk hubungan yang jelas, seperti `Ruang` adalah `Aset` dan `Laptop` adalah `Aset`.

## Kendala

Kendala yang saya temui adalah saat menjalankan pengujian menggunakan script `uji.ps1`. Awalnya PowerShell menolak menjalankan script karena pengaturan Execution Policy.

Saya mencoba mengatasinya dengan perintah:

`powershell -ExecutionPolicy Bypass -File .\scripts\uji.ps1 -Minggu 3`

Setelah itu, script berhasil dijalankan, tetapi muncul masalah lain karena perintah `mvn` belum dikenali oleh PowerShell.

Saya perlu mengatur kembali variabel `MAVEN_HOME` dan menambahkan folder `bin` Maven ke dalam `Path`.

**Hasil pengujian:** (ISI SETELAH TESTING BERHASIL. Tuliskan hasil BUILD SUCCESS atau pesan error yang masih muncul.)

## Penggunaan AI

## Laporan Penggunaan AI

**1. AI yang Digunakan**

Claude (Anthropic).

**2. Tujuan Penggunaan AI**

Saya menggunakan AI untuk membantu mengerjakan materi Inheritance pada Minggu 3, terutama dalam memahami dan membuat subclass dari class `Aset`.

**3. Bagian yang Dibantu AI**

AI membantu dalam pembuatan tiga class, yaitu:
- `Ruang.java`
- `Laptop.java`
- `AlatLab.java`

Bantuan yang diberikan meliputi penentuan field, konstruktor, validasi data, penggunaan `super()`, dan override metode `getJenis()`. AI juga membantu menyusun draf catatan Minggu 3.

**4. Prompt yang Digunakan**

Prompt utama yang saya gunakan adalah:

"Tolong kerjakan minggu ketiga" dengan menyertakan tautan repositori GitHub.

**5. Hasil Penggunaan AI**

Dari bantuan AI, saya mendapatkan contoh implementasi inheritance pada Java. Saya juga menjadi lebih memahami penggunaan `extends`, pemanggilan konstruktor induk menggunakan `super()`, serta penggunaan `@Override` pada subclass.

**6. Evaluasi dan Pemahaman Saya**

Saya menyadari bahwa penggunaan AI dengan prompt yang terlalu singkat membuat saya kurang terlibat dalam proses pengerjaan. Seharusnya saya memahami instruksi dan mencoba membuat kode terlebih dahulu sebelum meminta bantuan AI.

Setelah melihat kembali kode yang dibuat, saya memahami bahwa setiap subclass dapat memiliki field dan validasi masing-masing, sedangkan data yang digunakan bersama tetap berada di class induk `Aset`.

Ke depannya, saya akan menggunakan AI sebagai alat bantu untuk belajar dan mencari solusi ketika mengalami kesulitan, bukan hanya untuk mendapatkan kode yang langsung jadi.
- **Hal yang saya pelajari:** Saya mulai memahami bahwa konstruktor pada subclass harus memanggil `super(kode, nama)` terlebih dahulu. Dengan begitu, validasi dari class induk tetap dijalankan sebelum validasi tambahan pada subclass. Contohnya, jika kode aset kosong, objek tetap akan ditolak meskipun field lainnya sudah diisi dengan benar.

## Pengumpulan

- Commit menggunakan format `minggu-03: ringkasan`.
- Bukti pengujian dilihat dari hasil CI GitHub yang berhasil (hijau) pada commit terakhir sebelum tenggat pengumpulan.