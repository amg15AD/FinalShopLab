package shop;

public abstract class Product {
    private final int ID;
    private static int uniqueID = 0;
    private String name;
    private Size size;
    private double price;
    protected int inventory;

    public Product(String name, Size size, double price, int inventory) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.inventory = inventory;
       uniqueID++;
       ID = uniqueID;

    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
