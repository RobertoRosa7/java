module br.com.alura.clientservice {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.alura.clientservice to javafx.fxml;
    exports br.com.alura.clientservice;
}