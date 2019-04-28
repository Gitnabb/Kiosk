/**
 *  Represents a Book
 *  This class is designed to represent a Book with
 *  following details about the books' attributes.
 *
 *  This class is extended by the parent class Literature
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 *
 */
public class Book extends Literature {

    private String author; // author of the Book
    private int published; // the year the Book was published
    private int editionNumber; // the edition of the Book

    /**
     * Initialize a Book object with a title, author,
     * publishing number and a edition number.
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

    /**
     * A function tailored to give the user
     * info weather the input is valid or not
     * if the user fails to insert the correct/reasonable name
     * he will notice a INVALID VALUE, which might help him understand
     * @param author the author to be set of the book
     */
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

    /**
     * A method to help validate the correct values
     * to be inserted into the book
     * @param published the year the book was published
     */
    private void setPublished(int published) {

        if(published > 0){
            this.published = published;
        }
        else{
            this.published = 0;
        }
    }

    /**
     * a method to set a valid editionNumber for the book
     * @param editionNumber the editionNumber of the book (1st, 2nd, ..)
     */
    private void setEditionNumber(int editionNumber) {

        if(editionNumber >= 0){
            this.editionNumber = editionNumber;
        }
        else{
            this.editionNumber = 0;
        }
    }
}





