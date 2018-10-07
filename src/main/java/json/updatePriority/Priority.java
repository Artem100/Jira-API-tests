package json.updatePriority;

import json.Pojo;



public class Priority implements Pojo {

    public SetId setId;

    public Priority set(String set)
    { this.setId = new SetId(set);
        return this;}

}
