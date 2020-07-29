package com.atlassian.tutorial.myPlugin.dao.Impl;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.AttachmentManager;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.project.ProjectManager;
import com.atlassian.tutorial.myPlugin.dao.Interface.MyProjectDAO;
import com.atlassian.tutorial.myPlugin.entity.MyIssue;
import com.atlassian.tutorial.myPlugin.entity.MyProject;
import org.ofbiz.core.entity.GenericEntityException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyProjectDAOImpl implements MyProjectDAO {


    private IssueManager issueManager;
    private AttachmentManager attachmentManager;
    private ProjectManager projectManager;

    public MyProjectDAOImpl() {
        this.issueManager = ComponentAccessor.getIssueManager();
        this.attachmentManager = ComponentAccessor.getAttachmentManager();
        this.projectManager = ComponentAccessor.getProjectManager();
    }

    @Override
    public List<MyProject> getAll() throws GenericEntityException {
        List<MyProject> myProjects = new ArrayList<>();
        List<Project> projects = projectManager.getProjects();
        if (projects == null) {
            throw new IllegalArgumentException("No projects in the environment");
        }
        for (Project project : projects) {
            MyProject myProject = getFromProject(project);
            myProjects.add(myProject);
        }
        return myProjects;
    }

    @Override
    public MyProject getByKey(String key) throws GenericEntityException {
        Project project = projectManager.getProjectObjByKey(key);
        if (project == null) {
            throw new IllegalArgumentException("Key not found");
        }
        return getFromProject(project);
    }

    private List<Issue> getIssues(Project project) throws GenericEntityException {
        List<Issue> issues = new ArrayList<>();
        Collection<Long> issuesId = issueManager.getIssueIdsForProject(project.getId());
        for (Long id : issuesId) {
            issues.add(issueManager.getIssueObject(id));
        }
        return issues;
    }

    private MyProject getFromProject(Project project) throws GenericEntityException {
        MyProject myProject = new MyProject(project.getId());
        List<Issue> issues = getIssues(project);
        for (Issue issue : issues) {
            MyIssue myIssue = getFromIssue(issue);
            myProject.addIssue(myIssue);
        }
        myProject.setKey(project.getKey());
        return myProject;

    }

    private MyIssue getFromIssue(Issue issue) {
        MyIssue myIssue = new MyIssue(issue.getId());
        myIssue.setAttachments(attachmentManager.getAttachments(issue));
        myIssue.setKey(issue.getKey());
        return myIssue;
    }
}
