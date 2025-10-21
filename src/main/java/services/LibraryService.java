package services;

import models.Book;
import models.User;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books;
    private List<User> users;

    public LibraryService() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        initSampleData();
    }

    private void initSampleData() {
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien"));

        users.add(new User("Alice"));
        users.add(new User("Bob"));
    }

    public List<Book> getBooks() { return books; }
    public List<User> getUsers() { return users; }

    public User findUser(String name) {
        return users.stream().filter(u -> u.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public Book findBook(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }
}
