package models;

import javax.persistence.*;
import java.util.List;

public class Borrower {
    private int id;
    private String name;
    private List<Book> itemsBorrowed;

    public Borrower(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="books_borrowed")
    public List<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(List<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
    }
}
