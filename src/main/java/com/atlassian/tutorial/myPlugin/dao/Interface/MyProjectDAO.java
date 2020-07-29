package com.atlassian.tutorial.myPlugin.dao.Interface;

import com.atlassian.tutorial.myPlugin.entity.MyProject;
import org.ofbiz.core.entity.GenericEntityException;

import java.util.List;

/**
 * Methods return {@link MyProject} or List of {@link MyProject} with filled data about {@link com.atlassian.jira.issue.Issue}
 * and their {@link com.atlassian.jira.issue.attachment.Attachment}
 */
public interface MyProjectDAO {

    List<MyProject> getAll() throws GenericEntityException;

    MyProject getByKey(String key) throws GenericEntityException;
}
