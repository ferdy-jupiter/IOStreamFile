package tugas;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Gudang {
    private ArrayList<Barang> daftarBarang;
    private String namaFile;

    public Gudang(String namaFile) {
        this.namaFile = namaFile;
        daftarBarang = new ArrayList<>();
    }

    public void tambahBarang(Barang b) {
        daftarBarang.add(b);
    }

    public void tampilkanSemua() {
        for (Barang b : daftarBarang) {
            System.out.println(b.info());
        }
    }

    public void simpanKeBerkas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            for (Barang b : daftarBarang) {
                bw.write(b.keBaris());
                bw.newLine();
            }
            System.out.println("Data barang berhasil disimpan ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Error menyimpan ke file: " + e.getMessage());
        }
    }

    public void muatDariBerkas() {
        daftarBarang.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(";");
                if (data.length == 3) {
                    String nama = data[0];
                    double harga = Double.parseDouble(data[1]);
                    int stok = Integer.parseInt(data[2]);
                    Barang b = new Barang(nama, harga, stok);
                    daftarBarang.add(b);
                }
            }
            System.out.println("Data barang berhasil dimuat dari " + namaFile);
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }

    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}
