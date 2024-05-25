module com.carlitos.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.carlitos.todolist to javafx.fxml;
    exports com.carlitos.todolist;
    exports com.carlitos.todolist.controllers;
    opens com.carlitos.todolist.controllers to javafx.fxml;
}