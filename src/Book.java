
/*
*
* Class Book represents a book. Holds information about the books in the Kiosk.
*
*
*/

public class Book {

    // Necessary fields defined
    private String title; // Title of a book
    private String author; // Author of a book
    private int published; // The year the book was published
    private int edition; // Which edition it is

    /**
     *
     * Creates a book, initialized with the title, author, published and the edition
     *
     * @param title     Title of the book
     * @param author    Author of the book
     * @param published Year published
     * @param edition   Edition number
     */

    public Book(String title, String author, int published, int edition){
        this.title = title;
        this.author = author;
        this.published = published;
        this.edition = edition;
    }

    public Book (){

    }

    /**
     * Returns the title of the book when called.
     * @return the title of the book
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

    /**
     * Returns the author of the book when called.
     * @return the author of the book
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
     * Returns the publish year of the book when called.
     * @return the publish year of the book
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
     * Returns the edition of the book when called.
     * @return the edition of the book
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

    private String displayBook(Book book){

      return "Title: " + book.getTitle()
              + ", Author: " + book.getAuthor()
              + ", Published: " + book.getPublished()
              + ", Edition: " + book.getEdition();
    }
}