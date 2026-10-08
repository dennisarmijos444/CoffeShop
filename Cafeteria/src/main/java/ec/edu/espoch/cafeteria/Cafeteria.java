package ec.edu.espoch.cafeteria;

import java.util.Scanner;

public class Cafeteria {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeShop coffeeShop = new CoffeeShop();

        System.out.println("=== SISTEMA DE GESTIÓN DE LA CAFETERÍA ===");
        
        // 1. Iniciar con los datos del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(name);

        boolean registrarMas = true;

        // 2. Bucle para registrar varios pedidos
        while (registrarMas) {
            System.out.println("\n--- MENÚ DE PRODUCTOS ---");
            System.out.println("1. Café       - $2.50");
            System.out.println("2. Hamburguesa - $5.00");
            System.out.println("3. Pizza       - $8.00");
            System.out.println("4. Jugo        - $2.00");
            System.out.print("Seleccione una opción (1-4): ");
            
            int opcion = scanner.nextInt();
            String item = "";
            double price = 0.0;

            switch (opcion) {
                case 1:
                    item = "Café";
                    price = 2.50;
                    break;
                case 2:
                    item = "Hamburguesa";
                    price = 5.00;
                    break;
                case 3:
                    item = "Pizza";
                    price = 8.00;
                    break;
                case 4:
                    item = "Jugo";
                    price = 2.00;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue; // Vuelve a pedir la opción si es incorrecta
            }

            System.out.print("Ingrese la cantidad a comprar: ");
            int quantity = scanner.nextInt();

            // Crear el pedido y agregarlo a la cafetería
            Order order = new Order(item, quantity, price);
            coffeeShop.addOrder(order);

            System.out.println("-> Subtotal de este producto: $" + String.format("%.2f", order.getSubtotal()));

            // Preguntar si desea finalizar o continuar
            System.out.print("\n¿Desea agregar otro producto al pedido? (s/n): ");
            char respuesta = scanner.next().toLowerCase().charAt(0);
            if (respuesta != 's') {
                registrarMas = false;
            }
        }

        // 3. Mostrar resumen final
        System.out.println("\n----------------------------------------");
        System.out.println("Cliente atendido: " + customer.getName());
        coffeeShop.displaySummary();

        scanner.close();
    }
}

