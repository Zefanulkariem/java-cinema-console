package lab.tubes;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Film> filmList = new ArrayList<>();  //array index/panjangnya ga ditentuin

        int loginUser;


        do {
            System.out.println("========MASUK========");
            System.out.println("1. Akun Admin");
            System.out.println("2. Akun Guest");
            System.out.println("3. Keluar");
            System.out.print("Masuk Sebagai: ");
            
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
                        
                        TampilMenu.tampilInfoAdmin(filmList, in);       //function menu admin
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
                TampilMenu.tampilInfoUser(filmList, in);       //function menu user
            } else if (loginUser != 3) {
                System.out.println("Harap isi dengan pilihan yang tertera!");
            }
        } while(loginUser != 3);

        in.close();

        System.out.println("Program Selesai...");
    }
}