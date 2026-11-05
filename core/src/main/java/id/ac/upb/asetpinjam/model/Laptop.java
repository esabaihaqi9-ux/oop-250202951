package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa laptop. Spesifikasi dan nomor inventaris tidak boleh kosong. */
public class Laptop extends Aset {

    private static final int MULTIPLIER_DENDA = 2;

    private final String spesifikasi;
    private final String nomorInventaris;

    /**
     * @throws IllegalArgumentException jika kode/nama kosong (dari Aset), atau spesifikasi/nomor inventaris
     *     null atau kosong
     */
    public Laptop(String kode, String nama, String spesifikasi, String nomorInventaris) {
        super(kode, nama);
        this.spesifikasi = pastikanTidakKosong(spesifikasi, "spesifikasi");
        this.nomorInventaris = pastikanTidakKosong(nomorInventaris, "nomorInventaris");
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public String getNomorInventaris() {
        return nomorInventaris;
    }

    @Override
    public JenisAset getJenis() {
        return JenisAset.LAPTOP;
    }

    private static String pastikanTidakKosong(String nilai, String namaField) {
        if (nilai == null || nilai.isBlank()) {
            throw new IllegalArgumentException(namaField + " tidak boleh null atau kosong");
        }
        return nilai;
    }

    /** Denda Laptop: hari x 2 x tarif varian. Hari negatif ditolak. */
    @Override
    public long hitungDenda(int hariTerlambat) {
        return dendaDenganMultiplier(hariTerlambat, MULTIPLIER_DENDA);
    }
}