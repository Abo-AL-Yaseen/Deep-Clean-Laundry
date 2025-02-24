module com.example.project_db {
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires com.jfoenix;
    requires org.postgresql.jdbc;
    requires java.compiler;

    opens com.example.project_db to javafx.fxml;
    exports com.example.project_db;
}