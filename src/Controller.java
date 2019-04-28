import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * This class is tailored to be the controller of the application.
 * This class builds on everything created and written in the sample.fxml-file.
 * Sample.fxml is primarily created trough an external source (Scene-builder JavaFX).
 */
public class Controller {


    /**
     * Creating fields to support the available functions in the scene-builder.
     * Primarily based upon a set of view trough a table with two columns.
     * As well as we create a ObservableList to hold the info stored.
     */
    @FXML
    private TableView<Literature> tableView;

    @FXML
    private TableColumn<Literature, String> titleColumn;

    @FXML
    private TableColumn<Literature, String> publisherColumn;

    ObservableList<Literature> lit = FXCollections.observableArrayList();

    /**
     * A initializer to set the correct cell-values to
     * the columns in the table view.
     */
    public void initialize() {
        // set up the columns in the table
        titleColumn.setCellValueFactory(new PropertyValueFactory<Literature, String>("title"));
        publisherColumn.setCellValueFactory(new PropertyValueFactory<Literature, String>("publisher"));
    }

    /**
     * Function connected to "Show literature"-button.
     * Once executed, the list will forever be shown, until the
     * program is closed.
     */
    @FXML
    private void showRegistry(){
        tableView.setItems(lit);
    }

    /**
     * Tailored function to the "Fill registry"-button on the application.
     * This function will run each time the button is pressed.
     */
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