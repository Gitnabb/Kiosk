/**
 * This interface is designed to act a connector between the UI class and the
 * implementing class with all of its methods used in the UI.
 * This interface will guide all methods triggered in the KioskApplicationImpl-class
 * By that saying, all methods goes via this interface.
 *
 * @author <Andreas Øie>
 * @version 1.0
 */

public interface KioskApplication {
    /**
     * Initialize the application.
     * In this method is is common to create any business logic classes
     * to be used later in the applicaiton, like registers etc.
     */
    void init();

    /**
     * Register new literature to the register.
     */
    void doAddLiteratureToRegister();

    /**
     * List all literature in the register.
     */
    void doListAllLiterature();

    /**
     * Find a literature in the register based on the title and publisher.
     */
    void doFindLiterature();

    /**
     * Converts a single standing book into a series.
     */
    void doConvertBookToSeries();

}