package shop;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products;
    private final float TAX = 10.0f;
    private Special special;

    public Cart() {
        this.products =new HashMap<>();
    }
    public int cartQty(){
        int numberOfItems = 0;
        for(Map.Entry<Product,Integer> p : products.entrySet()){
            numberOfItems += p.getValue();
        }

        return numberOfItems;
    }
    public double subTotal(){
        double total =0;
        if(this.special == Special.TUE || this.special == Special.SUN) {
            for (Map.Entry<Product, Integer> p : products.entrySet()) {
                if(p.getValue() == 1){
                    total += p.getValue() * p.getKey().getPrice();
                }
                else if(p.getValue()%2 == 0){
                    total += (p.getValue() * p.getKey().getPrice()) /2;
                }
                else if(p.getValue()%2 != 0){
                    total += ((p.getValue() * p.getKey().getPrice()/2) + p.getKey().getPrice());
                }
                return total;
            }

        }else for (Map.Entry<Product, Integer> p : products.entrySet()) {
            total += p.getKey().getPrice() * p.getValue();
        }
        return total;
    }

    public double totalAfterTax(){
        return subTotal() + (subTotal() * TAX);
    }

    public void checkOut(){
        System.out.printf("\t\t======Receipt======\nQuantity\tSubtotal\tTotal after tax\n" +
                "%4d\t\t  $%.2f\t\t\t$%.2f\n",cartQty(),subTotal(),totalAfterTax());
    }

    public void printSpecial(){
        if(this.special == Special.TUE || this.special == Special.SUN){
            System.out.println("B.O.G.O FREE!!!");
        }
        else {
            System.out.println("Sorry there is no special today");
        }
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
