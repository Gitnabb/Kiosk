public class Printer {

    //info
    public static void info(String message) {
        System.out.println(message);
    }

    /**
     * Prints the literature
     *
     * @param literature
     */
    public static void printLiterature(Literature literature) {
        String title = literature.getTitle();
        String publisher = literature.getPublisher();
        String genre = literature.getGenre();
        String price = String.valueOf(literature.getPrice());
        String date = literature.getDate();

        Printer.info(literature.getClass().getSimpleName());
        info("Title:                  " + title);
        info("Publisher:              " + publisher);
        info("Genre:                  " + genre);
        info("Price:                  " + price);
        info("Date:                   " + date);

        if (literature instanceof Book) {
            Book book = (Book) literature;
            String author = book.getAuthor();
            info("Author:                 " + author);
            info("");
        } else if (literature instanceof Magazine) {
            Magazine magazine = (Magazine) literature;
            String type = magazine.getPeriodicalType();
            String releasesPerYear = String.valueOf(magazine.getPublicationAmountPerYear());
            String coverModel = String.valueOf(magazine.getCoverModel());
            info("Type:                   " + type);
            info("Releases Per Year:      " + releasesPerYear);
            info("Cover model:            " + coverModel);
            info("");

        } else if (literature instanceof BookSeries) {
            BookSeries bookSeries = (BookSeries) literature;
            int numberOfBooks = bookSeries.getSeriesSize();
            info("Number of books         " + numberOfBooks);
        }

    }


}
