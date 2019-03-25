/**
 *
 *
 *
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