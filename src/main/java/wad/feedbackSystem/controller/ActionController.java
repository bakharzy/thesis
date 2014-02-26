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
    public Action addAction(@PathVariable Long appId, @RequestBody Action action) {
        return actionService.add(appId, action);
    }

    @RequestMapping(value = "applications/{appId}/actions/{actionId}", method = RequestMethod.DELETE)
    public String removeAction(@PathVariable Long appId, @PathVariable Long actionId) {
        return actionService.remove(appId, actionId);
    }

    @RequestMapping(value = "applications/{appId}/actions/{actionId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Action getAction(@PathVariable Long appId, @PathVariable Long actionId) {
        return actionService.read(appId, actionId);
    }

    @RequestMapping(value = "applications/{appId}/actions/show", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Action> listActions(@PathVariable Long appId) {
        return actionService.list(appId);
    }

    @RequestMapping(value = "applications/{appId}/actions", method = RequestMethod.GET)
    public String listActions(@PathVariable Long appId, Model model) {
        model.addAttribute("actions", actionService.list(appId));
        return "action";
    }

    @RequestMapping(value = "actions", method = RequestMethod.GET)
    public String redirectToActionPage() {
        return "action";
    }
}
