import models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
     Book book;

     @Before
    public void setup(){
         book = new Book("Great Gatsby", "F Scott Fitzgerald", false);

     }

     @Test
    public void hasTitle(){
         assertEquals("Great Gatsby", book.getTitle());
     }

     @Test
    public void hasAuthor(){
         assertEquals("F Scott Fitzgerald", book.getAuthor());
     }

     @Test
    public void booleanOnLoan(){
         assertEquals(false, book.isOnLoan());
     }
}
