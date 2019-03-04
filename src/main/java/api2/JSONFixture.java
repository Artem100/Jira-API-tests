package api2;

import json.authorization.LoginFields;
import json.issues.AddComment;
import json.issues.CreateIssue;
import json.issues.Fields;
import json.issues.JqlRequest;
import json.updatePriority.Priority;
import json.updatePriority.SetId;
import json.updatePriority.Update;
import json.updatePriority.UpdateFieldsPriority;


public class JSONFixture {

    //Class for generation data of json fields

    public static CreateIssue createDefaultIssue(String project, String summary, String typeIssue, String assignee){

        Fields fields = new Fields();
        fields.setAssigne(assignee);
        fields.setIssueType(typeIssue);
        fields.setProject(project);
        fields.setSummary(summary);

        CreateIssue createIssue = new CreateIssue(fields);
        return createIssue;
    }

    public static AddComment addComment(String comment){
        AddComment addComment = new AddComment();
        addComment.setComment(comment);

        return addComment;
    }

    public static UpdateFieldsPriority updatepriority(String id){
        SetId setId = new SetId(id);
        Priority priority = new Priority(setId);
        Update update = new Update();
        update.setPriority(priority);

        UpdateFieldsPriority updateFieldsPriority = new UpdateFieldsPriority(update);
        return  updateFieldsPriority;
    }

    public static JqlRequest findUseToJQL(String jql){
        JqlRequest jqlRequest = new JqlRequest(jql);
        return jqlRequest;
    }

    public static LoginFields loginToJira(String username, String password){
        LoginFields login = new LoginFields(username, password);
        return login;
    }





}
