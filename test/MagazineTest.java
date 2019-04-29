import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagazineTest {

    private Magazine magazine;

    @Before
    public void setUp() throws Exception {
        this.magazine = new Magazine("TU 1","Teknisk Ukeblad Media AS",12,"Magazine","Tech","Steve Jobs");
    }

    /**
     * Test if the covermodel is correct set
     * Method: getCoverModel()
     *
     */
    @Test
    public void getCoverModel() {
        assertEquals("Steve Jobs", this.magazine.getCoverModel());
    }
}