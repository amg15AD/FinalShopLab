package shop;

public class Main {
    public static void main(String[] args) {
        Hat hat1 = new Hat("New Era", Size.S,10.00,10);
        Product p2 = new Hat("Trucker Hat", Size.S,10.00,20);

        Cart u1Cart = new Cart();
        User u1 = new User();
        u1.setCart(u1Cart);

        //u1.addToCart(hat1,20);

        u1.addToCart(hat1,5);
        u1.addToCart(hat1,2);
        u1.addToCart(hat1,2);
        System.out.println(hat1.getInventory());
        System.out.println(u1Cart.cartQty());
        System.out.println("==========");
        System.out.println( u1Cart.subTotal());
        System.out.println( u1Cart.totalAfterTax());
         u1Cart.printSpecial();
        u1Cart.checkOut();
        System.out.println("==========");
         u1Cart.setSpecial(Special.TUE);
        u1Cart.printSpecial();
        System.out.println( u1Cart.subTotal());
        System.out.println( u1Cart.totalAfterTax());
        u1Cart.checkOut();

    }





}
