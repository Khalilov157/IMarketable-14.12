package UI;

import Models.Item;
import Models.ItemCategorie;
import Models.Receipt;
import Repositories.Repository;
import Seeders.GlobalSeeder;

import java.util.Scanner;

public class Ui {

    private static Repository repo;
    public Ui(Repository repoIn) {

        this.repo = repoIn;
    }

    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    public static void run(Repository repoIn){

       repo = repoIn;


        System.out.println(
                "-1 Mehsullar uzerinde emeliyyat aparmaq\n" +
                "-2 Satislar uzerinde emeliyyat aparmaq\n" +
                "-3 Sistemden cixmaq \n" +
                        "Input number: ");
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        boolean whileBreaker = true;

        while (whileBreaker){
            input = scanner.nextInt();

        switch (input){
            case 1:
                stageItemsOps();
                whileBreaker = false;
                break;
            case 2:
                stageSalesOps();
                whileBreaker = false;
                break;
            case 3:
                whileBreaker = false;
                break;
            default:
                System.out.println("Wrong option! Enter number: ");
//                run();
//                whileBreaker = false;
        }}




    }


    public static void stageItemsOps(){
        System.out.println(
                        "    - 1 Yeni mehsul elave et  - userden yeni mehsul yaradilmasi ucun lazim olan melumatlari daxil edilmelidir\n" +
                        "    - 2 Mehsul uzerinde duzelis et -  duzelis edilecek mehsulun code-u ve duzelis melumatlari daxil edilmelidir\n" +
                        "    - 3 Mehsulu sil - mehsulu kodu daxil edilmelidir\n" +
                        "    - 4 Butun mehsullari goster - butun mehsullar gosterilecek (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
                        "    - 5 Categoriyasina gore mehsullari goster - usere var olan kateqoriyalar gosteilecek ve onlar arasinda bir secim etmelidir ve secilmis kateqoriyadan olan butun mehsullar gosterilir (kodu,adi,categoriyasi,sayi,qiymeti)\n" +
                        "    - 6 Qiymet araligina gore mehsullari goster - userden minmum ve maximum qiymetleri daxil etmesi istenilir ve hemin qiymet araliginda olan mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n" +
                        "    - 7 Mehsullar arasinda ada gore axtaris et - useden text daxil etmesi istenilir ve adinda hemin text olan butun mehsullar gosterilir (kodu, adi,categoriyasi,sayi,qiymeti)\n"
                                + "    - 8 Ba??lan????ca d??n \n" +
                "Enter number: ");
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        boolean whileBreaker = true;

        while (whileBreaker){
            input = scanner.nextInt();

            switch (input){
                case 1:
                    createItem();
                    whileBreaker = false;
                    break;
                case 2:
                    editItem();
                    whileBreaker = false;
                    break;
                case 3:
                    removeItem();
                    whileBreaker = false;
                    break;

                case 4:
                    getAllItems();
                    whileBreaker = false;
                    break;
                case 5:
                    getItemsByCategory();
                    whileBreaker = false;
                    break;
                case 6:
                    findItemsByPriceRange();
                    whileBreaker = false;
                    break;
                case 7:
                    findItemsByName();
                    whileBreaker = false;
                    break;
                case 8:
                    whileBreaker = false;
                    run(repo);
                    break;
                default:
                    System.out.println("Wrong option! Enter number: ");
//                run();
//                whileBreaker = false;
            }}
    }
    public static void stageSalesOps(){

        System.out.println(
                "    - 1 Yeni satis elave etmek - istifadeciden satis yaradilmasi ucun lazimi meulatlarin daxil edilmesi istenilir (mehsullarin kodlari)\n" +
                "    - 2 Satisdaki hansisa mehsulun geri qaytarilmasi( satisdan cixarilmasi) - userden satisin,cixarilacaq mehsulun ve sayinin daxil edilmesi istenilir\n" +
                "    - 3 Satisin silinmesi - satisin nomresine esasen silinmesi\n" +
                "    - 4 Butun satislarin ekrana cixarilmasi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
                "    - 5 Verilen tarix araligina gore satislarin gosterilmesi - userden qebul edilen iki tarix araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
                "    - 6 Verilen mebleg araligina gore satislarin gosterilmesi - userden qebul edilen iki mebleg araligindaki satislarin gosterilmesi (nomresi,meblegi,mehsul sayi,tarixi)\n" +
                "    - 7 Verilmis bir tarixde olan satislarin gosterilmesi  - userden qebul edilmis bir tarixde olan satislarin gosterilmesi(nomresi,meblegi,mehsul sayi,tarixi)\n" +
                "    - 8 Verilmis nomreye esasen hemin nomreli satisin melumatlarinin gosterilmesi - userden qebul edilmis nomdereye esasen hemin nomreli satisin melumatlarinin gosterilmesi\n" +
                        "    - 9  Ba??lan????ca d??n\n" +
                "Enter number: ");
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        boolean whileBreaker = true;

        while (whileBreaker){
            input = scanner.nextInt();

            switch (input){
                case 1:
                    renderAddReceipt();
                    whileBreaker = false;
                    break;
                case 2:
                    refundItem();
                    whileBreaker = false;
                    break;
                case 3:
                    removeReceipt();
                    whileBreaker = false;
                    break;

                case 4:
                    getAllReceipts();
                    whileBreaker = false;
                    break;
                case 5:
                    findReceiptsByDate();
                    whileBreaker = false;
                    break;
                case 6:
                    findReceiptsByPriceRange();
                    whileBreaker = false;
                    break;
                case 7:
                    findReceiptsBySpecificDate();
                    whileBreaker = false;
                    break;
                case 8:
                    renderGetReceipt();
                    whileBreaker = false;
                    break;
                case 9:
                    whileBreaker = false;
                    run(repo);
                    break;
                default:
                    System.out.println("Wrong option! Enter number: ");
//                run();
//                whileBreaker = false;
            }

    }}

