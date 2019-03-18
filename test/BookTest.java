import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Literature testLiterature;

    @Before
    public void setUp() throws Exception {

        testLiterature = new Literature("testTitle", "testAuthor", 2019, 1);

    }

    @Test
    public void getTitle() {
        assertEquals("testTitle", testLiterature.getTitle());
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void getAuthor() {
        assertEquals("testAuthor", testLiterature.getAuthor());
    }

    @Test
    public void setAuthor() {
    }

    @Test
    public void getPublished() {
        assertEquals(2019, testLiterature.getPublished());
    }

    @Test
    public void setPublished() {
    }

    @Test
    public void getEdition() {
        assertEquals(1, testLiterature.getEdition());
    }

    @Test
    public void setEdition() {
    }
}