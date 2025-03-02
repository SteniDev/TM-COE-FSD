package InventoryManagement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WarehouseInventorySystem {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Adding sample products
        inventoryManager.addProduct(new Product("P001", "Laptop", 10, new Location(1, 2, 3)));
        inventoryManager.addProduct(new Product("P002", "Phone", 5, new Location(1, 3, 2)));

        // Adding sample orders
        List<String> order1Products = Arrays.asList("P001", "P002");
        List<String> order2Products = Collections.singletonList("P002");
        inventoryManager.addOrder(new Order("O001", order1Products, Order.Priority.EXPEDITED));
        inventoryManager.addOrder(new Order("O002", order2Products, Order.Priority.STANDARD));

        // Processing Orders
        inventoryManager.processOrders();
    }
}
