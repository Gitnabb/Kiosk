import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ApplicationUI {
    // DECLARE SOFTWARE SPECIFIC CONSTANTS
    private final String SOFTWARE_NAME = "Kjetil and Andreas' Book Kiosk";
    private final String VERSION = "v1.0";

    // MAIN MENU CHOICES
    private final static int ADD_LITERATURE_TO_REGISTRY = 1;
    private final static int LIST_ALL_BY_PUBLISHER = 2;
    private final static int SEARCH_FOR_BOOK_BY_TITLE_AND_PUBLISHER = 3;
    private final static int SHOW_ALL_LITERATURE = 4;
    private final static int ADD_BOOK_TO_SERIES = 5;
    private final static int EXIT = 6;

    //
    private final static int ADD_BOOK_TO_REGISTRY = 1;
    private final static int ADD_NEWSPAPER_TO_REGISTRY = 2;
    private final static int ADD_MAGAZINE_TO_REGISTRY = 3;

    private Scanner in = new Scanner(System.in);
    private Registry registry = new Registry();
    private Printer printer = new Printer();

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

                    case ADD_LITERATURE_TO_REGISTRY:
                        // Launch addLiteratureMenu
                        addLiterature();
                        // addBookMenu();
                        break;

                    case LIST_ALL_BY_PUBLISHER:
                        // TODO: Create method to remove book from menu
                        doshowLiteratureByPublisher();
                        break;

                    case SEARCH_FOR_BOOK_BY_TITLE_AND_PUBLISHER:
                        doSearchByTitleAndPublisher();
                        break;
                    case SHOW_ALL_LITERATURE:
                        // Show whole registry
                        registry.showLiterature();
                        break;

                    case ADD_BOOK_TO_SERIES:
                        // Add a book to bookseries
                        doAddBookToSeries();
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

            "1: Add literature",
            "2: List all literature by a specific publisher",
            "3: Search for books",
            "4: Show all books",
            "5: Add book to series",
            "6: Exit program"
    };

    private final String[] addLitmenuItems = {

            "1: Book",
            "2: Newspaper",
            "3: Magazine"
    };

    public void addLiterature() {

        try {
            System.out.println("What would you like to add?");
            int menuSelection = this.showMenu(addLitmenuItems);
            switch (menuSelection) {

                case ADD_BOOK_TO_REGISTRY:
                    addBookMenu();
                    break;

                case ADD_NEWSPAPER_TO_REGISTRY:
                    addNewspaperMenu();
                    break;

                case ADD_MAGAZINE_TO_REGISTRY:
                    addMagazineMenu();
                    break;

            }
        } catch (InputMismatchException ime) {
            System.err.println("\nERROR: Please provide a number between 1 and " + (this.addLitmenuItems.length + 1) + "..\n");
        }


    }

    /**
     * Printer a welcome message to the user
     */
    public void welcomeMsg() {

        System.out.println("***** Welcome to " + SOFTWARE_NAME + " " + VERSION + "!" + " *****" + "\n");
    }

    /**
     * Search for a book by the title and author. Takes input from user, validates it and
     * sends that through to the search function in the registry.
     *
     */

    public void doSearchByTitleAndPublisher() {

        // SEARCH BY TITLE AND PUBLISHER
        System.out.println("Search for book by title and publisher!");
        System.out.println("Start with the title: ");
        in.nextLine();
        String searchTitle = in.nextLine();
        System.out.println("Then type in the publisher: ");
        String searchPublisher = in.nextLine();

        Literature bookByTitleAndPublisher =
                this.registry.findLiteratureByTitleAndPublisher(searchTitle, searchPublisher);

        if (bookByTitleAndPublisher != null) {
            System.out.println("Literature found in registry -> ");
            this.printer.printLiterature(bookByTitleAndPublisher);
        } else {
            System.out.println("Could not find literature");
        }

    }
    public void doshowLiteratureByPublisher(){

        System.out.println("Who's literature are you looking for? (Publisher): ");
        in.nextLine();
        String searchPublisher = in.nextLine();
        Iterator<Literature> iterator = registry.showLiteratureByPublisher(searchPublisher);

        if(iterator.hasNext()){
            while(iterator.hasNext()){

                Literature foundLiterature = iterator.next();
                printer.printLiterature(foundLiterature);

            }
        } else {
            System.out.println("No literature from that publisher! ");
        }
    }

    public void doAddBookToSeries() {

        System.out.println("Make a book a book series.");

        doShowAllBooks(); // SHOWS ALL LITERATURE ATM
        System.out.println("Which book would you like to make a series?");
        in.nextLine();
        String bookToAdd = in.nextLine();

        Literature literature = registry.findLiteratureByTitle(bookToAdd);
        if (literature instanceof Book) {
            Book book = (Book) literature;

            System.out.println("Your book is here: ");
            printer.printLiterature(literature);

            System.out.println("What is the name of the book series?");
            String bookSeriesTitle = in.nextLine();

            System.out.println("Who's the publisher?");
            String bookSeriesPublisher = in.nextLine();

            System.out.println("What genre is it?");
            String bookSeriesGenre = in.nextLine();

            System.out.println("What is the price?");
            String bookSeriesPrice = in.nextLine();

            System.out.println("What is the exact date of the book release?");
            String bookSeriesDate = in.nextLine();

            System.out.println("Are there multiple authors? If there's just one, type that author again.");
            String bookSeriesAuthors = in.nextLine();

            BookSeries bookSeries = new BookSeries(bookSeriesTitle, bookSeriesPublisher,
                    bookSeriesGenre, bookSeriesPrice,
                    bookSeriesDate, bookSeriesAuthors);

            bookSeries.addBookToBookSeries(book);


        } else {
            System.out.println("Could not find book");
        }

    }

    /**
     * Remove a book from the registry
     */

   /* public void doRemoveBookByTitle() {

        // TODO: FIGURE OUT WHY I CAN'T USE MAIN SCANNER..
        Scanner removeInput = new Scanner(System.in);
        System.out.println("Please enter the title of the book you want removed: ");
        String searchString = removeInput.nextLine();
        Literature litToBeFound = this.registry.findLiteratureByTitle(searchString);

        if (litToBeFound == null) {

            System.out.println("Could not find book " + searchString);

        } else {
            System.out.println("Are you sure you want to remove " + litToBeFound.getTitle() + " - Y/N ?");
            String answer = removeInput.nextLine();
            if (answer.equals("Y") || answer.equals("y")) {
                registry.removeLiterature(litToBeFound);
                System.out.println(litToBeFound.getTitle() + " has been removed from the registry! ");
            } else if (answer.equals("N") || answer.equals("n")) {
                System.out.println("Literature was not removed");
            } else {
                System.out.println("Could not understand you, aborting literature removal.");
            } // PACK THIS IN A WHILE TO HANDLE WRONG INPUT..MAYBE INTRODUCE A BACK / ABORT COMMAND?
        }

    }
*/
    /**
     * Search for literature (sort) by  published year.
     */
    public void doSearchByPublishedYear() {
        boolean searchDone = false;
        int year;
        while (!searchDone) {

            try {
                System.out.println("Search for a book by published year");
                year = Integer.parseInt(in.nextLine());
                Literature bookByYear = registry.findLiteratureByPublished(year);

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
        if (registry.bookListSize() > 0) {
            System.out.println("Current books in registry: ");

            Iterator<Literature> litIterator = this.registry.getIterator();
            while (litIterator.hasNext()){
                Literature literature = litIterator.next();
                if(literature instanceof Book){
                    Book book = (Book) literature;
                    printer.printLiterature(book);
                    System.out.println(" ");
                }
            }

        } else {
            System.out.println("There is no literature in the registry!");
        }

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
                    System.out.println("Book exists! Try another title");
                }
            } else {
                System.out.println("Are you sure? Try again..");
                bookTitle = in.nextLine();
            }
        }

        System.out.println("Who's the author of the book?");
        String bookAuthor = in.nextLine();

        System.out.println("Who's the publisher?");
        String bookPublisher = in.nextLine();

        System.out.println("What is the genre?");
        String bookGenre = in.nextLine();

        System.out.println("What is the price?");
        String bookPrice = in.nextLine();

        System.out.println("What is the date of the book?");
        String bookDate = in.nextLine();

       // ASK ALL THE DETAILS !!!!!!!!!!!!!!!!!!!

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
        Literature literature = new Book(bookTitle, bookPublisher, bookGenre, bookPrice, bookDate, bookAuthor, bookYearPublished, bookEdition);
        registry.addLiterature(literature);
        System.out.println(literature.getTitle() + " has been added!");
    }

    public void addNewspaperMenu() {

        System.out.println("To add a newspaper, start with the title: ");
        String newsPaperTitle = in.nextLine();
        in.nextLine();

        System.out.println("Who is the publisher?");
        String newsPaperPublisher = in.nextLine();

        System.out.println("What is the price?");
        String newsPaperPrice = in.nextLine();

        System.out.println("What is the date of the Newspaper? Today probably");
        String newsPaperDate = in.nextLine();

        System.out.println("How many times does it get published a year?");
        int newspaperPublicationAmount = in.nextInt();

        String periodicalType = "Newspaper";

        String periodicalGenre = "News";

      // CONSTRUCT NEWSPAPER, ADD IT TO REGISTRY, PRINT CONFIRMATION
        Literature newspaper  = new Newspaper(newsPaperTitle, newsPaperPublisher,
                periodicalGenre, newsPaperPrice,
                newsPaperDate, newspaperPublicationAmount,
                periodicalType);
        registry.addLiterature(newspaper);
        System.out.println(newspaper.getTitle() + " has been added!");

    }

    public void addMagazineMenu() {

        System.out.println("To add a Magazine, start with entering the magazine name: ");
        in.nextLine();
        String magazineTitle = in.nextLine();

        System.out.println("Who's the publisher of the magazine? ");
        String magazinePublisher = in.nextLine();

        System.out.println("What kind of magazine is it? (Gossip, sport, hunting?");
        String magazineGenre = in.nextLine();

        System.out.println("What is the price of the magazine?");
        String magazinePrice = in.nextLine();

        System.out.println("When did it get released? (The date of the magazine)");
        String magazineDate = in.nextLine();

        System.out.println("How many times does it get released per year?");
        int magazinePublicationAmount = in.nextInt();

        String periodicalType = "magazine";

        System.out.println("Whos the cover model?");
        in.nextLine();
        String magazineCoverModel = in.nextLine();

        // CONSTRUCT MAGAZINE, ADD IT TO REGISTRY, PRINT CONFIRMATION
        Literature magazine = new Magazine(magazineTitle, magazinePublisher,
                magazineGenre, magazinePrice,
                magazineDate, magazinePublicationAmount,
                periodicalType, magazineCoverModel);
        registry.addLiterature(magazine);
        this.printer.printLiterature(magazine);
    }

}
