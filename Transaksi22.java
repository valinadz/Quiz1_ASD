import java.util.ArrayList;
import java.util.Scanner;

public class Transaksi22 {
    ArrayList<Barang22> barangs = new ArrayList<>();

    public void tampilkanBarang() {
        System.out.println("==========================");
        System.out.println("Daftar Barang Tersedia");
        System.out.println("==========================");
        System.out.printf("%-6s %-15s %-10s %-5s%n", "Kode", "Nama", "Harga", "Stok");
        for (Barang22 barang : barangs) {
            barang.tampilkanInfoSekolom();
        }
    }

    public void tampilkanBarangPembelian(ArrayList<Barang22> pembelian) {
        System.out.println("==========================");
        System.out.println("List Belanjaan VP Stuff");
        System.out.println("==========================");
        System.out.printf("%-6s %-15s %-10s %-5s%n", "Kode", "Nama", "Harga", "Stok");
        for (Barang22 barang : pembelian) {
            barang.tampilkanInfoSekolom();
        }
    }

    public void melakukanPembelian(String kode, ArrayList<Barang22> pembelian, Scanner scanner) {
        for (Barang22 barang : barangs) {
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
                            for (Barang22 beli : barangs) {
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
