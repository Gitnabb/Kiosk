/**
 * The Periodical class is a sub class of Literature, and holds information and functionality
 * related to the periodical type of literature in the kiosk registry.
 *
 */


public class Periodical extends Literature {

    private int publicationAmount;
    private String periodicalType;
    private String periodicalGenre;

    public Periodical(String title, String publisher, int publicationAmount, String periodicalType, String periodicalGenre) {
        super(title, publisher);
        this.publicationAmount = publicationAmount;
        this.periodicalType = periodicalType;
        this.periodicalGenre = periodicalGenre;
    }
}
