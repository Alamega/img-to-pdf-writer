package alamega.imgtopdfwriter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonFileChoice;

    @FXML
    private Button buttonPathForOutput;

    @FXML
    private Button buttonWrite;

    @FXML
    private TextField inputCountWrite;

    @FXML
    private Label labelFileCount;

    @FXML
    private Label labelPathForOutput;

    @FXML
    void initialize() {
        assert buttonFileChoice != null : "fx:id=\"buttonFileChoice\" was not injected: check your FXML file 'main-view.fxml'.";
        assert buttonPathForOutput != null : "fx:id=\"buttonPathForOutput\" was not injected: check your FXML file 'main-view.fxml'.";
        assert buttonWrite != null : "fx:id=\"buttonWrite\" was not injected: check your FXML file 'main-view.fxml'.";
        assert inputCountWrite != null : "fx:id=\"inputCountWrite\" was not injected: check your FXML file 'main-view.fxml'.";
        assert labelFileCount != null : "fx:id=\"labelFileCount\" was not injected: check your FXML file 'main-view.fxml'.";
        assert labelPathForOutput != null : "fx:id=\"labelPathForOutput\" was not injected: check your FXML file 'main-view.fxml'.";

    }

}
