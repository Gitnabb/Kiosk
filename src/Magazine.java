
public class Magazine extends Periodical {

    // a cover model for the specific magazine, often connected to the genre of the magazine
    private String coverModel;

    public Magazine(String title, String publisher,
                    int publicationAmount, String periodicalType,
                    String periodicalGenre, String coverModel) {

        super(title, publisher, publicationAmount, periodicalType, periodicalGenre);
        this.coverModel = coverModel;
    }

    public String getCoverModel() {
        return coverModel;
    }


}
