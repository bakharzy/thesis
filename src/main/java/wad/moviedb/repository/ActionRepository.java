package wad.moviedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.moviedb.domain.Action;


public interface ActionRepository extends JpaRepository<Action, Long> {
    
}
