package Reservasi_Hotel;

// Class untuk tipe kamar dengan polimorfisme
public class Standard_NonAC extends Room {
    public Standard_NonAC() {
        this.tipe_kamar = "Standard Non-AC";
        this.harga = 3500000;
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("Tipe kamar: " + tipe_kamar + ", Price: Rp. " + harga);
    }
    public String getTipeKamar() {return tipe_kamar;}
}