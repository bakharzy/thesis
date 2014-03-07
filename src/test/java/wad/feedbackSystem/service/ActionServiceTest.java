/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.feedbackSystem.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.feedbackSystem.domain.Action;

/**
 *
 * @author mohi
 */
public class ActionServiceTest {
    
    ActionService actionService = new ActionServiceImplementation();

    public ActionServiceTest() {
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
    public void testObjectToJson() throws JsonProcessingException {

        Action action = new Action();
        action.setId("id");
        action.setUsername("username");
        action.setApplicationId("applicationId");
        action.setName("name");
        action.setTimeStamp("timestamp");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key", "value");
        map.put("key2", "value2");
        action.setOptions(map);

        ObjectMapper mapper = new ObjectMapper();

        String value = mapper.writeValueAsString(action);
        System.out.println(value);
    }

    @Test
    public void testJsonToObject() throws IOException {

        String json = "{\"id\":\"id\",\"name\":\"name\",\"applicationId\":\"applicationId\",\"timeStamp\":\"timestamp\",\"username\":\"username\",\"options\":{\"key\":\"value\", \"key2\":\"value2\"}}";

        ObjectMapper mapper = new ObjectMapper();

        Action value = mapper.readValue(json, Action.class);
        System.out.println(value);
    }

//    @Test
//    public void testActionObjectAdd() {
//        
//        Action action = new Action();
//        action.setId("id");
//        action.setUsername("username");
//        action.setApplicationId("applicationId");
//        action.setName("name");
//        action.setTimeStamp("timestamp");
//        action.setOptions("options");
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("key", "value");
//        map.put("key2", "value2");
//        action.setExtra(map);
//        Action returnedAction = actionService.add("applicationId", action);
//        assertEquals(action.getName(), returnedAction.getName());
//        
//    }
}
