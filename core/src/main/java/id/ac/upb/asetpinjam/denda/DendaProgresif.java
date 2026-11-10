package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 5: denda yang makin berat bila makin lama terlambat.
 *
 * <p>Rumus (lihat docs/asumsi.md, A-03): 7 hari pertama sama dengan denda flat. Mulai hari ke-8,
 * setiap hari tambahan dihitung dua kali lipat, yaitu denda flat ditambah satu denda harian lagi.
 * <pre>progresif(h) = flat(h) + max(0, h - 7) x flat(1)</pre>
 */
public class DendaProgresif implements AturanDenda {

    static final int BATAS_HARI_NORMAL = 7;

    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        if (aset == null) {
            throw new IllegalArgumentException("aset tidak boleh null");
        }
        long flat = aset.hitungDenda(hariTerlambat); // menolak hari negatif
        long hariLebih = Math.max(0, hariTerlambat - BATAS_HARI_NORMAL);
        return flat + hariLebih * aset.hitungDenda(1);
    }
}