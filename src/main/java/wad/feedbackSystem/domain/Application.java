package wad.feedbackSystem.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Application implements Serializable {
    
    @Id
    private String id;
    
    private String name;
   
    private String email;
    
    private Long queryLimit;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
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
