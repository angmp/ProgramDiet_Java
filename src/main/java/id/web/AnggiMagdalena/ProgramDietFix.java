/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.web.AnggiMagdalena;

import java.util.Scanner; //Digunakan untuk membaca input pengguna
import java.io.BufferedWriter; //Digunakan untuk menulis data ke file
import java.io.BufferedReader; //Digunakan untuk membaca data ke file
import java.io.FileReader; //Digunakan untuk membuka dan membaca data dari file
import java.io.FileWriter; //Digunakan untuk membuka dan menulis data ke file
import java.io.IOException; //Digunakan untuk digunakan untuk menangani kesalahan yang mungkin terjadi
import java.util.regex.Matcher; //Digunakan untuk memeriksa apakah sebuah string sesuai dengan pola yang diinginkan
import java.util.regex.Pattern; //Digunakan untuk mendefinisikan pola yang digunakan oleh ‘Matcher’

/**
 *
 * @author Lenovo
 */

public class ProgramDietFix {
    public static void main(String[] args) throws IOException { //Metode yang digunakan untuk memulai eksekusi program
    Scanner Scanner = new Scanner(System.in);
        
        //Welcome text bagi pengguna
        //NutriNerd adalah sebutan untuk pengguna
        //NutriNavigator adalah sebutan untuk pemandu
    System.out.println("""
                           Halo NutiNerd
                           Selamat datang di Ctrl+Alt+Eat!
                           Ctrl+Alt+Eat akan menjadi panduan setia NutriNerd mencapai tujuan diet dengan metode yang tepat
                           Bersiaplah untukk mengeksplorasi pilihan sehatmu dan meraih pencapaian yang kamu inginkan dengan menjadi versi terbaik dirimu!""");
        
        //Memastikan pengguna memasukan pilihan yang tepat
        boolean mulaiPerjalanan = false;
        while (!mulaiPerjalanan) {
            System.out.print("Apakah NutriNerd ingin memulai perjalanan diet? (Y/N) : ");
                String perjalanan = Scanner.nextLine();
            
            //Cek apakah penggguna ingin melanjutkan perjalanan
            if (perjalanan.equalsIgnoreCase("Y")) {
                menuProgram();
                mulaiPerjalanan = true;
            } else if (perjalanan.equalsIgnoreCase("N")) {
                System.out.println("Silahkan datang di lain waktu yaa");
                mulaiPerjalanan = true;
            } else {
                System.out.println("\nPilihan tidak valid. Silahkan pilih (Y/N)");
            }
        }
    }
    

    private static void menuProgram() throws IOException { //Metode yang digunakan untuk menampilkan pesan welcome text dan memanggil metode ‘dataPengguna()’ jika ingin memulai
        
        //Pengguna memasukan data terlebih dahulu
        System.out.println("""
                           \nHalo NutriNerd
                            Perkenalkan aku NutriNavigator yang akan menemani NutriNerd selama perjalanan diet NutriNerd
                            Ayo mulai perjalanan ini dengan semangat besar
                            Yuk! isi data diri NutriNerd terlebih dahulu sebelum memulai perjalanan diet!""");
                           dataPengguna();
                           pilihanMenu();
    }
    
    
    private static void pilihanMenu() throws IOException { //Metode yang digunakan untuk menampilkan menu pilihan untuk dipilih
                            
        //Pilihan menu
        try (input) {
            //Pilihan menu
            int choice;
            do {
                System.out.println("""
                                   \nHalo NutriNerd, berikut adalah pilihan untuk melanjutkan program diet NutriNerd
                                   Menu pilihan :
                                   1. Asupan Harian
                                   2. Asupanku
                                   3. Keluar""");
                System.out.print("Pilih menu (1-3): ");
                choice = input.nextInt();
                input.nextLine();
    
                // Proses pilihan
                switch (choice) {
                    case 1 -> asupanHarian();
                    case 2 -> asupanKu();
                    case 3 -> System.out.println("""
                                           Terima kasih atas waktunya NutriNerd! 
                                           Ingatlah, perubahan yang NutriNerd lakukan dimulai dari keputusan kecil
                                           Tetap konsisten. Pertahankan semangatmu NutriNerd!!!
                                           NutriNavigator akan selalu setia menunggumu!
                                           """);
                    default -> System.out.println("Pilihan tidak valid. Silakan pilih angka (1-3)");
                }
            } while (choice != 3);
        }
    }

    
    private static void dataPengguna() throws IOException { //Mtode yang digunakan untuk mengumpulkan data pengguna
        Scanner scanner = new Scanner(System.in);

        // Input data pengguna
        System.out.println("\n============= Data Pengguna =============");
        
        //Validasi input pengguna agar sesuai
        String nama;
        do {
            System.out.print("Nama : ");
                nama = scanner.nextLine();
                if (nama.trim().isEmpty()) {
                    System.out.println("Nama tidak dapat kosong. Silakan masukan kembali");
                } else if (nama.matches(".*\\d.*")) {
                    System.out.println("Nama tidak boleh mengandung angka. Silakan masukan kembali");
                }
        } while (nama.trim().isEmpty() || nama.matches(".*\\d.*"));
    
        int usia;
        do {
            System.out.print("Usia : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Usia harus berupa angka.Silakan masukan kembali");
                    System.out.print("Usia : ");
                    scanner.next();
                } 
                usia = scanner.nextInt();
                if (usia <= 0) {
                    System.out.println("Usia harus lebih dari 0. Silakan masukan kembali");
                }
        } while (usia <=0);
        
