package com.example.demo;

public class User {
    int id;
    String username;
    String password;
    int age;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.id = 0;
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

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean checkPassword(String pass){
        if(pass.equals(this.password)){
            return true;
        }
        return false;
    }
}
