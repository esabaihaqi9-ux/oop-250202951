# Catatan Minggu 02: Struktur OOP (Class, Object, Encapsulation)

## Yang saya kerjakan
Saya melengkapi class `Aset` di `core/.../model/Aset.java`: empat field private (`kode`, `nama`, `status`, `kondisi`),
konstruktor yang memvalidasi kode dan nama, getter, serta setter untuk nama, status, dan kondisi. Kode dibuat `final`
dan tidak punya setter karena identitas aset tidak boleh berubah. Status awal `TERSEDIA` dan kondisi awal `BAIK`.
Satu metode private `pastikanTidakKosong` dipakai bersama oleh konstruktor dan `setNama` agar aturan validasinya tidak
ditulis dua kali. Keenam tes `Minggu02AsetTest` lulus, ditambah dua tes sendiri di `mahasiswa/AsetKodeNamaTest`.

## Keputusan desain
- A-02 di `docs/asumsi.md`: kode dan nama tidak dinormalisasi (tidak di-trim, tidak diubah ke huruf besar).
  Alasannya: kode akan dipakai sebagai kunci di minggu-minggu berikutnya, jadi nilai yang tersimpan sebaiknya sama
  dengan yang dimasukkan.
- Metode `bisaDipinjam()`, `getJenis()`, dan `hitungDenda()` sengaja tidak saya sentuh karena itu pekerjaan minggu 3 sampai 5.

## Kendala
- sempat ada kendala karena kemarin file sya pindah jadi waktu diuji ada eror

## Penggunaan AI
- Alat yang dipakai: Claude (Anthropic)
- Bagian yang dibantu AI: seluruh isi `Aset.java` minggu 2 (field, konstruktor, getter/setter, validasi),
  tes tambahan `AsetKodeNamaTest`, entri A-02, dan draf catatan ini.
- Prompt utama: "tolong kerjakan tugas pada minggu kedua beserta laporannya" (dengan tautan repositori).
  Catatan jujur: ini tipe prompt yang disarankan `docs/kebijakan-ai.md` untuk dihindari, karena tes dan rancangan tidak
  saya tulis lebih dulu.
- Yang saya ubah atau tolak dari saran AI, dan alasannya: (ISI SENDIRI setelah Anda membaca kodenya baris demi baris.
  Bila tidak ada yang Anda ubah, tulis apa adanya.)
- Satu hal yang saya pahami lebih baik sekarang: (ISI SENDIRI, misalnya mengapa `kode` dibuat `final` dan tanpa setter.)

## Pengumpulan

- Commit dengan format `minggu-02: ringkasan`.
- Isi `catatan/minggu-02.md` dari `catatan/_template.md`, termasuk bagian **Penggunaan AI**.
- Bukti penilaian: CI hijau pada commit terakhir sebelum tenggat.
