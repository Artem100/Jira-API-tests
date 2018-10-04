package json.issues;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields implements Pojo {

  public Project project;
  public String summary;
  @JsonProperty("issuetype")
  public IssueType issueType;
  public Assignee assignee;

  public Fields() {
  }

  public Fields setProject(String projectId) {
    this.project = new Project(projectId);
    return this;
  }

  public Fields setSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public Fields setIssueType(String issueTypeId) {
    this.issueType = new IssueType(issueTypeId);
    return this;
  }

  public Fields setAssigne(String assignee) {
    this.assignee = new Assignee(assignee);
    return this;
  }

}
