package pojo;
// Generated Oct 6, 2019 9:18:57 PM by Hibernate Tools 4.3.1


import dao.post;
import dao.trans;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;


/**
 * TblPost generated by hbm2java
 */
@ManagedBean

public class TblPost  implements java.io.Serializable {

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }


     private String id;
     private String user;
     private String judul;
     private String deskirpsi;
     private Integer danaTerkumpul;
     private Set tblTransactions = new HashSet(0);
     private String info;
     private String nilai;

    public TblPost() {
    }

	
    public TblPost(String  id, String user, String judul, String deskirpsi) {
        this.id = id;
        this.user = user;
        this.judul = judul;
        this.deskirpsi = deskirpsi;
    }
    public TblPost(String  id, String user, String judul, String deskirpsi, Integer danaTerkumpul, Set tblTransactions) {
       this.id = id;
       this.user = user;
       this.judul = judul;
       this.deskirpsi = deskirpsi;
       
       this.tblTransactions = tblTransactions;
    }
   
    public String  getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getUser() {
        return this.user;
    }
    
    public void setUser(String user) {
        this.user = user;
    }
    public String getJudul() {
        return this.judul;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getDeskirpsi() {
        return this.deskirpsi;
    }
    
    public void setDeskirpsi(String deskirpsi) {
        this.deskirpsi = deskirpsi;
    }
    public Integer getDanaTerkumpul() {
        return this.danaTerkumpul;
    }
    
    public void setDanaTerkumpul(Integer danaTerkumpul) {
        this.danaTerkumpul = danaTerkumpul;
    }
    public Set getTblTransactions() {
        return this.tblTransactions;
    }
    
    public void setTblTransactions(Set tblTransactions) {
        this.tblTransactions = tblTransactions;
    }



public void save() {
 post plg = new post();
 plg.addPost(this);
        setInfo("Sukses Menambah Data");
 } 

  public void delete() {
      
 post pst = new post();
 pst.deletePelanggan(id);
 user = ""; 
 judul="";
 deskirpsi="";
 id="";
 info = "sukses menghapus Data";
    }
public String getbyid(){
    try{
        post plg = new post ();
        List<TblPost> lPlg = plg.getbyID(id);
 user = lPlg.get(0).user;
 judul = lPlg.get(0).judul;
 deskirpsi = lPlg.get(0).deskirpsi;
 info = "Data Ditemukan";
 }
 catch(Exception ex) {
     
 id= "";
 user = "";
 judul ="";
 deskirpsi = "";
 info = "Data Tidak Ditemukan";
 }
 return "tables";
 }
public String reset() {
  id= "";
 user = "";
 judul ="";
 deskirpsi = "";
 return "tables";
 } 
public List<TblPost> getallrecords() {
 post plg = new post();
 List<TblPost> lPlg = plg.retrieveTblPost();
 return lPlg;
 } 
public void update() {
 post plg = new post();
 plg.update(this);
 user = "";
 judul = ""; 
 deskirpsi="";
id="";
info ="sukses mengupdate Data";
}
public String lihat(){
    FacesContext fc = FacesContext.getCurrentInstance();
    Map<String, String>Params = fc.getExternalContext().getRequestParameterMap();
    id = Params.get("paramName");
    this.getbyid();
    return"modCharity";
    
}

    /**
     * @return the nilai
     */
    public String getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

}


