package wad.feedbackSystem.service;

import java.util.List;
import wad.feedbackSystem.domain.Action;


public interface ActionService {
    
  Action add(Long applicationId, Action action);
  
  Action remove(Long applicationId, Long actionId);
  
//  Action update(Long applicationId, Action action);
  
//  Action addActionCounter(Long applicationId, Long actionId);
  
  Action read(Long applicationId, Long actionId);
  
  List<Action> list(Long applicationId);
    
}