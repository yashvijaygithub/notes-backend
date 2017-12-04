package notes.dto;

import java.util.Date;

/**
 * Created by vijay on 13/11/17.
 */
public class UserNotesDto {
    private String id;
    private String userName;
    private String text;
    private Date dateFromClient;
    private String createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDateFromClient() {
        return dateFromClient;
    }

    public void setDateFromClient(Date dateFromClient) {
        this.dateFromClient = dateFromClient;
    }
}
