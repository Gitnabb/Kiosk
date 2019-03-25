
public class Newspaper extends Periodical {

    private String brainteaser;


    public Newspaper(String title, String publisher,
                     int publicationAmount, String periodicalType,
                     String periodicalGenre, String brainteaser) {

        super(title, publisher, publicationAmount, periodicalType, periodicalGenre);
        this.brainteaser = brainteaser;
    }
}
