import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class RegistryTest {

    @Test
    public void addBook() {
        Book book = new Book();

        String input = "bookTitle";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("bookTitle", book.getTitle());
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