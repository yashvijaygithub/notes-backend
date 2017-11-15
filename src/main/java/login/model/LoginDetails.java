package login.model;

import login.dto.UserDto;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by vijay on 28/9/17.
 */

@Document
public class LoginDetails {
    @Id
    private String userName;
    @NotNull
    private String password;
    private String nickName;
    @NotNull
    private String phone;
    private int age;
    @Email
    private String email;
    @NotNull
    private String gender;
    private Date dateOfBirth;


    public LoginDetails(UserDto userDto){
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.nickName = userDto.getNickName();
        this.phone = userDto.getPhone();
        this.age = userDto.getAge();
        this.email = userDto.getEmail();
        this.gender = userDto.getGender();
        this.dateOfBirth = userDto.getDateOfBirth();
    }

    public LoginDetails(){

    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
