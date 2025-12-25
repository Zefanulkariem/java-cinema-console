package lab.tubes;

import java.util.ArrayList;
import java.util.Scanner;

public class TampilMenu {

    public static void tampilInfoAdmin(ArrayList<Film> filmList, Scanner in){

        int menu;
        String lanjut;

        do{
            System.out.println("");
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                         MENU ADMIN                           ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                              ║");
            System.out.println("║                1.   Input Film Baru                          ║");
            System.out.println("║                2.   Lihat Daftar Film                        ║");
            System.out.println("║                3.   Edit Film                                ║");
            System.out.println("║                4.   Hapus Film                               ║");
            System.out.println("║                5.   Keluar                                   ║");
            System.out.println("║                                                              ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            System.out.print  ("                   Pilih menu (1-5):");   menu = in.nextInt();
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            in.nextLine();
            
            if(menu == 1){
                Film dataFilm = new Film();
                System.out.println("╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║                         INPUT FILM                           ║");
                System.out.println("╠══════════════════════════════════════════════════════════════╣");
                
                System.out.print("║ Input Judul: ");
                dataFilm.judul = in.nextLine();
                
                System.out.print("║ Input Genre: ");
                dataFilm.genre = in.nextLine();
                
                System.out.print("║ Input Durasi (menit): ");
                dataFilm.durasi = in.nextInt();
                
                System.out.print("║ Input Rating: ");
                dataFilm.rating = in.nextDouble();
                in.nextLine();
                
                System.out.println("║ Sipnosis : ");
                System.out.print(  "║ ");dataFilm.sipnosis = in.nextLine();
                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                
                dataFilm.jadwalList = new ArrayList<>();

                do{
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                     INPUT JADWAL FILM                        ║");
                    System.out.println("╠══════════════════════════════════════════════════════════════╣");

                    Jadwal dataJadwal = new Jadwal();

                    System.out.print("║ Tanggal (DD-MM-YYYY): ");
                    dataJadwal.tanggal = in.nextLine();

                    boolean cek = true;
                    while (cek) {
                        System.out.print("║ Hari: ");
                        dataJadwal.hari = in.nextLine().toLowerCase();

                        if (dataJadwal.hari.equals("senin") || dataJadwal.hari.equals("selasa") 
                            || dataJadwal.hari.equals("rabu") || dataJadwal.hari.equals("kamis") 
                            || dataJadwal.hari.equals("jumat")) {
                            dataJadwal.harga = "40.000"; 
                            cek = false;
                        }else if (dataJadwal.hari.equals("sabtu") || dataJadwal.hari.equals("minggu")) {
                            dataJadwal.harga = "60.000";
                            cek = false;
                        }else{
                            System.out.println("Masukan hari yang benar");
                        }
                    }

                    System.out.print("║ Input Jam: ");
                    dataJadwal.jam = in.nextLine();
                    
                    System.out.print("║ Input Studio: ");
                    dataJadwal.studio = in.nextLine();
                    
                    System.out.println("║ Isi jadwal lagi? (y/n): ");
                    System.out.print(  "║ ");lanjut = in.nextLine();
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");

                    dataFilm.jadwalList.add(dataJadwal);     // tambah ke class jadwal

                } while(lanjut.equalsIgnoreCase("y"));

                filmList.add(dataFilm);                      //add: arrayList
                System.out.println("╔══════════════════════════════════════════════════════════════╗");
                System.out.println("║                         Film di Simpan                       ║");
                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                
            } else if (menu == 2) {
                if(filmList.isEmpty()) {                       //add: isEmpty
                    System.out.println("Tidak ada data.");
                } else {                                                     //ganti ke for
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                         Daftar Film                          ║");
                    System.out.println("╠══════════════════════════════════════════════════════════════╣");
                    for(int i = 0; i < filmList.size(); i++){
                        System.out.println("║ \n Film ke-" + (i + 1) + ".");
                        filmList.get(i).tampilInfo();
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    }
                }
            } else if (menu == 3) {
                if(filmList.isEmpty()){
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                  TIDAK ADA FILM UNTUK DI EDIT                ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                } else {
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                   PILIH FILM UNTUK DI EDIT                   ║");
                    System.out.println("╠══════════════════════════════════════════════════════════════╣");
                    for(int i = 0; i < filmList.size(); i++){
                        System.out.println(   "║ "+(i + 1) + ". " + filmList.get(i).judul);
                        System.out.println("╠══════════════════════════════════════════════════════════════╣");
                    }
                    System.out.print(  "║ Pilih nomor film: ");int pilihanFilm = in.nextInt();
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    in.nextLine();
                    
                    if(pilihanFilm < 1 || pilihanFilm > filmList.size()){
                        System.out.println("Pilihan tidak valid.");
                    } else {
                        Film filmEdit = filmList.get(pilihanFilm - 1);
                        
                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("║                      APA YANG INGIN DI EDIT                  ║");
                        System.out.println("╠══════════════════════════════════════════════════════════════╣");
                        System.out.println("║                    1.  Detail Film                           ║");
                        System.out.println("║                    2.  Jadwal Tayang                         ║");
                        System.out.println("║                    3.  Keluar                                ║");
                        System.out.println("╠══════════════════════════════════════════════════════════════╣");
                        System.out.print  ("║                   Pilih menu (1-3):");  int pilihanEdit = in.nextInt();
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                        in.nextLine();
                        
                        if(pilihanEdit == 1){
                            
                            System.out.println("╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║                   DETAIL FILM SAAT INI                       ║");
                            System.out.println("╠══════════════════════════════════════════════════════════════╣");;
                            System.out.println(   "║ Judul: " + filmEdit.judul);
                            System.out.println(   "║ Durasi: " + filmEdit.durasi);
                            System.out.println(   "║ Rating: " + filmEdit.rating);
                            System.out.println(   "║ Sipnosis: " + filmEdit.sipnosis);
                            System.out.println(   "║ Genre: " + filmEdit.genre);
                            System.out.println("╠══════════════════════════════════════════════════════════════╣");;

                            System.out.print("║ Judul baru: ");
                            filmEdit.judul = in.nextLine();
                            
                            System.out.print("║ Durasi baru (menit): ");
                            filmEdit.durasi = in.nextInt();
                            
                            System.out.print("║ Rating baru: ");
                            filmEdit.rating = in.nextDouble();
                            in.nextLine();
                            
                            System.out.print("║ Genre baru: ");
                            filmEdit.genre = in.nextLine();
                            
                            System.out.println("║ Sinopsis baru: ");
                            System.out.print(  "║ ");filmEdit.sipnosis = in.nextLine();
                            System.out.println("╠══════════════════════════════════════════════════════════════╣");
    
                          //  System.out.println("╔═════════════════════════════════════════════════════════╗");
                            System.out.println("║ Detail film berhasil diperbarui!!!                           ║");
                            System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            
                        } else if(pilihanEdit == 2){
                            System.out.println("╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║              DETAIL JADWAL FILM SAAT INI                     ║");
                            System.out.println("╠══════════════════════════════════════════════════════════════╣");;
                            if(filmEdit.jadwalList.isEmpty()){
                                System.out.println("Belum ada jadwal.");
                                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            } else {
                                for(int i = 0; i < filmEdit.jadwalList.size(); i++){
                                    System.out.println(   "║ Jadwal ke-" + (i + 1) + ":");
                                    filmEdit.jadwalList.get(i).tampilInfo();
                                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                                }
                            }  
                            System.out.println("╔═════════════════════════════════════════════════════════╗");
                            System.out.println("║                        PILIH AKSI                       ║");
                            System.out.println("╠═════════════════════════════════════════════════════════╣");
                            System.out.println("║                    1.  Edit Jadwal                      ║");
                            System.out.println("║                    2.  Hapus Jadwal                     ║");
                            System.out.println("║                    3.  Keluar                           ║");
                            System.out.println("╠═════════════════════════════════════════════════════════╣");
                            System.out.print(  "║                     Pilih aksi: "); int aksiJadwal = in.nextInt();
                            System.out.println("╠═════════════════════════════════════════════════════════╣");
                            
                            in.nextLine();
                            
                            if(aksiJadwal == 1){
                                if(filmEdit.jadwalList.isEmpty()){
                                    System.out.println("║ Tidak ada jadwal untuk diedit.");
                                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                                } else {
                                    System.out.print("║ Pilih nomor jadwal untuk diedit: ");

                                    int nomorJadwal = in.nextInt();

                                    System.out.println("╠═════════════════════════════════════════════════════════╣");
                                    in.nextLine();

                                    if(nomorJadwal < 1 || nomorJadwal > filmEdit.jadwalList.size()){
                                        System.out.println("║ Nomor jadwal tidak valid.");
                                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                                    } else {
                                        Jadwal jadwalEdit = filmEdit.jadwalList.get(nomorJadwal - 1);

                                        System.out.print("║ Tanggal baru: ");
                                        jadwalEdit.tanggal = in.nextLine();

                                        boolean cek = true;
                                        while (cek) {
                                            System.out.print("║ Hari: ");
                                            jadwalEdit.hari = in.nextLine().toLowerCase();

                                            if (jadwalEdit.hari.equals("senin") || jadwalEdit.hari.equals("selasa") 
                                                || jadwalEdit.hari.equals("rabu") || jadwalEdit.hari.equals("kamis") 
                                                || jadwalEdit.hari.equals("jumat")) {
                                                jadwalEdit.harga = "40.000"; 
                                                cek = false;
                                            }else if (jadwalEdit.hari.equals("sabtu") || jadwalEdit.hari.equals("minggu")) {
                                                jadwalEdit.harga = "60.000";
                                                cek = false;
                                            }else{
                                                System.out.println("Masukan hari yang benar");
                                            }
                                        }

                                        System.out.print("║ Jam baru: ");
                                        jadwalEdit.jam = in.nextLine();

                                        System.out.print("║ Studio baru: ");
                                        jadwalEdit.studio = in.nextLine();
                                        System.out.println("╚══════════════════════════════════════════════════════════════╝");

                                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                                        System.out.println("║                    Jadwal berhasil dihapus!                  ║");
                                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                                    }
                                }
                            } else if(aksiJadwal == 2){
                                if(filmEdit.jadwalList.isEmpty()){
                                    System.out.println("║ Tidak ada jadwal untuk dihapus.");
                                    System.out.println("╚═════════════════════════════════════════════════════════╝");
                                } else {
                                    System.out.print("║ Pilih nomor jadwal untuk dihapus: ");

                                    int nomorJadwal = in.nextInt();

                                    System.out.println("╚═════════════════════════════════════════════════════════╝");
                                    in.nextLine();

                                    if(nomorJadwal < 1 || nomorJadwal > filmEdit.jadwalList.size()){
                                        System.out.println("║ Nomor jadwal tidak valid.");
                                        System.out.println("╚═════════════════════════════════════════════════════════╝");
                                    } else {
                                        filmEdit.jadwalList.remove(nomorJadwal - 1);
                                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                                        System.out.println("║                    Jadwal berhasil dihapus!                  ║");
                                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                                    }
                                }
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }
                        }else {
                            return; // out edit
                        }
                    }
                }
            } else if (menu == 4) {
                if(filmList.isEmpty()) {
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                 TIDAK ADA FILM UNTUK DI HAPUS                ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                } else {
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║               PILIH FILM UNTUK DI HAPUS                      ║");
                    System.out.println("╠══════════════════════════════════════════════════════════════╣");
                    for(int i = 0; i < filmList.size(); i++){
                        System.out.println("║ "+(i + 1) + ". " + filmList.get(i).judul);
                    }

                    System.out.println("╠══════════════════════════════════════════════════════════════╣");

                    System.out.print("║ Pilih nomor film: ");
                    int pilihFilm = in.nextInt();
                    in.nextLine();
                    
                    
                    if(pilihFilm < 1 || pilihFilm > filmList.size()){
                        System.out.println("║ Nomor film tidak valid!!!!");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    } else {
                        filmList.remove(pilihFilm - 1);
                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("║                    Film berhasil dihapus!                    ║");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    }
                }
            } else if (menu > 5){ 
                System.out.println("Harap isi dengan benar!");
            }
        } while(menu != 5);
    }


    // -------------------------USER--------------------------------------------------
    public static void tampilInfoUser(ArrayList<Film> filmList, Scanner in){

        int menu;

        do{
            System.out.println("");
            System.out.println("╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║                         MENU USER                            ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║                                                              ║");
            System.out.println("║                1.   Lihat Film                               ║");
            System.out.println("║                2.   Cari Film                                ║");
            System.out.println("║                3.   Filter Film                              ║");
            System.out.println("║                4.   Beli Tiket                               ║");
            System.out.println("║                5.   Keluar                                   ║");
            System.out.println("║                                                              ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            System.out.print  ("                   Pilih menu (1-5):");   menu = in.nextInt();
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            in.nextLine();
            
            if (menu == 1) {
                // if(film == null){}
                if(filmList.isEmpty()){
                    System.out.println("║ Tidak ada data.");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                } else {
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                         Daftar Film                          ║");
                    System.out.println("╠══════════════════════════════════════════════════════════════╣");
                    for(int i = 0; i < filmList.size(); i++){
                        System.out.println("║ \n Film ke-" + (i + 1) + ".");
                        filmList.get(i).tampilInfo();
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    }
                }
            } else if (menu == 2) {
                if (filmList.isEmpty()) {
                    System.out.println("║ Belum ada data film untuk dicari.");
                } else {
                    System.out.print("║ Masukkan judul film yang dicari: ");
                    String kataKunci = in.nextLine();

                    ArrayList<Film> hasil = SearchFilm.cariFilm(filmList, kataKunci);

                    if (hasil.isEmpty()) {
                        System.out.println("Film dengan judul '" + kataKunci + "' tidak ditemukan.");
                    } else {
                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("║                    HASIL PENCARIAN                           ║");
                        System.out.println("╠══════════════════════════════════════════════════════════════╣");
                        System.out.println("║ Ditemukan " + hasil.size() + " film:");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                        for (int i = 0; i < hasil.size(); i++) {
                            System.out.println("╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║ Film ke-" + (i + 1) + ".");
                            hasil.get(i).tampilInfo();
                            System.out.println("╚══════════════════════════════════════════════════════════════╝");
                        }
                    }
                }
            } else if (menu == 3) {
                if (filmList.isEmpty()) {
                    System.out.println("Belum ada data film untuk difilter.");
                } else {
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                      FILTER FILM                             ║");
                    System.out.println("╠══════════════════════════════════════════════════════════════╣");
                    System.out.println("║                1. Filter berdasarkan Tanggal dan Genre       ║");
                    System.out.println("║                2. Kembali                                    ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    System.out.print  ("                   Pilih filter (1-2):");   int pilihFilter = in.nextInt();
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    in.nextLine();

                    if (pilihFilter == 1) {

                        System.out.print("║ Masukkan tanggal (DD-MM-YYYY): ");
                        String tanggal = in.nextLine();

                        System.out.print("║ Masukkan genre: ");
                        String genre = in.nextLine();

                        ArrayList<Film> hasil = FilterFilm.filterByTanggalDanGenre(filmList, tanggal, genre);

                        if (hasil.isEmpty()) {
                            System.out.println("╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║ Tidak ada film genre " + genre + " yang tayang pada " + tanggal);
                            System.out.println("╚══════════════════════════════════════════════════════════════╝");
                        } else {
                            System.out.println("╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║ Film genre " + genre + " yang tayang pada " + tanggal + ":");
                            System.out.println("╠══════════════════════════════════════════════════════════════╣");
                            System.out.println("║                    HASIL FILTER                              ║");
                            System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            for (int i = 0; i < hasil.size(); i++) {
                                System.out.println("╔══════════════════════════════════════════════════════════════╗");
                                System.out.println("║ Film ke-" + (i + 1) + ".");
                                hasil.get(i).tampilInfo();
                                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            }
                        }

                    } else if (pilihFilter == 2) {
                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("║                Kembali ke menu utama...                      ║");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    } else {
                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("║                   Pilihan tidak valid!                        ║");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    }
                }

            } else if (menu == 4) {
                if (filmList.isEmpty()) {
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║            Belum ada data film untuk dibeli tiket.           ║");
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                } else {
                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                    System.out.println("║                      BELI TIKET                              ║");
                    System.out.println("╠══════════════════════════════════════════════════════════════╣");
                    for(int i = 0; i < filmList.size(); i++){
                        System.out.println("║ " + (i + 1) + ". " + filmList.get(i).judul);
                    }
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    System.out.print("║ Pilih nomor film: ");
                    int pilihFilm = in.nextInt();
                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    in.nextLine();

                    if(pilihFilm < 1 || pilihFilm > filmList.size()){
                        System.out.println("╔══════════════════════════════════════════════════════════════╗");
                        System.out.println("║                Nomor film tidak valid!                       ║");
                        System.out.println("╚══════════════════════════════════════════════════════════════╝");
                    } else {
                        Film filmDipilih = filmList.get(pilihFilm - 1);
                        if(filmDipilih.jadwalList.isEmpty()){
                            System.out.println("╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║             Belum ada jadwal untuk film ini.                 ║");
                            System.out.println("╚══════════════════════════════════════════════════════════════╝");
                        } else {
                            System.out.println("╔══════════════════════════════════════════════════════════════╗");
                            System.out.println("║                     JADWAL TAYANG                            ║");
                            System.out.println("╠══════════════════════════════════════════════════════════════╣");
                            for(int i = 0; i < filmDipilih.jadwalList.size(); i++){
                                System.out.println("║ " + (i + 1) + ". ");
                                filmDipilih.jadwalList.get(i).tampilInfo();
                                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            }
                            System.out.print("║ Pilih nomor jadwal: ");
                            int pilihJadwal = in.nextInt();
                            System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            in.nextLine();

                            if(pilihJadwal < 1 || pilihJadwal > filmDipilih.jadwalList.size()){
                                System.out.println("╔══════════════════════════════════════════════════════════════╗");
                                System.out.println("║               Nomor jadwal tidak valid!                      ║");
                                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                            } else {
                                Jadwal jadwalDipilih = filmDipilih.jadwalList.get(pilihJadwal - 1);
                                System.out.print("║ Masukkan jumlah tiket: ");
                                int jumlahTiket = in.nextInt();
                                System.out.println("╚══════════════════════════════════════════════════════════════╝");
                                in.nextLine();

                                if(jumlahTiket <= 0 || jumlahTiket > jadwalDipilih.availableSeats){
                                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                                    System.out.println("║        Jumlah tiket tidak valid atau kursi tidak cukup!      ║");
                                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                                } else {
                                    // Kurangi kursi
                                    jadwalDipilih.availableSeats -= jumlahTiket;

                                    // Hitung total harga
                                    double hargaPerTiket = Double.parseDouble(jadwalDipilih.harga.replace(".", "").replace(",", ""));
                                    double totalHarga = hargaPerTiket * jumlahTiket;

                                    System.out.println("╔══════════════════════════════════════════════════════════════╗");
                                    System.out.println("║                    DETAIL PESANAN                            ║");
                                    System.out.println("╠══════════════════════════════════════════════════════════════╣");
                                    System.out.println("║ Film: " + filmDipilih.judul);
                                    System.out.println("║ Genre: " + filmDipilih.genre);
                                    System.out.println("║ Durasi: " + filmDipilih.durasi + " menit");
                                    System.out.println("║ Rating: " + filmDipilih.rating);
                                    System.out.println("║ Tanggal: " + jadwalDipilih.tanggal);
                                    System.out.println("║ Jam: " + jadwalDipilih.jam);
                                    System.out.println("║ Studio: " + jadwalDipilih.studio);
                                    System.out.println("║ Jumlah Tiket: " + jumlahTiket);
                                    System.out.println("║ Total Harga: Rp " + String.format("%,.0f", totalHarga));
                                    System.out.println("╠══════════════════════════════════════════════════════════════╣");
                                    System.out.println("║               Tiket berhasil dibeli!                         ║");
                                    System.out.println("╚══════════════════════════════════════════════════════════════╝");
                                }
                            }
                        }
                    }
                }
            }else if (menu > 5) {
                System.out.println("║ Harap isi dengan benar!");
            }
                
        }while(menu != 5);
    }
}
