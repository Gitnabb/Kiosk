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

    //Declare ArrayList
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

    public void showBooks() {

        for (int i = 0; i < bookList.size(); i++) {

            System.out.println(bookList.get(i).toString());
        }

    }

    public void removeBook(Book book) {

        bookList.remove(book);

    }

    /**
     * Search registry by title
     *
     * @param title
     */

    public Book findBookByTitle(String title) {
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
     *
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

    public Iterator<Book> getIterator(){
        return this.bookList.iterator();
    }
}
