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

    private Registry literatureList;
    private BookSeries bookSeries;

    @Override
    public void init()
    {
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

        // TODO: complete doAddNewspaperToRegistry, doAddMagazineToRegistry, doAddBookSeriesToRegistry

        if(setupValue == 1) {
            doAddNewspaperToRegistry();
        }
        else if (setupValue == 2) {
            doAddMagazineToRegistry();
        }
        else if (setupValue == 3) {
            doAddBookToRegistry(); // FINISHED :)))
        }
        else if(setupValue == 4) {
            doAddBookSeriesToRegistry();
        }
    }

    @Override
    public void doListAllLiterature() {

        if(0 == this.literatureList.getNumberOfLiterature()) {
            System.out.println("There is no literature in the registry.");
        }
        else {
            System.out.println("Listing all current literature: ");
            Iterator<Literature> it = this.literatureList.getIterator();
            while(it.hasNext()) {
                Literature literature = it.next();
                displayLiterature(literature);
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

        if(0 == this.literatureList.getNumberOfLiterature()) {
            System.out.println("There is no literature in the registry.");
        }
        else {
            System.out.println("Searching for literature .... ");
            Iterator<Literature> it = this.literatureList.getIterator();
            while(it.hasNext()) {
                Literature literature = it.next();
                while(literature.getTitle().equals(title) && literature.getPublisher().equals(publisher)){
                    displayLiterature(literature);
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

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter book title: ");
        String bookTitle = reader.nextLine();

        System.out.println("Enter book edition number: ");
        int bookPublisher = reader.nextInt();

        if(0 == this.literatureList.getNumberOfLiterature()) {
            System.out.println("Literature is empty!");
        }
        else {
            System.out.println("Finding book ... ");
            Iterator<Literature> it = this.literatureList.getIterator();
            while(it.hasNext()) {
                Literature literature = it.next();
                if(literature instanceof Book) {
                    Book foundBook = (Book) literature;
                    bookSeries.addBookToSeries(foundBook);
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

        Literature magazine1 = new Magazine("TU","Teknisk Ukeblad Media AS",12,"Magazine","Tech","Steve Jobs");
        Literature magazine2 = new Magazine("TU","Teknisk Ukeblad Media AS",25,"Magazine","Tech","Elon Musk");

        Literature newspaper1 = new Newspaper("VG","Schibsted",200,"Newspaper","News","Sudoku");
        Literature newspaper2 = new Newspaper("VG","Schibsted",100,"Newspaper","News","Cross-word puzzle");


        this.literatureList.registerLiterature(book1);
        this.literatureList.registerLiterature(book2);

        this.literatureList.registerLiterature(bookSer);

        this.literatureList.registerLiterature(magazine1);
        this.literatureList.registerLiterature(magazine2);

        this.literatureList.registerLiterature(newspaper1);
        this.literatureList.registerLiterature(newspaper2);
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
            Book printLiterature = (Book) literature;
            System.out.println("Author:  " + printLiterature.getAuthor());
            System.out.println("Published:  " + printLiterature.getPublished());
            System.out.println("Edition number:  " + printLiterature.getEditionNumber());
        }

        else if(literature instanceof BookSeries) {
            BookSeries printLiterature = (BookSeries) literature;
            System.out.println("Author:  " + printLiterature.getAuthors());
        }

        else if(literature instanceof Newspaper) {
            Newspaper newspaper = (Newspaper) literature;
            System.out.println("Publication amount:  " + newspaper.getPublicationAmount());
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

    private void doAddNewspaperToRegistry() {

    }

    private void doAddMagazineToRegistry() {

    }

    private void doAddBookToRegistry() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("The book needs # ");

        System.out.println("Title: ");
        String title = scanner3.nextLine();

        System.out.println("Publisher: ");
        String publisher = scanner3.nextLine();

        System.out.println("Publication amount: ");
        int publicationAmount = scanner3.nextInt();

        System.out.println("Periodical type: ");
        String periodicalType = scanner3.nextLine();

        System.out.println("Periodical genre: ");
        String periodicalGenre = scanner3.nextLine();

        System.out.println("Brain Teaser: ");
        String brainTeaser = scanner3.nextLine();

        Literature newspaper = new Newspaper(title , publisher, publicationAmount,
                periodicalType, periodicalGenre, brainTeaser);

        literatureList.registerLiterature(newspaper);

        System.out.println("Literature " + newspaper.getTitle() + " from " + newspaper.getPublisher()
                + " was added to the registry.");

    }

    private void doAddBookSeriesToRegistry() {

    }
}
