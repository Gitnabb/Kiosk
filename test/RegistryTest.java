import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class RegistryTest {

    private Registry testRegistry;
    Literature testLiterature;

    @Before
    public void setup(){

        this.testRegistry = new Registry();
        this.testLiterature = new Literature("testBook", "testAuthor", 2019, 1);

    }

    @Test
    public void addLiterature() {
        assertTrue(this.testRegistry.addLiterature(testLiterature));
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