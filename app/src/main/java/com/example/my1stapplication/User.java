package com.example.my1stapplication;

public class User {
    String username;
    String password;
    String phone;
    String name;
    String email;
    long time;

    public User(String displayName, String userEmail, String password, long time){
name=displayName;
email=userEmail;
this.password=password;
this.time=time;
    }

    public User(String username, String name, String email,String password, long time, String phone){
        this.username=username;
        this.password=password;
        this.phone=phone;
        this.name=name;
        this.email=email;
        this.time=time;
    }

    public String getPassword() {
        return password;
    }
    public String getUsername(){
        return username;
    }
    public String getPhone() { return phone; }
    public String getName() { return name; }
    public long getTime() { return time; }
    public String getEmail() { return email; }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPhone(String phone) { this.phone = phone; }
    public void setName(String name) { this.name = name; }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

