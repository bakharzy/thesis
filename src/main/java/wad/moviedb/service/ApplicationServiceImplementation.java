package wad.moviedb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.moviedb.domain.Application;
import wad.moviedb.repository.ApplicationRepository;

@Service
public class ApplicationServiceImplementation implements ApplicationService{
    
    @Autowired
    private ApplicationRepository applicationsRepository;

    @Override
    @Transactional(readOnly = false)
    public Application add(String name) {
        Application newApplication = new Application();
        newApplication.setName(name);
        applicationsRepository.save(newApplication);
        return newApplication;
    }

    @Override
    @Transactional(readOnly = false)
    public Application remove(Long id) {
        Application toBeDeletedApp = applicationsRepository.findOne(id);
        applicationsRepository.delete(id);
        return toBeDeletedApp;
    }

    @Override
    @Transactional(readOnly = false)
    public Application update(Application application) {
        applicationsRepository.save(application);
        return application;
    }

    @Override
    @Transactional(readOnly = true)
    public Application read(Long id) {
        return applicationsRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Application> list() {
        return applicationsRepository.findAll();
    }
    
}
