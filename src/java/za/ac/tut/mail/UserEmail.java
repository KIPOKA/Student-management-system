/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.mail;

/**
 *
 * @author 27611
 */
//@ServletSecurity(@HttpConstraint(rolesAllowed={"admin"}))
public class UserEmail {
    private String email;
    private String text;

    public UserEmail(String email, String text) {
        this.email = email;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
