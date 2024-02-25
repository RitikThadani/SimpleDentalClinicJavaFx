module com.example.clinicatanyajavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.commons.annotations;
    requires org.hibernate.orm.core;

    opens com.example.clinicatanyajavafx;
    exports com.example.clinicatanyajavafx;
}