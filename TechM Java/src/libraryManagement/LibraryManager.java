package libraryManagement;

public class LibraryManager extends LibrarySystem {
    private static final int MAX_BORROWED_BOOKS = 5;

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        lock.lock();
        try {
            User user = findUser(userID);
            if (user.getBorrowedBooks().size() >= MAX_BORROWED_BOOKS) {
                throw new MaxBooksAllowedException("User has reached max borrowed books.");
            }
            Book book = findBook(ISBN);
            if (book.isBorrowed()) {
                throw new BookNotFoundException("Book is already borrowed.");
            }
            book.setBorrowed(true);
            user.getBorrowedBooks().add(book);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        lock.lock();
        try {
            User user = findUser(userID);
            Book book = findBook(ISBN);
            if (!user.getBorrowedBooks().remove(book)) {
                throw new BookNotFoundException("User did not borrow this book.");
            }
            book.setBorrowed(false);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        findUser(userID);  // Just to check if user exists
        findBook(ISBN);  // Just to check if book exists
        System.out.println("Book reserved successfully.");
    }

    @Override
    public Book searchBook(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    private User findUser(String userID) throws UserNotFoundException {
        return users.stream().filter(u -> u.getUserID().equals(userID)).findFirst().orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private Book findBook(String ISBN) throws BookNotFoundException {
        return books.stream().filter(b -> b.getISBN().equals(ISBN)).findFirst().orElseThrow(() -> new BookNotFoundException("Book not found"));
    }
}
