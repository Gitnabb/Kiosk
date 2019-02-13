// Import necessary libraries
import java.util.Scanner;

public class Main {

    public static void main(String args[]){

        Registry registry = new Registry();
        Scanner in = new Scanner(System.in);
        Book testBook = new Book("Peer Gynt", "H.Ibsen", 1990, 5);
        Book testBook2 = new Book("How to train arms", "M. Kvendseth", 2035, 7);
        Book testBookToBeRemoved = new Book("Gtfo", "Fgt ass", 2019, 1);
        registry.addBook(testBook);
        registry.addBook(testBook2);
        registry.addBook(testBookToBeRemoved);

        // REMOVE A BOOK FROM REGISTRY
        registry.removeBook(testBookToBeRemoved);

        // SHOW ALL BOOKS IN REGISTRY
        System.out.println("Current books in registry");
        registry.showBooks();
        System.out.println(" ");

        // SEARCH BY TITLE
        // TODO create new class to handle io. This is just testing.
        System.out.println("Search for book by title: ");
        String title = in.nextLine();
        Book bookByTitle = registry.findBookByTitle(title);


        if(bookByTitle != null ){

            System.out.println("Book found in registry -> " + bookByTitle.toString());

        }
        else{
            System.out.println("Could not find book");
        }

        // SEARCH BY AUTHOR
        System.out.println("Search for book by author: ");
        String author = in.nextLine();
        Book bookByAuthor = registry.findBookByAuthor(author);

        if(bookByAuthor != null ){

            System.out.println("Author found in registry -> " + bookByAuthor.toString());

        }
        else{
            System.out.println("Could not find book");
        }

        // SEARCH BY PUBLISHED YEAR
        boolean searchDone = false;
        int year;
        while(!searchDone){

            try {
                System.out.println("Search for a book by published year");
                year = Integer.parseInt(in.nextLine());
                Book bookByYear = registry.findBookByPublished(year);

                if(bookByYear != null){

                    System.out.println("Book found in registry -> " + bookByYear.toString());
                    searchDone = true;
                }
                else{
                    System.out.println("Could not find book");
                }
            }
            catch (NumberFormatException exception){

                System.out.println("Wrong search term");

            }
        }
    }
}
