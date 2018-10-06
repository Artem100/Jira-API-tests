package json.updatePriority;

import json.Pojo;

public class SetPriority implements Pojo {
     public String id;

     public SetPriority setId(String id){
         this.id=id;
         return this;
     }
}
