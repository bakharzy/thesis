package wad.feedbackSystem.service;

import java.util.List;
import wad.feedbackSystem.domain.Action;


public interface ActionService {
    
  Action add(Long applicationId, Action action);
  
  String remove(Long applicationId, Long actionId);
  
  Action read(Long applicationId, Long actionId);
  
  List<Action> list(Long applicationId);
    
}
