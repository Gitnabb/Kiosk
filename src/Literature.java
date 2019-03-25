/**
 * Act like the main class for the whole literature-universe
 * This class is supposed to form the back bones of the structure
 * to be used further into different types of sub-literature
 */

public class Literature {

    //holds the name, front-page-phrasing etc, for the specific literature
    private final String title;
    // holds the publisher of the literature itself ("forlag" in norwegian, sort of media house)
    private final String publisher;

    public Literature(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    /**
     * Returns the title of the book
     * @return the title of the book
     */
    protected String getTitle() {
        return this.title;
    }

    /**
     * Returns the publisher of the Literature (forlag in norwegian)
     * @return the publisher of the Literature (forlag in norwegian)
     */
    protected String getPublisher() {
        return this.publisher;
    }
}
