package shop;

public class CanSpam extends Food implements Perishable{
    public CanSpam(String name, Size size, double price, int inventory) {
        super(name, size, price, inventory);
    }

    @Override
    public boolean isPerishable() {
        return false;
    }
}
