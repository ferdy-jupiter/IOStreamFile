package tugas;

public class Barang {
    private String nama;
    private double harga;
    private int stok;

    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // ubah ke format: nama;harga;stok
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    public String info() {
        return nama + " - Rp" + harga + " - Stok: " + stok;
    }
}
