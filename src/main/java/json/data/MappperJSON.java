package json.data;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.issues.Fields;
import json.issues.Issue;

import java.io.File;
import java.io.IOException;

public class MappperJSON {

    ObjectMapper mapper = new ObjectMapper();

    public void cteateIssue(){

        Fields fields = new Fields();
        fields.setAssigne("Artem Stolbtsov");
        fields.setIssueType("Bug");
        fields.setProject("QAAUT6");
        fields.setSummary("Issue summary from the Automation Test");
        Issue issue = new Issue(fields);

        try {
            String jsonInString = mapper.writeValueAsString(issue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
