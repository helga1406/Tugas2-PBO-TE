import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void tampilkanMenu(ArrayList<MenuItem> daftarMenu) {
        System.out.println("\n=== Daftar Menu Kantin Pujasera Polban ===");
        for (int i = 0; i < daftarMenu.size(); i++) {

            daftarMenu.get(i).tampilkanInfo(i + 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- DATA MENU GABUNGAN ---
        ArrayList<MenuItem> daftarMenuLengkap = new ArrayList<>();
        daftarMenuLengkap.add(new MenuItem("Nasi Goreng", 15000));
        daftarMenuLengkap.add(new MenuItem("Ayam Geprek", 18000));
        daftarMenuLengkap.add(new MenuItem("Es Teh Manis", 5000));
        daftarMenuLengkap.add(new MenuItem("Jus Alpukat", 10000));

        // --- ALUR PROGRAM SEDERHANA ---
        ArrayList<MenuItem> daftarPesanan = new ArrayList<>();
        boolean pesanLagi = true;

        while (pesanLagi) {

            tampilkanMenu(daftarMenuLengkap);

            System.out.print("\nPilih nomor menu: ");
            int pilihanMenu = input.nextInt();
            MenuItem itemPilihan = daftarMenuLengkap.get(pilihanMenu - 1);

            System.out.print("Masukkan jumlah pesanan: ");
            int jumlah = input.nextInt();

            // Masukkan item ke daftar pesanan
            for (int i = 0; i < jumlah; i++) {
                daftarPesanan.add(itemPilihan);
            }
            System.out.println("'" + itemPilihan.getNamaItem() + "' berhasil ditambahkan ke pesanan.");

            System.out.print("\nApakah Anda ingin menambah pesanan lagi? (y/n): ");
            String jawaban = input.next();
            if (!jawaban.equalsIgnoreCase("y")) {
                pesanLagi = false;
            }
        }

        // --- Proses Pembayaran ---
        System.out.println("\n--- Proses Pembayaran ---");
        System.out.print("Masukkan nama pembeli: ");
        input.nextLine();
        String namaPembeli = input.nextLine();

        System.out.print("Masukkan uang pembayaran: Rp");
        int uang = input.nextInt();

        // Membuat objek Pembelian dengan daftar pesanan
        Pembelian pembelian = new Pembelian(namaPembeli, daftarPesanan, uang);

        pembelian.tampilkanStruk();

        input.close();
    }
}
