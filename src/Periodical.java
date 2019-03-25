

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
