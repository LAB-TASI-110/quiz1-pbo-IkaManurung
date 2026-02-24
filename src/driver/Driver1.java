import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inisialisasi variabel untuk menampung data
        double totalGross = 0;
        String outputList = ""; // Variabel krusial untuk menyimpan daftar makanan

        // Looping untuk membaca input sampai ada kata "END"
        while (sc.hasNext()) {
            String kode = sc.next();
            if (kode.equalsIgnoreCase("END")) break;

            // Membaca porsi yang diinput untuk Butet
            double porsiButet = sc.nextDouble();
            
            // Rasio porsi berdasarkan berat badan (Ucok 100kg : Butet 50kg = 2:1)
            // Total porsi = Butet (1) + Ucok (2) = 3x lipat porsi Butet
            double totalPorsi = porsiButet * 3.0;
            
            int harga = 0;
            String namaMenu = "";

            // Database harga berdasarkan image_0060fe.jpg dan image_0067bd.jpg
            switch (kode.toUpperCase()) {
                case "NGS": namaMenu = "Nasi Goreng Spesial"; harga = 15000; break;
                case "AP" : namaMenu = "Ayam Penyet"; harga = 20000; break;
                case "SA" : namaMenu = "Sate Ayam (10 Tusuk)"; harga = 25000; break;
                case "BU" : namaMenu = "Bakso Urat"; harga = 18000; break;
                case "MAP": namaMenu = "Mie Ayam Pangsit"; harga = 15000; break;
                case "GG" : namaMenu = "Gado-Gado"; harga = 15000; break;
                case "SAM": namaMenu = "Soto Ayam"; harga = 17000; break;
                case "RD" : namaMenu = "Rendang Daging"; harga = 25000; break;
                case "IB" : namaMenu = "Ikan Bakar"; harga = 35000; break;
                case "NUK": namaMenu = "Nasi Uduk Komplit"; harga = 20000; break;
            }

            if (!namaMenu.equals("")) {
                double itemTotal = totalPorsi * harga;
                totalGross += itemTotal;

                // Memasukkan baris per menu ke dalam list string
                outputList += String.format("%-22s %-10.1f %-10d %-10d\n", namaMenu, totalPorsi, harga, (int)itemTotal);
            }
        }

        // Logika penentuan kupon diskon kelipatan 100rb
        double diskonPersen = 0;
        String namaKupon = "-";

        if (totalGross >= 500000) { diskonPersen = 0.25; namaKupon = "Kupon Hitam (25%)"; }
        else if (totalGross >= 400000) { diskonPersen = 0.20; namaKupon = "Kupon Hijau (20%)"; }
        else if (totalGross >= 300000) { diskonPersen = 0.15; namaKupon = "Kupon Merah (15%)"; }
        else if (totalGross >= 200000) { diskonPersen = 0.10; namaKupon = "Kupon Kuning (10%)"; }
        else if (totalGross >= 100000) { diskonPersen = 0.05; namaKupon = "Kupon Biru (5%)"; }

        double potongan = totalGross * diskonPersen;
        double totalNet = totalGross - potongan;

        // CETAK STRUK FINAL (Format sesuai image_34ab3c.png)
        System.out.println("\n          WARUNG MAK ROBY - IT DEL           ");
        System.out.println("**************************************************");
        System.out.printf("%-22s %-10s %-10s %-10s\n", "Menu", "Porsi", "Harga", "Total");
        System.out.println("==================================================");
        
        // Cetak daftar makanan yang sudah disimpan tadi
        System.out.print(outputList);

        System.out.println("==================================================");
        System.out.printf("Subtotal              : Rp %d\n", (int)totalGross);
        System.out.println("Kupon Diperoleh       : " + namaKupon);
        System.out.printf("TOTAL BAYAR           : Rp %d\n", (int)totalNet);
        System.out.println("**************************************************");
        System.out.println("   Tugas numpuk, perut kenyang, hati tenang!   ");

        sc.close();
    }
}
