package pojo;
// Generated Oct 6, 2019 9:18:57 PM by Hibernate Tools 4.3.1

import dao.login;
import java.util.List;
import javax.faces.bean.ManagedBean;




/**
 * TblAdmin generated by hbm2java
 */
@ManagedBean
public class TblAdmin  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;

    public TblAdmin() {
    }

    public TblAdmin(String username, String password) {
       this.username = username;
       this.password = password;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
public String login() {
        login udao = new login();
        List<TblAdmin> us = udao.getBy(username, password);
        if(us != null){
            username=us.get(0).username;
            password=us.get(0).password;
            
            return "tables";
        }
        return "index";
    }




}
















