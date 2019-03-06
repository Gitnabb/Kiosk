import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationUI {
    // DECLARE SOFTWARE SPECIFIC CONSTANTS
    private final String SOFTWARE_NAME = "Kjetil and Andreas' Book Kiosk";
    private final String VERSION = "v1.0";

    // DECLARE MAIN MENU CHOICES
    private final static int ADD_BOOK_TO_REGISTRY = 1;
    private final static int REMOVE_BOOK_FROM_REGISTRY = 2;
    private final static int SEARCH_FOR_BOOK = 3;
    private final static int SHOW_ALL_BOOKS = 4;
    private final static int EXIT = 5;

    private Scanner in = new Scanner(System.in);
    private Registry registry = new Registry();

    public ApplicationUI() {

    }

    /**
     * Start the application, show menu options. If the user chooses to quit, the application stops
     * and prints a "good bye" - message.
     */
    public void start() {

        boolean quit = false;
        while (!quit) {
            try {
                int menuSelection = this.showMenu(menuItems);
                switch (menuSelection) {

                    case ADD_BOOK_TO_REGISTRY:
                        // Launch Add book menu
                        addBookMenu();
                        break;

                    case REMOVE_BOOK_FROM_REGISTRY:
                        // TODO: Create method to remove book from menu
                        doRemoveBookByTitle();
                        break;

                    case SEARCH_FOR_BOOK:
                        doSearchByTitle();
                        break;
                    case SHOW_ALL_BOOKS:
                        // Show whole registry
                        doShowAllBooks();
                        break;

                    case EXIT:
                        System.out.println("Closing program..\nThank you for using the " + SOFTWARE_NAME + " " + VERSION + " !");
                        quit = true;

                }
            } catch (InputMismatchException ime) {
                System.err.println("\nERROR: Please provide a number between 1 and " + (this.menuItems.length + 1) + "..\n");
            }
        }
    }

    /**
     * Prints out the array of available menu options stored in menuItems.
     *
     * @param menu
     * @return
     */
    private int showMenu(String menu[]) {

        int menuChosen;
        // Use for each to print out menu items
        // Press a number, and go to right menu.
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menu.length + 1;
        menuChosen = in.nextInt();

        // TODO: VALIDATE INPUT..
        return menuChosen;

    }

    /**
     * Names of the available menu choices
     */
    private final String[] menuItems = {

            "1: Add book",
            "2: Remove a book",
            "3: Search for books",
            "4: Show all books",
            "5: Exit program"
    };

    /**
     * Print a welcome message to the user
     */
    public void welcomeMsg() {

        System.out.println("***** Welcome to " + SOFTWARE_NAME + " " + VERSION + "!" + " *****" + "\n");
    }


    /**
     * Search for a book by it's title. Takes input from user, validates it and
     * sends that through to the search function in the registry.
     */
    public void doSearchByTitle() {

        // SEARCH BY TITLE
        // TODO create new class to handle io. This is just testing.
        System.out.println("Search for book by title: ");
        String title = in.nextLine();
        Book bookByTitle = registry.findBookByTitle(title);


        if (bookByTitle != null) {
            System.out.println("Book found in registry -> " + bookByTitle.toString());
        } else {
            System.out.println("Could not find book");
        }
    }

    /**
     * Search for a book by the author. Takes input from user, validates it and
     * sends that through to the search function in the registry.
     * TODO: Maybe use this later.
     */
    public void doSearchByAuthor() {

        System.out.println("Search for book by author: ");
        String author = in.nextLine();
        Book bookByAuthor = registry.findBookByAuthor(author);

        if (bookByAuthor != null) {

            System.out.println("Author found in registry -> " + bookByAuthor.toString());

        } else {
            System.out.println("Could not find book");
        }

    }

    /**
     * Remove a book from the registry
     */

    public void doRemoveBookByTitle() {

        // TODO: FIGURE OUT WHY I CAN'T USE MAIN SCANNER..
        Scanner removeInput = new Scanner(System.in);
        System.out.println("Please enter the title of the book you want removed: ");
        String searchString = removeInput.nextLine();
        Book bookToBeFound = this.registry.findBookByTitle(searchString);

        if (bookToBeFound == null) {

            System.out.println("Could not find book " + searchString);

        } else {
            System.out.println("Are you sure you want to remove " + bookToBeFound.getTitle() + " - Y/N ?");
            String answer = removeInput.nextLine();
            if (answer.equals("Y")) {
                registry.removeBook(bookToBeFound);
                System.out.println(bookToBeFound.getTitle() + " has been removed from the registry! ");
            } else if (answer.equals("N")) {
                System.out.println("Book was not removed");
            } else {
                System.out.println("Could not understand you, aborting book removal.");
            }
        }

    }

    /**
     * Search for books (sort) by  published year.
     */
    public void doSearchByPublishedYear() {
        boolean searchDone = false;
        int year;
        while (!searchDone) {

            try {
                System.out.println("Search for a book by published year");
                year = Integer.parseInt(in.nextLine());
                Book bookByYear = registry.findBookByPublished(year);

                if (bookByYear != null) {

                    System.out.println("Book found in registry -> " + bookByYear.toString());
                    searchDone = true;
                } else {
                    System.out.println("Could not find book");
                }
            } catch (NumberFormatException exception) {

                System.out.println("Wrong search term, try again (Enter a year, four digits)");

            }
        }
    }

    /**
     * Show all the books in the registry.
     */

    public void doShowAllBooks() {

        System.out.println("Current books in registry");
        registry.showBooks();
        System.out.println(" ");

    }

    /**
     * Add a book to the registry.
     * Takes input from user and validates them.
     * Adds book with a title, an author, the year it was published and which edition it is.
     * Once done the book is added to the registry.
     */

    public void addBookMenu() {
        // TODO: USE VALIDATE METHOD INSTEAD ?
        System.out.println("To add a book, start with entering a title: ");
        in.nextLine();
        String bookTitle = in.nextLine();
        boolean titleAdded = false;
        while (!titleAdded) {
            if (bookTitle.length() > 0) {
                if (!(registry.titleExist(bookTitle))) {
                    System.out.println("Title added");
                    titleAdded = true;
                } else {
                    System.out.println("Book exists, try another title");
                }
            } else {
                System.out.println("Are you sure? Try again..");
            }
            // bookTitle = in.nextLine();
        }

        System.out.println("Who wrote the book? ");
        String bookAuthor = in.nextLine();

        // ADDING YEAR PUBLISHED + CHECK IF YEAR IS VALID
        int bookYearPublished;
        do {
            System.out.println("When did it get published? (Year)");
            while (!in.hasNextInt()) {
                System.out.println("Thats not a year, try again");
                in.next(); // Redo input
            }
            bookYearPublished = in.nextInt();
        } while (!(bookYearPublished >= 0)); // While value is bigger than 0, exit while loop.
        System.out.println(bookYearPublished + " has been added as publish year.");

        // ADDING EDITION
        int bookEdition;
        do {
            System.out.println("Which edition of the book is it?");
            while (!in.hasNextInt()) {
                System.out.println("Thats not a valid edition, try again");
                in.next(); // Redo input
            }
            bookEdition = in.nextInt();
        } while (!(bookEdition >= 0)); // While value is bigger than 0, exit while loop.
        System.out.println(bookEdition + " has been added as publish year.");

        // CONSTRUCT BOOK, ADD BOOK TO REGISTRY, PRINT CONFIRMATION
        Book book = new Book(bookTitle, bookAuthor, bookYearPublished, bookEdition);
        registry.addBook(book);
        System.out.println(book.getTitle() + " has been added!");
    }
}
