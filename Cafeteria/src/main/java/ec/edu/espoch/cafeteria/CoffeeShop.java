package ec.edu.espoch.cafeteria;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CoffeeShop {
    private List<Order> orders;
    private int totalItems;
    private double totalCollected;
    private double discount;
    private String bestSellingItem;

    public CoffeeShop() {
        this.orders = new ArrayList<>();
        this.totalItems = 0;
        this.totalCollected = 0.0;
        this.discount = 0.0;
        this.bestSellingItem = "";
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        this.totalItems += order.getQuantity();
    }

    public double calculateTotal() {
        double subtotalAcumulado = 0.0;
        for (Order order : orders) {
            subtotalAcumulado += order.getSubtotal();
        }
        
        // Aplica 10% de descuento si el subtotal acumulado supera los $20
        this.discount = calculateDiscount(subtotalAcumulado);
        this.totalCollected = subtotalAcumulado - this.discount;
        
        return this.totalCollected;
    }

    public double calculateDiscount(double subtotalTotal) {
        if (subtotalTotal > 20.0) {
            return subtotalTotal * 0.10;
        }
        return 0.0;
    }

    public String findBestSellingItem() {
        if (orders.isEmpty()) {
            return "Ninguno";
        }

        Map<String, Integer> productCounts = new HashMap<>();
        for (Order order : orders) {
            productCounts.put(order.getItem(), productCounts.getOrDefault(order.getItem(), 0) + order.getQuantity());
        }

        String maxItem = "";
        int maxQty = -1;

        for (Map.Entry<String, Integer> entry : productCounts.entrySet()) {
            if (entry.getValue() > maxQty) {
                maxQty = entry.getValue();
                maxItem = entry.getKey();
            }
        }

        this.bestSellingItem = maxItem;
        return this.bestSellingItem;
    }

    public void displaySummary() {
        calculateTotal();
        findBestSellingItem();

        System.out.println("\n========== RESUMEN DE VENTAS ==========");
        System.out.println("Total de productos vendidos: " + totalItems);
        System.out.println("Descuento aplicado        : $" + String.format("%.2f", discount));
        System.out.println("Total de dinero recaudado : $" + String.format("%.2f", totalCollected));
        System.out.println("Producto más vendido      : " + bestSellingItem);
        System.out.println("========================================");
    }
}
