import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 *
 * @author <Andreas Øie>
 * @version 1.0
 */
public class ApplicationUI {


    /**
     * Gives a brief view of the menu
     * the available options to the user
     */
    private String[] menuItems = {
            "1. List all books",
            "2. Add a new book",
            "3. Find a book by name",
            "4. Remove a book by name",
            //the last option ( 5 ) is automatically created when called upon.
    };

    private BookRegistry bookReg;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
        this.bookReg = new BookRegistry();

    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() {
        this.init();

        boolean quit = false;

        while (!quit) {
            try {
                int menuSelection = this.showMenu();
                switch (menuSelection) {
                    case 1:
                        this.listAllBooks();
                        break;

                    case 2:
                        this.addNewBook();
                        break;

                    case 3:
                        this.findBookByTitle();
                        break;

                    case 4:
                        this.removeBookByTitle();
                        break;

                    case 5:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException {
        System.out.println("\n**** Kiosk application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menuItems ) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made private, since they are only used by the menu ---

    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init() {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllBooks() {
        if(bookReg.getNumberOfBooks() < 1) {
            System.out.println("There are no books in the registry.");
        }
        Iterator<Book> bookIter = this.bookReg.getIterator();
        while(bookIter.hasNext()) {
            Book book = bookIter.next();
            System.out.println(displayBook(book));
        }

    }


    /**
     * Add a new product/literature to the register.
     * In this method you have to add code to ask the
     * user for the necessary information you need to
     * create an instance of the product, which you
     * then send as a parameter to the addNewspaper()-
     * method of the register.
     * Remember to also handle invalid input from the
     * user!!
     */
    private void addNewBook() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter the title of the book");
        String title = reader.nextLine();

        System.out.println("Please enter the author of the book");
        String author = reader.nextLine();

        System.out.println("Please enter the year the Book was published");
        int published = reader.nextInt();

        System.out.println("Please enter the edition number of the book");
        int editionNumber = reader.nextInt();

        Book book = new Book(title, author, published, editionNumber);
        this.bookReg.registerBook(book);

        System.out.println("the book " + book.getTitle() + " was successfully added to the registry.");

        //Create a book was created confirmation-print
        //With all the stats
    }

    /**
     * Find and display a book based om name (title).
     * As with the addNewBook()-method, you have to
     * ask the user for the string (/title/)
     * to search for, and then use this string as input-
     * parameter to the method in the register-object.
     * Then, upon return from the register, you need
     * to print the details of the found item.
     */
    private void findBookByTitle() {
        System.out.println("Search for a book by title");
        Scanner reader = new Scanner(System.in);

        String searchTitle = reader.nextLine();
        Book newBook = this.bookReg.searchForBookTitle(searchTitle);

        if (newBook == null) {
            System.out.println("We didn't find the book called " + searchTitle);
        }
        else {
            // create a " displayBook " - method, use this here and in listALlBooks
            System.out.println("We found the following book for you: " + displayBook(newBook));
        }
    }

    /**
     * removes a book from the registry by the name of the book
     * reads the following input, and checks if it exist
     * if so, it will become clear that it get's removed from the registry
     */
    private void removeBookByTitle() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type the name of the book you want to remove.");
        String searchTitle = reader.nextLine();
        //searches for an exact book by the name of the searchTitle
        Book findBook = this.bookReg.searchForBookTitle(searchTitle);
        //if it doesnt exist, we make sure to tell the user
        if(findBook == null) {
            System.out.println("We didn't find a book called " + searchTitle);
        }
        else {
            bookReg.deleteBook(findBook);
            System.out.println("the book " + findBook.getTitle() + " was removed from the book registry.");
        }

    }

    /**
     * displays the all the vital information about the book given by the param
     * @param book uses any book to return info given about it
     * @return returns the display info about the book
     */
    private String displayBook(Book book) {
        String display = "Title: " + book.getTitle()
                + "  Author: " + book.getAuthor()
                + "  Published: " + book.getPublished()
                + "  Edition:  " + book.getEditionNumber();
        return display;
    }
}
