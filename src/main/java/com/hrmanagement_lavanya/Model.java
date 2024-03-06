package com.hrmanagement_lavanya;


public class Model {
    public int id;
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNo;
    public String type;
    public Double salary;
    public String datePaid;


    public Model(int id, String firstName, String lastName, String email, String phoneNo, String type, Double salary, String datePaid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.type = type;
        this.salary = salary;
        this.datePaid = datePaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDate() {
        return datePaid;
    }

    public void setDate(String date) {
        this.datePaid = date;
    }
}
