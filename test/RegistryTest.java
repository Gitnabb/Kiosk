import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegistryTest {

    Registry registry;
    private ArrayList<Literature> literatureList; // name of the Book-list
    private Book book1;
    private Book book2;
    private BookSeries bookSeries;
    private Magazine magazine1;
    private Magazine magazine2;
    private Newspaper newspaper1;
    private Newspaper newspaper2;

    @Before
    public void setUp() throws Exception {

        this.literatureList = new ArrayList<>();
        this.registry = new Registry();

        this.book1 = new Book("Harry-Potter 1","Cappelen damm","J.K. Rowling",2014,1);
        this.book2 = new Book("Harry-Potter 2","Cappelen damm","J.K. Rowling",2015,2);
        this.bookSeries = new BookSeries("Harry-Potter Collection","Cappelen damm","J.K. Rowling");
        this.magazine1 = new Magazine("TU 1","Teknisk Ukeblad Media AS",12,"Magazine","Tech","Steve Jobs");
        this.magazine2 = new Magazine("TU 2","Teknisk Ukeblad Media AS",25,"Magazine","Tech","Elon Musk");
        this.newspaper1 = new Newspaper("VG 1","Schibsted",200,"Newspaper","News","Sudoku");
        this.newspaper2 = new Newspaper("VG 2","Schibsted",100,"Newspaper","News","Cross-word puzzle");

        this.literatureList.add(book1);
        this.literatureList.add(book2);
        this.literatureList.add(bookSeries);
        this.literatureList.add(magazine1);
        this.literatureList.add(magazine2);
        this.literatureList.add(newspaper1);
        this.literatureList.add(newspaper2);

    }

    @Test
    public void registerLiterature() {
        Book testBook = new Book("testTitle", "testPublisher", "testAuthor", 2000,10);
        assertNotNull(testBook);
        assertNotSame("Should not be same", testBook, book1);
    }

    @Test
    public void searchForLiterature() {

        String expectedTitle = "Harry-Potter 1";
        String expectedPublisher = "Cappelen damm";

        Literature testBook = this.registry.searchForLiterature(expectedTitle,expectedPublisher);
        if(testBook instanceof Book){
            Book testbook = (Book) testBook;
            assertEquals(book1,testbook);
        }
    }

    @Test
    public void getNumberOfLiterature() {
        assertEquals(7,this.literatureList.size());
    }
}