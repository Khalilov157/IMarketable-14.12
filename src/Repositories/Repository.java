package Repositories;

import Models.Item;
import Models.Receipt;
import Models.SaleItem;
import Seeders.GlobalSeeder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Item> itemsList = new ArrayList<>();

    private List<Receipt> receiptsList = new ArrayList<>();



    public Repository() {
        this.itemsList = GlobalSeeder.generateItems(25);
        this.receiptsList = GlobalSeeder.generateReceipts(120, this.itemsList);
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public List<Receipt> getReceiptsList() {
        return receiptsList;
    }



    public void addReceipt(String idCount){

        List<SaleItem> saleItems = getItemsToReceipt(idCount);


        if (saleItems.size()>0){
            long receiptId = receiptsList.get(receiptsList.size()-1).getId()+1;
            double tempFinalPrice = GlobalSeeder.receiptPrice(saleItems);


            Receipt tempReceipt = new Receipt(receiptId, tempFinalPrice,saleItems, LocalDate.now());
            receiptsList.add(tempReceipt);

            System.out.println(tempReceipt.toString());

        }


    }

    public  List<SaleItem> getItemsToReceipt(String idCount){

        String [] idsList = idCount.split("[^0-9]");
        int elementId = 0;
        SaleItem tempSaleitem = null;
        List<SaleItem> saleItems = new ArrayList<>();
        int foundCount = 0;
        for (int i = 1; i < idsList.length+1; i++){

            if ( i % 2 >0) {
                elementId = Integer.parseInt(idsList[i - 1]);

                foundCount = isExistsInStock(Integer.parseInt(idsList[i - 1]), Integer.parseInt(idsList[i]));
//                System.out.println("found count = " + foundCount);
                if (foundCount > 0) {

                    Item tempItem = findItemById(Integer.parseInt(idsList[i - 1]));
                    tempSaleitem = new SaleItem(tempItem,Integer.parseInt(idsList[i]), tempItem.getPrice());
                    saleItems.add(tempSaleitem);
                }}}
        return saleItems;
    }

    public int isExistsInStock (long id, int count){

        for (Item itemn: itemsList){

            if (itemn.getId() == id){
                if (count <= itemn.getCount()){
                    itemn.setCount(itemn.getCount() - count);
                    return count;
                } else {
                    itemn.setCount(0);
                    return itemn.getCount();
                }}}
        return 0;
    }

    public Item findItemById(long id){
        for (Item item: itemsList){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void refundItem (String input){

        String [] inputArr = input.split("[^0-9]");
        long saleItemId = Long.parseLong(inputArr[0]);
        long receiptId = Long.parseLong(inputArr[1]);

        Receipt receipt = findReceiptById(receiptId);
        List<SaleItem> solditems = receipt.getSoldItems();

        for (int i = 0; i < solditems.size(); i++) {
            if (saleItemId == solditems.get(i).getItemType().getId()) {
                long itemId = solditems.get(i).getItemType().getId();
                findItemById(itemId).setCount(findItemById(itemId).getCount() + solditems.get(i).getCount());
                solditems.remove(i);
            }
        }

    }

    public Receipt findReceiptById(long receiptId){
        for (Receipt receipt: receiptsList){
            if (receipt.getId() == receiptId){
                System.out.println(receipt);
                return receipt;
            }
        }
        return null;
    }



}
