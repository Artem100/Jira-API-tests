package json.updatePriority;


import json.Pojo;

import java.util.ArrayList;

public class Update implements Pojo {
    public ArrayList<Object> priority =new ArrayList<Object>();

    public Update setPriority(Object set) {
        this.priority.add(set);
        return this;
    }
}
