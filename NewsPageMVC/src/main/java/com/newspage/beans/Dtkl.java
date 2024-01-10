package com.newspage.beans;

public class Dtkl {
	private int mdt;
	private String tendt;
	private String mgv;
	private int idhk;
	private Giangvien giangvien;
	
	public Giangvien getGiangvien() {
		return giangvien;
	}
	public void setGiangvien(Giangvien giangvien) {
	    this.giangvien = giangvien;
	}
	
	public int getMdt() {    
	    return mdt;    
	}    
	public void setMdt(int mdt) {    
	    this.mdt = mdt;    
	}
	
	public String getTendt() {    
	    return tendt;    
	}    
	public void setTendt(String tendt) {    
	    this.tendt = tendt;    
	}
	
	public String getMgv() {    
	    return mgv;    
	}    
	public void setMgv(String mgv) {    
	    this.mgv = mgv;    
	}

	public int getIdhk() {    
	    return idhk;    
	}    
	public void setIdhk(int idhk) {    
	    this.idhk = idhk;    
	}

}