    public static void renderAddReceipt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(repo.getItemsList());
        System.out.println("Enter Product ID and Count example: 122 5 45 2");
        String input = scanner.nextLine();
        repo.addReceipt(input);
        run(repo);
    }

    public static void renderGetReceipt (){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Receipt ID :");
        String input = scanner.nextLine();
        repo.findReceiptById(Long.parseLong(input));
        run(repo);
    }
    public static void getAllReceipts(){
        repo.printReceipts();
        run(repo);
    }
    public static void getAllItems(){
        repo.printItems();
        run(repo);
    }

    public static void refundItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item ID , then receipt ID");
        String input = scanner.nextLine();
        Receipt tempReceipt = repo.refundItem(input);
        if ( tempReceipt == null){
            System.out.println("??ek tap??lmam????d??r...");
        } else {
            System.out.println(tempReceipt);
        }

        run(repo);
    }

    public static void removeReceipt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter receipt ID");
        String input = scanner.nextLine();
        boolean deleted = repo.deleteReceipt(input);
        if (! deleted){
            System.out.println("??ek tap??lmam????d??r...");
        } else {
            System.out.println("??ek silinmi??dir");
        }

        run(repo);

    }

    public static void findReceiptsByDate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start date and end date. Format: YYYY-MM-dd YYYY-MM-dd");
        String input = scanner.nextLine();

        System.out.println(repo.findReceiptsByDate(input));

        run(repo);

    }
    public static void findReceiptsBySpecificDate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date for receipts. Format: YYYY-MM-dd");
        String input = scanner.nextLine();

        System.out.println(repo.findReceiptsBySpecificDate(input));

        run(repo);

    }
    public static void findReceiptsByPriceRange(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price range. Format: [Min price] [Max price]");
        String input = scanner.nextLine();

        System.out.println(repo.findReceiptsByPriceRange(input));

        run(repo);

    }

    public static void getItemsByCategory(){
        ItemCategorie[] yourEnums = ItemCategorie.values();
        String categories = "Kateqoriyalar: ";
        for (int i = 0; i< yourEnums.length; i++){
            categories =  categories + i + " - " + yourEnums[i] + "; ";
        }
        System.out.println(categories);
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        boolean whileBreaker = true;

        while (whileBreaker){
            input = scanner.nextInt();

            if (input >=0 && input <5) {
                repo.findItemsOfCategory(yourEnums[input]);
                run(repo);
                whileBreaker = false;
            } else {

                    System.out.println("Wrong option! Enter number from 1-4: ");}
//                run();
//                whileBreaker = false;
            }}


    public static void removeItem(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item ID");
        String input = scanner.nextLine();
        boolean deleted = repo.deleteItem(input);
        if (! deleted){
            System.out.println("M??hsul tap??lmam????d??r...");
        } else {
            System.out.println("M??hsul silinmi??dir");
        }

        run(repo);

    }

    public static void findItemsByPriceRange(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter price range. Format: [Min price] [Max price]");
        String input = scanner.nextLine();

        System.out.println(repo.findItemsByPriceRange(input));

        run(repo);

    }

    public static void findItemsByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item name: ");
        String input = scanner.nextLine();

        System.out.println(repo.findItemsByName(input));

        run(repo);
    }

    public static void createItem(){

        System.out.println("New item creation: \n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();

        System.out.println("Enter item price: ");
        Double itemPrice = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter item count: ");
        Integer itemCount = Integer.parseInt(scanner.nextLine());

        ItemCategorie[] categoriesEnums = ItemCategorie.values();
        String categories = "Kateqoriyalar: ";
        for (int i = 0; i< categoriesEnums.length; i++){
            categories =  categories + i + " - " + categoriesEnums[i] + "; ";
        }
        System.out.println(categories);

        System.out.println("Enter item category ID: ");

        int itemId = -1;
        boolean whilebreaker = true;
        ItemCategorie itemCategory = null;
        while (whilebreaker){
            itemId = Integer.parseInt(scanner.nextLine());
            if (itemId >=0 && itemId <5){
            itemCategory = categoriesEnums[itemId];
            whilebreaker = false;}
        }
        long tempId = GlobalSeeder.getGlobalItemID() + 1;
        GlobalSeeder.setGlobalItemID(tempId);
        Item tempItem = new Item(itemName,itemPrice, itemCount, itemCategory, tempId);
        System.out.println(tempItem);
        repo.addItemToList(tempItem);

        run(repo);
    }

    public static void editItem(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter item id: ");
        long itemId = Long.parseLong(scanner.nextLine());
        Item itemToChange = repo.findItemById(itemId);
        System.out.println(itemToChange);

           System.out.println("Old name: "+ itemToChange.getName() +
                   "\nEnter item name: ");
    String itemName = scanner.nextLine();

        System.out.println("Old price:"+ itemToChange.getPrice() +
                "\nEnter item price: ");
    Double itemPrice = Double.parseDouble(scanner.nextLine());

        System.out.println("Old item count: "+ itemToChange.getCount() +
                "\nEnter item count: ");
    Integer itemCount = Integer.parseInt(scanner.nextLine());

    ItemCategorie[] categoriesEnums = ItemCategorie.values();
    String categories = "Kateqoriyalar: ";
        for (int i = 0; i< categoriesEnums.length; i++){
        categories =  categories + i + " - " + categoriesEnums[i] + "; ";
    }
        System.out.println(categories);

        System.out.println("Old category: "+ itemToChange.getCategory() +
                "\nEnter item category ID: ");

    int globalItemId = -1;
    boolean whilebreaker = true;
    ItemCategorie itemCategory = null;
        while (whilebreaker){
            globalItemId = Integer.parseInt(scanner.nextLine());
        if (globalItemId >=0 && globalItemId <5){
            itemCategory = categoriesEnums[globalItemId];
            whilebreaker = false;}
    }
    Item tempItem = new Item(itemName,itemPrice, itemCount, itemCategory, itemToChange.getId());
        System.out.println(tempItem);
        repo.updateItemToList(tempItem);

    run(repo);

    }


}
