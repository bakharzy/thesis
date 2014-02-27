package wad.feedbackSystem.service;

import java.util.List;
import wad.feedbackSystem.domain.Application;


public interface ApplicationService {
    
    Application add(String name, String email);
    
    Application remove(String id);
    
    Application update(Application application);
    
    Application read(String id);
    
    List<Application> list();
    
    
}
