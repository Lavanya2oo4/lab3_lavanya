package com.hrmanagement_lavanya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class dashboardController {


    private final String url="jdbc:mysql://localhost:3306/hrmanagementlavanya";
    private final String username="root";
    private final String password="Oreo@2004";
    public Label dashboard;


    public void employee() throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("employee-view.fxml"));
        Stage secondStage=new Stage();
        secondStage.setTitle("Employee");

        secondStage.setScene(new Scene(root));

//                    close previous stage
        Stage previousStage= (Stage) dashboard.getScene().getWindow();
        previousStage.close();

        secondStage.show();

    }

    public void logout() throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Stage secondStage=new Stage();
        secondStage.setTitle("LOGIN");

        secondStage.setScene(new Scene(root));

//                    close previous stage
        Stage previousStage= (Stage) dashboard.getScene().getWindow();
        previousStage.close();

        secondStage.show();
    }

    public void admin() throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("admin-view.fxml"));
        Stage secondStage=new Stage();
        secondStage.setTitle("Admin");

        secondStage.setScene(new Scene(root));

//                    close previous stage
        Stage previousStage= (Stage) dashboard.getScene().getWindow();
        previousStage.close();

        secondStage.show();
    }

    public void back() {


//                    close current stage
        Stage currentStage= (Stage) dashboard.getScene().getWindow();
        currentStage.close();

    }
}