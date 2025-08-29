public class MenuItem {
    private String namaItem;
    private int harga;

    public MenuItem(String namaItem, int harga) {
        this.namaItem = namaItem;
        this.harga = harga;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    // Method tampilkan info menu
    public void tampilkanInfo(int nomor) {
        System.out.println(nomor + ". " + namaItem + " - Rp" + harga);
    }
}
