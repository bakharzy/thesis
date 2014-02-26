package wad.feedbackSystem.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.feedbackSystem.domain.Action;
import wad.feedbackSystem.repository.ActionRepository;


@Service
public class ActionServiceImplementation implements ActionService{
    
    @Autowired
    private ActionRepository actionRepository;
    
    @Override
    @Transactional(readOnly = false)
    public Action add(Long applicationId, Action action) {
        Date date = new Date();
        Action newAction = new Action();
        newAction.setApplicationId(applicationId);
        newAction.setName(action.getName());
        newAction.setOptions(action.getOptions());
        newAction.setTimeStamp(date);
        newAction.setUsername(action.getUsername());
        return actionRepository.save(newAction);
    }

    @Override
    @Transactional(readOnly = false)
    public String remove(Long applicationId, Long actionId) {
        Action actionToBeRemoved = actionRepository.findOne(actionId);
        if(actionToBeRemoved.getApplicationId() == applicationId ){
            actionRepository.delete(actionId);
            return "Action has been removed successfully!";
        }
        return "This action does not exists or you do not have permission for removal!";
    }


    @Override
    @Transactional(readOnly = true)
    public Action read(Long applicationId, Long actionId) {
        Action actionToBeReturned = actionRepository.findOne(actionId);
        if(actionToBeReturned == null){
            return null;
        }
        if(actionToBeReturned.getApplicationId() == applicationId){
            return actionToBeReturned;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Action> list(Long applicationId) {
        List<Action> wantedList = new LinkedList<Action>();
        List<Action> allActions = actionRepository.findAll();
        for(Action action: allActions){
            if(action.getApplicationId() == applicationId){
                wantedList.add(action);
            }
        }
        
        return wantedList;
    }

    
}
