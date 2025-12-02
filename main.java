package lab.tubes;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String judul = "";
        String genre = "";
        int durasi = 0;
        double rating = 0;
        String sipnosis = "";
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
                            System.out.println("========MENU========");
                            System.out.println("1. Input Film");
                            System.out.println("2. Lihat Film");
                            System.out.println("3. Keluar");
                            System.out.println("Pilih Menu: ");
                            
                            menu = in.nextInt();
                            in.nextLine();
                            
                            if(menu == 1){
                                System.out.print("Judul: ");
                                judul = in.nextLine();

                                System.out.print("Genre: ");
                                genre = in.nextLine();
                                
                                System.out.print("Durasi (menit): ");
                                durasi = in.nextInt();
                                
                                System.out.print("Rating: ");
                                rating = in.nextDouble();
                                in.nextLine();

                                System.out.println("Sipnosis");
                                sipnosis = in.nextLine();

                                System.out.println("Film disimpan!");
                            } else if (menu == 2) {
                                // if(film == null){}
                                if(judul.equals("")){
                                    System.out.println("Tidak ada data.");
                                } else {
                                    System.out.println("========DAFTAR FILM========");
                                    System.out.println("Judul: " + judul);
                                    System.out.println("Genre: " + genre);
                                    System.out.println("Durasi: " + durasi);
                                    System.out.println("Rating: " + rating);
                                    System.out.println("Sipnosis: " + sipnosis);
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
                System.out.println("Selamat Datang!");
                System.out.println("========MENU========");
                System.out.println("1. Lihat Film");
                System.out.println("2. Keluar");
                System.out.println("Pilih Menu: ");
                
                menu = in.nextInt();
                in.nextLine();
                
                if (menu == 1) {
                    // if(film == null){}
                    if(judul.equals("")){
                        System.out.println("Tidak ada data.");
                    } else {
                        System.out.println("========DAFTAR FILM========");
                        System.out.println("Judul: " + judul);
                        System.out.println("Genre: " + genre);
                        System.out.println("Durasi: " + durasi);
                        System.out.println("Rating: " + rating);
                        System.out.println("Sipnosis: " + sipnosis);
                    }
                } else if (menu != 2){
                    System.out.println("Harap isi dengan benar!");
                } 
            } else if (loginUser != 3) {
                System.out.println("Harap isi dengan pilihan yang tertera!");
            }
        } while(loginUser != 3);

        in.close();

        System.out.println("Program Selesai...");
    }
}
