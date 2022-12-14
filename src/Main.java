import Repositories.Repository;

import java.util.Scanner;

import UI.Ui;

   /*

 + Satislar
 + Mehsullar
 + Satis elave etmek - satis elave edilerken hansi mehsullardan hansi sayda satis oldugu gonderilir
 + Satisdan mehsulun geri qaytarilmasi
 - Umumi satisin geri qaytarilmasi
 - Verilen tarix araligina gore hemin tarix araligina olan satislarin qaytarilmasi
 - Verilen bir tarixe gore hemin tarix (il,ay,gun) ucun olan satislarin qaytarilmasi
 - Verilmis mebleg araligina gore edilmis satislarin qaytarilmasi
 + Verilmis nomreye esasen satisin qaytarilmasi
 - Yeni mehsul elave etmek
 - Mehsulun adini,sayini ve meblegini,categoriyasini deyismek (code-a gore tapilacaq)
 - Verilmis kateqoriyaya esasen hemin kateqoriyada olan mehsullarin qaytarilmasi
 - Verilmis qiymet araligina esasen hemin araliqda olan mehsullarin qaytarilmasi
 - Verilmis ada esasen mehsullarin search edilib qaytarilmasi
     */

public class Main {
    public static void main(String[] args) {

        Repository repo = new Repository();

        Ui.run(repo);


/*

        System.out.println(repo.getItemsList());

        //=============================
        //          Add new receipt

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input :");
        String input = scanner.nextLine();
        repo.addReceipt(input);

        //=============================
        //          Remove item from receipt

        System.out.println("Enter item ID , then receipt ID");
        input = scanner.nextLine();
        repo.refundItem(input);
*/

    }
}