package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "borrowers")
public class Borrower {

    private int id;
    private String name;
    private ArrayList<Book> itemsBorrowed;
    private Library library;

    public Borrower() {
    }

    public Borrower(String name) {
        this.name = name;
        this.itemsBorrowed = new ArrayList<Book>();
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "books_borrowed")
    public List<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(ArrayList<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }

    @Column
    public ArrayList<Book> getBooks() {
        return itemsBorrowed;
    }

    public void setBooks(Set<Book> books) {
        this.itemsBorrowed = itemsBorrowed;
    }

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false)
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}

