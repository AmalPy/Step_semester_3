import java.util.Scanner;

public class Cart {

    private double[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
        itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount >= prices.length) {
            System.out.println("Cart is full");
            return;
        }

        if (price < 0) {
            System.out.println("Invalid price");
            return;
        }

        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){

        System.out.print("Enter cart ID: ");
        String cartId = sc.nextLine();

        System.out.print("Enter maximum number of items: ");
        int maxItems = sc.nextInt();

        Cart cart = new Cart(cartId, maxItems);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of item " + (i + 1) + ": ");
            double price = sc.nextDouble();
            cart.addItem(price);
        }

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());

        sc.close();
    }
}
}