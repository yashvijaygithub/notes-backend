package login.controller;

import login.model.LoginDetails;
import login.service.LoginDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vijay on 28/9/17.
 */
@RestController
public class LoginDetailsController {

    @Autowired
    LoginDetailsService loginDetailsService;

    @RequestMapping("/")
    public String welcome(){
        return "Welcome message";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String userName, @RequestParam String password){
        String message = "";
        try{
            message = loginDetailsService.create(userName,password);
        } catch (Exception e){
        }
        return message;
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(@RequestParam String userName,@RequestParam String password){
        String message = "";
        try{
            message = loginDetailsService.updatePassword(userName,password);
        } catch (Exception e){

        }
        return message;
    }

    @RequestMapping("/getLoginDetails")
    public List<LoginDetails> allDetails(){
        List<LoginDetails> loginDetails = null;
        try{
            loginDetails = loginDetailsService.allDetails();
        } catch (Exception e){

        }
        return loginDetails;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String userName){
        String message = "";
        try{
            message = loginDetailsService.delete(userName);
        } catch (Exception e){

        }
        return message;
    }
}
