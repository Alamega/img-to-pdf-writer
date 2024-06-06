package alamega.imgtopdfwriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

public class MainController {
    @FXML
    private Button buttonFileChoice;

    @FXML
    private Button buttonWrite;

    @FXML
    private Spinner<Integer> inputCountWrite;

    @FXML
    private Label labelFileCount;

    List<File> selectedFiles = new ArrayList<>();

    @FXML
    void initialize() {
        inputCountWrite.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999, 1));
        inputCountWrite.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                int value = inputCountWrite.getValue();
                if (value > 999) {
                    inputCountWrite.getValueFactory().setValue(999);
                } else if (value < 1) {
                    inputCountWrite.getValueFactory().setValue(1);
                }
            }
        });

        buttonFileChoice.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Выберите файлы");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Изображения", "*.png", "*.jpg", "*.jpeg"));
            selectedFiles = fileChooser.showOpenMultipleDialog(
                    ((Node) actionEvent.getSource()).getScene().getWindow()
            );
            if (selectedFiles != null) {
                labelFileCount.setText(String.valueOf(selectedFiles.size()));
            }
        });

        buttonWrite.setOnAction(actionEvent -> {
            try {
                if (selectedFiles == null) { throw new RuntimeException("Выбрано 0 картинок!"); }
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Выберите путь для сохранения файла");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF-файл", "*.pdf"));
                File selectedFile = fileChooser.showSaveDialog(
                        ((Node) actionEvent.getSource()).getScene().getWindow()
                );
                WriteService.write(selectedFiles, selectedFile.getAbsolutePath(), inputCountWrite.getValue());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Шалость удалась");
                alert.setHeaderText("PDF успешно записан!");
                alert.setContentText("Теперь его можно найти по адресу " + selectedFile.getAbsolutePath());
                alert.showAndWait().ifPresent(rs -> {});
            } catch (RuntimeException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("О нет!");
                alert.setHeaderText("Проверьте правильность введенных данных и повторите попытку записи.");
                alert.setContentText(e.getMessage());
                alert.showAndWait().ifPresent(rs -> {});
            }
        });
    }
}
