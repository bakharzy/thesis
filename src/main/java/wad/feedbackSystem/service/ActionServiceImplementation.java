package wad.feedbackSystem.service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wad.feedbackSystem.domain.Action;

@Repository
public class ActionServiceImplementation implements ActionService {

    @Autowired
    private MongoTemplate mongoTemplate;
    public static final String COLLECTION_NAME = "action";

    @Override
    @Transactional(readOnly = false)
    public Action add(String applicationId, Action action) {
        if (!mongoTemplate.collectionExists(Action.class)) {
            mongoTemplate.createCollection(Action.class);
        }
        Action newAction = new Action();
        newAction.setId(UUID.randomUUID().toString());
        newAction.setApplicationId(applicationId);
        newAction.setName(action.getName());
        newAction.setOptions(action.getOptions());
        newAction.setUsername(action.getUsername());
        mongoTemplate.insert(newAction, COLLECTION_NAME);
        return newAction;
    }

    @Override
    @Transactional(readOnly = false)
    public String remove(String applicationId, String actionId) {
        Action actionToBeRemoved = mongoTemplate.findById(actionId, Action.class, COLLECTION_NAME);
        if (actionToBeRemoved.getApplicationId().equals(applicationId)) {
            mongoTemplate.remove(actionToBeRemoved, COLLECTION_NAME);
            return "Action has been removed successfully!";
        }
        return "This action does not exists or you do not have permission for removal!";
    }

    @Override
    @Transactional(readOnly = true)
    public Action read(String applicationId, String actionId) {
        Action actionToBeReturned = mongoTemplate.findById(actionId, Action.class, COLLECTION_NAME);
        if (actionToBeReturned == null) {
            return null;
        }
        if (actionToBeReturned.getApplicationId().equals(applicationId)) {
            return actionToBeReturned;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Action> list(String applicationId) {
        List<Action> wantedList = new LinkedList<Action>();
        List<Action> allActions = mongoTemplate.findAll(Action.class, COLLECTION_NAME);
        for (Action action : allActions) {
            if (action.getApplicationId().equals(applicationId)) {
                wantedList.add(action);
            }
        }

        return wantedList;
    }

}
