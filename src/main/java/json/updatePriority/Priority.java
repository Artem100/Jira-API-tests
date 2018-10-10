package json.updatePriority;

import json.Pojo;



public class Priority implements Pojo {

    public SetId set;

    public Priority set(String set)
    { this.set = new SetId(set);
        return this;}

}
