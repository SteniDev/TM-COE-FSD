package libraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class LibrarySystem implements ILibrary {
    protected List<Book> books = new ArrayList<>();
    protected List<User> users = new ArrayList<>();
    protected final ReentrantLock lock = new ReentrantLock();

    public abstract void addBook(Book book);

    public abstract void addUser(User user);
}
