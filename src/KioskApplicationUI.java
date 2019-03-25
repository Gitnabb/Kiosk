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
public class KioskApplicationUI {

    /**
     * Gives a brief view of the menu
     * the available options to the user
     */
    private String[] menuItems = {
            "1. List all literature",
            "2. Add a new literature",
            "3. Find a literature by name",
            "4. Remove a literature by name",
            //the last option ( 5 ) is automatically created when called upon.
    };

    private String[] literatureItems = {
            "1. Book",
            "2. Newspaper",
            "3. Magazine",
    };

    private Registry literatureReg;

    /**
     * Creates an instance of the KioskApplicationUI User interface.
     */
    public KioskApplicationUI() {
        this.literatureReg = new Registry();

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
                        this.listAllLiterature();
                        break;

                    case 2:
                        this.addNewLiterature();
                        break;

                    case 3:
                        this.findLiteratureByTitle();
                        break;

                    case 4:
                        this.removeLiteratureByTitle();
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
    private int showMenu(String[] yourItems) throws InputMismatchException {
        System.out.println("\n**** Kiosk application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : yourItems ) {
            System.out.println(menuItem);
        }
        int ma  xMenuItemNumber = yourItems.length + 1;
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
    private void listAllLiterature() {
        System.out.println("\nList of all Books in the register:");
        if(literatureReg.getNumberOfLiterature() == 0) {
            System.out.println("There are no books in the registry.");
        }
        else {
            Iterator<Literature> literatureIter = this.literatureReg.getIterator();
            while (literatureIter.hasNext()) {
                Literature literature = literatureIter.next();
                System.out.println(displayLiterature(literature));
            }
        }

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
    private void findLiteratureByTitle() {
        System.out.println("Search for a book by title");
        Scanner reader = new Scanner(System.in);

        String searchTitle = reader.nextLine();
        Literature newLiterature = this.literatureReg.searchForLiteratureTitle(searchTitle);

        if (newLiterature == null) {
            System.out.println("We didn't find the book called " + searchTitle);
        }
        else {
            // create a " displayBook " - method, use this here and in listALlBooks
            System.out.println("We found the following book for you: " + displayLiterature(newLiterature));
        }
    }

    /**
     * removes a book from the registry by the name of the book
     * reads the following input, and checks if it exist
     * if so, it will become clear that it get's removed from the registry
     */
    private void removeLiteratureByTitle() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type the name of the book you want to remove.");
        String searchTitle = reader.nextLine();
        //searches for an exact book by the name of the searchTitle
        Literature findLiterature = this.literatureReg.searchForLiteratureTitle(searchTitle);
        //if it doesnt exist, we make sure to tell the user
        if(findLiterature == null) {
            System.out.println("We didn't find a literature called " + searchTitle);
        }
        else {
            literatureReg.deleteLiterature(findLiterature);
            System.out.println("the book " + findLiterature.getTitle() + " was removed from the book registry.");
        }
    }

    /**
     * displays the all the vital information about the book given by the param
     * @param literature uses any book to return info given about it
     * @return returns the display info about the book
     */
    private String displayLiterature(Literature literature) {
        String display = "Title: " + literature.getTitle()
                + "  Author: " + literature.getAuthor()
                + "  Published: " + literature.getPublished()
                + "  Edition:  " + literature.getEditionNumber();
        return display;
    }
}
