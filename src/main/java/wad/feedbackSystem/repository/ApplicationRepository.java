package wad.feedbackSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.feedbackSystem.domain.Application;


public interface ApplicationRepository extends JpaRepository<Application, Long>{
    
}
