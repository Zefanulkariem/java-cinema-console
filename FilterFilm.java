package lab.tubes;

import java.util.ArrayList;

public class FilterFilm {
    
    
    public static ArrayList<Film> filterByTanggal(ArrayList<Film> filmList, String tanggal) {
        ArrayList<Film> hasil = new ArrayList<>();
        
        // Loop semua film
        for (int i = 0; i < filmList.size(); i++) {
            Film film = filmList.get(i);
            
            // Loop semua jadwal dalam film ini
            for (int j = 0; j < film.jadwalList.size(); j++) {
                Jadwal jadwal = film.jadwalList.get(j);
                
                // Cek apakah tanggal cocok
                if (jadwal.tanggal.equals(tanggal)) {
                    hasil.add(film);
                    break; // Film sudah ditambahkan, skip jadwal lainnya
                }
            }
        }
        
        return hasil;
    }
    

    public static ArrayList<Film> filterByGenre(ArrayList<Film> filmList, String genre) {
        ArrayList<Film> hasil = new ArrayList<>();
        
        // Ubah genre jadi huruf kecil untuk perbandingan
        String genreKecil = "";
        for (int i = 0; i < genre.length(); i++) {
            char huruf = genre.charAt(i);
            if (huruf >= 'A' && huruf <= 'Z') {
                huruf = (char)(huruf + 32);
            }
            genreKecil = genreKecil + huruf;
        }
        
        // Loop semua film
        for (int i = 0; i < filmList.size(); i++) {
            Film film = filmList.get(i);
            
            // Ubah genre film jadi huruf kecil
            String filmGenreKecil = "";
            for (int j = 0; j < film.genre.length(); j++) {
                char huruf = film.genre.charAt(j);
                if (huruf >= 'A' && huruf <= 'Z') {
                    huruf = (char)(huruf + 32);
                }
                filmGenreKecil = filmGenreKecil + huruf;
            }
            
            // Cek apakah genre cocok
            if (filmGenreKecil.equals(genreKecil)) {
                hasil.add(film);
            }
        }
        
        return hasil;
    }
    
    // ========== METHOD 3: FILTER BY TANGGAL DAN GENRE (KOMBINASI) ==========
    public static ArrayList<Film> filterByTanggalDanGenre(ArrayList<Film> filmList, String tanggal, String genre) {
        ArrayList<Film> hasil = new ArrayList<>();
        
        // Ubah genre jadi huruf kecil
        String genreKecil = "";
        for (int i = 0; i < genre.length(); i++) {
            char huruf = genre.charAt(i);
            if (huruf >= 'A' && huruf <= 'Z') {
                huruf = (char)(huruf + 32);
            }
            genreKecil = genreKecil + huruf;
        }
        
        // Loop semua film
        for (int i = 0; i < filmList.size(); i++) {
            Film film = filmList.get(i);
            
            // Ubah genre film jadi huruf kecil
            String filmGenreKecil = "";
            for (int j = 0; j < film.genre.length(); j++) {
                char huruf = film.genre.charAt(j);
                if (huruf >= 'A' && huruf <= 'Z') {
                    huruf = (char)(huruf + 32);
                }
                filmGenreKecil = filmGenreKecil + huruf;
            }
            
            // Cek apakah genre cocok
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