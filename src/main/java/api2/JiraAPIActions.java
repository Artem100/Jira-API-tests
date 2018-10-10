package api2;

import io.restassured.response.ValidatableResponse;
import json.authorization.LoginFields;
import json.issues.AddComment;
import json.issues.CreateIssue;
import json.issues.JqlRequest;
import json.updatePriority.UpdateFieldsPriority;

public class JiraAPIActions {

    public static ValidatableResponse login (LoginFields loginFields){
        return HTTPRequestSender.post(JiraPath.pageLogin, loginFields);
    }

    public static ValidatableResponse searchIssueJql(JqlRequest jqlRequest) {
        return HTTPRequestSender.post(JiraPath.searchIssue, jqlRequest);
    }

    public static ValidatableResponse createIssue(CreateIssue issuePOJO) {
        return HTTPRequestSender.post(JiraPath.pageIssue, issuePOJO);
    }

    public static ValidatableResponse addComment(AddComment comment, String issueId){
        return HTTPRequestSender.post(JiraPath.pageIssue + issueId + "/comment/", comment);
    }

    public static ValidatableResponse infoIssue(String issueId){
        return HTTPRequestSender.get(JiraPath.pageIssue + issueId);
    }

    public static ValidatableResponse updatePriority(UpdateFieldsPriority updateFieldsPriority, String issueId){
        return HTTPRequestSender.put(JiraPath.pageIssue + issueId, updateFieldsPriority);
    }

    public static ValidatableResponse getPriority(String issueId){
        return HTTPRequestSender.get(JiraPath.pageIssue + issueId);
    }

    public static ValidatableResponse searchIssueJQL(JqlRequest jql){
        return HTTPRequestSender.post(JiraPath.searchIssue, jql);
    }

    public static ValidatableResponse getUser(String userId){
        return HTTPRequestSender.get(JiraPath.searchUser + userId);
    }

    public static ValidatableResponse getGroup(String groupId){
        return HTTPRequestSender.get(JiraPath.searchGroup + groupId);
    }

    public static ValidatableResponse getProject(String projectId){
        return HTTPRequestSender.get(JiraPath.searchProject + projectId);
    }

    public static ValidatableResponse deleteIssue(String issueId) {
        return HTTPRequestSender.delete(JiraPath.pageIssue + issueId);
    }

}
