package lab.tubes;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String judul = "";
        String genre = "";
        int durasi = 0;
        double rating = 0;
        // String jadwalTayang;

        int menu;

        do {
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

                System.out.println("Film disimpan!");
            }
            else if (menu == 2) {
                // if(film == null){}
                if(judul.equals("")){
                    System.out.println("Tidak ada data.");
                } else {
                    System.out.println("========DAFTAR FILM========");
                    System.out.println("Judul: " + judul);
                    System.out.println("Genre: " + genre);
                    System.out.println("Durasi: " + durasi);
                    System.out.println("Rating: " + rating);
                }
            }            
        } while(menu != 3);

        in.close();

        System.out.println("Program Selesai...");
    }
}
