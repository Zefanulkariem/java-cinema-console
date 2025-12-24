package lab.tubes;

public class Jadwal {
    String tanggal;
    String hari;
    String jam;
    String studio;
    String harga;

    public void tampilInfo(){
        System.out.println("║ Tanggal: " + tanggal);
        System.out.println("║ Hari: " + hari);
        System.out.println("║ Jam: " + jam);
        System.out.println("║ Studio: " + studio);
        System.out.println("║ Harga: " + harga);
    }
}
