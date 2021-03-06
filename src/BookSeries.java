import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Represents a Book series.
 * This specific class is tailored to keep track of books in series.
 * It holds the information about the series names and date etc.
 * This class is extended by the parent class Book
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */
public class BookSeries extends Literature {

    //fields to hold the structure of the BookSeries-class
    private ArrayList<Book> bookSeriesList;
    private String authors;

    /**
     * Constructs a BookSeries, initialized with title, publisher &  authors.
     * @param title The title of the BookSeries
     * @param publisher the publisher of the BookSeries
     * @param authors the authors of the BookSeries
     */
    public BookSeries(String title, String publisher, String authors) {
        super(title, publisher);
        this.authors = authors;
        this.bookSeriesList = new ArrayList<>();
    }

    /**
     * retuns the bookseries-list
     * @return the bookseries-list
     */
    public ArrayList<Book> getBookSeriesList() {
        return bookSeriesList;
    }

    /**
     * returns the authors of the book series
     * @return the authors of the book series
     */
    protected String getAuthors() {

        return this.authors;
    }

    /**
     * Adds a given book into the the book-series-list
     * @param bookToAdd The book to add
     */
    protected void addBookToSeries(Book bookToAdd) {

        if (bookToAdd == null) {
            throw new InputMismatchException("null in book to add");
        }
        else {
            this.bookSeriesList.add(bookToAdd);
        }

    }

}
