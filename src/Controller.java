import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private Registry literatureRegister = new Registry();

    @FXML
    private TableView<Literature> tableView;

    @FXML
    private TableColumn<Literature, String> title;

    @FXML
    private TableColumn<Literature, String> publisher;


    public void print(){
        System.out.println("Hello");
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


}
