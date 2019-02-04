/**
 *
 */


import java.util.ArrayList;
import java.util.Iterator;


public class Registry {

    private ArrayList<Book> bookList;

    public Registry() {

        this.bookList = new ArrayList<>();

    }

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
}
