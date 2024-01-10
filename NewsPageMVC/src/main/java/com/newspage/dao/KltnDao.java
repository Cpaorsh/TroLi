package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Dtkl;
import com.newspage.beans.Giangvien;
import com.newspage.beans.Sinhvien;
import com.newspage.beans.Kltn;

public class KltnDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int addKltn(Kltn k){    
	    String sql="insert into kltn(msv, idhk) values('"+k.getMsv()+"',  '"+k.getIdhk()+"')";    
	    return template.update(sql);    
	} 
	public int duyetKltn(Kltn k){    
	    String sql="update kltn set duyet='"+k.getDuyet()+"', lidotc='"+k.getLidotc()+"' where msv="+k.getMsv()+"";    
	    return template.update(sql);    
	}
	public int updateKltn(Kltn s){    
	    String sql="update kltn set mdt='"+s.getMdt()+"', cstt='"+s.getCstt()+"' where msv="+s.getMsv()+"";    
	    return template.update(sql);    
	}    
	public int deleteKltn(String msv){    
	    String sql="delete from kltn where msv="+msv+"";    
	    return template.update(sql);    
	}  
	

	    
	public Kltn getKltnById(String msv){    
	    String sql="select * from kltn where msv=?";    
	    return template.queryForObject(sql, new Object[]{msv},new BeanPropertyRowMapper<Kltn>(Kltn.class)); 
	    //List<Kltn> kltn = template.query(sql, new BeanPropertyRowMapper<Kltn>(Kltn.class));
		//return kltn.size() > 0 ? kltn.get(0) : null;
	}
	
	public List<Kltn> getKltns(int id){    
	    return template.query("select * from kltn INNER JOIN sinhvien ON kltn.msv = sinhvien.msv left JOIN dtkl INNER JOIN giangvien ON dtkl.mgv = giangvien.mgv ON kltn.mdt = dtkl.mdt where kltn.idhk="+id+" and kltn.duyet=1 order by dtkl.tendt asc",new RowMapper<Kltn>(){    
	    public Kltn mapRow(ResultSet rs, int row) throws SQLException {    
	        	Kltn t=new Kltn();    
	        	t.setMsv(rs.getString(1));
	        	t.setMdt(rs.getString(2));       
	            t.setCstt(rs.getString(3));
	            t.setIdhk(rs.getInt(4));

	            Sinhvien s = new Sinhvien();
	            s.setHoten(rs.getString("sinhvien.hoten"));
	            s.setMsv(rs.getString("msv"));
	            s.setLop(rs.getString("sinhvien.lop"));
	            t.setSinhvien(s);           
	            
	            Dtkl d=new Dtkl(); 
	            d.setTendt(rs.getString("tendt"));
	            Giangvien g= new Giangvien();
	            g.setHoten(rs.getString("giangvien.hoten"));
	            g.setBomon(rs.getString("bomon"));
	            d.setGiangvien(g);          
	            t.setDtkl(d);
	             
	            return t;    
	        }    
	    });    
	}
	
	public List<Kltn> getKltnsbyGv(int id, String mgv){    
	    return template.query("select * from kltn INNER JOIN sinhvien ON kltn.msv = sinhvien.msv left JOIN dtkl INNER JOIN giangvien ON dtkl.mgv = giangvien.mgv ON kltn.mdt = dtkl.mdt where kltn.idhk="+id+" and giangvien.mgv='"+mgv+"' and kltn.duyet=1 order by dtkl.tendt asc",new RowMapper<Kltn>(){    
	    public Kltn mapRow(ResultSet rs, int row) throws SQLException {    
	        	Kltn t=new Kltn();    
	        	t.setMsv(rs.getString(1));
	        	t.setMdt(rs.getString(2));       
	            t.setCstt(rs.getString(3));
	            t.setIdhk(rs.getInt(4));

	            Sinhvien s = new Sinhvien();
	            s.setHoten(rs.getString("sinhvien.hoten"));
	            s.setMsv(rs.getString("msv"));
	            s.setLop(rs.getString("sinhvien.lop"));
	            t.setSinhvien(s);           
	            
	            Dtkl d=new Dtkl(); 
	            d.setTendt(rs.getString("tendt"));
	            Giangvien g= new Giangvien();
	            g.setHoten(rs.getString("giangvien.hoten"));
	            g.setBomon(rs.getString("bomon"));
	            d.setGiangvien(g);          
	            t.setDtkl(d);
	             
	            return t;    
	        }    
	    });    
	}
	
	public List<Kltn> getKltnCd(){    
	    return template.query("select * from kltn INNER JOIN sinhvien ON kltn.msv = sinhvien.msv left JOIN dtkl INNER JOIN giangvien ON dtkl.mgv = giangvien.mgv ON kltn.mdt = dtkl.mdt where kltn.duyet=0",new RowMapper<Kltn>(){    
	    public Kltn mapRow(ResultSet rs, int row) throws SQLException {    
	        	Kltn t=new Kltn();    
	        	t.setMsv(rs.getString(1));
	        	t.setMdt(rs.getString(2));       
	            t.setCstt(rs.getString(3));
	            t.setIdhk(rs.getInt(4));

	            Sinhvien s = new Sinhvien();
	            s.setHoten(rs.getString("sinhvien.hoten"));
	            s.setMsv(rs.getString("msv"));
	            s.setLop(rs.getString("sinhvien.lop"));
	            t.setSinhvien(s);           
	             
	            return t;    
	        }    
	    });    
	}
	
	public List<Kltn> getKltnKd(){    
	    return template.query("select * from kltn INNER JOIN sinhvien ON kltn.msv = sinhvien.msv left JOIN dtkl INNER JOIN giangvien ON dtkl.mgv = giangvien.mgv ON kltn.mdt = dtkl.mdt where  kltn.duyet=2",new RowMapper<Kltn>(){    
	    public Kltn mapRow(ResultSet rs, int row) throws SQLException {    
	        	Kltn t=new Kltn();    
	        	t.setMsv(rs.getString(1));
	        	t.setMdt(rs.getString(2));       
	            t.setCstt(rs.getString(3)); 
	            t.setIdhk(rs.getInt(4));
	            t.setLidotc(rs.getString(5)); 

	            Sinhvien s = new Sinhvien();
	            s.setHoten(rs.getString("sinhvien.hoten"));
	            s.setMsv(rs.getString("msv"));
	            s.setLop(rs.getString("sinhvien.lop"));
	            t.setSinhvien(s);           
	             
	            return t;    
	        }    
	    });    
	}
}
