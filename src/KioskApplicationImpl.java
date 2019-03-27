import java.util.Iterator;
import java.util.Scanner;

/**
 * Represents the KioskApplication. The class is a delegate for the main
 * application and the menu-system. Any functions triggered by a menu selection
 * leads to a call to one of the methods in this class (via the
 * KioskApplication interface).
 *
 * @author <Andreas Øie>
 * @version 1.0
 */

public class KioskApplicationImpl implements KioskApplication {

    private Registry literatureRegister;

    @Override
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
    @Override
    public void doAddLiteratureToRegister() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter confirmation number:");
        System.out.println("[1] Newspaper");
        System.out.println("[2] Magazine");
        System.out.println("[3] Book");
        System.out.println("[4] Book series");

        int setupValue = scanner.nextInt();

        // TODO: complete doAddBookToRegistry, doAddMagazineToRegistry, doAddBookSeriesToRegistry

        if(setupValue == 1) {
            doAddNewspaperToRegistry(); // FINISHED :)))
        }
        else if (setupValue == 2) {
            doAddMagazineToRegistry();
        }
        else if (setupValue == 3) {
            doAddBookToRegistry();
        }
        else if(setupValue == 4) {
            doAddBookSeriesToRegistry();
        }
    }

    @Override
    public void doListAllLiterature() {

        if(0 == this.literatureRegister.getNumberOfLiterature()) {
            System.out.println("There is no literature in the registry.");
        }
        else {
            System.out.println("Listing all current literature: ");
            Iterator<Literature> it = this.literatureRegister.getIterator();
            while(it.hasNext()) {
                Literature literature = it.next();
                displayLiterature(literature);
                System.out.println();
            }
        }
    }

    @Override
    public void doFindLiterature() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Search by title: ");
        String title = reader.nextLine();

        System.out.println("Search by publisher: ");
        String publisher = reader.nextLine();

        if(0 == this.literatureRegister.getNumberOfLiterature()) {
            System.out.println("There is no literature in the registry.");
        }
        else {
            System.out.println("-----------------------------------");
            System.out.println("    Your search resulted in: ");
            System.out.println("-----------------------------------");
            Iterator<Literature> it = this.literatureRegister.getIterator();
            while(it.hasNext()) {
                Literature literature = it.next();
                if(literature.getTitle().equals(title) && literature.getPublisher().equals(publisher)){
                    displayLiterature(literature);
                    System.out.println();
                }
            }
        }
    }

    /**
     * This function is tailored to convert a book into a series
     * This function read the input value of a title and edition numbers
     * then uses it to locate the book with the given values
     * then adds it to the bookSeries
     */
    @Override
    public void doConvertBookToSeries() {

        // TODO: fix this class, "bookSeries" inherits from Literature

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter book title: ");
        String bookTitle = reader.nextLine();

        System.out.println("Enter book edition number: ");
        int bookPublisher = reader.nextInt();

        if(0 == this.literatureRegister.getNumberOfLiterature()) {
            System.out.println("Literature is empty!");
        }
        else {
            System.out.println("Finding book ... ");
            Iterator<Literature> it = this.literatureRegister.getIterator();
            while(it.hasNext()) {
                Literature literature = it.next();
                if(literature instanceof Book) {
                    Book foundBook = (Book) literature;
                    System.out.println("Converting into series ... ");
                    BookSeries bookSeries =
                    this.bookSeries.addBookToSeries(foundBook);
                    System.out.println("The book + " + foundBook.getTitle() + "was added to registry");
                }
            }
        }
    }

    /**
     * A helper method that fills the register(s) with some
     * data for testing purposes.
     */
    private void fillRegistersWithDataForTesting()
    {
        Literature book1 = new Book("Harry-Potter","Cappelen damm","J.K. Rowling",2014,1);
        Literature book2 = new Book("Harry-Potter","Cappelen damm","J.K. Rowling",2015,2);

        Literature bookSer = new BookSeries("Harry-Potter Collection","Cappelen damm","J.K. Rowling");

        Literature magazine1 = new Magazine("TU 1","Teknisk Ukeblad Media AS",12,"Magazine","Tech","Steve Jobs");
        Literature magazine2 = new Magazine("TU 2","Teknisk Ukeblad Media AS",25,"Magazine","Tech","Elon Musk");

        Literature newspaper1 = new Newspaper("VG","Schibsted",200,"Newspaper","News","Sudoku");
        Literature newspaper2 = new Newspaper("VG","Schibsted",100,"Newspaper","News","Cross-word puzzle");


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
            System.out.println("Publication amount:  " + magazine.getPublicationAmount());
            System.out.println("Periodical type:  " + magazine.getPeriodicalType());
            System.out.println("periodical genre:  " + magazine.getPeriodicalGenre());
            System.out.println("Cover model:  " + magazine.getCoverModel());
        }
    }

    private void doAddBookToRegistry() {


    }

    private void doAddMagazineToRegistry() {

    }

    /**
     * This method is tailored to add a book to the literature registry
     * By using a scanner we can transform input in to the book-object.
     * NOTICE: We use scanner3.nextLine() to clear the previous input
     *          so we avoid any trouble causing the input to mis-match.
     */
    private void doAddNewspaperToRegistry() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("The newspaper needs # ");

        System.out.println("Title: ");
        String title = scanner3.nextLine();

        System.out.println("Publisher: ('forlag' in norwegian)");
        String publisher = scanner3.nextLine();

        System.out.println("Publication amount: ");
        int publicationAmount = scanner3.nextInt();
        scanner3.nextLine();

        System.out.println("Periodical type: Newspaper / Magazine / Book / Book series (?)");
        String periodicalType = scanner3.nextLine();

        System.out.println("Periodical genre: (such as: Sports, News ... ");
        String periodicalGenre = scanner3.nextLine();

        System.out.println("Brain Teaser: (such as: Sudoku, Riddle, Cross-word-puzzle ...) ");
        String brainTeaser = scanner3.nextLine();

        Literature newspaper = new Newspaper(title , publisher, publicationAmount,
                periodicalType, periodicalGenre, brainTeaser);

        literatureRegister.registerLiterature(newspaper);

        System.out.println("the Literature [ " + newspaper.getTitle() + " ] from " + newspaper.getPublisher()
                + " was added to the registry.");

    }

    private void doAddBookSeriesToRegistry() {

    }
}
