package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class Latihanmandiri {
    public static void main(String[] args) {
        // 1. Membuat objek File untuk laporan.txt
        File laporan = new File("laporan.txt");
        if (laporan.exists()) {
            System.out.println("Berkas laporan.txt ada.");
            System.out.println("Ukuran: " + laporan.length() + " byte");
        } else {
            System.out.println("Berkas laporan.txt tidak ditemukan.");
        }

        // 2. Membuat folder baru bernama arsip
        File arsip = new File("arsip");
        if (arsip.exists()) {
            System.out.println("Folder arsip sudah ada.");
        } else if (arsip.mkdir()) {
            System.out.println("Folder arsip berhasil dibuat.");
        } else {
            System.out.println("Folder arsip gagal dibuat.");
        }

        // 3. Membuat file sementara.txt lalu menghapusnya
        File sementara = new File("sementara.txt");
        try {
            if (sementara.createNewFile()) {
                System.out.println("File sementara.txt berhasil dibuat.");
            } else {
                System.out.println("File sementara.txt sudah ada.");
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membuat file: " + e.getMessage());
        }

        System.out.println("Apakah sementara.txt ada? " + sementara.exists());

        if (sementara.delete()) {
            System.out.println("File sementara.txt berhasil dihapus.");
        } else {
            System.out.println("File sementara.txt gagal dihapus.");
        }

        System.out.println("Apakah sementara.txt ada setelah dihapus? " + sementara.exists());
    }
}
