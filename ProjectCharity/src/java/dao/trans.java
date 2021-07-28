/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.TblPost;
import pojo.TblTransaction;
import pojo.chairty;

/**
 *
 * @author Zeezha
 */
public class trans {
    public void addtrans(TblTransaction plg) {
 Transaction da = null;
 Session session = chairty.getSessionFactory().openSession();
 try {
 da = session.beginTransaction();
 session.save(plg);
 da.commit();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
     public List<TblTransaction> retrieveTblPost() {
 List stud = new ArrayList();
 TblPost stud1 = new TblPost();
 Transaction trans = null;
 Session session = chairty.getSessionFactory().openSession();
 try {
 trans = session.beginTransaction();
 Query query = session.createQuery("from TblPost");
 stud = query.list();
 trans.commit();
 } catch (Exception e) {
 }
 return stud;
 }
}
