public class Book extends Literature {

    private String author; // Author of a book
    private int published; // The year the book was published
    private int edition; // Which edition it is

    public Book(String title, String publisher, String author, int published, int edition) {
        super(title, publisher);
        this.author = author;
        this.published = published;
        this.edition = edition;
    }

    /**
     * Returns the author of the literature when called.
     * @return the author of the literature
     */

    public String getAuthor() {
        return author;
    }

    /**
     * Sets author with input author
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Returns the publish year of the literature when called.
     * @return the publish year of the literature
     */

    public int getPublished() {
        return published;
    }

    /**
     * Sets the published year with input published
     * @param published
     */

    public void setPublished(int published) {
        this.published = published;
    }

    /**
     * Returns the edition of the literature when called.
     * @return the edition of the literature
     */

    public int getEdition() {
        return edition;
    }

    /**
     * Sets edition with input edition
     * @param edition
     */

    public void setEdition(int edition) {
        this.edition = edition;
    }

    /**
     * Consolidates get methods and returns formatted String.
     * @Override Skip existing toString method.
     * @return String
     */

}
