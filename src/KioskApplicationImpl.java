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

    private Registry literatureReg;

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
        Scanner reader = new Scanner(System.in);

        System.out.println("Please enter your type of literature");
        System.out.println("newspaper? magazine? book?");

        String title = reader.nextLine();

        System.out.println("Please enter the author of the book");
        String author = reader.nextLine();

        System.out.println("Please enter the year the Book was published");
        int published = reader.nextInt();

        System.out.println("Please enter the edition number of the book");
        int editionNumber = reader.nextInt();

        Literature literature = new Book(title, author, published, editionNumber);
        this.literatureReg.registerLiterature(literature);

        System.out.println("the book " + literature.getTitle() + " was successfully added to the registry.");

        //Create a book was created confirmation-print
        //With all the stats
    }

    @Override
    public void doListAllLiterature() {
        System.out.println(" --- ");
    }

    @Override
    public void doFindLiterature() {
        System.out.println(" --- ");
    }

    @Override
    public void doConvertBookToSeries() {
        System.out.println(" --- ");
    }

    /**
     * A helper method that fills the register(s) with some
     * data for testing purposes.
     */
    private void fillRegistersWithDataForTesting()
    {
        //TODO: Fill in code that creates some Realestates and adds them
        //      to the register
        Literature book1 = new Book("Harry-Potter","Gyldendal","J.K. Rowling",2014,1);
    }



}
