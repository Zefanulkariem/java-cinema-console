package lab.tubes;

import java.util.ArrayList;

public class SearchFilm {
    
    public static ArrayList<Film> cariFilm(ArrayList<Film> filmList, String keyword) {

        ArrayList<Film> hasil = new ArrayList<>();

        for (int i = 0; i < filmList.size(); i++) {
            Film film = filmList.get(i);

            String judulKecil = "";
            for (int j = 0; j < film.judul.length(); j++) {
                char huruf = film.judul.charAt(j);
                if (huruf >= 'A' && huruf <= 'Z') {
                    huruf = (char)(huruf + 32);
                }
                judulKecil = judulKecil + huruf;
            }

            String keywordKecil = "";
            for (int j = 0; j < keyword.length(); j++) {
                char huruf = keyword.charAt(j);
                if (huruf >= 'A' && huruf <= 'Z') {
                    huruf = (char)(huruf + 32);
                }
                keywordKecil = keywordKecil + huruf;
            }

            boolean ketemu = false;

            if (keywordKecil.length() <= judulKecil.length()) {
                
                for (int posisi = 0; posisi <= judulKecil.length() - keywordKecil.length(); posisi++) {
                    boolean cocok = true;

                    for (int k = 0; k < keywordKecil.length(); k++) {
                        if (judulKecil.charAt(posisi + k) != keywordKecil.charAt(k)) {
                            cocok = false;
                            break;
                        }
                    }
                    
                    if (cocok) {
                        ketemu = true;
                        break;
                    }
                }
            }

            if (ketemu) {
                hasil.add(film);
            }
        }

        return hasil;
    }
}
