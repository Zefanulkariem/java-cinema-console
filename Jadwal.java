package lab.tubes;

public class Jadwal {
    String tanggal;
    String hari;
    String jam;
    String studio;
    String harga;
    int totalSeats;
    int availableSeats;

    public Jadwal() {
        totalSeats = 50; // Default total seats
        availableSeats = totalSeats;
    }

    public void tampilInfo(){
        System.out.println("║ Tanggal: " + tanggal);
        System.out.println("║ Hari: " + hari);
        System.out.println("║ Jam: " + jam);
        System.out.println("║ Studio: " + studio);
        System.out.println("║ Harga: " + harga);
        System.out.println("║ Kursi Tersedia: " + availableSeats + "/" + totalSeats);
    }
}
