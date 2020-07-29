package com.atlassian.tutorial.myPlugin.servlet;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.tutorial.myPlugin.dao.Impl.MyProjectDAOImpl;
import com.atlassian.tutorial.myPlugin.dao.Interface.MyProjectDAO;
import com.atlassian.tutorial.myPlugin.entity.MyProject;
import com.atlassian.velocity.VelocityManager;
import org.ofbiz.core.entity.GenericEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(MyProject.class);
    private VelocityManager velocityManager;
    private final String TEMPLATE_PATH = "/templates/";
    private final String TEMPLATE_PROJECTS = "projects.vm";
    private final String TEMPLATE_SELECT_SERVER = "select_servlet.vm";

    public MyServlet() {
        this.velocityManager = ComponentAccessor.getVelocityManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = this.velocityManager.getEncodedBody(TEMPLATE_PATH, TEMPLATE_SELECT_SERVER, "UTF-8", new HashMap<>());
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(content);
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyProjectDAO myProjectDAO = new MyProjectDAOImpl();
        Map<String, Object> context = new HashMap<>();
        List<MyProject> myProjects = new ArrayList<>();
        String key = req.getParameter("key");
        try {
            if (key.isEmpty()) {
                myProjects = myProjectDAO.getAll();
            } else {
                myProjects.add(myProjectDAO.getByKey(key));
            }
        } catch (GenericEntityException | IllegalArgumentException e) {
            log.warn(e.getMessage(), e);
            e.printStackTrace();
        }
        context.put("myProjects", myProjects);
        String content = this.velocityManager.getEncodedBody(TEMPLATE_PATH, TEMPLATE_PROJECTS, "UTF-8", context);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(content);
        resp.getWriter().close();
    }
}