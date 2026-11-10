# Asumsi dan Keputusan Desain

Isi bagian ini sendiri. Satu entri per keputusan. Dinilai dari kejelasan alasan dan konsistensi dengan kode dan tes Anda,
bukan dari jawaban "benar".

Format tiap entri:

```
## A-NN: judul singkat
- Pertanyaan: ...
- Keputusan: ...
- Alasan: ...
- Dampak ke kode: ... (kelas/metode)
- Tes yang membuktikan: ... (nama tes di folder mahasiswa/)
```

## Aturan ambigu dari docs/aturan-bisnis.md

Salin setiap pertanyaan ambigu (nomor 1 sampai 7) ke sini dan jawab. Contoh:

## A-01: batas waktu bentrok
- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: (isi)
- Alasan: (isi)
- Dampak ke kode: (isi)
- Tes yang membuktikan: (isi)

## Asumsi lain

Tambahkan di sini keputusan lain yang Anda ambil: rumus denda progresif, perubahan skema database, format error API, dan seterusnya.

## A-02: normalisasi kode dan nama aset (minggu 2)
- Pertanyaan: apakah kode dan nama aset dinormalisasi (trim, huruf besar) saat disimpan?
- Keputusan: tidak. Nilai disimpan apa adanya. Yang ditolak hanya null, kosong, atau berisi spasi saja (`isBlank()`).
- Alasan: kode aset kelak dipakai sebagai kunci pencarian (minggu 8 dan seterusnya) dan disimpan ke database (minggu 11).
  Mengubah isinya diam-diam bisa membuat kode yang dimasukkan pengguna berbeda dengan yang tersimpan. Normalisasi lebih
  tepat dilakukan di lapisan input, bukan di dalam model.
- Dampak ke kode: `Aset.pastikanTidakKosong(...)` hanya memvalidasi dan mengembalikan nilai asli.
- Tes yang membuktikan: `AsetKodeNamaTest.kodeDisimpanApaAdanyaTanpaNormalisasi`.

## A-03: rumus denda progresif (minggu 5)
- Pertanyaan: bagaimana denda dihitung agar makin berat bila makin lama terlambat?
- Keputusan: 7 hari pertama sama dengan denda flat. Mulai hari ke-8, tiap hari tambahan dihitung dua kali lipat.
  Rumus: `progresif(h) = flat(h) + max(0, h - 7) x flat(1)`.
- Alasan: keterlambatan singkat tetap diperlakukan sama dengan denda flat, sedangkan keterlambatan panjang
  (aset tidak tersedia bagi peminjam lain) dikenai beban lebih besar. Rumus ini memakai `hitungDenda`, sehingga
  multiplier jenis aset dan tarif varian ikut otomatis. Tidak pernah di bawah flat, tidak turun saat hari bertambah,
  dan pada hari ke-30 lebih mahal dari flat.
- Dampak ke kode: `DendaProgresif.hitung(...)`.
- Tes yang membuktikan: `Minggu05AbstraksiTest.dendaProgresifMemenuhiSyaratMinimal`.
