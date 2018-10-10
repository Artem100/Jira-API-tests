package json.authorization;

import json.Pojo;

public class Authorization implements Pojo {

    public String username;
    public String password;

    public Authorization(String username, String password){
        this.username=username;
        this.password=password;
    }
}
