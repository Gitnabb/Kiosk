import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class RegistryTest {

    private Registry testRegistry;
    Book testBook;

    @Before
    public void setup(){

        this.testRegistry = new Registry();
        this.testBook = new Book("testBook", "testAuthor", 2019, 1);

    }

    @Test
    public void addBook() {
        assertTrue(this.testRegistry.addBook(testBook));
    }

    @Test
    public void removeBook() {
    }

    @Test
    public void showBooks() {
    }

    @Test
    public void findBookByTitle() {
    }

    @Test
    public void findBookByAuthor() {
    }

    @Test
    public void findBookByPublished() {
    }

    @Test
    public void getIterator() {
    }

    @Test
    public void titleExist() {
    }
}