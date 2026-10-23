# Catatan Minggu 01: Paradigma Pemrograman dan Setup

Bobot: Quiz 2%, Praktikum 3%, Observasi 1%.

## Tujuan

- Membedakan paradigma prosedural, OOP, dan functional lewat satu program kecil yang sama.
- Menyiapkan JDK 21, Maven, Git, dan repo.

## Keputusan desain

Pada gaya prosedural, saya menggunakan fungsi statis `sapa()` yang menerima nama dan NIM sebagai parameter. Pada gaya OOP, saya menggunakan class `HelloOOP` dengan field `private final` dan metode `sapa()`. Pada gaya fungsional, saya menggunakan `Function<String, String>` dan lambda yang dikembalikan oleh metode `pembuatSapaan()`. Ketiga gaya menggunakan format sapaan yang sama agar mudah dibandingkan.

Untuk sistem peminjaman aset, gaya prosedural cocok untuk alur sederhana, OOP cocok untuk mengelompokkan data dan perilaku aset, sedangkan gaya fungsional cocok untuk operasi yang dapat dibuat sebagai fungsi dan digunakan kembali.

Kelebihan dan keterbatasan setiap gaya:

- **Prosedural**
  - Kelebihan: Alur peminjaman, pengembalian, dan perhitungan denda mudah diikuti.
  - Keterbatasan: Jika fitur bertambah, jumlah fungsi dapat menjadi banyak dan pengelolaan data lebih sulit.
- **OOP**
  - Kelebihan: Data aset dan perilaku peminjaman dapat dikelompokkan dalam class sehingga lebih mudah dikembangkan.
  - Keterbatasan: Perlu merancang class, atribut, dan hubungan antarkelas.
- **Fungsional**
  - Kelebihan: Fungsi dapat digunakan kembali dan membantu mengurangi perubahan state yang tidak diperlukan.
  - Keterbatasan: Lambda dan fungsi tingkat tinggi yang terlalu banyak dapat membuat alur program lebih sulit dipahami.

## Kendala

Kendala yang saya temui adalah pengujian gagal karena properti NIM tidak terbaca. Setelah memeriksa file hasil build, saya menemukan adanya BOM UTF-8 di awal file `mahasiswa.properties`. Saya menyimpan ulang file menggunakan UTF-8 tanpa BOM, membersihkan hasil build, lalu menjalankan pengujian kembali hingga berhasil.

## Penggunaan AI

- **Alat yang dipakai:** ChatGPT untuk menyelesaikan masalah tadi , Claude untuk memahami isinya dan tugasnya , CoPilot untuk membantu saya menulis baris kode yang baik dan benar
- **Bagian yang dibantu AI:** Pemeriksaan `HelloProsedural.java`, `HelloOOP.java`, `HelloFungsional.java`, dan penelusuran masalah `mahasiswa.properties`.
- **Prompt utama:**
  1. Membantu memeriksa ketiga file Java Minggu 1 agar sesuai dengan aturan tugas.
  2. Membantu menelusuri dan memperbaiki error pengujian Maven pada `mahasiswa.properties`.
- **Yang saya ubah atau tolak dari saran AI, dan alasannya:** Saya tidak mengubah `Varian.java` karena file tersebut disediakan dosen dan instruksinya menyatakan agar tidak diubah. Saya memeriksa hasil pengujian dan memperbaiki konfigurasi setelah penyebab masalah ditemukan.
- **Satu hal yang saya pahami lebih baik sekarang:** Saya memahami perbedaan gaya prosedural, OOP, dan fungsional, serta bahwa BOM UTF-8 dapat menyebabkan nama properti pertama pada file konfigurasi Java tidak terbaca sesuai harapan.

## Pengumpulan

- Commit dengan format `minggu-01: ringkasan`.
- Isi `catatan/minggu-01.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat. .
