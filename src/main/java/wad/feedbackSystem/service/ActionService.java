package wad.feedbackSystem.service;

import java.util.List;
import wad.feedbackSystem.domain.Action;


public interface ActionService {
    
  Action add(String applicationId, Action action);
  
  String remove(String applicationId, String actionId);
  
  Action read(String applicationId, String actionId);
  
  List<Action> list(String applicationId);
    
}
