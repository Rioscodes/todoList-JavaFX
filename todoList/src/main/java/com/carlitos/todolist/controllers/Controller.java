package com.carlitos.todolist.controllers;

import com.carlitos.todolist.models.Task;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;

import java.util.ResourceBundle;

public class Controller implements Initializable {
    //button who clear all
    @FXML
    Button btnClean;
//combobox of titles
    @FXML
    ComboBox<String> cbList;
//create a new task button
    @FXML Button btnCreate;
    //txtTitle
    @FXML TextField txtId;
//txtDesc
    @FXML
    TextField txtDesc;
    //btn for delete a task who is completed alredy
    @FXML Button btnComplete;
//labels
    @FXML Label lbTitle;
    @FXML Label lbDesc;
//btn add task
    @FXML Button btnAddTask;

    ArrayList<Task> arrTask = new ArrayList<>();
    ObservableList<String> arrTitles = FXCollections.observableArrayList();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //begin invisible
        lbTitle.setVisible(false);
        lbDesc.setVisible(false);
        txtId.setVisible(false);
        txtDesc.setVisible(false);
        btnAddTask.setVisible(false);
    }



    public void onClickClean(){
        txtId.clear();
        txtDesc.clear();
    }


    public void onClickCreate(){

        lbTitle.setVisible(true);
        lbDesc.setVisible(true);
        txtId.setVisible(true);
        txtDesc.setVisible(true);
        btnAddTask.setVisible(true);
    }

    public void onClickExit(){
        Platform.exit();
    }

//onAddTask

public void onAddTask(){
        //get vars
        String id = txtId.getText();
        String desc = txtDesc.getText();

        if (id.isEmpty() || desc.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Enter data");
            alert.setHeaderText(null);
            alert.setContentText("Please enter data on Title or Desc");
            alert.showAndWait();
        }else {
            Task task = new Task(id, desc);
            arrTask.add(task);
            arrTitles.add(task.getTitle());
            cbList.setItems(arrTitles);
            txtId.clear();
            txtDesc.clear();
        }
    }

    public void onClickTitle(){
        for (Task task : arrTask) {
            if (cbList.getSelectionModel().getSelectedItem().equals(task.getTitle())) {
                txtId.setText(task.getTitle());
                txtDesc.setText(task.getDescription());
            }
        }
    }

    public void onClickFinish(){

        for (int i = 0; i < arrTask.size(); i++) {
            if (cbList.getSelectionModel().getSelectedItem().equals(arrTask.get(i).getTitle())) {
                //delete task
                arrTask.remove(i);
                cbList.getItems().remove(cbList.getSelectionModel().getSelectedItem());
                break;
            }
        }

        txtId.clear();
        txtDesc.clear();

    }


}