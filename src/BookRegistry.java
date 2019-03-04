import java.util.ArrayList;
import java.util.Iterator;

/**
 * Represents a database for registering the different Books
 * This class is designed to in the future, hold different types of literature
 *
 * @author <Andreas Øie>
 * @version 1.0
 *
 */

public class BookRegistry {

    //defining fields
    private ArrayList<Book> bookList; // name of the Book-list

    /**
     * Constructs the list available to store the different books
     */
    public BookRegistry() {

        this.bookList = new ArrayList<>();
    }

    /**
     * Registers a book
     * @param bookToAdd Registers a book
     */
    public void registerBook(Book bookToAdd) {
        if (bookToAdd != null) {
            this.bookList.add(bookToAdd);
        }
    }
    public void deleteBook(Book bookToRemove) {
        if (bookToRemove != null) {
            this.bookList.remove(bookToRemove);
        }
    }

    /**
     * sums up all the different books in the book-list
     */
    public void listAllBooks() {
        for (Book books : bookList) {
            System.out.println(books);
        }
    }

    public Iterator<Book> getIterator() {
        return this.bookList.iterator();
    }

    /**
     * Searches for a book by its title, then returns the object its inside
     * @param title Searches for a book by its title.
     * @return returns the correct object with the following title inside it.
     */
    public Book searchForBookTitle(String title) {

        Book book = null;
        boolean found = false;

        Iterator<Book> it = this.bookList.iterator();
        //This while loop will run as long as there are objects left to visit
        //in the collection (ArrayList) AND we have still not found the person
        //we are looking for.
        while (it.hasNext() && !found){

            Book bookNext = it.next();

            if (bookNext.getTitle().equals(title))
            {
                book = bookNext;
                found = true;
            }
        }
        return book;
    }

    /**
     * List the number of books added.
     * @return the number of books
     */
    public int getNumberOfBooks() {
        return this.bookList.size();
    }

    public void displayBook() {

    }

}
