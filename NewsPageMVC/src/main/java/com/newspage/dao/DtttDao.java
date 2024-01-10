package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Dttt;
import com.newspage.beans.Giangvien;

public class DtttDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int saveDt(Dttt s){    
	    String sql="insert into dttt(tendt, mgv, idhk) values('"+s.getTendt()+"', '"+s.getMgv()+"', '"+s.getIdhk()+"')";    
	    return template.update(sql);    
	}    
	public int updateDt(Dttt s){    
	    String sql="update dttt set tendt='"+s.getTendt()+"', idhk='"+s.getIdhk()+"' where mdt="+s.getMdt()+"";    
	    return template.update(sql);    
	}    
	public int deleteDt(String mdt){    
	    String sql="delete from dttt where mdt="+mdt+"";    
	    return template.update(sql);    
	}   
	

	
	public Dttt getDtById(String mdt){    
	    String sql="select * from dttt where mdt=?";    
	    return template.queryForObject(sql, new Object[]{mdt},new BeanPropertyRowMapper<Dttt>(Dttt.class));    
	}
	
	public List<Dttt> getDts(int id){    
	    return template.query("select * from dttt LEFT JOIN giangvien ON dttt.mgv = giangvien.mgv where idhk="+id+"",new RowMapper<Dttt>(){    
	        public Dttt mapRow(ResultSet rs, int row) throws SQLException {    
	        	Dttt d=new Dttt();    
	            d.setMdt(rs.getInt(1));    
	            d.setTendt(rs.getString(2));    
	            d.setMgv(rs.getString(3));    
	            d.setIdhk(rs.getInt(4));
	            
	            Giangvien g= new Giangvien();
	            g.setHoten(rs.getString("hoten"));
	            g.setBomon(rs.getString("bomon"));
	            d.setGiangvien(g);
	            
	            return d;    
	        }    
	    });    
	}
	
	// de tai chua full slot
	//SELECT dttt.mdt, dttt.tendt, COUNT(ttcn.mdt) FROM dttt LEFT JOIN ttcn ON ttcn.mdt = dttt.mdt where dttt.idhk=3 GROUP BY dttt.mdt having count(ttcn.mdt) <4;
	public List<Dttt> getDtcs(int id){    
	    return template.query("SELECT dttt.mdt, dttt.tendt, COUNT(ttcn.mdt) FROM dttt LEFT JOIN ttcn ON ttcn.mdt = dttt.mdt where dttt.idhk="+id+" GROUP BY dttt.mdt having count(ttcn.mdt)<4",new RowMapper<Dttt>(){    
	        public Dttt mapRow(ResultSet rs, int row) throws SQLException {    
	        	Dttt d=new Dttt();    
	            d.setMdt(rs.getInt(1));    
	            d.setTendt(rs.getString(2));     
	            return d;    
	        }    
	    });    
	}

	
	public List<Dttt> getDtgvs(String mgv, int id){    
	    return template.query("select * from dttt LEFT JOIN giangvien ON dttt.mgv = giangvien.mgv where dttt.mgv='"+mgv+"' and idhk="+id+"",new RowMapper<Dttt>(){    
	        public Dttt mapRow(ResultSet rs, int row) throws SQLException {    
	        	Dttt d=new Dttt();    
	            d.setMdt(rs.getInt(1));    
	            d.setTendt(rs.getString(2));    
	            d.setMgv(rs.getString(3));    
	            d.setIdhk(rs.getInt(4));
	            
	            Giangvien g= new Giangvien();
	            g.setHoten(rs.getString("hoten"));
	            g.setBomon(rs.getString("bomon"));
	            d.setGiangvien(g);
	            
	            return d;    
	        }    
	    });    
	}
}
