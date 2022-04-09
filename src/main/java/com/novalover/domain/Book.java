package com.novalover.domain;

public class Book {

    private int id;
    private String username;
    private String password;
    private String Email;

    public Book(){

    }

    public Book(int id, String userName, String passWord, String email) {
        this.id = id;
        username = userName;
        password = passWord;
        Email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", UserName='" + username + '\'' +
                ", PassWord='" + password + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
