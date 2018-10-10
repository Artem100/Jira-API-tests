package json.authorization;

import json.Pojo;

public class LoginFields implements Pojo {

    public String username;
    public String password;

    public LoginFields(String username, String password){
        this.username=username;
        this.password=password;
    }
}
