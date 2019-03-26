/**
 * Registry class holds the book registry, and provide functionality of retrieving and adding books
 * to the book registry. Registry also provides a search function to search the book registry and retreive books based on
 * title and author.
 */

// Import necessary libraries.

import java.util.ArrayList;
import java.util.Iterator;


public class Registry {

    // DECLARE LIST
    private ArrayList<Literature> kioskRegistry;

    // DECLARE MANUAL TEST BOOK OBJECTS
    private Literature testBook;
    private Literature testBook2;

    public Registry() {
        // INSTANTIATE LIST
        this.kioskRegistry = new ArrayList<>();

        // CONSTRUCT MANUAL TEST BOOK OBJECTS
        testBook = new Book("Peer Gynt", "Gyldendal", "H.Ibsen", 1900, 1);
        testBook2 = new Book("How to train arms", "Kjetils Forlag", "M. Kvendseth", 2019, 1);

        fillRegistry();

    }

    /**
     * Fill kiosk with manually added test books.
     */
    public void fillRegistry() {

        addLiterature(testBook);
        addLiterature(testBook2);

    }

    /**
     * Add book to the registry
     *
     * @param literature
     */
    public boolean addLiterature(Literature literature) {

        boolean added = false;

        if(literature != null){
            kioskRegistry.add(literature);
            added = true;
        }
        return added;
    }

    /**
     * Remove a book from the registry. If there are no books
     *
     * @param literature
     */
    public void removeLiterature(Literature literature) {

        if (literature != null) {

            kioskRegistry.remove(literature);

        }

    }

    /**
     * Show all books in the registry
     */
    public void showLiterature() {

        for (int i = 0; i < kioskRegistry.size(); i++) {

            System.out.println("- " + kioskRegistry.get(i).getTitle());
        }
    }

    /**
     * Search registry by title
     *
     * @param title
     */

    public Literature findLiteratureByTitle(String title) {
        title = title.toLowerCase().trim(); // Trim whitespaces in search term.
        Literature foundLiterature = null;
        Iterator<Literature> it = this.kioskRegistry.iterator();

        while (it.hasNext() && foundLiterature == null) {

            Literature literature = it.next();
            if (literature.getTitle().toLowerCase().equals(title)) {
                foundLiterature = literature;
            }
        }
        return foundLiterature;
    }

    /**
     * Search registry by author
     *
     * @param author
     */
    public Iterator<Literature> findBookByAuthor(String author) {
        author = author.toLowerCase().trim();
        ArrayList<Literature> foundLiteratures = new ArrayList<>();
        Iterator<Literature> it = this.kioskRegistry.iterator();

        while (it.hasNext()) {

            Literature literature = it.next();
            if(literature instanceof Book){
                Book book = (Book) literature;
                if (book.getAuthor().toLowerCase().equals(author)) {
                    foundLiteratures.add(literature);
                }
            }
        }
        return foundLiteratures.iterator();
    }

    /**
     * Find a book by the publish year
     */
    public Literature findLiteratureByPublished(int published) {
        Literature foundLiterature = null;
        Iterator<Literature> it = this.kioskRegistry.iterator();

        while (it.hasNext() && foundLiterature == null) {

            Literature literature = it.next();
            if(literature instanceof Book){
                Book book = (Book) literature;
                if (book.getPublished() == published) {
                    foundLiterature = literature;
                }
            }
        }
        return foundLiterature;
    }

    /**
     * Get iterator from registry
     *
     * @return Iterator
     */
    public Iterator<Literature> getIterator() {
        return this.kioskRegistry.iterator();
    }

    public Boolean titleExist(String title) {

        Boolean exist = false;

        if (findLiteratureByTitle(title) != null) {

            exist = true;
        } else {
            exist = false;
        }
        return exist;
    }

    public int bookListSize(){

        return kioskRegistry.size();

    }

}
