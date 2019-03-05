import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book testBook;

    @Before
    public void setUp() throws Exception {

        testBook = new Book("testTitle", "testAuthor", 2019, 1);

    }

    @Test
    public void getTitle() {
        assertEquals("testTitle", testBook.getTitle());
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void getAuthor() {
        assertEquals("testAuthor", testBook.getAuthor());
    }

    @Test
    public void setAuthor() {
    }

    @Test
    public void getPublished() {
        assertEquals(2019, testBook.getPublished());
    }

    @Test
    public void setPublished() {
    }

    @Test
    public void getEdition() {
        assertEquals(1, testBook.getEdition());
    }

    @Test
    public void setEdition() {
    }
}