import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Input Jumlah Total Data (N)
        System.out.print("Masukkan jumlah total data (N): ");
        int n = input.nextInt();

        int[] nilai = new int[n];
        char[] gender = new char[n];

        // 2. Input Nilai dan Jenis Kelamin (L/P)
        for (int i = 0; i < n; i++) {
            System.out.println("Data ke-" + (i + 1) + ":");
            System.out.print(" - Nilai: ");
            nilai[i] = input.nextInt();
            System.out.print(" - Jenis Kelamin (L/P): ");
            // Mengambil karakter pertama dan diubah ke huruf kapital
            gender[i] = input.next().toUpperCase().charAt(0);
        }

        // 3. Memilih Kelompok Berdasarkan Jenis Kelamin
        System.out.print("\nMasukkan kode kelompok yang ingin dijumlahkan (L/P): ");
        char target = input.next().toUpperCase().charAt(0);

        int totalNilai = 0;
        int jumlahSiswa = 0;

        // Proses Filter: Hanya menjumlahkan yang sesuai target
        for (int i = 0; i < n; i++) {
            if (gender[i] == target) {
                totalNilai += nilai[i];
                jumlahSiswa++;
            }
        }

        // Output Akhir
        String label = (target == 'L') ? "Laki-laki" : "Perempuan";
        
        System.out.println("\n============================");
        if (jumlahSiswa > 0) {
            System.out.println("HASIL PENJUMLAHAN");
            System.out.println("Kelompok      : " + label);
            System.out.println("Total Nilai   : " + totalNilai);
            System.out.println("Jumlah Siswa  : " + jumlahSiswa);
        } else {
            System.out.println("Data kelompok " + label + " tidak ditemukan.");
        }
        System.out.println("============================");

        input.close();
    }
}
