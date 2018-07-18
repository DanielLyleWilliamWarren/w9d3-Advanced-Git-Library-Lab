package models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "libraries")
public class Library {
    private int id;
    private ArrayList<Book> books;
    private ArrayList<Borrower> borrowers;


    public Library() {
    }

    public Library(ArrayList<Book> books, ArrayList<Borrower> borrowers) {
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
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    @OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
    public ArrayList<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(ArrayList<Borrower> borrowers) {
        this.borrowers = borrowers;
    }

}

