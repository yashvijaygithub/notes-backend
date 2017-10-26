package login.service;

import login.dao.LoginDetailsDao;
import login.model.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vijay on 28/9/17.
 */
@Service
public class LoginDetailsService {
    @Autowired
    LoginDetailsDao loginDetailsDao;

    public String create(String userName,String password) {

        LoginDetails loginDetails = findIfUserExits(userName);
        try {
            if(null == loginDetails) {
                loginDetails = new LoginDetails(userName, password);
                loginDetailsDao.save(loginDetails);
            } else{
                return "UserName " + userName + "  already exits";
            }

        } catch (Exception e) {
            return "Exception occured : " + e.getMessage();
        }
        return "UserName " + userName + " : Login details created";
    }

    public String updatePassword(String userName,String password){
        try{
            LoginDetails loginDetails = findIfUserExits(userName);
            if(null != loginDetails){
                if(loginDetails.getPassword().equalsIgnoreCase(password)) {
                    return "Password cannot be same";
                } else {
                    loginDetails.setPassword(password);
                    loginDetailsDao.save(loginDetails);
                }
            } else{
                return "UserName" + userName + "not found";
            }

        } catch (Exception e){
            return "Exception occured : "+e.getMessage();
        }
        return "Password updated for userName "+ userName +" successfully";
    }

    public List<LoginDetails> allDetails(){
        try{
            return (List<LoginDetails>) loginDetailsDao.findAll();
        } catch (Exception e){
            return null;
        }
    }

    public String delete(String userName){
        try{
            LoginDetails loginDetails = findIfUserExits(userName);
            if(null != loginDetails){
                loginDetailsDao.delete(loginDetails);
            } else{
                return "UserName" + userName + "not found";
            }
        } catch (Exception e){
            return "Exception occured : "+e.getMessage();
        }
        return "Deleted userName :" + userName + " successfully";
    }

    private LoginDetails findIfUserExits(String userName){
        LoginDetails loginDetails = loginDetailsDao.findByUserName(userName);
        if(null == loginDetails){
            return null;
        }
        if(loginDetails.getUserName().equalsIgnoreCase(userName)){
            return loginDetails;
        } else{
            return null;
            }
        }
}
