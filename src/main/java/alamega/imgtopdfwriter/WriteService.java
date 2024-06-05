package alamega.imgtopdfwriter;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;
import javafx.scene.control.ProgressBar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteService {
    public WriteService() {}
    public static void write(List<File> files, String outputPath, Integer count) {
        try(Document document = new Document()) {
            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(outputPath)));
            document.open();
            files.forEach(filePath -> {
                try {
                    for (int i = 0; i < count; i++) {
                        document.add(Image.getInstance(filePath.getAbsolutePath()));
                    }
                } catch (IOException e) {
                    throw new RuntimeException("Не получилось добавить файл: " + filePath, e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("Не получилось создать файл: " + outputPath, e);
        }
    }
}
