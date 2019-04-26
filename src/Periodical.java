/**
 * Represents a Periodical class.
 * This is tailored to setup the correct type of literature from the parent class
 * This class holds information about the publication frequency, the type of publication
 * as well as the genre of the periodical
 * This class is extended by the parent class Literature
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */

public abstract class Periodical extends Literature {

    private int publicationAmount; // once a year for instance
    private String periodicalType; // newspaper, magazine etc..
    private String periodicalGenre; // genre of periodical, like sports / news / travel

    /**
     * Constructs the Periodical with a title,
     * publisher, publication amount, periodical type and the genre.
     * Since the class is abstract, if wont ever be used.
     * @param title
     * @param publisher
     * @param publicationAmount
     * @param periodicalType
     * @param periodicalGenre
     */
    public Periodical(String title, String publisher, int publicationAmount, String periodicalType, String periodicalGenre) {
        super(title, publisher);
        this.publicationAmount = publicationAmount;
        this.periodicalType = periodicalType;
        this.periodicalGenre = periodicalGenre;
    }

    /**
     * returns the amount of publications
     * @return the amount of publications
     */
    public int getPublicationAmount() {
        return publicationAmount;
    }

    /**
     * retunrs the type of periodical
     * @return the type of periodical
     */
    public String getPeriodicalType() {
        return periodicalType;
    }

    /**
     * returns the genre of the periodical
     * @return the genre of the periodical
     */
    public String getPeriodicalGenre() {
        return periodicalGenre;
    }
}
