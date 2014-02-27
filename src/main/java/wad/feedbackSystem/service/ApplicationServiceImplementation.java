package wad.feedbackSystem.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wad.feedbackSystem.domain.Action;
import wad.feedbackSystem.domain.Application;
import static wad.feedbackSystem.service.ActionServiceImplementation.COLLECTION_NAME;

@Repository
public class ApplicationServiceImplementation implements ApplicationService {

    @Autowired
    private MongoTemplate mongoTemplate;
    public static final String COLLECTION_NAME = "application";

    @Override
    @Transactional(readOnly = false)
    public Application add(String name, String email) {
        if (!mongoTemplate.collectionExists(Application.class)) {
            mongoTemplate.createCollection(Application.class);
        }

        Application newApplication = new Application();
        newApplication.setName(name);
        newApplication.setEmail(email);
        newApplication.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(newApplication, COLLECTION_NAME);
        return newApplication;
    }

    @Override
    @Transactional(readOnly = false)
    public Application remove(String id) {

        Application toBeDeletedApp = mongoTemplate.findById(id, Application.class, COLLECTION_NAME);
        List<Action> allActions = mongoTemplate.findAll(Action.class, "action");
        for (Action action : allActions) {
            if (action.getApplicationId().equals(id)) {
                mongoTemplate.remove(action, "action");
            }
        }
        mongoTemplate.remove(toBeDeletedApp, COLLECTION_NAME);
        return toBeDeletedApp;
    }

    @Override
    @Transactional(readOnly = false)
    public Application update(Application application) {
        mongoTemplate.insert(application, COLLECTION_NAME);
        return application;
    }

    @Override
    @Transactional(readOnly = true)
    public Application read(String id) {
        return mongoTemplate.findById(id, Application.class, COLLECTION_NAME);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Application> list() {
        return mongoTemplate.findAll(Application.class, COLLECTION_NAME);
    }
}
