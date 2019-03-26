import java.util.ArrayList;

public class BookSeries  extends  Book {

    private int editionNumber;
    private int amountOfBooks;

    private final ArrayList<Book> bookSeries;

    public BookSeries(String title, String publisher,
                      String genre, String price,
                      String date, String author,
                      int published, int edition,
                      boolean isPartOfSeries, int editionNumber,
                      int amountOfBooks) {
        super(title, publisher, genre, price, date, author, published, edition, isPartOfSeries);
        this.editionNumber = editionNumber;
        this.amountOfBooks = amountOfBooks;

        this.bookSeries = new ArrayList<>();

    }

    public void addBookToBookSeries(Book book){

        this.bookSeries.add(book);

    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public int getAmountOfBooks() {
        return amountOfBooks;
    }


}
