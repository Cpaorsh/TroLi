package com.newspage.beans;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Sinhvien {
	
	private String msv;
	private String hoten;
	private String ngaysinh;
	private String lop;
	private String chucvu;
	private String dem;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "max")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "msv")
	private Drl drl;
	  
	public Drl getDrl() {
		return drl;
	}
	public void setDrl(Drl drl) {
		this.drl = drl;
	}
	
	
	public String getMsv() {
		return msv;
	}
	public void setMsv(String msv) {
		this.msv = msv;
	}
	
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}

	
	
	public String getDem() {
		return dem;
	}
	public void setDem(String dem) {
		this.dem = dem;
	}
}
