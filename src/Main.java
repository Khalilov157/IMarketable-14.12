import Repositories.Repository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Ui.run();



        Repository repo = new Repository();

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
        System.out.println(repo.getReceiptsList());




    }
}