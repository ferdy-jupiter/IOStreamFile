package bagian3.kontak;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class BukuKontak {
    private ArrayList<Kontak> daftarKontak;
    private String namaFile;

    public BukuKontak(String namaFile) {
        this.namaFile = namaFile;
        daftarKontak = new ArrayList<>();
    }

    public void tambahKontak(Kontak k) {
        daftarKontak.add(k);
    }

    public void tampilkanSemua() {
        for (Kontak k : daftarKontak) {
            System.out.println(k.info());
        }
    }

    public int jumlahKontak() {
        return daftarKontak.size();
    }

    // cari kontak berdasarkan nama
    public void cariKontak(String nama) {
        boolean ditemukan = false;
        for (Kontak k : daftarKontak) {
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Kontak ditemukan: " + k.info());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Kontak dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // hapus kontak berdasarkan nama
    public void hapusKontak(String nama) {
        Iterator<Kontak> it = daftarKontak.iterator();
        boolean dihapus = false;
        while (it.hasNext()) {
            Kontak k = it.next();
            if (k.getNama().equalsIgnoreCase(nama)) {
                it.remove();
                dihapus = true;
                break;
            }
        }
        if (dihapus) {
            System.out.println("Kontak " + nama + " berhasil dihapus.");
            simpanKeBerkas();
        } else {
            System.out.println("Kontak dengan nama " + nama + " tidak ditemukan.");
        }
    }

    // simpan daftar kontak ke file
    public void simpanKeBerkas() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            for (Kontak k : daftarKontak) {
                bw.write(k.keBaris());
                bw.newLine();
            }
            System.out.println("Data kontak berhasil disimpan ke " + namaFile);
        } catch (IOException e) {
            System.out.println("Error menyimpan ke file: " + e.getMessage());
        }
    }

    // muat daftar kontak dari file
    public void muatDariBerkas() {
        daftarKontak.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] data = baris.split(";");
                if (data.length == 3) {
                    Kontak k = new Kontak(data[0], data[1], data[2]);
                    daftarKontak.add(k); 
                }
            }
            System.out.println("Data kontak berhasil dimuat dari " + namaFile);
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }
}
