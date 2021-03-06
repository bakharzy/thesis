package wad.feedbackSystem.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.TimeZone;

@Document
public class Action implements Serializable {

    public Action() {

        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
        df.setTimeZone(tz);
        this.timeStamp = df.format(new Date());
    }
    @Id
    private String id;
    private String name;
    private String applicationId;
    private String timeStamp;
    private String username;
    private HashMap<String,String> options;


    

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
     * @return the applicationId
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * @param applicationId the applicationId to set
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the options
     */
    public HashMap<String,String> getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(HashMap<String,String> options) {
        this.options = options;
    }
    
    //    @Override
//        public String toString() {
//            final StringBuffer sb = new StringBuffer("Action{");
//            sb.append("id='").append(id).append('\'');
//            sb.append(", name='").append(name).append('\'');
//            sb.append(", applicationId='").append(applicationId).append('\'');
//            sb.append(", timeStamp='").append(timeStamp).append('\'');
//            sb.append(", username='").append(username).append('\'');
//            sb.append(", options=").append(options);
//            sb.append(", extra=").append(extra);
//            sb.append('}');
//            return sb.toString();
//        }

}
