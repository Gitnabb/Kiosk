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

    private KioskApplication application = null;

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


    private final static int LIST_ALL_LITERATURE = 1;
    private final static int ADD_LITERATURE_TO_REGISTER = 2;
    private final static int FIND_LITERATURE = 3;
    private final static int CONVERT_BOOK_TO_SERIES = 4;
    private final static int EXIT = 5;


    private final static int NEWSPAPER = 1;
    private final static int MAGAZINE = 2;
    private final static int BOOK = 3;
    private final static int BOOKSERIES = 4;

    /**
     * Creates an instance of the KioskApplicationUI User interface.
     */
    public KioskApplicationUI() {
        this.application = new KioskApplicationImpl();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() {

        this.application.init();

        boolean quit = false;

        while (!quit) {
            try {
                int menuSelection = this.showMenu(menuItems);
                switch (menuSelection) {

                    case LIST_ALL_LITERATURE:
                        this.application.doListAllLiterature();
                        break;

                    case ADD_LITERATURE_TO_REGISTER:
                        int secondMenuSelection = this.showMenu(literatureItems);
                        switch (secondMenuSelection) {
                            case NEWSPAPER:
                                this.application.doAddLiteratureToRegister();
                                break;
                            case MAGAZINE:
                                this.application.doAddLiteratureToRegister();
                                break;
                            case BOOK:
                                this.application.doAddLiteratureToRegister();
                                break;
                            case BOOKSERIES:
                                this.application.doAddLiteratureToRegister();
                                break;
                            case EXIT:
                                System.out.println("Exiting registration of literature");
                                break;
                        }
                        break;

                    case FIND_LITERATURE:
                        this.application.doFindLiterature();
                        break;

                    case CONVERT_BOOK_TO_SERIES:
                        this.application.doConvertBookToSeries();
                        break;

                    case EXIT:
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
    private int showMenu(String[] theMenuItems) throws InputMismatchException {
        System.out.println("\n**** Kiosk application v0.1 ****\n");
        // Display the menu
        for (String menuItem : theMenuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = theMenuItems.length + 1;
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
}
