package alamega.imgtopdfwriter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ImgToPDFWriter extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Настройка Stage
        stage.setMinWidth(480);
        stage.setMinHeight(200);
        stage.getIcons().add(new Image(Objects.requireNonNull(ImgToPDFWriter.class.getResourceAsStream("/logo.png"))));

        //Создание и настройка Scene
        FXMLLoader fxmlLoader = new FXMLLoader(ImgToPDFWriter.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Запиши чтобы не забыть! Что?");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}