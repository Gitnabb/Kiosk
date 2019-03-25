public class Literature {

    private String title; // Title of a book
    private String publisher; // Publisher of a book

    public Literature(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
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

    /**
     * Consolidates get methods and returns formatted String.
     * @Override Skip existing toString method.
     * @return String
     */

}
