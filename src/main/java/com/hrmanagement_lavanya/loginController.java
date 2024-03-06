package com.hrmanagement_lavanya;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class loginController {

    public PasswordField passwordField;
    public TextField emailField;
    public Label message;

    private final String url="jdbc:mysql://localhost:3306/hrmanagementlavanya";
    private final String username="root";
    private final String password="Oreo@2004";

    public void login() throws Exception{
        String pass=passwordField.getText();
        String email=emailField.getText();


        if(pass.equals("") || email.equals("")){
            setMsg("EMAIL AND PASSWORD ARE REQUIRED");
            System.out.println(pass+email);
            return;
        }
//        System.out.println("Try");

        try{
            Class.forName("com.cj.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
//            System.out.println(e.getMessage());
        }
        try{
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            String query=String.format("SELECT password,firstName,lastName FROM user WHERE email='%s'",email);
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next()){
                String originalPass=resultSet.getString("password");
                String Uname=resultSet.getString("firstName").concat(" ").concat(resultSet.getString("lastName"));
                if(originalPass.equals(pass)){
//                    Parent root=FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
//                    Stage secondStage=new Stage();
//                    secondStage.setTitle("Dashboard");
//
//                    secondStage.setScene(new Scene(root));
//
////                    close previous stage
//                    Stage previousStage= (Stage) emailField.getScene().getWindow();
//                    previousStage.close();
//
////                    send data
//                    try {
//                        dashboardController dc = new dashboardController();
//                        dc.setUSER(Uname);
//                    }
//                    catch (Exception e){
//                        System.out.println(e.getMessage());
//                    }
//
//                    secondStage.show();

                    try {
                        // Load the FXML file for the second scene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
                        Parent secondScene = loader.load();

                        // Access the controller of the second scene
                        dashboardController dashController = loader.getController();

                        // Set the data in the controller of the second scene
                        dashController.setMessage(Uname);

                        // Create a new stage for the second scene
                        Stage secondStage = new Stage();
                        secondStage.setTitle("DashBoard");
                        secondStage.setScene(new Scene(secondScene));

                        Stage firstSceneStage = (Stage) emailField.getScene().getWindow();
                        firstSceneStage.close();

                        // Show the second stage
                        secondStage.show();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }


                }
                else{
                    setMsg("INVALID CREDENTIALS");
                }
            }
            else{
                setMsg("INVALID CREDENTIALS");

            }

        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void setMsg(String msg){
        message.setText(msg);
    }
}