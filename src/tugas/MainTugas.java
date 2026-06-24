package tugas;

// Nama: Muhammad Ferdy Firdaus 
// NPM: 2410010232

public class MainTugas {
    public static void main(String[] args) {
        // Array kategori (ukuran tetap, minimal 3)
        String[] kategori = {"Elektronik", "Pakaian", "Makanan"};
        System.out.println("Kategori barang:");
        for (String k : kategori) {
            System.out.println("- " + k);
        }
        System.out.println();

        // Membuat gudang dan menambah barang
        Gudang gudang = new Gudang("barang.txt");
        gudang.tambahBarang(new Barang("Laptop", 7500000, 5));
        gudang.tambahBarang(new Barang("Kaos", 100000, 20));
        gudang.tambahBarang(new Barang("Roti", 15000, 50));
        gudang.tambahBarang(new Barang("HP", 3000000, 10));
        gudang.tambahBarang(new Barang("Celana", 200000, 15));

        gudang.tampilkanSemua();
        gudang.simpanKeBerkas();
        System.out.println();

        // Objek baru, muat dari berkas
        Gudang gudangLain = new Gudang("barang.txt");
        gudangLain.muatDariBerkas();
        gudangLain.tampilkanSemua();

        // Total nilai persediaan
        System.out.println("Total nilai persediaan: Rp" + gudangLain.totalNilai());
    }
}
