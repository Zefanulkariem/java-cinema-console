package lab.tubes;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Film> filmList = new ArrayList<>();

        int loginUser;
        int menu;
        String lanjut;

        do {
            System.out.println("========MASUK========");
            System.out.println("1. Akun Admin");
            System.out.println("2. Akun Guest");
            System.out.println("3. Keluar");
            System.out.println("Masuk Sebagai: ");
            
            loginUser = in.nextInt();
            in.nextLine();
            
            if(loginUser == 1){
                boolean login = false;
                int percobaan = 0;
                final String PIN_BENAR = "admin123";

                while(percobaan < 3){
                    System.out.print("Masukkan Password Admin: ");
                    String pin = in.nextLine();
                    
                    if(pin.equals(PIN_BENAR)){
                        login = true;
                        System.out.println("");
                        System.out.println("Selamat Datang Admin!");
                        
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
                        break;
                    } else {
                        percobaan++;
                        System.out.println("Password salah, kesempatan tersisa " + (3 - percobaan));
                    }

                }
                if(!login){
                    System.out.println("Password salah, Maaf coba ulang lain kali");
                }
            } else if (loginUser == 2) {
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
            } else if (loginUser != 3) {
                System.out.println("Harap isi dengan pilihan yang tertera!");
            }
        } while(loginUser != 3);

        in.close();

        System.out.println("Program Selesai...");
    }
}
