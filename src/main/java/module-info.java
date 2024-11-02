module com.example.partegraficalaboratoriosokets {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.partegraficalaboratoriosokets to javafx.fxml;
    exports com.example.partegraficalaboratoriosokets;
}