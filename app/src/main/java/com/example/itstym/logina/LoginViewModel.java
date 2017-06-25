package com.example.itstym.logina;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by itstym on 22/6/17.
 */

public class LoginViewModel extends BaseObservable {

    //for hint
    private String emailHint;
    private String passwordHint;

    //edittext Data
    private String userEmailAddress;
    private String userPassword;

    //for errors
    private String errorEmail;
    private String errorPassword;

    //button
    private String loginButtonText;


    public LoginViewModel(String emailHint, String passwordHint, String loginButtonText){
        this.emailHint=emailHint;
        this.passwordHint=passwordHint;
        this.loginButtonText=loginButtonText;
    }

    //getter and setter


    public String getEmailHint() {
        return emailHint;
    }

    public void setEmailHint(String emailHint) {
        this.emailHint = emailHint;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    public void setUserEmailAddress(String userEmailAddress) {
        this.userEmailAddress = userEmailAddress;

        /* To get value of edittext enterd by user, This Updates the value of userEmail on Every LEtter Entered by User*/
        notifyPropertyChanged(R.id.user_email_address);

        notifyPropertyChanged(BR.errorEmail);
    }

    @Bindable
    public String getErrorEmail() {

        if (userEmailAddress==null){
            return "Please enter email id";
        }else {

            if (!isEmailValid(userEmailAddress))
                return "Enter valid email id.";
            else
                return null;
        }
    }

    private boolean isEmailValid(String emailId){

        Pattern emailPattern= Patterns.EMAIL_ADDRESS;
        Matcher matcher=emailPattern.matcher(emailId);

        return matcher.matches();
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
         /* To get value of edittext enterd by user, This Updates the value of userEmail on Every LEtter Entered by User*/
        notifyPropertyChanged(R.id.user_password);

        notifyPropertyChanged(BR.errorPassword);

    }

    @Bindable
    public String getErrorPassword() {

        if (userPassword==null)
            return "Please enter password";
        else if (userPassword.length()<8)
            return "Too short..!!";
        else
            return errorPassword;
    }

    public String getLoginButtonText() {
        return loginButtonText;
    }

    public void setLoginButtonText(String loginButtonText) {
        this.loginButtonText = loginButtonText;
    }


}
