package ut.com.atlassian.tutorial.jira.webwork;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @since 3.5
 */
public class WebworTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {
    }

    @Test(expected = Exception.class)
    public void testSomething() throws Exception {
        //MyWebWorkAction testClass = new MyWebWorkAction();
        throw new Exception("MyWebWorkAction has no tests!");

    }

}
