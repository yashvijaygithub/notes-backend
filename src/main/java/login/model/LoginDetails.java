package login.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by vijay on 28/9/17.
 */

@Entity
@Table(name = "LoginDetails")
public class LoginDetails {
    @Id
    private String userName;
    @NotNull
    private String password;

    public LoginDetails(){

    }

    public LoginDetails(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
