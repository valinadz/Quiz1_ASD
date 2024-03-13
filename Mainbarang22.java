import java.util.ArrayList;
import java.util.Scanner;

public class Mainbarang22 {
    public static void main(String[] args) {
        Barang22 barang1 = new Barang22("VP1", "Jubah", 100000, 10);
        Barang22 barang2 = new Barang22("VP2", "Tongkat Sihir", 75000, 20);
        Barang22 barang3 = new Barang22("VP3", "Buku Mantra", 125000, 20);
        Barang22 barang4 = new Barang22("VP4", "Syal", 50000, 15);
        Barang22 barang5 = new Barang22("VP5", "Sapu Terbang", 400000, 8);

        Transaksi22 transaksi = new Transaksi22();
        transaksi.barangs.add(barang1);
        transaksi.barangs.add(barang2);
        transaksi.barangs.add(barang3);
        transaksi.barangs.add(barang4);
        transaksi.barangs.add(barang5);

        Scanner scanner = new Scanner(System.in);
        ArrayList<Barang22> pembelian = new ArrayList<>();

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
