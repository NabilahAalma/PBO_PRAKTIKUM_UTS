package Reservasi_Hotel;

// Class abstraksi untuk Kamar atau Room disini objeknya
public abstract class Room {
    protected String tipe_kamar;
    protected double harga;
    protected int stok;
    protected int id;

    public abstract void displayRoomInfo();

    public double getPrice() {return harga;}
    public int getStok() {return stok;}
    public int getId() {return id;}
    public String gettipeKamar() {return tipe_kamar;}
}