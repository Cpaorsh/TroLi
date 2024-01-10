package com.newspage.beans;


public class Drl {
 
	  private int msv;
	  private String tthai;
	  private int ythuc;
	  private int clbhoc;
	  private int quyche;
	  private int vuotkho;
	  private int hoctap;
	  private int tsvgioi;
	  private int kqchaphanh;
	  private int tgngoaikhoa;
	  private int dangnn;
	  private int bieuduong;
	  private int giupdo;
	  private int tgdoanhoi;
	  private int tongdiem;
	  
	  private int ltythuc;
	  private int ltclbhoc;
	  private int ltquyche;
	  private int ltvuotkho;
	  private int lthoctap;
	  private int lttsvgioi;
	  private int ltkqchaphanh;
	  private int lttgngoaikhoa;
	  private int ltdangnn;
	  private int ltbieuduong;
	  private int ltgiupdo;
	  private int lttgdoanhoi;
	  private int lttongdiem;
	  
	  private int gvythuc;
	  private int gvclbhoc;
	  private int gvquyche;
	  private int gvvuotkho;
	  private int gvhoctap;
	  private int gvtsvgioi;
	  private int gvkqchaphanh;
	  private int gvtgngoaikhoa;
	  private int gvdangnn;
	  private int gvbieuduong;
	  private int gvgiupdo;
	  private int gvtgdoanhoi;
	  private int gvtongdiem;

	  //@OneToOne(cascade = CascadeType.PERSIST)
	  //@JoinColumn(name = "msv")
	  private Sinhvien sinhvien;
	  
	  public Sinhvien getSinhvien() {
	    return sinhvien;
	  }
	  public void setSinhvien(Sinhvien sinhvien) {
	    this.sinhvien = sinhvien;
	  }
		
	  
	  
	public int getMsv() {
	  return msv;
	}
	
	public void setMsv(int msv) {
	  this.msv = msv;
	}

	public String getTthai() {    
	    return tthai;    
	}    
	public void setTthai(String tthai) {    
	    this.tthai = tthai;    
	}
		
	  public int getYthuc() {
		    return ythuc;
		  }

	  public void setYthuc(int ythuc) {
		    this.ythuc = ythuc;
		  }
	
	  public int getClbhoc() {
		    return clbhoc;
		  }

	  public void setClbhoc(int clbhoc) {
		    this.clbhoc = clbhoc;
		  }
	  
	  public int getQuyche() {
		    return quyche;
		  }

	  public void setQuyche(int quyche) {
		    this.quyche = quyche;
		  }

	  public int getVuotkho() {
		    return vuotkho;
		  }

	  public void setVuotkho(int vuotkho) {
		    this.vuotkho = vuotkho;
		  }

	  public int getHoctap() {
		    return hoctap;
		  }

	  public void setHoctap(int hoctap) {
		    this.hoctap = hoctap;
		  }

	  public int getTsvgioi() {
		    return tsvgioi;
		  }

	  public void setTsvgioi(int tsvgioi) {
		    this.tsvgioi = tsvgioi;
		  }

	  public int getKqchaphanh() {
		    return kqchaphanh;
		  }

	  public void setKqchaphanh(int kqchaphanh) {
		    this.kqchaphanh = kqchaphanh;
		  }

	  public int getTgngoaikhoa() {
		    return tgngoaikhoa;
		  }

	  public void setTgngoaikhoa(int tgngoaikhoa) {
		    this.tgngoaikhoa = tgngoaikhoa;
		  }

	  public int getDangnn() {
		    return dangnn;
		  }

	  public void setDangnn(int dangnn) {
		    this.dangnn = dangnn;
		  }

	  public int getBieuduong() {
		    return bieuduong;
		  }

	  public void setBieuduong(int bieuduong) {
		    this.bieuduong = bieuduong;
		  }

	  public int getGiupdo() {
		    return giupdo;
		  }

	  public void setGiupdo(int giupdo) {
		    this.giupdo = giupdo;
		  }

	  public int getTgdoanhoi() {
		    return tgdoanhoi;
		  }

	  public void setTgdoanhoi(int tgdoanhoi) {
		    this.tgdoanhoi = tgdoanhoi;
		  }

	  public int getTongdiem() {
		    return tongdiem;
		  }

	  public void setTongdiem(int tongdiem) {
		    this.tongdiem = tongdiem;
		  }
	  
	  //lop truong danh gia
	  public int getLtythuc() {
		    return ltythuc;
		  }

	  public void setLtythuc(int ltythuc) {
		    this.ltythuc = ltythuc;
		  }
	
	  public int getLtclbhoc() {
		    return ltclbhoc;
		  }

	  public void setLtclbhoc(int ltclbhoc) {
		    this.ltclbhoc = ltclbhoc;
		  }
	  
	  public int getLtquyche() {
		    return ltquyche;
		  }

