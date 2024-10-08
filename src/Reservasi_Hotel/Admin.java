package Reservasi_Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin implements InterfaceAdmin {
    private List<Customer> customers = new ArrayList<>();
    private List<Room> kamarTersedia = new ArrayList<>();
    private String nama_Cust;
    private String kontak_Cust;
    private String alamat_Cust;
    protected String tipe_kamar;
    protected double harga;
    protected int stok;
    protected int id;

    public double getPrice() {return harga;}
    public int getStok() {return stok;}
    public int getId() {return id;}
    public String gettipeKamar() {return tipe_kamar;}
        
    public Admin() {
        kamarTersedia.add(new Standard_NonAC());
        kamarTersedia.add(new Standard_AC());
        // hanya memberikan 2 tipe saja agar sederhana
    }

    public Admin(String nama_Cust, String kontak_Cust, String alamat_Cust) {
        this.nama_Cust = nama_Cust;
        this.kontak_Cust = kontak_Cust;
        this.alamat_Cust = alamat_Cust;
        this.tampilReservasi();
        this.isiStok(nama_Cust, 0);
        this.cekKetersediaan(nama_Cust, 0);
    }

    public String getNamaCust() {return nama_Cust;}
    public String getKontakCust() {return kontak_Cust;}
    public String getAlamatCust() {return alamat_Cust;}
    
    public void pesanKamar(String namaCust, String kontakCust, String alamatCust) {
        Scanner inputan = new Scanner(System.in);

        System.out.println("Pilih Tipe Kamar yang Tersedia:");
        for (int i = 0; i < kamarTersedia.size(); i++) {
            Room room = kamarTersedia.get(i);
            System.out.println((i + 1) + ". " + room.tipe_kamar + " - Rp" + room.harga + " | Stok: " + room.stok);
        }

        System.out.print("Masukkan nomor tipe kamar yang diinginkan: ");
        int pilihanKamar = inputan.nextInt();

        // Validasi input
        if (pilihanKamar < 1 || pilihanKamar > kamarTersedia.size()) {
            System.out.println("Pilihan tidak valid. Kamar tidak berhasil dipesan.");
            return;
        }

        Room pesanKamar = kamarTersedia.get(pilihanKamar - 1);

        // Meminta jumlah kamar yang ingin dipesan
        System.out.print("Masukkan jumlah kamar yang ingin dipesan: ");
        int jumlah = inputan.nextInt();

        // Cek ketersediaan sebelum memesan
        if (cekKetersediaan(pesanKamar.tipe_kamar, jumlah)) {
            Customer customer = new Customer(namaCust, kontakCust, alamatCust);
            customers.add(customer);
            pesanKamar.stok -= jumlah; // Mengurangi stok setelah pemesanan

            System.out.println("-------------------------------------------");
            System.out.println("       Kamar Berhasil Dipesan Untuk        " + customer.getNamaCust());
            System.out.println("------------ Detail Reservasi ------------");
            System.out.println("Reservasi Kamar: " + pesanKamar.tipe_kamar);
            System.out.println("Biaya Kamar /malam: Rp" + pesanKamar.harga);
            System.out.println("ID Kamar: " + pesanKamar.id);
            System.out.println("Nama Pelanggan: " + customer.getNamaCust());
            System.out.println("Kontak Pelanggan: " + customer.getKontakCust());
            System.out.println("Alamat Pelanggan: " + customer.getAlamatCust());
            System.out.println("Jumlah Kamar Dipesan: " + jumlah);
        } else {
            System.out.println("Maaf, tidak cukup stok untuk " + jumlah + " kamar " + pesanKamar.tipe_kamar + ".");
        }
    }

    // Method tampil detail reservasi yang sudah dilakukan pelanggan secara otomatis di eksekusi saat reservasi pesan kamar sudah berhasil
    public void tampilReservasi() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        if (customers.isEmpty()) { // Check if the list is empty
            System.out.println("Belum Ada Kamar yang Berhasil Di Reservasi");
        } else {
             System.out.println("===================================== Reservasi Berhasil Disimpan ======================================");
            for (Customer customer : customers) {
                System.out.printf("Nama: %s, Kontak: %s, Alamat: %s", customer.getNamaCust(), customer.getKontakCust(), customer.getAlamatCust());
                System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
    // Method untuk mengisi stok kamar
    public void isiStok(String tipeKamar, int jumlah) {
        for (Room room : kamarTersedia) {
            if (room.tipe_kamar.equals(tipeKamar)) {
                room.stok += jumlah;
                System.out.println("Stok berhasil diperbarui: " + jumlah + " kamar " + tipeKamar + " ditambahkan.");
                System.out.println("Total stok sekarang: " + room.stok);
                return;
            }
        }
        System.out.println("Tipe kamar tidak valid.");
    }
        
    public boolean cekKetersediaan(String tipeKamar, int jumlah) {
        for (Room room : kamarTersedia) {
            if (room.tipe_kamar.equals(tipeKamar) && room.stok >= jumlah) {
                return true;
            }
        }
        return false;
    }
    
}
