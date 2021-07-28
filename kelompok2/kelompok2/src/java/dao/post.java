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
import pojo.chairty;

/**
 *
 * @author Zeezha
 */
public class post {
     public void addPost(TblPost plg) {
 Transaction trans = null;
 Session session = chairty.getSessionFactory().openSession();
 try {
 trans = session.beginTransaction();
 session.save(plg);
 trans.commit();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
     public void deletePelanggan(String idP) {
 Transaction trans = null;
 Session session = chairty.getSessionFactory().openSession();
 try {
 trans = session.beginTransaction();
 TblPost pst = (TblPost) session.load(TblPost.class, new
String(idP));
 session.delete(pst);
 trans.commit();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }

public List<TblPost> getbyID(String idP) {
 TblPost pst = new TblPost();
 List<TblPost> lPlg = new ArrayList();
 
 Transaction trans = null;
 Session session = chairty.getSessionFactory().openSession();
 try {
 trans = session.beginTransaction();
 Query query = session.createQuery("from TblPost where id= :id");
 
 query.setString("id", idP);
 pst = (TblPost) query.uniqueResult();
 lPlg = query.list();
 trans.commit();
 } catch (Exception e) {
 }
 return lPlg;
 }
 public List<TblPost> retrieveTblPost() {
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
 public void update(TblPost plg) {
 Transaction trans = null;
 Session session = chairty.getSessionFactory().openSession();
 try { trans = session.beginTransaction();
 session.update(plg);
 trans.commit();
 } catch (Exception e) {
 }
 }
} 
    

