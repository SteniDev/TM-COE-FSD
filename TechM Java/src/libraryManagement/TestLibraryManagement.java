package libraryManagement;

public class TestLibraryManagement {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        // Adding books
        library.addBook(new Book("Java Programming", "James Gosling", "123456"));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "789101"));

        // Adding users
        library.addUser(new User("Alice", "U001"));
        library.addUser(new User("Bob", "U002"));

        // Simulating multithreading
        Thread user1 = new Thread(() -> {
            try {
                library.borrowBook("123456", "U001");
                System.out.println("Alice borrowed Java Programming");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread user2 = new Thread(() -> {
            try {
                library.borrowBook("123456", "U002");
                System.out.println("Bob borrowed Java Programming");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
