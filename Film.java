package lab.tubes;

import java.util.ArrayList;

public class Film {
    String judul;
    String genre;
    int durasi;
    double rating;
    String sipnosis;
    ArrayList<Jadwal> jadwalList;
    
    // int harga;

    public Film(String judul, String genre, int durasi, double rating, String sipnosis){
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.rating = rating;
        this.sipnosis = sipnosis;
        this.jadwalList = new ArrayList<>();
    }

    public void tambahJadwal(Jadwal jadwal){
        this.jadwalList.add(jadwal);              //anggap untuk add daripada variable jadwal main
    }

    public void tampilInfo(){
        System.out.println("Judul: " + judul);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + durasi);
        System.out.println("Rating: " + rating);
        System.out.println("Sipnosis: " + sipnosis);
        System.out.println("");
        System.out.println("Jadwal Tayang: " + judul);
        if(jadwalList.isEmpty()){
            System.out.println("\n Jadwal Belum Tersedia...");
        } else {
            for(int i = 0; i < jadwalList.size(); i++){
                System.out.println("\n Jadwal ke-" + (i + 1) + ".");
                jadwalList.get(i).tampilInfo();
            }
        }
    }
}
