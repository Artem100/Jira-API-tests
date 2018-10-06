package json.login;

import json.Pojo;

public class Login implements Pojo {

    public String username;
    public String password;

    public Login(){}

    public Login setLogin(String username){
        this.username=username;
        return this;
    }

    public Login setPassword(String password){
        this.password=password;
        return this;
    }
}
