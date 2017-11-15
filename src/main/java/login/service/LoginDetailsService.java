package login.service;

import login.dao.LoginDetailsDao;
import login.dto.UserDto;
import login.model.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijay on 28/9/17.
 */
@Service
public class LoginDetailsService {
    @Autowired
    LoginDetailsDao loginDetailsDao;

   public List<LoginDetails> allDetails(){
        try{
            return loginDetailsDao.findAll();
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


    public String createNewUser(UserDto userDto) {
        String userName = userDto.getUserName();
        LoginDetails loginDetails = findIfUserExits(userName);
        try {
            if(null == loginDetails) {
                loginDetails = new LoginDetails(userDto);
                loginDetailsDao.save(loginDetails);
            } else {
                return "UserName " + userName + "  already exits";
            }
        } catch (Exception e) {
            return "Exception occured : " + e.getMessage();
        }
        return "UserName " + userName + " : Login details created";
    }

    public String updatePassword(UserDto userDto){
        String userName = userDto.getUserName();
        String newPassword = userDto.getPassword();
        try{
            LoginDetails loginDetails = findIfUserExits(userName);
            if(null != loginDetails){
                if(loginDetails.getPassword().equalsIgnoreCase(newPassword)) {
                    return "Password cannot be same";
                } else {
                    loginDetails.setPassword(newPassword);
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

}
