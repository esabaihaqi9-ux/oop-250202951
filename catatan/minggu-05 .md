# Catatan Minggu 05: Abstraction

## 1. Yang Saya Kerjakan

Pada minggu kelima, saya mempelajari dan menerapkan konsep Abstraction (Abstraksi) pada program Aset Pinjam. Pekerjaan yang saya lakukan adalah mengubah kelas `Aset` menjadi `abstract class` dan menjadikan metode `hitungDenda(int)` sebagai metode abstrak.

Dengan perubahan tersebut, setiap subclass, yaitu `Ruang`, `Laptop`, dan `AlatLab`, wajib memiliki implementasi metode `hitungDenda(int)` masing-masing.

Selain itu, saya melengkapi implementasi metode `bisaDipinjam()` dari interface `DapatDipinjam`. Metode ini mengembalikan nilai `true` hanya jika status aset adalah `TERSEDIA` dan kondisi aset bukan `RUSAK_BERAT`.

Saya juga mengimplementasikan interface `AturanDenda` pada dua kelas, yaitu `DendaFlat` dan `DendaProgresif`. Kedua kelas tersebut digunakan untuk menerapkan aturan perhitungan denda yang berbeda.

## 2. Keputusan Desain

Dalam pengerjaan minggu ini, saya membuat beberapa keputusan desain agar program lebih terstruktur dan menghindari pengulangan kode.

- Saya mengubah kelas `Aset` menjadi abstract class karena kelas tersebut menyimpan atribut dan logika umum yang digunakan oleh seluruh jenis aset, seperti kode, nama, status, dan kondisi.
- Metode `hitungDenda(int)` dijadikan abstrak agar setiap subclass memiliki implementasi perhitungan denda sendiri.
- Interface `DapatDipinjam` digunakan sebagai kontrak perilaku untuk menentukan apakah suatu aset dapat dipinjam.
- Interface `AturanDenda` digunakan sebagai kontrak untuk kelas yang menerapkan aturan perhitungan denda.
- Kelas `DendaFlat` hanya meneruskan perhitungan ke metode `aset.hitungDenda(hari)` agar rumus denda dan multiplier setiap jenis aset tetap berada di satu tempat.
- Kelas `DendaProgresif` menggunakan metode `hitungDenda()` agar multiplier jenis aset dan tarif varian NIM tetap diperhitungkan secara otomatis.
- Rumus denda progresif mengikuti asumsi A-03 pada `docs/asumsi.md`, yaitu tujuh hari pertama menggunakan perhitungan flat, sedangkan mulai hari kedelapan setiap tambahan hari dikenakan denda dua kali lipat dari denda satu hari.

Rumus yang digunakan:

`flat(h) + max(0, h - 7) × flat(1)`

## 3. Perbedaan Abstract Class dan Interface

Dari pengerjaan minggu ini, saya memahami bahwa abstract class dan interface memiliki fungsi yang berbeda dalam Java.

**Abstract Class** merupakan kelas yang tidak dapat dibuat objek secara langsung dan dapat digunakan untuk menyimpan atribut, konstruktor, serta metode yang memiliki implementasi maupun metode abstrak. Contohnya adalah kelas `Aset` yang menjadi induk dari `Ruang`, `Laptop`, dan `AlatLab`.

**Interface** merupakan kontrak yang berisi aturan perilaku yang harus diterapkan oleh kelas yang mengimplementasikannya. Contohnya adalah `DapatDipinjam` dan `AturanDenda` yang digunakan untuk mengatur perilaku peminjaman aset dan perhitungan denda.

Dengan demikian, abstract class digunakan untuk menyimpan bagian umum yang dapat diwariskan, sedangkan interface digunakan untuk menentukan kemampuan atau perilaku yang harus dimiliki suatu kelas.

## 4. Kendala

Kendala yang saya temui pada minggu ini adalah ketika menjalankan pengujian menggunakan script `uji.ps1` untuk Minggu 5.

Awalnya saya menjalankan perintah:

`powershell -ExecutionPolicy Bypass -File .\scripts\uji.ps1 -Minggu 5`

Namun, pengujian tidak dapat berjalan karena PowerShell menampilkan pesan error bahwa perintah `mvn` tidak dikenali.

Padahal, Maven sudah terpasang sebelumnya. Setelah diperiksa, ternyata lokasi folder Maven belum aktif pada PATH terminal VS Code yang digunakan.

Untuk mengatasinya, saya mengaktifkan kembali PATH Maven secara manual menggunakan perintah:

`$env:Path += ";$env:USERPROFILE\.maven\maven-3.10.0\bin"`

Setelah itu, saya perlu memeriksa kembali apakah Maven sudah dikenali menggunakan perintah `mvn -version`.

Kendala lainnya adalah memahami perbedaan antara abstract class dan interface, terutama dalam menentukan penggunaannya pada program. Saya perlu memahami bahwa abstract class dapat menyimpan atribut dan logika bersama, sedangkan interface digunakan sebagai kontrak perilaku yang harus diterapkan oleh kelas lain.

## 5. Hasil Pengujian

Pengujian dilakukan menggunakan script `uji.ps1` dengan parameter Minggu 5.

Perintah yang digunakan:

`powershell -ExecutionPolicy Bypass -File .\scripts\uji.ps1 -Minggu 5`

Pengujian mencakup Minggu 1 sampai Minggu 5, yaitu:

- week1
- week2
- week3
- week4
- week5

Pada percobaan pertama, pengujian belum dapat berjalan karena perintah Maven tidak dikenali oleh PowerShell.

**Status hasil pengujian:** Menunggu pengujian ulang setelah konfigurasi PATH Maven diperbaiki.

## 6. Penggunaan AI

- **Alat yang digunakan:** Claude (Anthropic).
- **Bagian yang dibantu AI:** Mengubah kelas `Aset` menjadi abstract class, melengkapi metode `bisaDipinjam()`, membuat implementasi `DendaFlat` dan `DendaProgresif`, menyusun asumsi A-03, serta membantu penyusunan draf catatan Minggu 5.
- **Prompt utama:** "Tolong arahkan saya dan cara menggerjakan mingggu ke 5" disertai tautan repository GitHub.

**Yang saya ubah atau tolak dari saran AI, dan alasannya:**

Saya memeriksa kembali kode yang diberikan AI, terutama pada bagian perhitungan denda progresif. Saya memastikan rumus yang digunakan sesuai dengan asumsi A-03, yaitu tujuh hari pertama dihitung menggunakan denda flat dan mulai hari kedelapan terdapat tambahan denda dua kali lipat dari denda satu hari.

Saya juga memperhatikan penggunaan metode `hitungDenda()` agar perhitungan tetap mengikuti multiplier setiap jenis aset dan tarif varian NIM.

**Satu hal yang saya pahami lebih baik sekarang:**

Saya menjadi lebih memahami konsep abstraction dalam Java, terutama perbedaan abstract class dan interface. Abstract class dapat digunakan untuk menyimpan atribut serta logika umum, sedangkan interface digunakan untuk menentukan kontrak perilaku. Saya juga memahami bahwa abstraksi membantu membuat struktur program lebih rapi dan memudahkan pengembangan kode.

## 7. Pengumpulan

Setelah seluruh pengujian berhasil, perubahan akan disimpan menggunakan commit dengan format:

`minggu-05: ringkasan`

Selanjutnya, perubahan akan di-push ke repository GitHub dan hasil pengujian CI akan diperiksa untuk memastikan proses build berhasil.