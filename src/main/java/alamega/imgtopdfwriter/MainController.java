package alamega.imgtopdfwriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MainController {
    @FXML
    private Button buttonFileChoice;

    @FXML
    private Button buttonWrite;

    @FXML
    private TextField inputCountWrite;

    @FXML
    private Label labelFileCount;

    List<File> selectedFiles = new ArrayList<>();

    @FXML
    void initialize() {
        buttonFileChoice.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Выберите файлы");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Изображения", "*.png", "*.jpg", "*.jpeg"));
            selectedFiles = fileChooser.showOpenMultipleDialog(
                    ((Node) actionEvent.getSource()).getScene().getWindow()
            );
            labelFileCount.setText(String.valueOf(selectedFiles.size()));
        });

        buttonWrite.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Выберите путь для сохранения файла");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF-файл", "*.pdf"));
            File selectedFile = fileChooser.showSaveDialog(
                    ((Node) actionEvent.getSource()).getScene().getWindow()
            );
            if (selectedFiles != null && !selectedFiles.isEmpty() && selectedFile != null && inputCountWrite != null) {
                WriteService.write(selectedFiles, selectedFile.getAbsolutePath(), Integer.parseInt(inputCountWrite.getText()));
            }
        });
    }
}
