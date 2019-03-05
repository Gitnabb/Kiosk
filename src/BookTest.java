import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book testBook;


    /**
     * We create a testbook for testing the different parameters by methods
     * @throws Exception we create a exception to control the result of the test
     */
    @Before
    public void setUp() throws Exception {
        this.testBook = new Book("Bibelen", "Jesus", 0001, 1);
    }

    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     */
    @Test
    public void getTitle() {
        assertEquals("Bibelen",testBook.getTitle());
    }

    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     */
    @Test
    public void getAuthor() {
        assertEquals("Jesus", testBook.getAuthor());
    }

    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     */
    @Test
    public void getPublished() {
        assertEquals(0001,testBook.getPublished(),0);
    }

    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     */
    @Test
    public void getEditionNumber() {
        assertEquals(1,testBook.getEditionNumber());
    }
}

