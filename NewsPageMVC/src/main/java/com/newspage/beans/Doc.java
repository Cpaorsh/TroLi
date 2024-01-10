package com.newspage.beans;

import java.sql.Blob;
import java.sql.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class Doc {
	private int id;    
	private String title; 
	private Date datec;
	private String bytefi;
	private Blob hexfi;
	private CommonsMultipartFile filed;
	private String namefi;
	    
	public int getId() {    
	    return id;    
	}    
	public void setId(int id) {    
	    this.id = id;    
	}    
	public String getTitle() {    
	    return title;    
	}    
	public void setTitle(String title) {    
	    this.title = title;    
	}    

	public Date getDatec() {    
	    return datec;    
	}    
	public void setDatec(Date datec) {    
	    this.datec = datec;    
	}
	
	
	public String getBytefi() {
        return bytefi;
    }
    public void setBytefi(String bytefi) {
        this.bytefi = bytefi;
    }
	public Blob getHexfi() {
        return hexfi;
    }
    public void setHexfi(Blob hexfi) {
        this.hexfi = hexfi;
    }
    public CommonsMultipartFile getFiled() {
        return filed;
    }
    public void setFiled(CommonsMultipartFile filed) {
        this.filed = filed;
    }
    public String getNamefi() {    
	    return namefi;    
	}    
	public void setNamefi(String namefi) {    
	    this.namefi = namefi;    
	}

}

