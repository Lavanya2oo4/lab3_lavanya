package com.hrmanagement_lavanya;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.*;

public class adminController {

    
    public Label message;

    private final String url="jdbc:mysql://localhost:3306/hrmanagementlavanya";
    private final String username="root";
    private final String password="Oreo@2004";
    public TableView tableView;

    //    public void login() {
//        String pass=passwordField.getText();
//        String email=emailField.getText();
//
//
//        if(pass.equals("") || email.equals("")){
//            setMsg("EMAIL AND PASSWORD ARE REQUIRED");
//            System.out.println(pass+email);
//            return;
//        }
////        System.out.println("Try");
//
//        try{
//            Class.forName("com.cj.mysql.jdbc.Driver");
//        }
//        catch(ClassNotFoundException e){
////            System.out.println(e.getMessage());
//        }
//        try{
//            Connection connection=DriverManager.getConnection(url,username,password);
//            Statement statement=connection.createStatement();
//            String query=String.format("SELECT password FROM user WHERE email='%s'",email);
//            ResultSet resultSet=statement.executeQuery(query);
//            if(resultSet.next()){
//                String originalPass=resultSet.getString("password");
//                if(originalPass.equals(pass)){
//                    System.out.println("Success");
//                }
//                else{
//                    setMsg("INVALID CREDENTIALS");
//                }
//            }
//            else{
//                setMsg("INVALID CREDENTIALS");
//
//            }
//
//        }
//        catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
//
//    }
    public void setMsg(String msg){
        message.setText(msg);
    }

    public void back(ActionEvent actionEvent) {
    }

    public void view(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void update(ActionEvent actionEvent) {
    }

    public void insert(ActionEvent actionEvent) {
    }
}