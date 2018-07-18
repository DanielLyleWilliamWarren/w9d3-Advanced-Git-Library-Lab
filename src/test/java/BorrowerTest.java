import models.Borrower;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower;

    @Before
    public void setup(){
        borrower = new Borrower("Dave");
    }

    @Test
    public void hasName(){
        assertEquals("Dave", borrower.getName());
    }
}
