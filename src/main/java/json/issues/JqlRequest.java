package json.issues;

import json.Pojo;

public class JqlRequest implements Pojo {

    public String jql;

    public JqlRequest setJqlRequest(String jql){
        this.jql=jql;
        return this;
    }
}
