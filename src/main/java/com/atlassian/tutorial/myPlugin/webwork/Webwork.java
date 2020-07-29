package com.atlassian.tutorial.myPlugin.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.atlassian.tutorial.myPlugin.dao.Impl.MyProjectDAOImpl;
import com.atlassian.tutorial.myPlugin.dao.Interface.MyProjectDAO;
import com.atlassian.tutorial.myPlugin.entity.MyProject;
import org.ofbiz.core.entity.GenericEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webwork.action.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Webwork extends JiraWebActionSupport {
    private static final Logger log = LoggerFactory.getLogger(Webwork.class);
    private MyProjectDAO myProjectDAO;
    private String key;
    private List<MyProject> myProjects;
    private final String SELECT_FORM = "select";
    private final String PROJECTS_FORM = "projects";

    public Webwork() {
        myProjectDAO = new MyProjectDAOImpl();
        myProjects = new ArrayList<>();
    }

    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        if (request.getMethod().equals("GET")) {
            return doGet();
        } else if (request.getMethod().equals("POST")) {
            return doPost();
        } else {
            log.warn("not supported request type");
            return SELECT_FORM;
        }
    }

    private String doGet() {
        return SELECT_FORM;
    }

    private String doPost() throws GenericEntityException {
        try {
            if (key.isEmpty()) {
                myProjects = myProjectDAO.getAll();
            } else {
                myProjects = new ArrayList<>();
                myProjects.add(myProjectDAO.getByKey(key));
            }
        } catch (IllegalArgumentException e) {
            log.warn(e.getMessage(), e);
            e.printStackTrace();
        }
        return PROJECTS_FORM;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<MyProject> getMyProjects() {
        return myProjects;
    }
}
