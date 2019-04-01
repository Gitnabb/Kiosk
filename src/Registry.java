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

    private Literature testNewsPaper;

    private Literature testMagazine;

    public Registry() {
        // INSTANTIATE LIST
        this.kioskRegistry = new ArrayList<>();

        // CONSTRUCT MANUAL TEST BOOK OBJECTS
        testBook = new Book("Peer Gynt", "Gyldendal", "Cute literature", "40kr","05.01.1867", "H.Ibsen", 1867, 1);
        testNewsPaper = new Newspaper("VG", "Schibsted", "Journalism", "20kr", "01.04.19", 312, "Newspaper");
        testMagazine = new Magazine("Vi Menn", "Egmont Publishing AS", "Journalism", "30kr", "01.04.19", 24, "Magazine", "Tina(18)");

        fillRegistry();

    }

    /**
     * Fill kiosk with manually added test books.
     */
    public void fillRegistry() {

        addLiterature(testBook);
        addLiterature(testNewsPaper);
        addLiterature(testMagazine);

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

    public Literature findLiteratureByTitleAndPublisher(String title, String publisher) {

        Literature foundLiterature = null;
        Iterator<Literature> it = this.kioskRegistry.iterator();

        while (it.hasNext() && foundLiterature == null) {

            Literature literature = it.next();
            if (literature.getTitle().equals(title) && literature.getPublisher().equals(publisher)) {
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


    public int bookListSize(){

        return kioskRegistry.size();

    }

    public Boolean titleExist(String title){
        boolean exist;

        Iterator<Literature> it = getIterator();
        if (it.next().equals(title)){
            exist = true;
        } else{
            exist = false;
        }

        return exist;
    }

}
