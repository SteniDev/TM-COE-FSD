package InventoryManagement;

import java.util.List;

public class Order implements Comparable<Order> {
    private final String orderID;
    private final List<String> productIDs;
    private final Priority priority;

    public enum Priority {
        STANDARD,
        EXPEDITED
    }

    public Order(String orderID, List<String> productIDs, Priority priority) {
        this.orderID = orderID;
        this.productIDs = productIDs;
        this.priority = priority;
    }

    public List<String> getProductIDs() {
        return productIDs;
    }

    public Priority getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Order o) {
        return this.priority.compareTo(o.priority);
    }
}
