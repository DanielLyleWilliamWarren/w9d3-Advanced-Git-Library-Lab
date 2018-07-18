package models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    private int id;
    private String title;
    private String author;
    private boolean onLoan;
    private Borrower borrower;
    private Library libary;

    public Book() {
    }

    public Book(String title, String author, boolean onLoan) {
        this.title = title;
        this.author = author;
        this.onLoan = onLoan;
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Column(name = "onLoan")
    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    @ManyToOne
    @JoinColumn(name = "library_id", nullable = false)
    public Library getLibary() {
        return libary;
    }

    public void setLibary(Library libary) {
        this.libary = libary;
    }

}
