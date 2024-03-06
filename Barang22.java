import java.util.ArrayList;
import java.util.Scanner;

// Class Barang
class Barang {
    String kode;
    String nama;
    double harga;
    int stok;

    // Constructor
    public Barang(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Method untuk menampilkan info barang dalam satu kolom
    public void tampilkanInfoSekolom() {
        System.out.printf("%-6s %-15s %-10s %-5s%n", kode, nama, harga, stok);
    }
}

// Class TransaksiBarang
class TransaksiBarang {
    ArrayList<Barang> barangs = new ArrayList<>();

    // Method untuk menampilkan daftar barang
    public void tampilkanBarang() {
        System.out.println("==========================");
        System.out.println("Daftar Barang Tersedia");
        System.out.println("==========================");
        System.out.printf("%-6s %-15s %-10s %-5s%n", "Kode", "Nama", "Harga", "Stok");
        for (Barang barang : barangs) {
            barang.tampilkanInfoSekolom();
        }
    }

    // Method untuk menampilkan daftar barang yang dibeli
    public void tampilkanBarangPembelian(ArrayList<Barang> pembelian) {
        System.out.println("==========================");
        System.out.println("List Belanjaan VP Stuff");
        System.out.println("==========================");
        System.out.printf("%-6s %-15s %-10s %-5s%n", "Kode", "Nama", "Harga", "Stok");
        for (Barang barang : pembelian) {
            barang.tampilkanInfoSekolom();
        }
    }

    // Method untuk melakukan pembelian
    public void melakukanPembelian(String kode, ArrayList<Barang> pembelian, Scanner scanner) {
        for (Barang barang : barangs) {
            if (barang.kode.equals(kode)) {
                if (barang.stok > 0) {
                    pembelian.add(barang);
                    barang.stok--;
                    System.out.println("Barang dengan kode " + kode + " berhasil dibeli.");

                    while (true) {
                        System.out.print("Apakah Anda ingin berbelanja lagi? (Y/N): ");
                        String belanjaLagi = scanner.next();
                        if (belanjaLagi.equalsIgnoreCase("Y")) {
                            System.out.print("Masukkan kode barang yang ingin dibeli: ");
                            kode = scanner.next();
                            for (Barang beli : barangs) {
                                if (beli.kode.equals(kode)) {
                                    if (beli.stok > 0) {
                                        pembelian.add(beli);
                                        beli.stok--;
                                        System.out.println("Barang dengan kode " + kode + " berhasil dibeli.");
                                        break;
                                    } else {
                                        System.out.println("Maaf, stok barang dengan kode " + kode + " habis.");
                                        break;
                                    }
                                }
                            }
                        } else if (belanjaLagi.equalsIgnoreCase("N")) {
                            return;
                        } else {
                            System.out.println("Masukkan Y untuk Ya atau N untuk Tidak.");
                        }
                    }
                } else {
                    System.out.println("Maaf, stok barang dengan kode " + kode + " habis.");
                    return;
                }
            }
        }
        System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
    }
}

// Class MainBarang
public class Barang22 {
    public static void main(String[] args) {
        // Inisialisasi data barang
        Barang barang1 = new Barang("VP1", "Jubah", 100000, 10);
        Barang barang2 = new Barang("VP2", "Tongkat Sihir", 75000, 20);
        Barang barang3 = new Barang("VP3", "Buku Mantra", 125000, 20);
        Barang barang4 = new Barang("VP4", "Syal", 50000, 15);
        Barang barang5 = new Barang("VP5", "Sapu Terbang", 400000, 8);

        // Inisialisasi TransaksiBarang
        TransaksiBarang transaksi = new TransaksiBarang();
        transaksi.barangs.add(barang1);
        transaksi.barangs.add(barang2);
        transaksi.barangs.add(barang3);
        transaksi.barangs.add(barang4);
        transaksi.barangs.add(barang5);

        Scanner scanner = new Scanner(System.in);
        ArrayList<Barang> pembelian = new ArrayList<>();

        int pilihan;
        do {
            System.out.println("====================");
            System.out.println("VALINA POTTER STUFF");
            System.out.println("====================");
            System.out.println("1. Tampilkan Potter Stuff");
            System.out.println("2. Buy It!!");
            System.out.println("3. Tampilkan Pembelian");
            System.out.println("4. Keluar");
            System.out.print("Pilihan(1-4): ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    transaksi.tampilkanBarang();
                    break;
                case 2:
                    System.out.print("Masukkan kode barang yang ingin dibeli: ");
                    String kodeBeli = scanner.next();
                    transaksi.melakukanPembelian(kodeBeli, pembelian, scanner);
                    break;
                case 3:
                    transaksi.tampilkanBarangPembelian(pembelian);
                    break;
                case 4:
                    System.out.println("Terima kasih telah berbelanja di Valina Potter Stuff.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
