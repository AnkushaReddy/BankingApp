/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.training.bankapp.managedbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author neeshukl
 */
@Named(value = "userLoginManagedBean")
@SessionScoped
public class UserLoginManagedBean implements Serializable {

    private String customerId;
    private String password;
    private String message;
    private String passwordChangedMessage;
    private String newPassword;
    private String confirmNewPassword;

    /**
     * Creates a new instance of UserLoginManagedBean
     */
    public UserLoginManagedBean() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPasswordChangedMessage() {
        return passwordChangedMessage;
    }

    public void setPasswordChangedMessage(String passwordChangedMessage) {
        this.passwordChangedMessage = passwordChangedMessage;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public String login() {
        if (this.customerId.equals("admin") && this.getPassword().equals("admin")) {
            this.message = "";
            this.passwordChangedMessage ="";
            HttpSession sess =  (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            sess.setAttribute("cutsomerId", customerId);
            
            return "success";
        } else {
            this.message = "Login Failed!";
            return "failure";
        }
    }

    public String changePassword() {
        if (!this.newPassword.equals(this.confirmNewPassword)) {
            this.message = "Password don't match!!";
            return "failure";
        } else {
            this.passwordChangedMessage = "Password Changed Successfully.";
            this.message = "";
            return "success";
        }
    }
    
    public String forgotPassword(){
        if(this.customerId == null || this.customerId.equals(""))
        {
            this.message = "Please provide customer id and click on forgot password!";
            return "failure";
        }
        else
        {
            this.message = "";
            return "success";
        }
        
    }
    
    public String onLoad()
    {
        this.message = "Welcome";
        this.passwordChangedMessage = "";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String logout()
    {
        this.message = "";
        this.passwordChangedMessage = "";
        final HttpServletRequest request= 
                (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession(false).invalidate();
        return "/index.xhtml?faces-redirect=true";
    }

}
