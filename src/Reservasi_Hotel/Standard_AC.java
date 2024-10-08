package Reservasi_Hotel;

// Class untuk tipe kamar dengan polimorfisme
public class Standard_AC extends Room {
    public Standard_AC() {
        this.tipe_kamar = "Standard AC";
        this.harga = 4000000;
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("Tipe Kamar: " + tipe_kamar + ", Price: Rp. " + harga);
    }
    public String getTipeKamar() {return tipe_kamar;}
}