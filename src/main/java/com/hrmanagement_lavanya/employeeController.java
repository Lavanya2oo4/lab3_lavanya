package com.hrmanagement_lavanya;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.*;

public class employeeController {

    
    public Label message;

    private final String url="jdbc:mysql://localhost:3306/hrmanagementlavanya";
    private final String username="root";
    private final String password="Oreo@2004";
    public TableView tableView;
    public TableColumn tableId;
    public TableColumn tableFName;
    public TableColumn tableLName;
    public TableColumn tableEmail;
    public TableColumn tablePhone;
    public TableColumn tableType;
    public TableColumn TableSalary;
    public TextField textFName;
    public TextField textLName;
    public TextField textEmail;
    public TextField textPhone;
    public TextField textId;
    public PasswordField textPass;

    //    public void login() {
//        
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

    public void back() throws  Exception {
        Parent root= FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        Stage secondStage=new Stage();
        secondStage.setTitle("Dashboard");

        secondStage.setScene(new Scene(root));

//                    close previous stage
        Stage previousStage= (Stage) this.textEmail.getScene().getWindow();
        previousStage.close();

        secondStage.show();
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