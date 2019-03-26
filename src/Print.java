public class Print {

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

        Print.info(literature.getClass().getSimpleName());
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
            String type = magazine.getMagazineType();
            String releasesPerYear = String.valueOf(magazine.getPublicationAmountPerYear());
            info("Type:                   " + type);
            info("Releases Per Year:      " + releasesPerYear);
            info("");

        } else if (literature instanceof BookSeries) {
            BookSeries bookSeries = (BookSeries) literature;
            int numberOfBooks = bookSeries.getSerieSize();
            info("Number of books         " + numberOfBooks);
        }

    }


}
