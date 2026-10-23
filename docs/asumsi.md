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