        String jenisKelamin;
        do {
            System.out.print("Jenis Kelamin (Pria/Wanita) : ");
                jenisKelamin = scanner.next();
                if (!jenisKelamin.equalsIgnoreCase("Pria") && !jenisKelamin.equalsIgnoreCase("Wanita")) {
                    System.out.println("Jenis kelamin harus Pria atau Wanita. Silakan masukan kembali");
                }
        } while (!jenisKelamin.equalsIgnoreCase("Pria") && !jenisKelamin.equalsIgnoreCase("Wanita"));
        
        double tinggiBadan;
        do {
            System.out.print("Tinggi Badan (cm) : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Tinggi Badan harus berupa angka.Silakan masukan kembali");
                    System.out.print("Tinggi Badan (cm) : ");
                    scanner.next();
                } 
                tinggiBadan = scanner.nextInt();
                if (tinggiBadan <= 0) {
                    System.out.println("Tinggi Badan harus lebih dari 0. Silakan masukan kembali");
                }
        } while (tinggiBadan <=0);
        
        double beratBadan;
        do {
            System.out.print("Berat badan (kg) : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Berat Badan harus berupa angka.Silakan masukan kembali");
                    System.out.print("Berat Badan (cm) : ");
                    scanner.next();
                } 
                beratBadan = scanner.nextInt();
                if (beratBadan <= 0) {
                    System.out.println("Berat Badan harus lebih dari 0. Silakan masukan kembali");
                }
        } while (beratBadan <=0);
            
        //Pilihan tingkatan aktivitas
        System.out.println("""
                           Pilihan tingkatan aktivitas :
                           1. Sangat sedikit (Tidak pernah berolahraga hanya sesekali)
                           2. Sedikit (Melakukan sedikit olahraga)
                           3. Cukup (Melakukan cukup olahraga secara berkelanjutan)
                           4. Tinggi (Melakukan olahraga secara rutin)
                           5. Sangat tinggi (Melakukan olahraga dengan jadwal yang padat)""");
        System.out.print("Tingkat Aktivitas (1-5): ");    
            int tingkatAktivitas = scanner.nextInt();
            
        double targetBeratBadan;
        do {
            System.out.print("Target Berat Badan (kg): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Berat Badan harus berupa angka.Silakan masukan kembali");
                    System.out.print("Target Berat Badan (kg): ");
                    scanner.next();
                } 
                targetBeratBadan = scanner.nextInt();
                if (targetBeratBadan <= 0) {
                    System.out.println("Berat Badan harus lebih dari 0. Silakan masukan kembali");
                }
        } while (targetBeratBadan <=0);
        
        int targetWaktu;
        do {
            System.out.print("Target Penurunan berat badan (hari) : ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Berat Badan harus berupa angka.Silakan masukan kembali");
                    System.out.print("Target Berat Badan (kg): ");
                    scanner.next();
                } 
                targetWaktu = scanner.nextInt();
                if (targetWaktu <= 0) {
                    System.out.println("Berat Badan harus lebih dari 0. Silakan masukan kembali");
                }
        } while (targetWaktu <=0);
            
        // Hitung BMI
        double bmi = hitungBMI(tinggiBadan, beratBadan);
        String kategoriBMI = kategoriBMI(bmi);

        // Menentukan faktor aktivitas berdasarkan tingkatan aktivitas
        double faktorAktivitas = 0;
        switch (tingkatAktivitas) {
            case 1 -> faktorAktivitas = 1.2;
            case 2 -> faktorAktivitas = 1.375;
            case 3 -> faktorAktivitas = 1.55;
            case 4 -> faktorAktivitas = 1.725;
            case 5 -> faktorAktivitas = 1.9;
            default -> System.out.println("Tingkatan aktivitas tidak valid, harap masukan skala 1-5");
        }
        
        //Hitung BMR, jumlah kalori yang diperlukan
        double bmr = 0;
        if (jenisKelamin.equalsIgnoreCase("Pria")) {
            bmr = 66.5 + (13.75 * beratBadan) + (5.0003 * tinggiBadan) - (6.75 * usia);
        } else if (jenisKelamin.equalsIgnoreCase("Wanita")) {
            bmr = 655.1 + (9.563 * beratBadan) + (1.850 * tinggiBadan) - (4.676 * usia);
        } else {
            System.out.println("Jenis kelamin tidak valid");
        }
        
        //Kebutuhan kalori harian
        int defisitKaloriNormal = 500;
        double kebutuhanKalori = bmr * faktorAktivitas;
        double kaloriTargetWaktu = kebutuhanKalori - defisitKaloriNormal;
        
        //Kebutuhan Air
        double faktorKebutuhanAir = 30 * beratBadan;
       
                
        // Tampilkan hasil
        System.out.println("\n============= Hasil =============");
        System.out.println("BMI NutriNerd adalah " + bmi + " dengan kategori BMI NutriNerd tergolong " + kategoriBMI);
        System.out.println("Jumlah kalori yang dibutuhkan NutriNerd per hari sebesar " + kebutuhanKalori + " kcal");
        System.out.println("Dengan target waktu " + targetWaktu + " hari, NutriNNerd membutuhkan kalori sebanyak " + kaloriTargetWaktu + " per hari");
        System.out.println("Kebutuhan asupan air NutriNerd sebanyak " + faktorKebutuhanAir + " ml per hari");
        System.out.println("Berdasarkan tingkatan aktivitas NutriNerd, Nutrinerd perlu : ");
    
        if (tingkatAktivitas == 1) {
            System.out.println("melakukan aktivitas ringan seperti berjalan kaki secara teratur");
        } else if (tingkatAktivitas == 2) {
            System.out.println("melakukan olahraga ringan seperti jogging atau senam secara teratur");
        } else if (tingkatAktivitas == 3) {
            System.out.println("melakukan aktivitas olahraga yang cukup rutin seperti berlari atau bersepeda secara teratur");
        } else if (tingkatAktivitas == 4) {
            System.out.println("mempertahankan aktivitas olahraga dengan lebih rajin secara teratur");
        } else if (tingkatAktivitas == 5) {
            System.out.println("mempertahankan aktivitas olahraga dan mencoba aktivitas olahraga lainnya dengan intenditas lebih tinggi secara teratur");
        }
        
        //Menyimpan data
        try {
            try (FileWriter writer = new FileWriter("dataPengguna.txt", true)) {

                writer.write("\nNama : " + nama + "\n");
                writer.write("Umur : " + usia + "\n");
                writer.write("Jenis Kelamin : " + jenisKelamin + "\n");
                writer.write("Tinngi Badan : " + tinggiBadan + "\n");
                writer.write("BeratBadan : " + beratBadan + "\n");
                writer.write("Tingkat Aktivitas : " + tingkatAktivitas + "\n");
                writer.write("Target Berat Badan : " + targetBeratBadan + "\n");
                writer.write("BMI : " + bmi + "\n");
                writer.write("Kategori BMI : " + kategoriBMI + "\n");
                writer.write("Jumlah kalori yang dibutuhkan Per hari : " + kebutuhanKalori + "kcal\n");
                writer.write("Jumlah kalori yang dibutuhkan sesuai target berat badan : " + kaloriTargetWaktu + "\n");
                writer.write("Kebutuhan asupan air harian : " + faktorKebutuhanAir + "\n");
                writer.write("                                                              ");
            }
            System.out.println("Data NutriNerd berhasil disimpan");
        } catch (IOException e) {
            System.out.println("Data NutriNerd gagal disimpan");
        }
    }

    
    private static void asupanHarian() throws IOException { //Metode yang digunakan untuk memulai kontrol asupan dan akan memanggil metode ‘memulaiAsupan()’ jika ingin memulai
        System.out.println("\n=== Asupan Harian ===");
        System.out.println("""
                           Pada bagian ini, NutriNerd dapat memantau jumlah asupan nutrisi harian
                           seperti jumlah kalori, karbohidrat, protein, dan lemak
                           NutriNerd akan mengetahui sejauh mana asupan nutrisi untuk memnuhi kebutuhan harian NutriNerd""");
        
        String asupan;
        do {
            System.out.print("Apakah NutriNerd ingin memulai kontrol asupan harian? (Y/N) : ");
                asupan = input.nextLine();
            
            //Cek apakah penggguna ingin melanjutkan perjalanan
            if (asupan.equalsIgnoreCase("Y")) {
                memulaiAsupan();
            } else if (asupan.equalsIgnoreCase("N")) {
                menuProgram();
            } else {
                System.out.println("\nPilihan tidak valid. Silahkan pilih (Y/N)");
            }
        } while (!asupan.equalsIgnoreCase("Y") && !asupan.equalsIgnoreCase("N"));
    }
      
        
    private static void memulaiAsupan() {
        
        String tanggalTulis;
        do {
        System.out.print("\nMasukkan tanggal (format YYYY-MM-DD) : ");
            tanggalTulis = input.nextLine();
        } while (!isValidFormat(tanggalTulis));
            
        System.out.print("Jumlah makanan yang ingin dimasukkan : ");    
        int jumlahMakanan;
        while (true) {
            try {
                jumlahMakanan = Integer.parseInt(input.nextLine());
                if (jumlahMakanan > 0) {
                    break;
                } else {
                    System.out.println("Jumlah makanan harus lebih darii 0. Silakan masukan kembali");
                } 
            } catch (NumberFormatException e) {
                        System.out.println("Masukan angka yang valid. Silakan masukan kembali");
                }
            }

        double totalKalori = 0;
        double totalKarbohidrat = 0;
        double totalProtein = 0;
        double totalLemak = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("AsupanKu.txt", true))) {
            writer.write("Tanggal: " + tanggalTulis);
            writer.newLine();

            for (int i = 1; i <= jumlahMakanan; i++) {
                System.out.println("Makanan ke-" + i);

                // Input nama makanan 
                System.out.print("Nama Makanan : ");
                String namaMakanan = input.nextLine();

                // Input jumlah gram dengan validasi
                double jumlahGram = 0;
                while (true) {
                    System.out.print("Jumlah (gram) : ");
                    String inputStr = input.nextLine();
                    try {
                        jumlahGram = Double.parseDouble(inputStr);
                        if (jumlahGram > 0) break;
                        else System.out.println("Jumlah makanan harus lebih dari 0. Silakan masukkan kembali.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka valid. Gunakan titik untuk desimal, misal 50.5");
                    }
                }

                // Input kalori per 100 gram dengan validasi
                double kaloriPer100Gram = 0;
                while (true) {
                    System.out.print("Kalori per 100 gram : ");
                    String inputStr = input.nextLine();
                    try {
                        kaloriPer100Gram = Double.parseDouble(inputStr);
                        if (kaloriPer100Gram > 0) break;
                        else System.out.println("Kalori harus lebih dari 0.");
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus angka valid. Gunakan titik untuk desimal.");
                    }
                }

                // Hitung kalori per gram
                double kaloriPerGram = kaloriPer100Gram / 100;

                // Hitung asupan kalori, karbohidrat, protein, dan lemak
                double asupanKalori = jumlahGram * kaloriPerGram;
                double asupanKarbohidrat = (35.71 / 100) * (asupanKalori / 4);
                double asupanProtein = (20.0 / 100) * (asupanKalori / 4);
                double asupanLemak = (15.0 / 100) * (asupanKalori / 9);

                // Tambahkan ke total
                totalKalori += asupanKalori;
                totalKarbohidrat += asupanKarbohidrat;
                totalProtein += asupanProtein;
                totalLemak += asupanLemak;

                // Tulis ke file
                writer.write("\nMakanan ke-" + i + " : " + namaMakanan);
                writer.newLine();
                writer.write("Asupan Kalori : " + asupanKalori + " kcal");
                writer.newLine();
                writer.write("Asupan Karbohidrat : " + asupanKarbohidrat + " gram");
                writer.newLine();
                writer.write("Asupan Protein : " + asupanProtein + " gram");
                writer.newLine();
                writer.write("Asupan Lemak : " + asupanLemak + " gram");
                writer.newLine();

                if (i < jumlahMakanan) {
                    writer.newLine();
                }
            }

            // Tulis total ke file
            writer.write("\nTotal Asupan :");
            writer.newLine();
            writer.write("Total Kalori : " + totalKalori + " kcal");
            writer.newLine();
            writer.write("Total Karbohidrat : " + totalKarbohidrat + " gram");
            writer.newLine();
            writer.write("Total Protein : " + totalProtein + " gram");
            writer.newLine();
            writer.write("Total Lemak : " + totalLemak + " gram");
            writer.newLine();
            writer.write("=================================================");
            writer.newLine();
            writer.newLine();


            System.out.println("Data asupan harian berhasil disimpan.");

        } catch (IOException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
        }
    }
    private static final Scanner input = new Scanner (System.in);
    private static void asupanKu() {
        System.out.print("Masukkan tanggal yang ingin dibaca (format YYYY-MM-DD): ");
        String tanggalBacaPengguna = input.nextLine();
        String file = "AsupanKu.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String baris;
        boolean catatanDitemukan = false;

        while ((baris = reader.readLine()) != null) {
            if (baris.startsWith("Tanggal: " + tanggalBacaPengguna)) {
            catatanDitemukan = true;
            System.out.println(baris);

        // Membaca semua baris hingga baris "Total Asupan:"
        while ((baris = reader.readLine()) != null && !baris.startsWith("=================================================")) {
            System.out.println(baris);
        }

        // Membaca baris "Total Asupan:" dan mencetaknya
        if (baris != null) {
            System.out.println(baris);
        }

        break;
        }
    }

        if (!catatanDitemukan) {
            System.out.println("Catatan tidak ditemukan untuk tanggal " + tanggalBacaPengguna);
        }

        } catch (IOException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
    }
}

    private static boolean isValidFormat(String tanggal) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tanggal);
        
        if (!matcher.matches()) {
            System.out.println("Format tanggal tidak sesuai. Silakan masukan kembali");
            return false;
        }
        
        return true;
    }
    
    private static double hitungBMI(double tinggiBadan, double beratBadan) {
        return beratBadan / Math.pow((tinggiBadan / 100), 2);
    }

    private static String kategoriBMI(double bmi) {
        if (bmi < 18.5) {
            return "Kurus";
        } else if (bmi >=18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Berlebihan";
        } else if (bmi >= 30.0 && bmi <= 34.9) {
            return "Obesitas tingkat 1";
        } else if (bmi >= 35.0 && bmi <= 39.9) {
            return "Obesitas tingkat 2";
        } else {
            return "Obesitas tingkat 3";
        }
    }
}