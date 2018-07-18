package models;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.List;

public class Borrower {
    private int id;
    private String name;
    private List<Book> itemsBorrowed;
=======
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;

public class Borrower {

    private int id;
    private String name;
    private Set<Book> books;

    public Borrower(){}
>>>>>>> master

    public Borrower(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue
<<<<<<< HEAD
    @Column(name="id")
    public int getId() {
        return id;
    }

=======
    @Column(name = "id")
    public int getId() {
        return id;
    }
>>>>>>> master
    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
    @Column(name="name")
=======
    @Column(name = "name")
>>>>>>> master
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
    @Column(name="books_borrowed")
    public List<Book> getItemsBorrowed() {
        return itemsBorrowed;
    }

    public void setItemsBorrowed(List<Book> itemsBorrowed) {
        this.itemsBorrowed = itemsBorrowed;
=======
    @Column
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
>>>>>>> master
    }
}
