import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book testBook;

    @Before
    public void setUp() throws Exception {
        this.testBook = new Book("Bibelen", "Jesus", 0001, 1);
    }

    @Test
    public void getTitle() {
        assertEquals("Bibelen",testBook.getTitle());
    }

    @Test
    public void getAuthor() {
    }

    @Test
    public void getPublished() {
        assertEquals(0001,testBook.getPublished(),0);
    }

    @Test
    public void getEditionNumber() {
    }
}

