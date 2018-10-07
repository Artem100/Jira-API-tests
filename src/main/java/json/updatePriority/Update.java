package json.updatePriority;


import json.Pojo;

import java.util.ArrayList;

public class Update implements Pojo {
    public ArrayList<Priority> priority = new ArrayList<Priority>();

    public Update setPriority(Priority set) {
        this.priority.add(set);
        return this;
    }
}
