
package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name")
    private String userName;
    
    @Column(name = "email")
    private String userEmail;
    
    @Column(name = "subject")
    private String userSubject;
    
    @Column(name = "message")
    private String userMessage;



    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserEmail() {
        return userEmail;
    }


    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getUserSubject() {
        return userSubject;
    }


    public void setUserSubject(String userSubject) {
        this.userSubject = userSubject;
    }


    public String getUserMessage() {
        return userMessage;
    }


    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
    
    
    
}


