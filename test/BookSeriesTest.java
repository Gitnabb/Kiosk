import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookSeriesTest {

    //fields to hold the structure of the BookSeries-class
    private ArrayList<Book> bookSeriesList1 = new ArrayList<>();
    private ArrayList<Book> bookSeriesList4 = new ArrayList<>();

    private String authors;

    Book book1 = new Book("Book 1", "A random Publisher1", "Some author 1",2011,1);
    Book book4 = new Book("Book 4", "A random Publisher4", "Some author 4",2014,4);

    BookSeries booklist4 = new BookSeries("list4 title","list4 Media", "list4 auth");

    @Before
    public void setUp() {
        this.bookSeriesList1.add(book1);
        this.bookSeriesList4.add(book4);
    }

    /**
     * Tests if the given author name equals the correct author
     * name of the book1.
     */
    @Test
    public void getAuthors() {
        assertEquals("Some author 1", book1.getAuthor());
    }

    /**
     * Assert true if the list isn't empty, which means
     * the add book to series-method works,
     */
    @Test
    public void addBookToSeries() {
        booklist4.addBookToSeries(book4);
        ArrayList<Book> testList = booklist4.getBookSeriesList();
        assertTrue(testList.size() != 0);
    }

}