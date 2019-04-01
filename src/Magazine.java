public class Magazine extends Periodical {

    private String coverModel;

    public Magazine(String title, String publisher,
                    String genre, String price,
                    String date, int publicationAmountPerYear,
                    String periodicalType,
                    String coverModel) {
        super(title, publisher, genre, price, date, publicationAmountPerYear, periodicalType);
        this.coverModel = coverModel;
    }

    public String getCoverModel() {
        return coverModel;
    }

}
