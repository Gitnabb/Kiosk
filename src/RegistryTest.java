import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegistryTest {

    private ArrayList<Literature> literatureList; // name of the Book-list

    @Before
    public void setUp() throws Exception {

        this.literatureList = new ArrayList<>();

        Literature book1 = new Book("Harry-Potter 1","Cappelen damm","J.K. Rowling",2014,1);
        Literature book2 = new Book("Harry-Potter 2","Cappelen damm","J.K. Rowling",2015,2);
        Literature bookSer = new BookSeries("Harry-Potter Collection","Cappelen damm","J.K. Rowling");
        Literature magazine1 = new Magazine("TU 1","Teknisk Ukeblad Media AS",12,"Magazine","Tech","Steve Jobs");
        Literature magazine2 = new Magazine("TU 2","Teknisk Ukeblad Media AS",25,"Magazine","Tech","Elon Musk");
        Literature newspaper1 = new Newspaper("VG 1","Schibsted",200,"Newspaper","News","Sudoku");
        Literature newspaper2 = new Newspaper("VG 2","Schibsted",100,"Newspaper","News","Cross-word puzzle");

        this.literatureList.add(book1);
        this.literatureList.add(book2);
        this.literatureList.add(bookSer);
        this.literatureList.add(magazine1);
        this.literatureList.add(magazine2);
        this.literatureList.add(newspaper1);
        this.literatureList.add(newspaper2);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void registerLiterature() {
    }

    @Test
    public void getIterator() {
    }

    @Test
    public void searchForLiterature() {
    }

    @Test
    public void getNumberOfLiterature() {
    }
}