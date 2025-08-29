import java.util.ArrayList;

public class Pembelian {
    private String namaPembeli;
    private ArrayList<MenuItem> daftarPesanan;
    private int uangBayar;

    public Pembelian(String namaPembeli, ArrayList<MenuItem> daftarPesanan, int uangBayar) {
        this.namaPembeli = namaPembeli;
        this.daftarPesanan = daftarPesanan;
        this.uangBayar = uangBayar;
    }

    public int hitungTotal() {
        int total = 0;

        for (MenuItem item : daftarPesanan) {
            total += item.getHarga();
        }
        return total;
    }

    public int hitungKembalian() {
        return uangBayar - hitungTotal();
    }

    public void tampilkanStruk() {
        System.out.println("\n==============================");
        System.out.println("       STRUK PEMBELIAN          ");
        System.out.println("=================================");
        System.out.printf("%-15s : %s%n", "Nama Pembeli", namaPembeli);
        System.out.println("------------------------------");
        System.out.println("Pesanan:");

        // Loop untuk menampilkan setiap item di daftarPesanan
        for (MenuItem item : daftarPesanan) {
            System.out.printf("- %-15s Rp%d%n", item.getNamaItem(), item.getHarga());
        }

        System.out.println("------------------------------");
        System.out.printf("%-15s : Rp%d%n", "Total Bayar", hitungTotal());
        System.out.printf("%-15s : Rp%d%n", "Uang Diberikan", uangBayar);

        if (uangBayar >= hitungTotal()) {
            System.out.printf("%-15s : Rp%d%n", "Kembalian", hitungKembalian());
        } else {
            System.out.printf("%-15s : Rp%d (Uang Kurang)%n",
                    "Kekurangan", (hitungTotal() - uangBayar));
        }

        System.out.println("==============================");
        System.out.println(" Terima Kasih, Selamat Makan! ");
        System.out.println("==============================");
    }
}
