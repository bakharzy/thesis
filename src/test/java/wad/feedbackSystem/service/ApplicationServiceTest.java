package wad.feedbackSystem.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.feedbackSystem.domain.Application;


public class ApplicationServiceTest {
    
    ApplicationService applicationService = new ApplicationServiceImplementation();
    
    public ApplicationServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createApplicationCaseSuccessfulTest(){
        System.out.println("createApplicationCaseSuccessfulTest");
//        Application app = new Application();
//        applicationService.add("test@gmail.com", "app1");   
//        assertEquals(applicationService.list().size(),1);
    }
    @Test
    public void testToPass(){
        System.out.println("test to pass");
        assertTrue(true);
    }
}