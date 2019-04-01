public abstract class Literature {

    private String title; // Title of literature
    private String publisher; // Publisher of literature
    private String genre;
    private String price;
    private String date;

    public Literature(String title, String publisher, String genre, String price, String date) {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.price = price;
        this.date = date;
    }

    /**
     * Returns the title of the literature when called.
     * @return the title of the literature
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title with input title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }
}
