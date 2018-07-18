import models.Book;
import models.Borrower;
import models.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library;
    ArrayList<Book> books;
    ArrayList<Borrower> borrowers;

    @Before
    public void setup(){
        books = new ArrayList<Book>();
        borrowers = new ArrayList<Borrower>();
        library = new Library(books, borrowers);
    }

    @Test
    public void hasBooks(){
        assertEquals(books, library.getBooks());
    }

    @Test
    public void hasBorrowers(){
        assertEquals(borrowers, library.getBorrowers());
    }

}
