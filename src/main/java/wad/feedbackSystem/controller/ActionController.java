package wad.feedbackSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.feedbackSystem.domain.Action;
import wad.feedbackSystem.service.ActionService;

@Controller
public class ActionController {
    
    @Autowired
    private ActionService actionService;
    
    @RequestMapping(value="applications/{appId}/actions", method = RequestMethod.POST)
    @ResponseBody
    public Action addAction(@PathVariable Long appId, @RequestBody Action action){
        return actionService.add(appId, action);
    }
    
    @RequestMapping(value="applications/{appId}/actions/{actionId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Action removeAction(@PathVariable Long appId, @PathVariable Long actionId){
        return actionService.remove(appId, actionId);
    }
    
//    @RequestMapping(value="applications/{appId}/actions/{actionId}", method = RequestMethod.PUT, consumes="application/json", produces = "application/json")
//    @ResponseBody
//    public Action updateAction(@PathVariable Long appId, @RequestBody Action action){
//        return actionService.update(appId, action);
//    }
    
    @RequestMapping(value="applications/{appId}/actions/{actionId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Action getAction(@PathVariable Long appId, @PathVariable Long actionId){
        return actionService.read(appId, actionId);
    }
    
    @RequestMapping(value="applications/{appId}/actions", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Action> listActions(@PathVariable Long appId){
        return actionService.list(appId);
    }
    
//    @RequestMapping(value="applications/{appId}/actions/{actionId}/+", method = RequestMethod.PUT, produces = "application/json")
//    @ResponseBody
//    public Action IncerementCounter(@PathVariable Long appId, @PathVariable Long actionId){
//        return actionService.addActionCounter(appId, actionId);
//    }
    
}