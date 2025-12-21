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
            System.out.println("Pilih Menu: ");
            
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
                double rating = in.nextDouble();
                in.nextLine();

                System.out.println("Sipnosis");
                dataFilm.sipnosis = in.nextLine();

                dataFilm.jadwalList = new ArrayList<>();

                do{
                    System.out.println("===INPUT JADWAL FILM===");

                    Jadwal dataJadwal = new Jadwal();

                    System.out.println("Hari: ");
                    dataJadwal.hari = in.nextLine();

                    System.out.println("Jam: ");
                    dataJadwal.jam = in.nextLine();
                    
                    System.out.println("Studio: ");
                    dataJadwal.studio = in.nextLine();
                    
                    System.out.println("Isi jadwal lagi? (y/n): ");
                    lanjut = in.nextLine();

                    dataFilm.jadwalList.add(dataJadwal);

                } while(lanjut.equalsIgnoreCase("y"));

                filmList.add(dataFilm);                      //add: arrayList
                System.out.println("Film disimpan!");
                
            } else if (menu == 2) {
                // if(film == null){}
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
            System.out.println("2. Keluar");
            System.out.println("Pilih Menu: ");
            
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
            } else if (menu != 2){
                System.out.println("Harap isi dengan benar!");
            }
        }while(menu != 2);
    }
}
