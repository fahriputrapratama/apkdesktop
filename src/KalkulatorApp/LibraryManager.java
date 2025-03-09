package KalkulatorApp;

import java.util.*;



public class LibraryManager {
    static List<Buku> daftarBuku = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Manajemen Perpustakaan =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Daftar Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    tampilkanBuku();
                    break;
                case 3:
                    pinjamBuku();
                    break;
                case 4:
                    kembalikanBuku();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }


    static void tambahBuku() {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        daftarBuku.add(new Buku(judul));
        System.out.println("Buku '" + judul + "' telah ditambahkan.");
    }

    static void tampilkanBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku.");
            return;
        }
        System.out.println("\nDaftar Buku:");
        for (int i = 0; i < daftarBuku.size(); i++) {
            String status = daftarBuku.get(i).sedangDipinjam ? "Dipinjam" : "Tersedia";
            System.out.println((i + 1) + ". " + daftarBuku.get(i).judul + " - " + status);
        }
    }

    static void pinjamBuku() {
        tampilkanBuku();
        if (daftarBuku.isEmpty()) return;
        System.out.print("Masukkan nomor buku yang ingin dipinjam: ");
        int indeks = scanner.nextInt() - 1;
        if (indeks >= 0 && indeks < daftarBuku.size()) {
            daftarBuku.get(indeks).pinjamBuku();
        } else {
            System.out.println("Nomor buku tidak valid.");
        }
    }

    static void kembalikanBuku() {
        tampilkanBuku();
        if (daftarBuku.isEmpty()) return;
        System.out.print("Masukkan nomor buku yang ingin dikembalikan: ");
        int indeks = scanner.nextInt() - 1;
        if (indeks >= 0 && indeks < daftarBuku.size()) {
            daftarBuku.get(indeks).kembalikanBuku();
        } else {
            System.out.println("Nomor buku tidak valid.");
        }
    }
}

class Buku {
    String judul;
    boolean sedangDipinjam;

    public Buku(String judul) {
        this.judul = judul;
        this.sedangDipinjam = false;
    }

    public void pinjamBuku() {
        if (!sedangDipinjam) {
            sedangDipinjam = true;
            System.out.println("Buku '" + judul + "' berhasil dipinjam.");
        } else {
            System.out.println("Buku '" + judul + "' sedang dipinjam.");
        }
    }

    public void kembalikanBuku() {
        if (sedangDipinjam) {
            sedangDipinjam = false;
            System.out.println("Buku '" + judul + "' berhasil dikembalikan.");
        } else {
            System.out.println("Buku '" + judul + "' tidak sedang dipinjam.");
        }
    }
}
