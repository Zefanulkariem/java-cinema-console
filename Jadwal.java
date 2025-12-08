package lab.tubes;

public class Jadwal {
    String hari;
    String jam;
    String studio;

    public Jadwal(String hari, String jam, String studio){
        this.hari = hari;
        this.jam = jam;
        this.studio = studio;
    }

    public void tampilInfo(){
        System.out.println("Hari: " + hari);
        System.out.println("Jam: " + jam);
        System.out.println("Studio: " + studio);
    }
}
