package com.hrmanagement_lavanya;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    public TableView<Model> tableView;

    public TableColumn<Model, Integer> tableId;
    public TableColumn<Model, String> tableFName;
    public TableColumn<Model, String> tableLName;
    public TableColumn<Model, String> tableEmail;
    public TableColumn<Model, String> tablePhone;
    public TableColumn<Model, String> tableType;
    public TableColumn<Model, Double> TableSalary;
    public TableColumn<Model, String> tableDate;

    public TextField textSalary;
    public DatePicker date;

    ObservableList<Model> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableId.setCellValueFactory(new PropertyValueFactory<Model, Integer>("id"));
        tableFName.setCellValueFactory(new PropertyValueFactory<Model, String>("firstName"));
        tableLName.setCellValueFactory(new PropertyValueFactory<Model, String>("lastName"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<Model, String>("email"));
        tablePhone.setCellValueFactory(new PropertyValueFactory<Model, String>("phoneNo"));
        tableType.setCellValueFactory(new PropertyValueFactory<Model, String>("type"));
        TableSalary.setCellValueFactory(new PropertyValueFactory<Model, Double>("salary"));
        tableDate.setCellValueFactory(new PropertyValueFactory<Model, String>("datePaid"));
        tableView.setItems(list);
    }

    public TextField textLName;
    public TextField textEmail;
    public TextField textPhone;
    public TextField textId;
    public PasswordField textPass;
    public TextField textFName;


    public Label message;

    private final String url = "jdbc:mysql://localhost:3306/hrmanagementlavanya";
    private final String username = "root";
    private final String password = "Oreo@2004";

    public void setMsg(String msg) {
        message.setText(msg);
    }

    public void back() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setTitle("Admin");

        secondStage.setScene(new Scene(root));

//                    close previous stage
        Stage previousStage = (Stage) this.textFName.getScene().getWindow();
        previousStage.close();

        secondStage.show();
    }

    public void view() {
        tableView.getItems().clear();
        fetchAll();
        setMsg(" DETAILS FETCHED");
    }

    public void delete() {
        setMsg("");
        String id = (textId.getText());
        if (id.equals("")) {
            setMsg("ID IS REQUIRED");
            return;
        }
        try {
            Class.forName("com.cj.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = String.format("DELETE FROM user WHERE id=%d", Integer.parseInt(id));
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                setMsg("ADMIN DELETED");
                fetchAll();
            } else {
                setMsg("FAILED TO DELETE ADMIN");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public void update() {
        setMsg("");
        String fName = textFName.getText();
        String lName = textLName.getText();
        String email = textEmail.getText();
        String pass = textPass.getText();
        String phone = textPhone.getText();
        String salary = textSalary.getText();
        String id = textId.getText();

        String date_=date.getValue().toString();
        Double salaryDouble;

        if (fName.equals("") || lName.equals("") || email.equals("") || pass.equals("") || phone.equals("") || salary.equals("") || id.equals("") || date_.equals("")) {
            setMsg("FIRSTNAME LASTNAME EMAIL PASSWORD PHONE-NO ID DATE AND SALARY ARE REQUIRED");
        }

//        check if salary is double
        try {
            salaryDouble = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            System.out.println(e);
            setMsg("INVALID SALARY");
            return;
        }

        try {
            Class.forName("com.cj.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
        }
        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            String query = String.format("UPDATE user set firstName='%s',lastName='%s',email='%s',password='%s',phoneNo='%s' WHERE id=%d", fName, lName, email, pass, phone, Integer.parseInt(id));
            int rowsAffected = statement.executeUpdate(query);
            if(rowsAffected>0){
                String query2 = String.format("UPDATE salary set salary=%f,datePaid='%s' WHERE employeeId=%d",salaryDouble,date_, Integer.parseInt(id));
                int rowsAffected2=statement.executeUpdate(query2);
                if(rowsAffected2>0){
                    connection.commit();
                    fetchAll();
                    setMsg("ADMIN UPDATED");
                }
                else {
                    connection.rollback();
                    setMsg("FAILED TO UPDATE ADMIN");
                }

            }

        } catch(SQLException e){
        System.out.println(e.getMessage());
        setMsg("FAILED TO UPDATE ADMIN");
    }

}

    public void insert() {
        setMsg("");
        String fName = textFName.getText();
        String lName = textLName.getText();
        String email = textEmail.getText();
        String pass = textPass.getText();
        String phone = textPhone.getText();
        String salary = textSalary.getText();
        String date_=date.getValue().toString();
        int id;
        Double salaryDouble;

        if (fName.equals("") || lName.equals("") || email.equals("") || pass.equals("") || phone.equals("") || salary.equals("") || date_.equals("")){
            setMsg("FIRSTNAME LASTNAME EMAIL PASSWORD PHONE NO DATE AND SALARY ARE REQUIRED");
        }

//        check if salary is double
        try {
            salaryDouble = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            System.out.println(e);
            setMsg("INVALID SALARY");
            return;
        }

        try {
            Class.forName("com.cj.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
        }
        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO user (firstName,lastName,email,password,phoneNo,type) VALUES ('%s','%s','%s','%s','%s','admin')", fName, lName, email, pass, phone);
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
//                getting id of added admin
                String query2 = String.format("SELECT id FROM user WHERE email='%s'", email);
                ResultSet resultSet = statement.executeQuery(query2);
                if (resultSet.next()) {

                    id = resultSet.getInt("id");

                    String query3 = String.format("INSERT INTO salary (employeeId,salary,datePaid) values (%d,%f,'%s')", id, salaryDouble,date_);
                    int rowsAffected2 = statement.executeUpdate(query3);
                    if (rowsAffected2 > 0) {
                        setMsg("ADMIN ADDED");
                        fetchAll();
                        connection.commit();
                    } else {
                        connection.rollback();
                    }

                } else {
                    connection.rollback();
                    setMsg("FAILED TO ADD ADMIN");
                    return;
                }
            } else {
                setMsg("FAILED TO ADD ADMIN");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            setMsg("FAILED TO ADD ADMIN");
        }
    }

    public void fetchAll() {
        tableView.getItems().clear();
        try {
            Class.forName("com.cj.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = String.format("SELECT user.*,salary.salary,salary.datePaid FROM user,salary WHERE user.id=salary.employeeId AND type='admin'");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fName = resultSet.getString("firstName");
                String lName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phoneNo");
                String type = resultSet.getString("type");
                Double salary = resultSet.getDouble("salary");
                String dateF=resultSet.getString("datePaid");

                tableView.getItems().add(new Model(id, fName, lName, email, phone, type, salary,dateF));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


}