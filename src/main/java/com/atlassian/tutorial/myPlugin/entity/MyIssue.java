package com.atlassian.tutorial.myPlugin.entity;

import com.atlassian.jira.issue.attachment.Attachment;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains Id, Key and List of {@link Attachment} for an {@link com.atlassian.jira.issue.Issue}.
 * Atlassian {@link com.atlassian.jira.issue.Issue} class does not allow extract attachments directly from an Issue object
 */
public class MyIssue {
    private Long id;
    private String key;
    private List<Attachment> attachments;

    public MyIssue(Long id) {
        this.id = id;
        attachments = new ArrayList<>();
    }

    public void addAttachment(Attachment attachment) {
        attachments.add(attachment);
    }

    public Long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
