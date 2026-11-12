# Prinsip SOLID pada Aset-Pinjam

Dua prinsip yang saya tunjukkan: **OCP (Open/Closed Principle)** dan **LSP (Liskov Substitution Principle)**.
Keduanya saya rujuk ke kode yang sudah ada di `core/`, bukan ke rancangan ideal.

## 1. OCP: terbuka untuk perluasan, tertutup untuk perubahan

**Kelas terkait:** `Aset`, `Ruang`, `Laptop`, `AlatLab`, `AturanDenda`, `DendaFlat`, `DendaProgresif`.

- `DendaFlat` dan `DendaProgresif` hanya memanggil `aset.hitungDenda(hari)`. Mereka tidak memeriksa jenis aset
  (tidak ada `if (aset instanceof Laptop)`). Rumus multiplier tiap jenis ada di subclass masing-masing
  (`Ruang` 1x, `Laptop` 2x, `AlatLab` 4x).
- Bila nanti ada jenis aset baru, misalnya `Kendaraan`, cukup membuat subclass baru dari `Aset` dan mengisi
  `hitungDenda`. `DendaFlat`, `DendaProgresif`, dan `KatalogAset` tidak perlu diubah.
- Bila nanti ada aturan denda baru, misalnya denda libur, cukup membuat kelas baru yang mengimplementasikan
  `AturanDenda`. Kelas yang sudah berjalan tidak disentuh.

**Alasan:** perubahan kebutuhan (jenis aset atau aturan denda baru) ditangani dengan menambah kelas, bukan
mengedit kelas yang sudah teruji. Risiko merusak fitur lama lebih kecil.

## 2. LSP: subclass dapat menggantikan induknya

**Kelas terkait:** `Aset` (induk) dengan `Ruang`, `Laptop`, `AlatLab` (turunan).

- Kode yang menerima `Aset` (misalnya `KatalogAset.cari(kata, jenis)`, `DendaFlat.hitung(aset, hari)`,
  `Peminjaman`) bekerja sama benar untuk ketiga subclass tanpa tahu tipe aslinya.
- Subclass tidak memperketat prasyarat dan tidak melanggar kontrak induk: validasi kode dan nama tetap di
  konstruktor `Aset`, `bisaDipinjam()` tidak dioverride sehingga aturannya sama untuk semua jenis, dan
  `hitungDenda` tetap menolak hari negatif lewat `dendaDenganMultiplier` milik induk.
- **Refactor kecil minggu 6:** sebelumnya `Aset.getJenis()` konkret dan melempar `UnsupportedOperationException`
  ("TODO minggu 3"). Itu pelanggaran LSP, karena memanggil `getJenis()` pada sebuah `Aset` bisa meledak.
  Sekarang `getJenis()` dijadikan `abstract`, sehingga compiler memaksa setiap subclass menjawabnya dan tidak ada
  `Aset` yang tidak bisa menjawab jenisnya.

**Alasan:** objek `Ruang`, `Laptop`, atau `AlatLab` dapat dipakai di mana pun `Aset` diminta, tanpa kejutan
saat dijalankan.

## Catatan konsistensi dengan kode

- `LayananDenda` (minggu 10) masih berupa kerangka. Ia akan menunjukkan DIP (menerima `AturanDenda` lewat
  konstruktor), tetapi belum saya klaim di sini karena isinya belum dikerjakan.
- Diagram pada `docs/uml/class-diagram-*.mmd` dan `sequence-pengajuan.mmd` menggambarkan keadaan kode sekarang.