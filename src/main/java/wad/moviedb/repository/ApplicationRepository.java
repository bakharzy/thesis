package wad.moviedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.moviedb.domain.Application;


public interface ApplicationRepository extends JpaRepository<Application, Long>{
    
}
