import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a Book series.
 * This specific class is tailored to keep track of books in series.
 * It holds the information about the series names and date etc.
 * This class is extended by the parent class Book
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */
public class BookSeries extends Literature {

    private List<Book> bookSeries;
    private String authors;

    public BookSeries(String title, String publisher, String authors) {
        super(title, publisher);
        this.authors = authors;
        this.bookSeries = new ArrayList<>();
    }

    protected List<Book> getBookSeries() {
        return this.bookSeries;
    }

    protected String getAuthors() {
        return this.authors;
    }

    protected void addBookToSeries(Book bookToAdd) {
        this.bookSeries.add(bookToAdd);
    }

}
