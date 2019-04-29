import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class LiteratureTest {

    /**
     * Test of the getters and setters methods
     */
    Literature book = new Book("Harry-Potter 1","Cappelen damm","J.K. Rowling",2014,1);

    @Before
    public void setUp() throws Exception {
    }

    /**
     * We use the input from the setup from the book to validate
     * the result from the method, and checks whether its correct or false
     */
    @Test
    public void getTitle() {
        assertEquals("Harry-Potter 1", book.getTitle());
        assertNotEquals("", book.getTitle());
    }


    /**
     * We use the input from the setup from the book to validate
     * the result from the method, and checks whether its correct or false
     */
    @Test
    public void getPublisher() {
        assertEquals("Cappelen damm", book.getPublisher());
    }


    /**
     * We use the input from the setup from the book to validate
     * the result from the method, and checks whether its correct or false
     */
    @Test
    public void setTitle() {
        String testTitle = "Harry-Potter 1";
        assertEquals(testTitle,book.getTitle());
    }

    /**
     * We use the input from the setup from the book to validate
     * the result from the method, and checks whether its correct or false
     */
    @Test
    public void setPublisher() {
        String testPublisher = "Cappelen damm";
        assertEquals(testPublisher,book.getPublisher());
    }



}