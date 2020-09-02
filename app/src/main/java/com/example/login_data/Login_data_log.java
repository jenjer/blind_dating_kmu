package com.example.login_data;

public class Login_data_log {
    private static final Login_data_log login_data = new Login_data_log();
    public static Login_data_log get_login_data(){
        return login_data;
    }
    private Login_data_log(){
    }
    private String id;
    private String name;
    private String e_mail;

    public String getID(){
        return id;
    }
    public void setID(String id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setname(String id){
        this.name = name;
    }
    public String getE_mail(){
        return e_mail;
    }
    public void setE_mail(String e_mail){
        this.e_mail = e_mail;
    }
}
