import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookRegistryTest {

    private ArrayList<Book> BookList; // name of the Book-list
    private BookRegistry BookReg;
    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void setUp() throws Exception {
        this.bookList = new ArrayList<>();

        this.book1 = new Book("Bibelen", "Jesus", 0001, 1);
        this.book2 = new Book("Koranen", "Buddha", 0630, 1);
        this.book3 = new Book("Første Mosebok", "Moses", 0230, 1);

        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }

    /**
     * Checks if the book is added to the book-list
     * it see's if the book is not null
     * which is considered it to be already added.
     */
    @Test
    public void registerBook() {
        assertNotNull(book1);
    }

    /**
     * Checks if the book is deleted, if it is
     * deleted and removed from the bookList,
     * the assertNull-method will approve the test
     */
    @Test
    public void deleteBook() {
        assertNull(book2);
    }

    /**
     *
     */
    @Test
    public void listAllBooks() {
    }

    /**
     *
     */
    @Test
    public void getIterator() {

    }

    /**
     *
     */
    @Test
    public void searchForBookTitle() {
    }

    /**
     * It goes forward to check if the size of the list
     * corresponds to the number (3, in this case) in the method
     * Will also vary depending on the deleteBook-method
     * SO PRO_TIP:
     * Don't run these test's at the same time
     */
    @Test
    public void getNumberOfBooks() {
        assertEquals(3,bookList.size());
    }
}