package wad.feedbackSystem.service;

import java.util.List;
import wad.feedbackSystem.domain.Application;


public interface ApplicationService {
    
    Application add(String name, String email);
    
    Application remove(Long id);
    
    Application update(Application application);
    
    Application read(Long id);
    
    List<Application> list();
    
    
}
