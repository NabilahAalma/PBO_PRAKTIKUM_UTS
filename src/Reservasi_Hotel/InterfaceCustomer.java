package Reservasi_Hotel;

// interface menyembunyika code dari method
public interface InterfaceCustomer {
    public String getNamaCust();
    public String getKontakCust();
    public String getAlamatCust();
    public void pesanKamar(String namaCust, String kontakCust, String alamatCust);
    public boolean cekKetersediaan(String tipeKamar, int jumlah);
}