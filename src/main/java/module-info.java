module com.example.orlog {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.orlog to javafx.fxml;
    exports com.example.orlog;
    exports com.example.orlog.Buttons;
    opens com.example.orlog.Buttons to javafx.fxml;
    exports com.example.orlog.Menu;
    opens com.example.orlog.Menu to javafx.fxml;
    exports com.example.orlog.Realms;
    opens com.example.orlog.Realms to javafx.fxml;
    exports com.example.orlog.Game;
    opens com.example.orlog.Game to javafx.fxml;
}