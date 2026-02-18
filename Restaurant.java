public class Restaurant {

    // Encapsulation: semua attribute private
    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int jumlahMenu; // menggantikan static id

    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
        jumlahMenu = 0;
    }

    // Method untuk menambah menu
    public void tambahMenuMakanan(String nama, double harga, int stokAwal) {
        if (stokAwal < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }

        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif!");
            return;
        }

        namaMakanan[jumlahMenu] = nama;
        hargaMakanan[jumlahMenu] = harga;
        stok[jumlahMenu] = stokAwal;
        jumlahMenu++; // otomatis bertambah (tidak perlu nextId dari luar)
    }

    // Method untuk menampilkan menu
    public void tampilMenuMakanan() {
        System.out.println("=== DAFTAR MENU ===");
        for (int i = 0; i < jumlahMenu; i++) {
            if (stok[i] > 0) {
                System.out.printf(
                        "%-3d %-20s [%3d]  Rp. %10.0f%n",
                        (i + 1),
                        namaMakanan[i],
                        stok[i],
                        hargaMakanan[i]);
            }
        }
    }

    // Method pemesanan
    public void pesanMenu(int index, int jumlahPesan) {
        if (index < 0 || index >= jumlahMenu) {
            System.out.println("Menu tidak ditemukan!");
            return;
        }

        if (jumlahPesan <= 0) {
            System.out.println("Jumlah pesan tidak valid!");
            return;
        }

        if (stok[index] >= jumlahPesan) {
            stok[index] -= jumlahPesan;
            System.out.println("Pesanan berhasil! Sisa stok: " + stok[index]);
        } else {
            System.out.println("Pesanan ditolak! Stok tidak mencukupi.");
        }
    }

    // Getter (jika diperlukan)
    public int getJumlahMenu() {
        return jumlahMenu;
    }

    public int getStok(int index) {
        if (index >= 0 && index < jumlahMenu) {
            return stok[index];
        }
        return -1;
    }
}
