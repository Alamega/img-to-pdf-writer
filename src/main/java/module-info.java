module alamega.imgtopdfwriter {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.librepdf.openpdf;

    opens alamega.imgtopdfwriter to javafx.fxml;
    exports alamega.imgtopdfwriter;
}