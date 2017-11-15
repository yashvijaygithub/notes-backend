package login.controller;

import login.dto.ResponseDto;
import login.dto.UserDto;
import login.model.LoginDetails;
import login.service.LoginDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vijay on 28/9/17.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginDetailsController {

    private static final String SUCCESS = "Success";
    private static final String FAILURE = "Failure";

    @Autowired
    LoginDetailsService loginDetailsService;

    @RequestMapping(value="/api", method = RequestMethod.GET)
    public ResponseEntity<String> welcome(){
        return new ResponseEntity<>("Welcome message from SpringBoot", HttpStatus.OK);
    }

    @RequestMapping(value="/api/create", method = RequestMethod.POST)
    public ResponseDto create(@RequestBody UserDto userDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            String message = loginDetailsService.createNewUser(userDto);
            responseDto.setStatus(SUCCESS);
            responseDto.setMessage(message);
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }

    @RequestMapping(value="/api/updatePassword", method = RequestMethod.PUT)
    public ResponseDto updatePassword(@RequestBody UserDto userDto){
        ResponseDto responseDto = new ResponseDto();
        try{
            String message = loginDetailsService.updatePassword(userDto);
            responseDto.setStatus(SUCCESS);
            responseDto.setMessage(message);
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }

    @RequestMapping(value="/api/getLoginDetails", method = RequestMethod.GET)
    public ResponseDto allDetails(){
        ResponseDto responseDto = new ResponseDto();
        try{
            List<LoginDetails> loginDetails = loginDetailsService.allDetails();
            responseDto.setStatus(SUCCESS);
            responseDto.setResponseData(loginDetails);
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }

    @RequestMapping(value="/api/delete", method = RequestMethod.DELETE)
    public ResponseDto delete(@RequestParam String userName){
        ResponseDto responseDto = new ResponseDto();
        try{
            String message = loginDetailsService.delete(userName);
            responseDto.setStatus(SUCCESS);
            responseDto.setMessage(message);
        } catch (Exception e){
            responseDto.setStatus(FAILURE);
            responseDto.setErrorLog(e.getMessage());
        }
        return responseDto;
    }
}
