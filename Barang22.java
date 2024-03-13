import java.util.Scanner;

public class Barang22 {
    String kode;
    String nama;
    double harga;
    int stok;

    public Barang22(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanInfoSekolom() {
        System.out.printf("%-6s %-15s %-10s %-5s%n", kode, nama, harga, stok);
    }
}
