package id.ac.upb.asetpinjam.model;

import id.ac.upb.asetpinjam.config.Varian;
import id.ac.upb.asetpinjam.kontrak.DapatDipinjam;

/**
 * Aset yang dapat dipinjam.
 *
 * <p>Minggu 2: lengkapi field, konstruktor, getter/setter, dan validasi (encapsulation).
 * Minggu 3: tambahkan getJenis() di tiap subclass.
 * Minggu 4: hitungDenda() dioverride di tiap subclass.
 * Minggu 5: isi bisaDipinjam() dan ubah menjadi class abstrak
 * (TestSupport.aset(...) di folder test menyesuaikan sendiri, lihat docs/minggu-05.md).
 */
public abstract class Aset implements DapatDipinjam {

    private final String kode;
    private String nama;
    private StatusAset status = StatusAset.TERSEDIA;
    private Kondisi kondisi = Kondisi.BAIK;

    /**
     * Membuat aset baru dengan status TERSEDIA dan kondisi BAIK.
     *
     * @throws IllegalArgumentException jika kode atau nama null atau kosong
     */
    public Aset(String kode, String nama) {
        this.kode = pastikanTidakKosong(kode, "kode");
        this.nama = pastikanTidakKosong(nama, "nama");
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public StatusAset getStatus() {
        return status;
    }

    public Kondisi getKondisi() {
        return kondisi;
    }

    /** Nama baru tidak boleh null atau kosong. Bila ditolak, nama lama tetap. */
    public void setNama(String nama) {
        this.nama = pastikanTidakKosong(nama, "nama");
    }

    /** Status tidak boleh null. */
    public void setStatus(StatusAset status) {
        if (status == null) {
            throw new IllegalArgumentException("status tidak boleh null");
        }
        this.status = status;
    }

    /** Kondisi tidak boleh null. */
    public void setKondisi(Kondisi kondisi) {
        if (kondisi == null) {
            throw new IllegalArgumentException("kondisi tidak boleh null");
        }
        this.kondisi = kondisi;
    }

    private static String pastikanTidakKosong(String nilai, String namaField) {
        if (nilai == null || nilai.isBlank()) {
            throw new IllegalArgumentException(namaField + " tidak boleh null atau kosong");
        }
        return nilai;
    }

    /** True hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT. */
    @Override
    public boolean bisaDipinjam() {
        return status == StatusAset.TERSEDIA && kondisi != Kondisi.RUSAK_BERAT;
    }

    /** TODO minggu 3: dioverride tiap subclass agar mengembalikan jenis yang benar. */
    public JenisAset getJenis() {
        throw new UnsupportedOperationException("TODO minggu 3");
    }

    /** Denda keterlambatan. Dioverride tiap subclass sesuai multiplier jenisnya (docs/aturan-bisnis.md). */
    public abstract long hitungDenda(int hariTerlambat);

    /**
     * Rumus bersama: hari x multiplier jenis x tarif varian. Hari negatif ditolak, 0 hari berarti 0.
     * Dihitung dengan long supaya tidak overflow pada hari yang besar.
     *
     * @throws IllegalArgumentException jika hariTerlambat negatif
     */
    protected final long dendaDenganMultiplier(int hariTerlambat, int multiplier) {
        if (hariTerlambat < 0) {
            throw new IllegalArgumentException("hari terlambat tidak boleh negatif");
        }
        return (long) hariTerlambat * multiplier * Varian.aktif().dendaPerHari;
    }
}