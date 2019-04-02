import java.util.ArrayList;

public class BookSeries extends Literature {

    private String authors;
    private String seriesTitle;
    private ArrayList<Literature> bookSeriesList;

    public BookSeries(String title, String publisher, String genre, String price, String date, String authors) {
        super(title, publisher, genre, price, date);
        this.authors = authors;
        this.seriesTitle = seriesTitle;
        this.bookSeriesList = new ArrayList<>();

    }

    public void addBookToBookSeries(Literature literature){

        this.bookSeriesList.add(literature);
        System.out.println("A book was added to " + seriesTitle + "!");

    }

    public String getAuthors() {
        return authors;
    }

    private boolean isBookPartOfSeries(Book book){
        boolean exists = false;

        // Search in bookSeriesList if the book exists there.
        return exists;
    }

    public int getSeriesSize(){

        return bookSeriesList.size();
    }
}
