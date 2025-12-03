package lab.tubes;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<String> judulList = new ArrayList<>();                     //add: ArrayList
        ArrayList<String> genreList = new ArrayList<>();
        ArrayList<Integer> durasiList = new ArrayList<>();
        ArrayList<Double> ratingList = new ArrayList<>();
        ArrayList<String> sipnosisList = new ArrayList<>();
        // String jadwalTayang;

        int loginUser;
        int menu;

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
                                System.out.print("Judul: ");
                                String judul = in.nextLine();

                                System.out.print("Genre: ");
                                String genre = in.nextLine();
                                
                                System.out.print("Durasi (menit): ");
                                int durasi = in.nextInt();
                                
                                System.out.print("Rating: ");
                                double rating = in.nextDouble();
                                in.nextLine();

                                System.out.println("Sipnosis");
                                String sipnosis = in.nextLine();

                                System.out.println("Film disimpan!");

                                judulList.add(judul);                         //add: arrayList
                                genreList.add(genre);
                                durasiList.add(durasi);
                                ratingList.add(rating);
                                sipnosisList.add(sipnosis);
                                
                            } else if (menu == 2) {
                                // if(film == null){}
                                if(judulList.isEmpty()){                       //add: isEmpty
                                    System.out.println("Tidak ada data.");
                                } else {                                                     //ganti ke for
                                    System.out.println("========DAFTAR FILM========");
                                    for(int i = 0; i < judulList.size(); i++){
                                        System.out.println("\n " + (i + 1) + ".");
                                        System.out.println("Judul: " + judulList.get(i));                   //add: get List (tunda)
                                        System.out.println("Genre: " + genreList.get(i));
                                        System.out.println("Durasi: " + durasiList.get(i));
                                        System.out.println("Rating: " + ratingList.get(i));
                                        System.out.println("Sipnosis: " + sipnosisList.get(i));
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
                        if(judulList.isEmpty()){
                            System.out.println("Tidak ada data.");
                        } else {
                            System.out.println("========DAFTAR FILM========");
                            for(int i = 0; i < judulList.size(); i++){
                                System.out.print("\n " + (i + 1) + ". ");                   //add: get List (tunda)
                                System.out.println("Judul: " + judulList.get(i));                   //add: get List (tunda)
                                System.out.println("Genre: " + genreList.get(i));
                                System.out.println("Durasi: " + durasiList.get(i));
                                System.out.println("Rating: " + ratingList.get(i));
                                System.out.println("Sipnosis: " + sipnosisList.get(i));
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
