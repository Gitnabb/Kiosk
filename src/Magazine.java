public class Magazine extends Periodical {

    private String coverModel;
    private String magazineType;

    public Magazine(String title, String publisher,
                    String genre, String price,
                    String date, int publicationAmountPerYear,
                    String periodicalType, String periodicalGenre,
                    String coverModel, String magazineType) {
        super(title, publisher, genre, price, date, publicationAmountPerYear, periodicalType, periodicalGenre);
        this.coverModel = coverModel;
        this.magazineType = magazineType;
    }

    public String getCoverModel() {
        return coverModel;
    }

    public String getMagazineType() {
        return magazineType;
    }
}
