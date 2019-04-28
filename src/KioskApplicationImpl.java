import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents the KioskApplication. The class is a delegate for the main
 * application and the menu-system. Any functions triggered by a menu selection
 * leads to a call to one of the methods in this class (via the
 * KioskApplication interface).
 *
 * @author <Andreas Øie>
 * @version 1.01
 *
 * -------------------------------------------------------------
 * This class is altered, and many functions is unused due to the
 * integration of an GUI. However, as the GUI-application is
 * developing, more and more functions will be used, therefore
 * they're still not removed from the class.
 * -------------------------------------------------------------
 */
public class KioskApplicationImpl {

    private Registry literatureRegister;

    /**
     * initializing the literature registry, and
     * fill registry with some example properties.
     */
    public void init() {
        this.literatureRegister = new Registry();
        this.fillRegistersWithDataForTesting();
    }

    /**
     * Add a new literature to the register.
     * In this method you have to add code to ask the
     * user for the necessary information you need to
     * create an instance of the product, which you
     * then send as a parameter to the addLiterature()-
     * method of the register.
     * Remember to also handle invalid input from the
     * user!!
     */
    public void doAddLiteratureToRegister(int choice) {

        // TODO: complete doAddBookToRegistry, doAddMagazineToRegistry, doAddBookSeriesToRegistry

        if (choice == 1) {
            doAddNewspaperToRegistry();
        } else if (choice == 2) {
            doAddMagazineToRegistry();
        } else if (choice == 3) {
            doAddBookToRegistry();
        } else if (choice == 4) {
            doAddBookSeriesToRegistry();
        }
    }

    /**
     * List every existing literature in the registry.
     * In this method the info you'll receive info about
     * every registered literature in the registry.
     */
    public void doListAllLiterature() {

        if (0 == this.literatureRegister.getNumberOfLiterature()) {
            System.out.println("There is no literature in the registry.");
        }
        else {
            System.out.println("Listing all current literature: \n");
            Iterator<Literature> it = this.literatureRegister.getIterator();
            while (it.hasNext()) {
                Literature literature = it.next();
                displayLiterature(literature);
                System.out.println();
            }
        }
    }

    /**
     * This method will register any given literature object,
     * specifically given by the user. User is asked to select
     * between four different types, then asked to fill in the
     * required info such as; title, publisher and so on.
     */
    public void doFindLiteratureByTitleAndPublisher() {

        Scanner reader = new Scanner(System.in);

        System.out.println("Search by title: ");
        String title = reader.nextLine();

        System.out.println("Search by publisher: ");
        String publisher = reader.nextLine();

        Literature searchedLiterature = this.literatureRegister.searchForLiterature(title, publisher);

        if (searchedLiterature == null) {
            System.out.println("We didn't find anything in the registry.");
        }
        else {
            System.out.println("-----------------------------------");
            System.out.println("    Your search resulted in: ");
            System.out.println("-----------------------------------");
            displayLiterature(searchedLiterature);
        }
    }



    /**
     * This function is tailored to convert a book into a series
     * This function read the input value of a title and edition numbers
     * then uses it to locate the book with the given values
     * then adds it to the bookSeries
     */
    public void doConvertBookToSeries() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Find your book");
        System.out.println("Title: ");
        String title = reader.nextLine();

        System.out.println("Publisher: ");
        String publisher = reader.nextLine();

        Literature literature = this.literatureRegister.searchForLiterature(title, publisher);

