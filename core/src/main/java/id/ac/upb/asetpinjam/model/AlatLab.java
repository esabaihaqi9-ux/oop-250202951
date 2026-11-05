package id.ac.upb.asetpinjam.model;

/** Minggu 3: alat laboratorium. Laboratorium tidak boleh kosong; risiko tidak boleh null. */
public class AlatLab extends Aset {

    private static final int MULTIPLIER_DENDA = 4;

    private final String laboratorium;
    private final TingkatRisiko tingkatRisiko;

    /**
     * @throws IllegalArgumentException jika kode/nama kosong (dari Aset), laboratorium null atau kosong,
     *     atau tingkat risiko null
     */
    public AlatLab(String kode, String nama, String laboratorium, TingkatRisiko tingkatRisiko) {
        super(kode, nama);
        if (laboratorium == null || laboratorium.isBlank()) {
            throw new IllegalArgumentException("laboratorium tidak boleh null atau kosong");
        }
        if (tingkatRisiko == null) {
            throw new IllegalArgumentException("tingkatRisiko tidak boleh null");
        }
        this.laboratorium = laboratorium;
        this.tingkatRisiko = tingkatRisiko;
    }

    public String getLaboratorium() {
        return laboratorium;
    }

    public TingkatRisiko getTingkatRisiko() {
        return tingkatRisiko;
    }

    @Override
    public JenisAset getJenis() {
        return JenisAset.ALAT_LAB;
    }

    /** Denda Alat laboratorium: hari x 4 x tarif varian. Hari negatif ditolak. */
    @Override
    public long hitungDenda(int hariTerlambat) {
        return dendaDenganMultiplier(hariTerlambat, MULTIPLIER_DENDA);
    }
}