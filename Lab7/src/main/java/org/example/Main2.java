package org.example;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

record Book(String bookTitle, String author, int publicationYear, boolean isAvailable) { }

class LibraryCatalog {
    private ArrayList<Book> books;

    public LibraryCatalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book b) {
        this.books.add(b);
    }

    public Optional<Book> isAvailable(String title) {
        return this.books.stream().
                filter(b -> b.isAvailable() && b.bookTitle().equals(title)).
                findFirst();
    }

    public Optional<Book> retrieveDetailsOfBookByAuthor(String author) {
        return books.stream().
                filter(b -> b.isAvailable() && b.author().equals(author)).
                findFirst();
    }


}

public class Main2 {
    public static void main(String[] args) {


    }
}
