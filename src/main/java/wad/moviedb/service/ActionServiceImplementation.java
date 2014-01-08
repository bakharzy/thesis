package wad.moviedb.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wad.moviedb.domain.Action;
import wad.moviedb.domain.Application;
import wad.moviedb.repository.ActionRepository;
import wad.moviedb.repository.ApplicationRepository;

@Service
public class ActionServiceImplementation implements ActionService{
    
    @Autowired
    private ActionRepository actionRepository;
    
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    @Transactional(readOnly = false)
    public Action add(Long applicationId, Action action) {
        action.setApplicationId(applicationId);
//        How the actionId is set?
        return actionRepository.save(action);
    }

    @Override
    @Transactional(readOnly = false)
    public Action remove(Long applicationId, Long actionId) {
        Action actionToBeRemoved = actionRepository.findOne(actionId);
        actionRepository.delete(actionId);
        return actionToBeRemoved;
    }

//    @Override
//    @Transactional(readOnly = false)
//    public Action update(Long applicationId, Action action) {
//        // Do we need to first delete the action and save the new action?
//        // Do we need to find the action in application list and change the new one there?
//        return actionRepository.save(action);
//    }

    @Override
    @Transactional(readOnly = true)
    public Action read(Long applicationId, Long actionId) {
        return actionRepository.findOne(actionId);
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

//    @Override
//    @Transactional(readOnly = false)
//    public Action addActionCounter(Long applicationId, Long actionId) {
//        Action actionCounterToIncrement = actionRepository.findOne(actionId);
//        actionCounterToIncrement.IncerementCounter();
//        actionRepository.save(actionCounterToIncrement);
//        return actionCounterToIncrement;
//        
//    }
    
}
