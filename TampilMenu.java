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
            System.out.println("3. Keluar");
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
                    String keyword = in.nextLine();
                    
                    ArrayList<Film> hasil = SearchFilm.cariFilm(filmList, keyword);
                    
                    if (hasil.isEmpty()) {
                        System.out.println("Film dengan judul '" + keyword + "' tidak ditemukan.");
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
            } else if (menu != 3){
                System.out.println("Harap isi dengan benar!");
            }
        }while(menu != 3);
    }
}
