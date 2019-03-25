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

public class Periodical extends Literature {

    private int publicationAmount; // once a year for instance
    private String periodicalType; // newspaper, magazine etc..
    private String periodicalGenre; // genre of periodical, like sports / news / travel


    public Periodical(String title, String publisher, int publicationAmount, String periodicalType, String periodicalGenre) {
        super(title, publisher);
        this.publicationAmount = publicationAmount;
        this.periodicalType = periodicalType;
        this.periodicalGenre = periodicalGenre;
    }

    public int getPublicationAmount() {
        return publicationAmount;
    }
}
