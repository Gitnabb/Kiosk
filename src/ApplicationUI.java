import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationUI  {

    Scanner in = new Scanner(System.in);
    Registry registry = new Registry();

    public ApplicationUI(){

    }

    public void start() {

        boolean quit = false;
        while (!quit){
            try {
                int menuSelection = this.showMenu(menuItems);
                switch (menuSelection){

                    case 1:
                        // Add book
                        break;

                    case 2:
                        //doRemoveBook(); // start "remove menu", no parametres..
                        break;

                    case 3:
                        // doSearch - start "search menu"
                        break;
                    case 4:
                        // Show whole registry
                        doShowAllBooks();
                        break;

                        default:
                            if(wantsToQuit()){
                                quit = true;
                        }
                }
            } catch (InputMismatchException ime){
                System.err.println("\nERROR: Please provide a number between 1 and " + (this.menuItems.length + 1) + "..\n");
            }
        }
    }

    private int showMenu(String menu[]){

        int menuChosen;
        // Use for each to print out menu items
        // Press a number, and go to right menu.
        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menu.length + 1;
        menuChosen = in.nextInt();
        // check range
        return menuChosen;

    }

    private final String[] menuItems = {

            "1: Add book",
            "2: Remove a book",
            "3: Search for books",
            "4: Show all books"

    };

    private boolean wantsToQuit(){

        // Ask user if he wants to quit
        // Ask until user writes either Y or N - or equivalent
        return false;
    }

    public void welcomeMsg(){

        System.out.println("Welcome to the Kiosk. ");
    }


    public void doSearchByTitle(){

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
    }

    public void doSearchByAuthor(){

        System.out.println("Search for book by author: ");
        String author = in.nextLine();
        Book bookByAuthor = registry.findBookByAuthor(author);

        if(bookByAuthor != null ){

            System.out.println("Author found in registry -> " + bookByAuthor.toString());

        }
        else{
            System.out.println("Could not find book");
        }

    }

    public void doSearchByPublishedYear(){
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

                System.out.println("Wrong search term, try again (Enter a year, four digits)");

            }
        }
    }

    public void doShowAllBooks(){

        System.out.println("Current books in registry");
        registry.showBooks();
        System.out.println(" ");

    }

    public void doRemoveBook(Book book){
        registry.removeBook(book);
    }
}
