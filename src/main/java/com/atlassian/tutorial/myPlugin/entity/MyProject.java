package com.atlassian.tutorial.myPlugin.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains Id, Key and List of {@link com.atlassian.jira.issue.Issue} for a {@link com.atlassian.jira.project.Project}.
 * Atlassian {@link com.atlassian.jira.project.Project} class does not allow extract its Issues directly from a Project object
 */

public class MyProject {
    private Long id;
    private String key;
    private List<MyIssue> issues;

    public MyProject(Long id) {
        this.id = id;
        issues = new ArrayList<>();
    }

    public void addIssue(MyIssue myIssue) {
        issues.add(myIssue);
    }

    public Long getId() {
        return id;
    }

    public List<MyIssue> getIssues() {
        return issues;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
