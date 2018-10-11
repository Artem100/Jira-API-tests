package api2;

public interface JiraPath {

    String pageLogin = "/rest/auth/1/session/";
    String createmetadata = "/rest/api/2/issue/createmeta/";
    String pageIssue ="/rest/api/2/issue/";
    String searchIssue = "/rest/api/2/search/";
    String searchUser = "/rest/api/2/user/search?username=";
    String searchProject = "/rest/api/2/project/";
    String searchGroup = "/rest/api/2/groups/";

}
