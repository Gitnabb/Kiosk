/**
 * Act like the main class for the whole literature-universe
 * This class is supposed to form the back bones of the structure
 * to be used further into different types of sub-literature
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */

public abstract class Literature {

    //holds the name, front-page-phrasing etc, for the specific literature
    private String title;
    // holds the publisher of the literature itself ("forlag" in norwegian, sort of media house)
    private String publisher;

    public Literature(String title, String publisher) {
        setTitle(title);
        setPublisher(publisher);
    }

    /**
     * Returns the title of the Book
     * @return the title of the Book
     */
    protected String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the Literature ("forlag" in norwegian)
     * @return the publisher of the Literature ("forlag" in norwegian)
     */
    protected String getPublisher() {
        return this.publisher;
    }

    /**
     * A function tailored to give the user
     * info weather the input is valid or not
     * if the user fails to insert the correct/reasonable name
     * he will notice a INVALID VALUE, which might help him understand
     * @param title the title to be set of the book
     */
    protected void setTitle(String title) {
        if(title == null) {
            this.title = "INVALID VALUE";
        }
        else{
            if(title.length() == 0) {
                this.title = "INVALID VALUE";
            }
            else {
                this.title = title;
            }
        }
    }

    /**
     * A function tailored to give the user
     * info weather the input is valid or not
     * if the user fails to insert the correct/reasonable name
     * he will notice a INVALID VALUE, which might help him understand
     * @param publisher the publisher to be set of the book
     */
    protected void setPublisher(String publisher) {
        if(publisher == null) {
            this.publisher = "INVALID VALUE";
        }
        else{
            if(publisher.length() == 0) {
                this.publisher = "INVALID VALUE";
            }
            else {
                this.publisher = publisher;
            }
        }
    }

}
