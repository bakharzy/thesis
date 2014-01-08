package wad.moviedb.service;

import java.util.List;
import wad.moviedb.domain.Application;


public interface ApplicationService {
    
    Application add(String name);
    
    Application remove(Long id);
    
    Application update(Application application);
    
    Application read(Long id);
    
    List<Application> list();
    
    
}
