module com.example.orlog {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.orlog to javafx.fxml;
    exports com.example.orlog;
    exports com.example.orlog.Buttons;
    opens com.example.orlog.Buttons to javafx.fxml;
    exports com.example.orlog.Menu;
    opens com.example.orlog.Menu to javafx.fxml;
}