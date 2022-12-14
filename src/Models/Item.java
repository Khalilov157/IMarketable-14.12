package Models;

public class Item {

    private String name;
    private Double price;
    private int count;

    private ItemCategorie category;
    private long id;

    public Item(String name, Double price, int count, ItemCategorie category, long id) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.category = category;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " " + name + " Price :" + price + " Count = " + count + " Category :" + category;
    }

    public Double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
