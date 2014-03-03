package wad.feedbackSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import wad.feedbackSystem.domain.Application;
import wad.feedbackSystem.service.ApplicationService;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "applications", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Application addApplication(@RequestParam String name, @RequestParam String email ) {
        return applicationService.add(name, email);
    }

    @RequestMapping(value = "applications/{appId}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Application removeApplication(@PathVariable String appId) {
        return applicationService.remove(appId);
    }
    
    @RequestMapping(value = "applications/{appId}", method = RequestMethod.PUT, consumes="application/json", produces = "application/json")
    @ResponseBody
    public Application updateApplication(@RequestBody Application application) {
        return applicationService.update(application);
    }

    @RequestMapping(value = "applications/{appId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Application getApplication(@PathVariable String appId) {
        return applicationService.read(appId);
    }
// Below APIs are not exposed to users
    @RequestMapping(value = "applications/show", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Application> listApplicationsReturnJSON() {
        return applicationService.list();
    }
    
    @RequestMapping(value = "applications", method = RequestMethod.GET)
    public String ListApplicationsReturnJSP(Model model) {
        model.addAttribute("applications",applicationService.list());
        return "applications";
    }
}
