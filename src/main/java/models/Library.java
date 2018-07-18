package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "libraries")
public class Library {
    private int id;
    private Set<Book> books;
    private Set<Borrower> borrowers;


    public Library() {
    }

    public Library(Set<Book> books, Set<Borrower> borrowers) {
        this.books = books;
        this.borrowers = borrowers;
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

    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    public Set<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(Set<Borrower> borrowers) {
        this.borrowers = borrowers;
    }




}

