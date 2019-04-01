/**
 * The Periodical class is a sub class of Literature, and holds information and functionality
 * related to the periodical type of literature in the kiosk registry.
 *
 */


public abstract class Periodical extends Literature {

    private int publicationAmountPerYear;
    private String periodicalType;
    // private String periodicalGenre;

    public Periodical(String title, String publisher,
                      String genre, String price,
                      String date, int publicationAmountPerYear,
                      String periodicalType) {
        super(title, publisher, genre, price, date);
        this.publicationAmountPerYear = publicationAmountPerYear;
        this.periodicalType = periodicalType;
       // this.periodicalGenre = periodicalGenre;
    }

    public int getPublicationAmountPerYear() {
        return publicationAmountPerYear;
    }

    public String getPeriodicalType() {
        return periodicalType;
    }

}
