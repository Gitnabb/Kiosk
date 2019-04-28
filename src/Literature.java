import javafx.beans.property.SimpleStringProperty;

/**
 * Act like the main class for the main-literature
 * This class is supposed to form the back bones of the structure
 * to be used further into different types of sub-literature
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 *
 */

public abstract class Literature {

    //holds the name, front-page-phrasing etc, for the specific literature
    private SimpleStringProperty title;

    // holds the publisher of the literature itself ("forlag" in norwegian, sort of media house)
    private SimpleStringProperty publisher;

    /**
     * Constructs a object with static type of Literature
     * with title and publisher
     * @param title The title of the literature
     * @param publisher The publisher of the literature
     */
    public Literature(String title, String publisher) {
        this.title = new SimpleStringProperty(title);
        this.publisher = new SimpleStringProperty(publisher);
    }

    /**
     * Returns the title of the Book
     * @return the title of the Book
     */
    public String getTitle() {
        return this.title.get();
    }

    /**
     * Returns the publisher of the Literature ("forlag" in norwegian)
     * @return the publisher of the Literature ("forlag" in norwegian)
     */
    public String getPublisher() {
        return this.publisher.get();
    }
}
