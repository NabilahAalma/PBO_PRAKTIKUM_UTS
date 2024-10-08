package Reservasi_Hotel;

import java.util.Scanner;

public class SistemReservasiHotel {
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        Customer customers = new Customer();
        Admin admins = new Admin();
        
        while (true) {
            System.out.println("===  APLIKASI RESERVASI HOTEL ===");
            System.out.println("[1] Masuk sebagai Customer");
            System.out.println("[2] Masuk sebagai Admin");
            System.out.println("[3] Exit");
            System.out.print("Input Opsi: ");
            int roleOption = inputan.nextInt();
            inputan.nextLine();

            switch (roleOption) {
                case 1: // Customer
                    while (true) {
                        System.out.println("\n---------- Menu Customer ---------");
                        System.out.println("[1] Pesan Kamar");
                        System.out.println("[2] Kamar yang Tersedia");
                        System.out.println("[3] Detail Reservasi");
                        System.out.println("[4] Kembali ke Menu Utama");
                        System.out.print("Input Opsi: ");
                        int customerOption = inputan.nextInt();
                        inputan.nextLine();

                        switch (customerOption) {
                            case 1 -> {
                                System.out.print("----------------------------\n");
                                System.out.print("Nama Pelanggan: ");
                                String nama_Cust = inputan.nextLine();
                                System.out.print("Kontak Pengguna: ");
                                String kontak_Cust = inputan.nextLine();
                                System.out.print("Alamat Pengguna: ");
                                String alamat_Cust = inputan.nextLine();
                                
                                // panggil pesanKamar lewat parameter tipeKamar
                                admins.pesanKamar(nama_Cust, kontak_Cust, alamat_Cust);
                                System.out.print("=================================\n");
                    }
                            case 2 -> {
                                System.out.print("Masukkan tipe kamar yang ingin dicek: ");
                                String tipeKamarCek = inputan.nextLine();
                                System.out.print("Masukkan jumlah kamar yang ingin dicek: ");
                                int jumlahCek = inputan.nextInt();

                                if (admins.cekKetersediaan(tipeKamarCek, jumlahCek)) {
                                    System.out.println("Kamar tersedia.");
                                } else {
                                    System.out.println("Maaf, tidak ada cukup stok untuk tipe kamar tersebut.");
                                }
                                }
                            case 3 -> admins.tampilReservasi(); // Menampilkan detail reservasi pelanggan
                            case 4 -> {
                            }
                            default -> System.out.println("Kesalahan Opsi, Silahkan Pilih Lagi");
                        }
                        
                        if (customerOption == 4) break; // Kembali ke menu utama
                    }
                    break;

                case 2: // Admin
                    while (true) {
                        System.out.println("\n------------ Menu Admin --------------");
                        System.out.println("[1] Tampilkan Reservasi");
                        System.out.println("[2] Edit Stok Kamar Reservasi");
                        System.out.println("[3] Kembali ke Menu Utama");
                        System.out.print("Input Opsi: ");
                        int adminOption = inputan.nextInt();
                        inputan.nextLine(); // consume newline

                        switch (adminOption) {
                            case 1 -> admins.tampilReservasi();
                            case 2 ->{                                
                                System.out.print("----------------------------\n");
                                System.out.print("Tipe Kamar: ");
                                String tipe_Kamar = inputan.nextLine();
                                System.out.print("Jumlah Stok Kamar: ");
                                int stokKamar = inputan.nextInt();
                                
                                // panggil pesanKamar lewat parameter tipeKamar
                            admins.isiStok(tipe_Kamar, stokKamar);
                                System.out.print("=================================\n");
                            }
                            case 3 -> {
                            }
                            default -> System.out.println("Kesalahan Opsi, Silahkan Pilih Lagi");
                        }
                        
                        if (adminOption == 3) break; // Kembali ke menu utama
                    }
                    break;

                case 3:
                    // Keluar dari aplikasi
                    System.out.println("Terima kasih telah menggunakan Aplikasi Reservasi Hotel. Sampai jumpa!");
                    inputan.close(); // Menutup scanner
                    return; // Keluar dari program

                default:
                    System.out.println("Kesalahan Opsi, Silahkan Pilih Lagi");
            }
        }
    }
}
