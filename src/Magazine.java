/**
 * This class represents a magazine.
 * This specific class is tailored to give information
 * about a magazine.
 * The class holds information about the title, publisher,
 * the frequency of the publication, the type of periodical,
 * the periodical genre and the front cover model of the magazine front page.
 *
 * This class is extended by the parent clas Periodical
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */

public class Magazine extends Periodical {

    // a cover model for the specific magazine, often connected to the genre of the magazine
    private String coverModel;


    /**
     * Constructs the Magazine with a title, publisher, publication amount,
     * periodicla type, periodical genre and a cover model for the front page.
     * @param title The title of the magazine
     * @param publisher The publiser of the magazine
     * @param publicationAmount the amount of published amounts
     * @param periodicalType the type of magazine
     * @param periodicalGenre the genre of the magazine
     * @param coverModel the front page cover model
     */
    public Magazine(String title, String publisher,
                    int publicationAmount, String periodicalType,
                    String periodicalGenre, String coverModel) {

        super(title, publisher, publicationAmount, periodicalType, periodicalGenre);
        this.coverModel = coverModel;
    }


    /**
     * returns the cover-model for the magazine
     * @return the cover-model for the magazine
     */
    public String getCoverModel() {
        return coverModel;
    }


}
