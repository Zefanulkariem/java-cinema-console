package lab.tubes;

import java.util.ArrayList;

public class FilterFilm {
    
    public static ArrayList<Film> filterByTanggalDanGenre(ArrayList<Film> filmList, String tanggal, String genre) {
        ArrayList<Film> hasil = new ArrayList<>();
        
        String genreKecil = "";

        for (int i = 0; i < genre.length(); i++) {
            char huruf = genre.charAt(i);
            if (huruf >= 'A' && huruf <= 'Z') {
                huruf = (char)(huruf + 32);
            }
            genreKecil = genreKecil + huruf;           //ngubah upper ke lower
        }
        

        for (int i = 0; i < filmList.size(); i++) {          //program bandingkan
            Film film = filmList.get(i);
            
            String filmGenreKecil = "";
            for (int j = 0; j < film.genre.length(); j++) {
                char huruf = film.genre.charAt(j);
                if (huruf >= 'A' && huruf <= 'Z') {
                    huruf = (char)(huruf + 32);
                }
                filmGenreKecil = filmGenreKecil + huruf;
            }
            
            
            boolean genreCocok = filmGenreKecil.equals(genreKecil);
            
            // Cek apakah ada jadwal dengan tanggal yang cocok
            boolean tanggalCocok = false;
            for (int j = 0; j < film.jadwalList.size(); j++) {
                if (film.jadwalList.get(j).tanggal.equals(tanggal)) {
                    tanggalCocok = true;
                    break;
                }
            }
            
            // Kalau genre DAN tanggal cocok, tambahkan
            if (genreCocok && tanggalCocok) {
                hasil.add(film);
            }
        }
        
        return hasil;
    }
}