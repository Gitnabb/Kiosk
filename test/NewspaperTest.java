import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewspaperTest {

    private Newspaper newspaper;

    /**
     * Sets up a newspaper, initialized with
     * title, publsiher, publication amount, periodical type,
     * periodical genre and brainteaser
     */
    @Before
    public void setUp() {
        this.newspaper = new Newspaper("VG","Schibsted",1,"Newspaper","News","Sudoku");
    }

    /**
     *Test if initialized brainteaser of newspaper is correct
     * Method: getBrainteaser()
     */
    @Test
    public void getBrainteaser() {
        assertEquals("Sudoku", newspaper.getBrainteaser());
    }
}