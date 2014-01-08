package wad.moviedb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="APPLICATION")
public class Application implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
   
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="QUERYLIMIT")
    private Long queryLimit;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the queryLimit
     */
    public Long getQueryLimit() {
        return queryLimit;
    }

    /**
     * @param queryLimit the queryLimit to set
     */
    public void setQueryLimit(Long queryLimit) {
        this.queryLimit = queryLimit;
    }
    
    
    
    
}
