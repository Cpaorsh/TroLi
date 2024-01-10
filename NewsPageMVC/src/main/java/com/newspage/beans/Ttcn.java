package com.newspage.beans;

public class Ttcn {

	private String mdt;
	private String msv;
	private String cstt;
	private String duyet;
	private String lidotc;
	private int idhk;
	
	private Sinhvien sinhvien;
	private Dttt dttt;
	
	public Sinhvien getSinhvien() {
		return sinhvien;
	}
	public void setSinhvien(Sinhvien sinhvien) {
		this.sinhvien = sinhvien;
	}

	public Dttt getDttt() {
		return dttt;
	}
	public void setDttt(Dttt dttt) {
	    this.dttt = dttt;
	}
	
	
	public String getMdt() {    
	    return mdt;    
	}    
	public void setMdt(String mdt) {    
	    this.mdt = mdt;    
	}
	
	public String getCstt() {    
	    return cstt;    
	}    
	public void setCstt(String cstt) {    
	    this.cstt = cstt;    
	}
	
	public String getMsv() {    
	    return msv;    
	}    
	public void setMsv(String msv) {    
	    this.msv = msv;    
	}
	
	public String getDuyet() {    
	    return duyet;    
	}    
	public void setDuyet(String duyet) {    
	    this.duyet = duyet;    
	}
	
	public String getLidotc() {    
	    return lidotc;    
	}    
	public void setLidotc(String lidotc) {    
	    this.lidotc = lidotc;    
	}
	
	public int getIdhk() {    
	    return idhk;    
	}    
	public void setIdhk(int idhk) {    
	    this.idhk = idhk;    
	}

}
