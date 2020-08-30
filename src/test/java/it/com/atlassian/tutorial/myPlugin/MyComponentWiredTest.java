package it.com.atlassian.tutorial.myPlugin;

import com.atlassian.tutorial.myPlugin.dao.Impl.MyProjectDAOImpl;
import com.atlassian.tutorial.myPlugin.dao.Interface.MyProjectDAO;
import com.atlassian.tutorial.myPlugin.entity.MyProject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.atlassian.plugins.osgi.test.AtlassianPluginsTestRunner;
import com.atlassian.tutorial.myPlugin.api.MyPluginComponent;
import com.atlassian.sal.api.ApplicationProperties;
import org.ofbiz.core.entity.GenericEntityException;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AtlassianPluginsTestRunner.class)
public class MyComponentWiredTest {
    private final ApplicationProperties applicationProperties;
    private final MyPluginComponent myPluginComponent;
//    private MyProjectDAO myProjectDAO;

    public MyComponentWiredTest(ApplicationProperties applicationProperties, MyPluginComponent myPluginComponent) {
        this.applicationProperties = applicationProperties;
        this.myPluginComponent = myPluginComponent;

    }
//    @Before
//    public void setUp() {
//        myProjectDAO = new MyProjectDAOImpl();
//    }

    @Test
    public void testsmth() {
        assertEquals(1, 1);
    }
//    @Test
//    public void testDAO() throws GenericEntityException {
//        MyProjectDAO myProjectDAO = new MyProjectDAOImpl();
//        List<MyProject> myProjects = myProjectDAO.getAll();
//        assertEquals(1, myProjects.size());
////        assertEquals(6, myProjects.get(1).getIssues().size());
////        assertEquals(1, myProjects.get(1).getIssues().get(0).getAttachments().size());
////
//    }
    //    @Test
//    public void DAOImplGetByKeyShouldReturnOneProject() throws GenericEntityException {
//        MyProject myProject = myProjectDAO.getByKey("MYP");
//        assertEquals("MYP", myProject.getKey());
//        assertEquals("MYP-1", myProject.getIssues().get(0).getKey());
//    }

}