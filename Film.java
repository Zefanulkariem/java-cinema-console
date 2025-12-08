package lab.tubes;

import java.math.BigDecimal;

public class Film {
    String judul;
    String genre;
    Integer durasi;
    BigDecimal rating;
    String sipnosis;
    // String jadwalTayang;

    // int harga;

    public Film(String judul, String genre, Integer durasi, BigDecimal rating, String sipnosis){
        this.judul = judul;
        this.genre = genre;
        this.durasi = durasi;
        this.rating = rating;
        this.sipnosis = sipnosis;
    }

    public void tampilInfo(){
        System.out.println("Judul: " + judul);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + durasi);
        System.out.println("Rating: " + rating);
        System.out.println("Sipnosis: " + sipnosis);
    }
}
