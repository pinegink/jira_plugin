package ut.com.atlassian.tutorial.myPlugin.dao.Impl;

import com.atlassian.jira.issue.AttachmentManager;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.MutableIssue;
import com.atlassian.jira.issue.attachment.Attachment;
import com.atlassian.jira.junit.rules.AvailableInContainer;
import com.atlassian.jira.junit.rules.MockComponentContainer;
import com.atlassian.jira.mock.issue.MockIssue;
import com.atlassian.jira.mock.ofbiz.MockGenericValue;
import com.atlassian.jira.project.MockProject;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.project.ProjectManager;
import com.atlassian.tutorial.myPlugin.dao.Impl.MyProjectDAOImpl;
import com.atlassian.tutorial.myPlugin.dao.Interface.MyProjectDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.ofbiz.core.entity.GenericEntityException;
import org.ofbiz.core.entity.GenericValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MyProjectDAOImplTest {
//    @Rule public MockComponentContainer container = new MockComponentContainer(this);
//    @Mock @AvailableInContainer private ProjectManager projectManager;
//    @Mock @AvailableInContainer private IssueManager issueManager;
//    @Mock @AvailableInContainer private AttachmentManager attachmentManager;

//    @Mock private Project project;
//    @Mock private Issue issue; // мб его нужно будет переделать в MutableIssue
//    @Mock private Attachment attachment;

//    private MockProject mockProject;
//    private  MockIssue mockIssue;
//    private Attachment attachment;

//    @Before
//    public void setup() throws GenericEntityException {
//        when(projectManager.getProjectObjByKey("MYP")).thenReturn(project);
//        when(project.getId()).thenReturn((long) 1);
//        List<Long> issuesId = new ArrayList<>();
//        issuesId.add(1L);
//        when(issueManager.getIssueIdsForProject(1L)).thenReturn(issuesId);
//        List<Issue> issues = new ArrayList<>();
//        issues.add(issue);
//        when(issueManager.getIssueObject(1L)).thenReturn((MutableIssue) issue);
//        when(issue.getId()).thenReturn(1L);
//        List<Attachment> attachments = new ArrayList<>();
//        attachments.add(attachment);
//        when(attachmentManager.getAttachments(any())).thenReturn(attachments);
//        when(issue.getKey()).thenReturn("MYP-1");
//
//    }
//    @Before
//    public void setup() throws GenericEntityException {
//        mockProject = new MockProject();
//        mockIssue = new MockIssue();
////        attachment = new Attachment(issueManager, new MockGenericValue());
//
//        mockProject.setId(1L);
//        mockProject.setKey("MYP");
//        mockIssue.setId(1L);
//        mockIssue.setKey("MYP-1");
//
//        List<Project> projects = new ArrayList<>();
//        List<Issue> issues = new ArrayList<>();
//        List<Attachment> attachments = new ArrayList<>();
//        List<Long> issuesId = new ArrayList<>();
//        projects.add(mockProject);
//        issues.add(mockIssue);
////        attachments.add(attachment);
//        issuesId.add(1L);

//        when(projectManager.getProjects()).thenReturn(projects);
//        when(projectManager.getProjectObjByKey("MYP")).thenReturn(mockProject);
//        when(issueManager.getIssueIdsForProject(mockProject.getId())).thenReturn(issuesId);
//        when( issueManager.getIssueObject(anyLong())).thenReturn(new MockIssue());
//        when(attachmentManager.getAttachments(mockIssue)).thenReturn(attachments);
//    }
    @Test
    public void tes () throws GenericEntityException {
        assertEquals(1,1);
//        MyProjectDAO myProjectDAO = new MyProjectDAOImpl();
//        assertEquals("MYP", myProjectDAO.getByKey("MYP").getKey());
    }
}
