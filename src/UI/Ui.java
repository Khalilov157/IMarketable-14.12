package UI;

import java.util.Scanner;

public class Ui {



    public static void run(){

        System.out.println(
                "-1 Mehsullar uzerinde emeliyyat aparmaq\n" +
                "-2 Satislar uzerinde emeliyyat aparmaq\n" +
                "-3 Sistemden cixmaq");
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        System.out.println(input);


    }

}
