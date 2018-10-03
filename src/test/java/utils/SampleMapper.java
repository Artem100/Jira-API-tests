package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.issues.Fields;
import json.issues.Issue;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SampleMapper {

    @Test
    public void testMapper(){

    ObjectMapper mapper = new ObjectMapper();

    Fields fields = new Fields();
    fields.setAssigne("Artem Stolbtsov");
    fields.setIssueType("Bug");
    fields.setProject("QAAUT6");
    fields.setSummary("Issue summary from the Automation Test");

        Issue issue = new Issue(fields);

        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(issue);
            try {
                mapper.writeValue(new File("/Users/macbook/Documents/Hillel/pojo_jackson_sample/test.json"), issue);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonInString);


    }
}
