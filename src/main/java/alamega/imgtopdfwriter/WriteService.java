package alamega.imgtopdfwriter;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteService {
    public WriteService() {}
    public File write(List<String> filePathList, String outputPath) {
        try(Document document = new Document()) {
            PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(outputPath)));
            document.open();
            filePathList.forEach(filePath -> {
                try {
                    document.add(Image.getInstance(filePath));
                } catch (IOException e) {
                    throw new RuntimeException("Не получилось добавить файл: " + filePath, e);
                }
            });
            return new File(outputPath);
        } catch (IOException e) {
            throw new RuntimeException("Не получилось создать файл: " + outputPath, e);
        }
    }
}
