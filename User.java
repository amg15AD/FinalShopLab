package shop;

import java.util.Map;

public class User {
    private final int id;
    private static int uniqueId = 0;
    private Cart cart;

    public User() {
        this.cart = new Cart();
        uniqueId++;
        id = uniqueId;

    }

    public void addToCart(Product product, int qty){
//        if(cart.getProducts().containsKey(product)){
//            cart.getProducts().merge(product,qty,)
//        }
//        if(qty < product.inventory){
//            Map<Product,Integer> productsInCart = cart.getProducts();
//                    productsInCart.put(product,qty);
//
//        }
        if(qty <= 0 ){
            System.out.println("Nothing added to cart");
        }
        else if(product.inventory == 0){
            System.out.println("Sorry we're out of stock");
        }
        else if(qty > product.inventory){
            System.out.println("Sorry you're ordering more than we have in stock");
        }
        else if(qty <= product.inventory){
            Map<Product,Integer> productsInCart = cart.getProducts();
            productsInCart.merge(product,qty, (oldValue, newValue) -> oldValue + newValue);
            product.inventory -= qty;
            System.out.println(product.getName() +" Item added to your cart !!!");
        }
    }



    public void removeFromCart(Product product, int qty){
        Map<Product,Integer> productToRemove = cart.getProducts();
        if(!productToRemove.containsKey(product)){
            System.out.println("Womp Womp, You don't have that Item in your cart.");
        }
        else if(productToRemove.containsKey(product)){
            for(Map.Entry<Product,Integer> p : productToRemove.entrySet()){
                if(p.getKey() == product && p.getValue() >= qty){
                    productToRemove.merge(product,qty, (oldValue, newValue) -> oldValue - newValue);
                    productToRemove.remove(product,0);
                    product.inventory += qty;
                }
                else if(p.getKey() == product && p.getValue() >= qty){
                    System.out.println("Your cart does not have that many " + product);
                }
            }
        }
    }

    public int getId() {
        return id;
    }

    public static int getUniqueId() {
        return uniqueId;
    }

    public static void setUniqueId(int uniqueId) {
        User.uniqueId = uniqueId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


}//end of class