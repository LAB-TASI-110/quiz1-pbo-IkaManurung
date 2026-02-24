import java.util.Scanner;
import java.time.LocalDate;

class PesananLaundry {
    private String namaPelanggan;
    private String kategori;
    private double berat;
    private String catatan;
    private String status;
    private final double hargaPerKg = 8000;

    public PesananLaundry(String nama, String kategori, double berat, String catatan) {
        this.namaPelanggan = nama;
        this.kategori = kategori;
        this.berat = berat;
        this.catatan = catatan;
        this.status = "Diproses (Antrean)";
    }

    public void updateStatus(int pilihan) {
        switch (pilihan) {
            case 1 -> this.status = "Sedang Dicuci";
            case 2 -> this.status = "Sedang Dikeringkan";
            case 3 -> this.status = "Sedang Disetrika";
            case 4 -> this.status = "Selesai & Siap Diambil";
        }
    }

    public void cetakStruk() {
        System.out.println("\n===============================");
        System.out.println("         LAUNDRY DEL          ");
        System.out.println("===============================");
        System.out.println("Pelanggan : " + namaPelanggan + " (" + kategori + ")");
        System.out.println("Tanggal   : " + LocalDate.now());
        System.out.println("Berat     : " + berat + " kg");
        System.out.println("Total     : Rp " + (int)(berat * hargaPerKg));
        System.out.println("Catatan   : " + (catatan.isEmpty() ? "-" : catatan));
        System.out.println("STATUS    : [" + status + "]");
        System.out.println("===============================");
    }
}

public class Driver3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("--- Input Pesanan Baru ---");
        System.out.print("Nama: "); 
        String nama = in.nextLine();
        
        System.out.print("Kelompok (L/P): "); 
        String kel = in.nextLine();

        System.out.print("Catatan: "); 
        String note = in.nextLine();

        System.out.print("Berat (kg): "); 
        double berat = in.nextDouble();
        in.nextLine(); // Membersihkan sisa baris setelah input angka

        PesananLaundry order = new PesananLaundry(nama, kel, berat, note);
        
        int menu = -1;
        while (menu != 0) {
            order.cetakStruk(); // Struk akan dicetak ulang setiap kali status berubah
            System.out.println("\nUpdate Progres Cucian:");
            System.out.println("1. Mulai Cuci | 2. Pengeringan | 3. Setrika | 4. Selesai | 0. Keluar");
            System.out.print("Pilih Menu: ");
            
            if (in.hasNextInt()) {
                menu = in.nextInt();
                in.nextLine(); // Membersihkan sisa baris agar tidak error di loop berikutnya
                if (menu > 0 && menu <= 4) {
                    order.updateStatus(menu);
                    System.out.println("\n[Sistem]: Status berhasil diperbarui!");
                }
            } else {
                System.out.println("Input harus angka!");
                in.nextLine(); // Membersihkan input yang salah
            }
        }

        System.out.println("\nSistem Laundry Del Berhenti. Sampai Jumpa!");
        in.close();
    }
}
