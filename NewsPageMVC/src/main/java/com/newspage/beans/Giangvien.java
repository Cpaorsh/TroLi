package com.newspage.beans;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Giangvien {

	private String mgv;
	private String hoten;
	private String ngaysinh;
	private String bomon;
	private String chucvu;
	private String lop;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "max")
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String getMgv() {
		return mgv;
	}
	public void setMgv(String mgv) {
		this.mgv = mgv;
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
	
	public String getBomon() {
		return bomon;
	}
	public void setBomon(String bomon) {
		this.bomon = bomon;
	}
	
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
}
