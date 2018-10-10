package json.issues;

import json.Pojo;

public class AddComment implements Pojo {
    public String body;

    public AddComment setComment(String body) {
        this.body = body;
        return this;
    }
}
