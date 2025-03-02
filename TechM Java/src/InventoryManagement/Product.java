package InventoryManagement;

public class Product {
    private String name;
    private int quantity;
    private Location location;
    private String productID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Product(String productID, String name, int quantity, Location location) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    public synchronized void reduceStock(int amount) throws OutOfStockException {
        if (amount > quantity) {
            throw new OutOfStockException("Product " + name + " is out of stock!");
        }
        quantity -= amount;
    }
}
