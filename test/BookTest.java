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
        this.testBook = new Book("testTitle", "testPublisher","testAuthor",2010,10);
    }

    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     */
    @Test
    public void getTitle() {
        assertEquals("testTitle",testBook.getTitle());
    }

    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     *
     */
    @Test
    public void getPublisher() {
        assertEquals("testPublisher",testBook.getPublisher());
    }
    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     */
    @Test
    public void getAuthor() {
        assertEquals("testAuthor", testBook.getAuthor());
    }

    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     */
    @Test
    public void getPublished() {
        assertEquals(2010,testBook.getPublished(),0);
        assertNotEquals(1449,testBook.getPublished(),0);
    }

    /**
     * We use the input from the setup from the book to validate
     * the positive check result from the method
     */
    @Test
    public void getEditionNumber() {
        assertEquals(10,testBook.getEditionNumber(),0);
        assertNotEquals(2,testBook.getEditionNumber(),0);
    }
}

