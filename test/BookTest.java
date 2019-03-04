import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
    }

    @Test
    public void setAuthor() {
    }

    @Test
    public void getPublished() {
    }

    @Test
    public void setPublished() {
    }

    @Test
    public void getEdition() {
    }

    @Test
    public void setEdition() {
    }
}