        if (literature instanceof Book) {

            Book tempBook = (Book) literature;

            System.out.println("Here is your book");
            System.out.println();
            displayLiterature(tempBook);

            System.out.println("Lets add it to a series");
            System.out.println("Name of book series?");
            String seriesTitle = reader.nextLine();

            System.out.println("Authors?");
            String authors = reader.nextLine();

            Literature bookSeries = new BookSeries(seriesTitle, publisher, authors);

            if (bookSeries instanceof BookSeries) {

                BookSeries realBookSeries = (BookSeries) bookSeries;
                realBookSeries.addBookToSeries(tempBook);

                this.literatureRegister.registerLiterature(realBookSeries);
                System.out.println("The series '" + realBookSeries.getTitle() + "' was added to the registry.");
            }
        }
        else {
            System.out.println("No books found .. ");
        }
    }
    /**
     * A helper method that fills the register(s) with some
     * data for testing purposes.
     */
    private void fillRegistersWithDataForTesting() {

        Literature book1 = new Book("Harry-Potter 1","Cappelen damm","J.K. Rowling",2014,1);
        Literature book2 = new Book("Harry-Potter 2","Cappelen damm","J.K. Rowling",2015,2);
        Literature bookSer = new BookSeries("Harry-Potter Collection","Cappelen damm","J.K. Rowling");
        Literature magazine1 = new Magazine("TU 1","Teknisk Ukeblad Media AS",12,"Magazine","Tech","Steve Jobs");
        Literature magazine2 = new Magazine("TU 2","Teknisk Ukeblad Media AS",25,"Magazine","Tech","Elon Musk");
        Literature newspaper1 = new Newspaper("VG 1","Schibsted",200,"Newspaper","News","Sudoku");
        Literature newspaper2 = new Newspaper("VG 2","Schibsted",100,"Newspaper","News","Cross-word puzzle");

        this.literatureRegister.registerLiterature(book1);
        this.literatureRegister.registerLiterature(book2);
        this.literatureRegister.registerLiterature(bookSer);
        this.literatureRegister.registerLiterature(magazine1);
        this.literatureRegister.registerLiterature(magazine2);
        this.literatureRegister.registerLiterature(newspaper1);
        this.literatureRegister.registerLiterature(newspaper2);
    }

    /**
     * This function is tailored to specifically print out
     * the necessary info about the literature given by the parameter
     * @param literature takes in your type of literature
     */
    private void displayLiterature(Literature literature) {

        System.out.println("Title:  " + literature.getTitle());
        System.out.println("Publisher:  " + literature.getPublisher());

        if(literature instanceof Book) {
            Book book = (Book) literature;
            System.out.println("Author:  " + book.getAuthor());
            System.out.println("Published:  " + book.getPublished());
            System.out.println("Edition number:  " + book.getEditionNumber());
        }

        else if(literature instanceof BookSeries) {
            BookSeries aBookSeries = (BookSeries) literature;
            System.out.println("Author:  " + aBookSeries.getAuthors());
        }

        else if(literature instanceof Newspaper) {
            Newspaper newspaper = (Newspaper) literature;
            System.out.println("Publication amount:  " + newspaper.getPublicationAmount() + " each year.");
            System.out.println("Periodical type:  " + newspaper.getPeriodicalType());
            System.out.println("periodical genre:  " + newspaper.getPeriodicalGenre());
            System.out.println("Brain teaser:  " + newspaper.getBrainteaser());
        }

        else if(literature instanceof Magazine) {
            Magazine magazine = (Magazine) literature;
            System.out.println("Publication amount:  " + magazine.getPublicationAmount() + " each year.");
            System.out.println("Periodical type:  " + magazine.getPeriodicalType());
            System.out.println("periodical genre:  " + magazine.getPeriodicalGenre());
            System.out.println("Cover model:  " + magazine.getCoverModel());
        }
    }

    /**
     * This method will straightforwardly add a magazine to the
     * literature-registry, and will ask the user for information
     * required upon registration. Title, publisher ... etc.
     */
    private void doAddMagazineToRegistry() {

        String periodicalType = "Magazine";

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("The newspaper needs # ");

        System.out.println("Title: ");
        String title = scanner3.nextLine();

        System.out.println("Publisher: ('forlag' in norwegian)");
        String publisher = scanner3.nextLine();

        System.out.println("Publication amount: ");
        int publicationAmount = 0;
        boolean needToCheck = true;
        while(needToCheck){
            try {
                publicationAmount = scanner3.nextInt();
                needToCheck = false;
            }
            catch (InputMismatchException ime){
                System.out.println("Not a valid number!");
            }
            scanner3.nextLine();
        }
        System.out.println("Periodical genre: (such as: Sports, News ... )");
        String periodicalGenre = scanner3.nextLine();

        System.out.println("Front page model:  ");
        String coverModel = scanner3.nextLine();

        Literature magazine = new Magazine(title , publisher, publicationAmount,
                periodicalType, periodicalGenre, coverModel);
        this.literatureRegister.registerLiterature(magazine);

        System.out.println("the Literature '" + magazine.getTitle() + "' from " + magazine.getPublisher()
                + " was added to the registry.");
    }

    /**
     * This method is tailored to add a book to the literature registry
     * By using a scanner we can transform input in to the book-object.
     * NOTICE: We use scanner3.nextLine() to clear the previous input
     *          so we avoid any trouble causing the input to mis-match.
     */
    private void doAddNewspaperToRegistry() {

        String periodicalType = "Newspaper";

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("The newspaper needs # ");

        System.out.println("Title: ");
        String title = scanner3.nextLine();

        System.out.println("Publisher: ('forlag' in norwegian)");
        String publisher = scanner3.nextLine();

        System.out.println("Publication amount: ");
        int publicationAmount = 0;
        boolean checker = true;

        while(checker) {

            try {
                publicationAmount = scanner3.nextInt();
                checker = false;
            }
            catch (InputMismatchException ime){
                System.out.println("Not a valid number!");
            }
            scanner3.nextLine();
        }

        System.out.println("Periodical genre: (such as: Sports, News ... )");
        String periodicalGenre = scanner3.nextLine();

        System.out.println("Brain Teaser: (such as: Sudoku, Riddle, Cross-word-puzzle ...) ");
        String brainTeaser = scanner3.nextLine();

        Literature newspaper = new Newspaper(title , publisher, publicationAmount,
                periodicalType, periodicalGenre, brainTeaser);
        this.literatureRegister.registerLiterature(newspaper);

        System.out.println("the Literature '" + newspaper.getTitle() + "' from " + newspaper.getPublisher()
                + " was added to the registry.");

    }

    /**
     * This method will straightforwardly add a magazine to the
     * literature-registry, and will ask the user for information
     * required upon registration. Title, publisher ... etc.
     */
    private void doAddBookToRegistry() {

        Scanner scanner3 = new Scanner(System.in);

        System.out.println("The book needs # ");
        System.out.println("Title: ");
        String title = scanner3.nextLine();

        System.out.println("Publisher: ('forlag' in norwegian)");
        String publisher = scanner3.nextLine();

        System.out.println("Author: ");
        String author = scanner3.nextLine();

        System.out.println("Year published: ");
        int published = 0;
        boolean needToCheck = true;
        while(needToCheck){
            try {
                published = scanner3.nextInt();
                needToCheck = false;
            }
            catch (InputMismatchException ime){
                System.out.println("Not a valid number!");
            }
            scanner3.nextLine();
        }

        System.out.println("Edition number: ");
        int editionNumber = 0;
        boolean tryCheck = true;
        while(tryCheck) {
            try {
                editionNumber = scanner3.nextInt();
                tryCheck = false;
            }
            catch (InputMismatchException ime) {
                System.out.println("Not a valid number!");
            }
            scanner3.nextLine();
        }

        Literature book = new Book(title, publisher, author, published, editionNumber);
        this.literatureRegister.registerLiterature(book);

        System.out.println("the Literature '" + book.getTitle() + "' from " + book.getPublisher()
                + " was added to the registry.");
    }

    /**
     * This method will straightforwardly add a magazine to the
     * literature-registry, and will ask the user for information
     * required upon registration. Title, publisher ... etc.
     */
    private void doAddBookSeriesToRegistry() {

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("The book series needs # ");

        System.out.println("Title: ");
        String title = scanner4.nextLine();

        System.out.println("Publisher: ('forlag' in norwegian)");
        String publisher = scanner4.nextLine();

        System.out.println("Authors:  ");
        String authors = scanner4.nextLine();

        Literature bookSeri = new BookSeries(title, publisher, authors);
        this.literatureRegister.registerLiterature(bookSeri);

        System.out.println("the Literature '" + bookSeri.getTitle() + "' from " + bookSeri.getPublisher()
                    + " was added to the registry.");
    }

    public void doListAllByPublisher() {

        if (0 == this.literatureRegister.getNumberOfLiterature()) {
            System.out.println("There is no literature in the registry.");
        }
        else {

            Scanner reader = new Scanner(System.in);

            System.out.println("Search after publisher: ");
            String publisher = reader.nextLine();

            System.out.println("Listing literature with following publisher: " + publisher + "\n");

            Iterator<Literature> it = this.literatureRegister.getIterator();

            while (it.hasNext()) {

                Literature literature = it.next();

                if (literature.getPublisher().equals(publisher)) {
                    displayLiterature(literature);
                    System.out.println();
                }
            }
        }
    }
}