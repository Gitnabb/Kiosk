/**
 * Represents a Newspaper
 * This specific class is tailored to give info
 * about a newspaper.
 * The class holds all the info required to establish a newspaper.
 * This class extends from the parent class Periodical.
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */
public class Newspaper extends Periodical {


    /**
     * Defining field, represents a special feature in the newspaper.
     * The brainteaser might differ from week to week
     * and is usually one of the following;
     *  - crossword-puzzle
     *  - sudoku
     *  - word-mystery-puzzle
     *  - etc.
     */
    private String brainteaser;

    /**
     * Constructs a Newspaper, initialized with the title, publisher,
     * publication amount, periodical type, periodical genre & brainteaser.
     * @param title the name of the Newspaper (such as VG, DB ..)
     * @param publisher the publisher of the Newspaper ("forlag" in norwegian)
     * @param publicationAmount the amount of publications per year / month / week
     * @param periodicalType the type of periodical, in this case newspaper
     * @param periodicalGenre the genre of the newspaper (such as: news, sports, travel etc)
     * @param brainteaser the newspaper's brainteaser
     */
    public Newspaper(String title, String publisher,
                     int publicationAmount, String periodicalType,
                     String periodicalGenre, String brainteaser) {

        super(title, publisher, publicationAmount, periodicalType, periodicalGenre);
        this.brainteaser = brainteaser;
    }

    /**
     * returns the newspaper's brain teaser
     * @return the newspaper's brain teaser
     */
    public String getBrainteaser() {
        return brainteaser;
    }
}
