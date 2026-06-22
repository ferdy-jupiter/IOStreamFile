package bagian2.bacatulis;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Latihanmandiri2 {

    public static void main(String[] args) {
        String namaFile = "hari.txt";

        // 1. Tulis 5 nama hari ke dalam file (overwrite)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile))) {
            bw.write("Senin\n");
            bw.write("Selasa\n");
            bw.write("Rabu\n");
            bw.write("Kamis\n");
            bw.write("Jumat\n");
        } catch (IOException e) {
            System.out.println("Error menulis file: " + e.getMessage());
        }

        // Baca kembali isi file
        System.out.println("Isi file setelah menulis 5 hari:");
        bacaFile(namaFile);

        // 2. Tambahkan 2 nama hari lagi (append)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(namaFile, true))) {
            bw.write("Sabtu\n");
            bw.write("Minggu\n");
        } catch (IOException e) {
            System.out.println("Error menulis file: " + e.getMessage());
        }

        // Tampilkan seluruh isi file
        System.out.println("\nIsi file setelah append 2 hari:");
        bacaFile(namaFile);

        // 3. Hitung jumlah baris
        int jumlahBaris = hitungBaris(namaFile);
        System.out.println("\nJumlah baris dalam file: " + jumlahBaris);
    }

    // Method untuk membaca isi file
    public static void bacaFile(String namaFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error membaca file: " + e.getMessage());
        }
    }

    // Method untuk menghitung jumlah baris
    public static int hitungBaris(String namaFile) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            while (br.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error menghitung baris: " + e.getMessage());
        }
        return count;
    }
}
