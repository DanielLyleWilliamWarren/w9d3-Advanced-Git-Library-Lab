package models;

import java.util.Set;
import javax.persistence.*;



@Entity
@Table(name = "borrowers")
public class Borrower {

    private int id;
    private String name;
    private Set<Book> books;
    private Library library;

    public Borrower(){}

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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
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
