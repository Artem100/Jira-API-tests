package json.issues;

import json.Pojo;

public class Issue implements Pojo {
    public Fields fields;

    public Issue(Fields fields) {
        this.fields = fields;
    }
}
