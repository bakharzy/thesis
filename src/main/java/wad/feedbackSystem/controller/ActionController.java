package wad.feedbackSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "applications/{appId}/actions", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Action addAction(@PathVariable String appId, @RequestBody Action action) {
        return actionService.add(appId, action);
    }

    @RequestMapping(value = "applications/{appId}/actions/{actionId}", method = RequestMethod.POST)
    public String removeAction(@PathVariable String appId, @PathVariable String actionId) {
        return actionService.remove(appId, actionId);
    }

    @RequestMapping(value = "applications/{appId}/actions/{actionId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Action getAction(@PathVariable String appId, @PathVariable String actionId) {
        return actionService.read(appId, actionId);
    }

    @RequestMapping(value = "applications/{appId}/actions", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Action> listActionsReturnJSON(@PathVariable String appId) {
        return actionService.list(appId);
    }
// Below APIs are not exposed to users
    @RequestMapping(value = "applications/{appId}/actions/show", method = RequestMethod.GET)
    public String listActionsReturnJSP(@PathVariable String appId, Model model) {
        model.addAttribute("actions", actionService.list(appId));
        return "action";
    }

    @RequestMapping(value = "actions", method = RequestMethod.GET)
    public String redirectToActionPage() {
        return "action";
    }
}
