package wad.feedbackSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.feedbackSystem.domain.Action;


public interface ActionRepository extends JpaRepository<Action, Long> {
    
}
