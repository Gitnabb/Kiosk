/**
 *  Represents a Book
 *  This class is designed to represent a Book with
 *  following details about the books' attributes.
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */


public class Book extends Literature{

    private String author; // author of the Book
    private int published; // the year the Book was published
    private int editionNumber; // the edition of the Book

    /**
     * initialize the different fields with given parameters
     * @param title title of the Book
     * @param author author of the Book
     * @param published the year the Book was published
     * @param editionNumber the edition of the Book
     */
    public Book(String title, String publisher, String author, int published, int editionNumber) {
        super(title, publisher);
        setAuthor(author);
        setPublished(published);
        setEditionNumber(editionNumber);
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

    private void setTitle(String title) {
        if(title == null){
            this.title = "INVALID VALUE";
        }
        else{
            if(title.length() == 0){
                this.title = "INVALID VALUE";
            }
            else {
                this.title = title;
            }
        }
    }

    private void setAuthor(String author) {
        if(author ==  null){
            this.author = "INVALID VALUE";
        }
        else{
            if(author.length() == 0){
                this.author = "INVALID VALUE";
            }
            else {
                this.author = author;
            }
        }
    }

    private void setPublished(int published) {
        if(published > 0){
            this.published = published;
        }
        else{
            this.published = 0;
        }

    }
    private void setEditionNumber(int editionNumber) {
        if(editionNumber >= 0){
            this.editionNumber = editionNumber;
        }
        else{
            this.editionNumber = 0;
        }
    }
}





