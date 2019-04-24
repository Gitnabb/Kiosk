import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private TableView<Literature> tableView;

    @FXML
    private TableColumn<Literature, String> titleColumn;

    @FXML
    private TableColumn<Literature, String> publisherColumn;

    ObservableList<Literature> lit = FXCollections.observableArrayList();


    // LIST ALL
    public void initialize() {
        // set up the columns in the table
        titleColumn.setCellValueFactory(new PropertyValueFactory<Literature, String>("title"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<Literature, String>("publisher"));
    }

    // load data dummies
    @FXML
    private void showRegistry(){
        tableView.setItems(lit);
    }


    // fill
    public void fillRegistry() {
        lit.add(new Book("Harry-Potter 1", "Cappelen damm", "J.K. Rowling", 2014, 1));
        lit.add(new Book("Harry-Potter 2", "Cappelen damm", "J.K. Rowling", 2015, 2));
        lit.add(new BookSeries("Harry-Potter Collection", "Cappelen damm", "J.K. Rowling"));
        lit.add(new Magazine("TU 1", "Teknisk Ukeblad Media AS", 12, "Magazine", "Tech", "Steve Jobs"));
        lit.add(new Magazine("TU 2", "Teknisk Ukeblad Media AS", 25, "Magazine", "Tech", "Elon Musk"));
        lit.add(new Newspaper("VG 1", "Schibsted", 200, "Newspaper", "News", "Sudoku"));
        lit.add(new Newspaper("VG 2", "Schibsted", 100, "Newspaper", "News", "Cross-word puzzle"));
    }

}