	  public void setLtquyche(int ltquyche) {
		    this.ltquyche = ltquyche;
		  }

	  public int getLtvuotkho() {
		    return ltvuotkho;
		  }

	  public void setLtvuotkho(int ltvuotkho) {
		    this.ltvuotkho = ltvuotkho;
		  }

	  public int getLthoctap() {
		    return lthoctap;
		  }

	  public void setLthoctap(int lthoctap) {
		    this.lthoctap = lthoctap;
		  }

	  public int getLttsvgioi() {
		    return lttsvgioi;
		  }

	  public void setLttsvgioi(int lttsvgioi) {
		    this.lttsvgioi = lttsvgioi;
		  }

	  public int getLtkqchaphanh() {
		    return ltkqchaphanh;
		  }

	  public void setLtkqchaphanh(int ltkqchaphanh) {
		    this.ltkqchaphanh = ltkqchaphanh;
		  }

	  public int getLttgngoaikhoa() {
		    return lttgngoaikhoa;
		  }

	  public void setLttgngoaikhoa(int lttgngoaikhoa) {
		    this.lttgngoaikhoa = lttgngoaikhoa;
		  }

	  public int getLtdangnn() {
		    return ltdangnn;
		  }

	  public void setLtdangnn(int ltdangnn) {
		    this.ltdangnn = ltdangnn;
		  }

	  public int getLtbieuduong() {
		    return ltbieuduong;
		  }

	  public void setLtbieuduong(int ltbieuduong) {
		    this.ltbieuduong = ltbieuduong;
		  }

	  public int getLtgiupdo() {
		    return ltgiupdo;
		  }

	  public void setLtgiupdo(int ltgiupdo) {
		    this.ltgiupdo = ltgiupdo;
		  }

	  public int getLttgdoanhoi() {
		    return lttgdoanhoi;
		  }

	  public void setLttgdoanhoi(int lttgdoanhoi) {
		    this.lttgdoanhoi = lttgdoanhoi;
		  }

	  public int getLttongdiem() {
		    return lttongdiem;
		  }

	  public void setLttongdiem(int lttongdiem) {
		    this.lttongdiem = lttongdiem;
		  }
	  
	  //giang vien danh gia
	  public int getGvythuc() {
		    return gvythuc;
		  }

	  public void setGvythuc(int gvythuc) {
		    this.gvythuc = gvythuc;
		  }
	
	  public int getGvclbhoc() {
		    return gvclbhoc;
		  }

	  public void setGvclbhoc(int gvclbhoc) {
		    this.gvclbhoc = gvclbhoc;
		  }
	  
	  public int getGvquyche() {
		    return gvquyche;
		  }

	  public void setGvquyche(int gvquyche) {
		    this.gvquyche = gvquyche;
		  }

	  public int getGvvuotkho() {
		    return gvvuotkho;
		  }

	  public void setGvvuotkho(int gvvuotkho) {
		    this.gvvuotkho = gvvuotkho;
		  }

	  public int getGvhoctap() {
		    return gvhoctap;
		  }

	  public void setGvhoctap(int gvhoctap) {
		    this.gvhoctap = gvhoctap;
		  }

	  public int getGvtsvgioi() {
		    return gvtsvgioi;
		  }

	  public void setGvtsvgioi(int gvtsvgioi) {
		    this.gvtsvgioi = gvtsvgioi;
		  }

	  public int getGvkqchaphanh() {
		    return gvkqchaphanh;
		  }

	  public void setGvkqchaphanh(int gvkqchaphanh) {
		    this.gvkqchaphanh = gvkqchaphanh;
		  }

	  public int getGvtgngoaikhoa() {
		    return gvtgngoaikhoa;
		  }

	  public void setGvtgngoaikhoa(int gvtgngoaikhoa) {
		    this.gvtgngoaikhoa = gvtgngoaikhoa;
		  }

	  public int getGvdangnn() {
		    return gvdangnn;
		  }

	  public void setGvdangnn(int gvdangnn) {
		    this.gvdangnn = gvdangnn;
		  }

	  public int getGvbieuduong() {
		    return gvbieuduong;
		  }

	  public void setGvbieuduong(int gvbieuduong) {
		    this.gvbieuduong = gvbieuduong;
		  }

	  public int getGvgiupdo() {
		    return gvgiupdo;
		  }

	  public void setGvgiupdo(int gvgiupdo) {
		    this.gvgiupdo = gvgiupdo;
		  }

	  public int getGvtgdoanhoi() {
		    return gvtgdoanhoi;
		  }

	  public void setGvtgdoanhoi(int gvtgdoanhoi) {
		    this.gvtgdoanhoi = gvtgdoanhoi;
		  }

	  public int getGvtongdiem() {
		    return gvtongdiem;
		  }

	  public void setGvtongdiem(int gvtongdiem) {
		    this.gvtongdiem = gvtongdiem;
		  }
}
