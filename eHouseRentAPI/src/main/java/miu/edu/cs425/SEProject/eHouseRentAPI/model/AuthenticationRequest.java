package miu.edu.cs425.SEProject.eHouseRentAPI.model;

import java.io.Serializable;

public class AuthenticationRequest  implements Serializable {


    private String userName;
    private String passWord;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String userName, String passWord) {
        this.setUserName(userName);
        this.setPassWord(passWord);
    }

}
