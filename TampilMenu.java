package lab.tubes;

import java.util.ArrayList;
import java.util.Scanner;

public class TampilMenu {

    public static void tampilInfoAdmin(ArrayList<Film> filmList, Scanner in){

        int menu;
        String lanjut;

        do{
            System.out.println("");
            System.out.println("========MENU========");
            System.out.println("1. Input Film");
            System.out.println("2. Lihat Film");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu: ");
            
            menu = in.nextInt();
            in.nextLine();
            
            if(menu == 1){
                Film dataFilm = new Film();

                System.out.print("Judul: ");
                dataFilm.judul = in.nextLine();

                System.out.print("Genre: ");
                dataFilm.genre = in.nextLine();
                
                System.out.print("Durasi (menit): ");
                dataFilm.durasi = in.nextInt();
                
                System.out.print("Rating: ");
                dataFilm.rating = in.nextDouble();
                in.nextLine();

                System.out.println("Sipnosis");
                dataFilm.sipnosis = in.nextLine();

                dataFilm.jadwalList = new ArrayList<>();

                do{
                    System.out.println("===INPUT JADWAL FILM===");

                    Jadwal dataJadwal = new Jadwal();

                    System.out.print("Tanggal (DD-MM-YYYY): ");
                    dataJadwal.tanggal = in.nextLine();

                    boolean cek = true;
                    while (cek) {
                        System.out.print("Hari: ");
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

                    System.out.print("Jam (HH:MM): ");
                    dataJadwal.jam = in.nextLine();
                    
                    System.out.print("Studio: ");
                    dataJadwal.studio = in.nextLine();
                    
                    System.out.print("Isi jadwal lagi? (y/n): ");
                    lanjut = in.nextLine();

                    dataFilm.jadwalList.add(dataJadwal);

                } while(lanjut.equalsIgnoreCase("y"));

                filmList.add(dataFilm);                      //add: arrayList
                System.out.println("Film disimpan!");
                
            } else if (menu == 2) {
                if(filmList.isEmpty()){                       //add: isEmpty
                    System.out.println("Tidak ada data.");
                } else {                                                     //ganti ke for
                    System.out.println("========DAFTAR FILM========");
                    for(int i = 0; i < filmList.size(); i++){
                        System.out.println("\n Film ke-" + (i + 1) + ".");
                        filmList.get(i).tampilInfo();
                        System.out.println("-----------------------------");
                    }
                }
            } else if (menu != 3){ 
                System.out.println("Harap isi dengan benar!");
            }
        } while(menu != 3);
    }

    public static void tampilInfoUser(ArrayList<Film> filmList, Scanner in){

        int menu;

        do{
            System.out.println("");
            System.out.println("Selamat Datang!");
            System.out.println("========MENU========");
            System.out.println("1. Lihat Film");
            System.out.println("2. Cari Film");
            System.out.println("3. Filter Film");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            
            menu = in.nextInt();
            in.nextLine();
            
            if (menu == 1) {
                // if(film == null){}
                if(filmList.isEmpty()){
                    System.out.println("Tidak ada data.");
                } else {
                    System.out.println("=========DAFTAR FILM=========");
                    for(int i = 0; i < filmList.size(); i++){
                        System.out.println("\n Film ke-" + (i + 1) + ".");
                        filmList.get(i).tampilInfo();
                        System.out.println("---------------------------");
                    }
                }
            } else if (menu == 2) {
                if (filmList.isEmpty()) {
                    System.out.println("Belum ada data film untuk dicari.");
                } else {
                    System.out.print("Masukkan judul film yang dicari: ");
                    String kataKunci = in.nextLine();
                    
                    ArrayList<Film> hasil = SearchFilm.cariFilm(filmList, kataKunci);
                    
                    if (hasil.isEmpty()) {
                        System.out.println("Film dengan judul '" + kataKunci + "' tidak ditemukan.");
                    } else {
                        System.out.println("\nDitemukan " + hasil.size() + " film:");
                        System.out.println("========HASIL PENCARIAN========");
                        for (int i = 0; i < hasil.size(); i++) {
                            System.out.println("\nFilm ke-" + (i + 1) + ".");
                            hasil.get(i).tampilInfo();
                            System.out.println("---------------------------");
                        }
                    }
                }
            } else if (menu == 3) {
                if (filmList.isEmpty()) {
                    System.out.println("Belum ada data film untuk difilter.");
                } else {
                    System.out.println("\n========FILTER FILM========");
                    System.out.println("1. Filter berdasarkan Tanggal dan Genre");
                    System.out.println("2. Kembali");
                    System.out.print("Pilih filter: ");
                    
                    int pilihFilter = in.nextInt();
                    in.nextLine();
                    
                    if (pilihFilter == 1) {

                        System.out.print("Masukkan tanggal (DD-MM-YYYY): ");
                        String tanggal = in.nextLine();
                        
                        System.out.print("Masukkan genre: ");
                        String genre = in.nextLine();
                        
                        ArrayList<Film> hasil = FilterFilm.filterByTanggalDanGenre(filmList, tanggal, genre);
                        
                        if (hasil.isEmpty()) {
                            System.out.println("Tidak ada film genre " + genre + " yang tayang pada " + tanggal);
                        } else {
                            System.out.println("\nFilm genre " + genre + " yang tayang pada " + tanggal + ":");
                            System.out.println("========HASIL FILTER========");
                            for (int i = 0; i < hasil.size(); i++) {
                                System.out.println("\nFilm ke-" + (i + 1) + ".");
                                hasil.get(i).tampilInfo();
                                System.out.println("---------------------------");
                            }
                        }
                        
                    } else if (pilihFilter == 2) {
                        System.out.println("Kembali ke menu utama...");
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                }
                
            } else if (menu != 4){
                System.out.println("Harap isi dengan benar!");
            }
        }while(menu != 4);
    }
}
