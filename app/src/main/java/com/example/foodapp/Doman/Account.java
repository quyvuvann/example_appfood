package com.example.foodapp.Doman;

public class Account {
    public int Id;
    public String user;
    public String password;
    public String email;
    public int phanquyen;

    public Account(String user, String email) {
        this.user = user;
        this.email = email;
    }

    public Account(String user, String password, String email, int phanquyen) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.phanquyen = phanquyen;
    }

    public Account(int id, String user, String password, String email, int phanquyen) {
        Id = id;
        this.user = user;
        this.password = password;
        this.email = email;
        this.phanquyen = phanquyen;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhanquyen() {
        return phanquyen;
    }

    public void setPhanquyen(int phanquyen) {
        this.phanquyen = phanquyen;
    }
}
