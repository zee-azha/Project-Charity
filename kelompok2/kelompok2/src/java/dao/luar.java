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
import pojo.TblLuar;
import pojo.TblPost;
import pojo.TblTransaction;
import pojo.chairty;

/**
 *
 * @author Zeezha
 */
public class luar {
     public void addluar(TblLuar plg) {
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
        public List<TblLuar> retrieveTblLuar() {
 List stud = new ArrayList();
 TblLuar stud1 = new TblLuar();
 Transaction luar = null;
 Session session = chairty.getSessionFactory().openSession();
 try {
luar = session.beginTransaction();
 Query query = session.createQuery("from TblLuar");
 stud = query.list();
 luar.commit();
 } catch (Exception e) {
 }
 return stud;
 }
    
}
