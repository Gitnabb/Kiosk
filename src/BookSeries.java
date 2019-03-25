/**
 * Represents a Book series.
 * This specific class is tailored to keep track of books in series.
 * It holds the information about the series names and date etc.
 * This class is extended by the parent class Book
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */
public class BookSeries extends Book {

    private String titleSeries;

    // TODO: Add further fields to the class


    public BookSeries(String title, String publisher,
                      String author, int published,
                      int editionNumber, String titleSeries) {

        super(title, publisher, author, published, editionNumber);
        this.titleSeries = titleSeries;
    }
}
