/**
 *
 * Registry class holds the book registry, and provide functionality of retrieving and adding books
 * to the book registry. Registry also provides a search function to search the book registry and retreive books based on
 * title and author.
 *
 */

// Import necessary libraries.
import java.util.ArrayList;
import java.util.Iterator;


public class Registry {

    // Declare ArrayList
    private ArrayList<Book> bookList;

    public Registry() {
        // Instanciate ArrayList.
        this.bookList = new ArrayList<>();

    }

    /**
     * Add book to the registry
     *
     * @param book
     */
    public void addBook(Book book) {

        bookList.add(book);
    }

    /**
     * Remove a book from the registry
     * @param book
     */
    public void removeBook(Book book) {

        bookList.remove(book);
    }

    /**
     * Show all books in the registry
     */
    public void showBooks() {

        for (int i = 0; i < bookList.size(); i++) {

            System.out.println(bookList.get(i).toString());
        }
    }

    /**
     * Search registry by title
     *
     * @param title
     */

    public Book findBookByTitle(String title) {
        title = title.toLowerCase().trim(); // Trim whitespaces in search term.
        Book foundBook = null;
        boolean found = false;
        Iterator<Book> it = this.bookList.iterator();

        while (it.hasNext() && !found) {

            Book book = it.next();
            if (book.getTitle().toLowerCase().equals(title.toLowerCase())) {
                foundBook = book;
                found = true;
            }
        }
        return foundBook;
    }

    /**
     * Search registry by author
     *
     * @param author
     */
    public Book findBookByAuthor(String author) {
        author = author.toLowerCase().trim();
        Book foundBook = null;
        boolean found = false;
        Iterator<Book> it = this.bookList.iterator();

        while (it.hasNext() && !found) {

            Book book = it.next();
            if (book.getAuthor().toLowerCase().equals(author.toLowerCase())) {
                foundBook = book;
                found = true;
            }
        }
        return foundBook;
    }

    /**
     * Find a book by the publish year
     */
    public Book findBookByPublished(int published) {
        Book foundBook = null;
        boolean found = false;
        Iterator<Book> it = this.bookList.iterator();

        while (it.hasNext() && !found) {

            Book book = it.next();
            if (book.getPublished() == published) {
                foundBook = book;
                found = true;
            }
        }
        return foundBook;

    }

    /**
     * Get iterator from registry
     * @return Iterator
     */
    public Iterator<Book> getIterator(){
        return this.bookList.iterator();
    }
}
