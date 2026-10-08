package ec.edu.espoch.cafeteria;


public class Order {
    private  String item;
    private  int quantity;
    private  double price;
    private  double subtotal;

    public Order(String item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = calculateSubtotal();
    }

    public double calculateSubtotal() {
        return this.quantity * this.price;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }
}