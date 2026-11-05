package id.ac.upb.asetpinjam.model;

/** Minggu 3: aset berupa ruang. Kapasitas harus lebih dari 0 (IllegalArgumentException). */
public class Ruang extends Aset {

    private static final int MULTIPLIER_DENDA = 1;

    private final int kapasitas;

    /**
     * @throws IllegalArgumentException jika kode/nama kosong (dari Aset) atau kapasitas tidak lebih dari 0
     */
    public Ruang(String kode, String nama, int kapasitas) {
        super(kode, nama);
        if (kapasitas <= 0) {
            throw new IllegalArgumentException("kapasitas harus lebih dari 0");
        }
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    @Override
    public JenisAset getJenis() {
        return JenisAset.RUANG;
    }

    /** Denda Ruang: hari x 1 x tarif varian. Hari negatif ditolak. */
    @Override
    public long hitungDenda(int hariTerlambat) {
        return dendaDenganMultiplier(hariTerlambat, MULTIPLIER_DENDA);
    }
}