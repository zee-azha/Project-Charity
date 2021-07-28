/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.chairty;
import pojo.TblAdmin;

/**
 *
 * @author Zeezha
 */
public class login {
    public List<TblAdmin> getBy(String uName, String uPass){
       TblAdmin u = new TblAdmin() ;
       List<TblAdmin> admin = new ArrayList();
         Transaction trans = null;
         Session session = chairty.getSessionFactory().openSession();
         try{
             trans = session.beginTransaction();
             Query query = session.createQuery("from TblAdmin where username = :uName AND password = :uPass");
             query.setString("uName",uName);
             query.setString("uPass",uPass);
             u =(TblAdmin) query.uniqueResult();
             admin = query.list();
                     trans.commit();
             
                     }
         catch(Exception e){
             System.out.println("Error:  " +e);
             
                     
         } return admin;
    }

  

    
}

    

