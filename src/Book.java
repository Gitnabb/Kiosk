/**
 *  Represents a Book
 *  This class is designed to represent a Book with
 *  following details about the books' attributes.
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */


public class Book {

    private final String title; // title of the Book
    private final String author; // author of the Book
    private final int published; // the year the Book was published
    private final int editionNumber; // the edition of the Book

    /**
     * initialize the different fields with given parameters
     * @param title title of the Book
     * @param author author of the Book
     * @param published the year the Book was published
     * @param editionNumber the edition of the Book
     */
    public Book(String title, String author, int published, int editionNumber) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.editionNumber = editionNumber;
    }

    /**
     * Returns the title of the book
     * @return the title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the author of the book
     * @return the author of the book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the year the book was published
     * @return the year it was published
     */
    public int getPublished() {
        return this.published;
    }

    /**
     * Returns the edition of the Book
     * @return the edition of the Book
     */
    public int getEditionNumber() {
        return this.editionNumber;
    }

}





