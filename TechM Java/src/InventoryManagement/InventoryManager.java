package InventoryManagement;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InventoryManager {
    private ConcurrentHashMap<String, Product> inventory = new ConcurrentHashMap<>();
    private PriorityQueue<Order> orderQueue = new PriorityQueue<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductID(), product);
    }

    public void processOrders() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            executorService.submit(() -> fulfillOrder(order));
        }
        executorService.shutdown();
    }

    public void fulfillOrder(Order order) {
        for (String productId : order.getProductIDs()) {
            try {
                Product product = inventory.get(productId);
                if (product == null) {
                    throw new InvalidLocationException("Product ID " + productId + " not found!");
                }
                product.reduceStock(1);
                System.out.println("Order fulfilled: " + product.getName() + " from " + product.getLocation());
            } catch (OutOfStockException | InvalidLocationException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public void addOrder(Order order) {
        orderQueue.add(order);
    }
}
