package com.newspage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.newspage.beans.Dtkl;
import com.newspage.beans.Giangvien;

public class DtklDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	public int saveDt(Dtkl s){    
	    String sql="insert into dtkl(tendt, mgv, idhk) values('"+s.getTendt()+"', '"+s.getMgv()+"', '"+s.getIdhk()+"')";    
	    return template.update(sql);    
	}    
	public int updateDt(Dtkl s){    
	    String sql="update dtkl set tendt='"+s.getTendt()+"', idhk='"+s.getIdhk()+"' where mdt="+s.getMdt()+"";    
	    return template.update(sql);    
	}    
	public int deleteDt(String mdt){    
	    String sql="delete from dtkl where mdt="+mdt+"";    
	    return template.update(sql);    
	}   
	

	
	public Dtkl getDtById(String mdt){    
	    String sql="select * from dtkl where mdt=?";    
	    return template.queryForObject(sql, new Object[]{mdt},new BeanPropertyRowMapper<Dtkl>(Dtkl.class));    
	}
	
	public List<Dtkl> getDts(int id){    
	    return template.query("select * from dtkl LEFT JOIN giangvien ON dtkl.mgv = giangvien.mgv where idhk="+id+"",new RowMapper<Dtkl>(){    
	        public Dtkl mapRow(ResultSet rs, int row) throws SQLException {    
	        	Dtkl d=new Dtkl();    
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
	
	//de tai chua co sv dang ki
	public List<Dtkl> getDtcdks(int id){    
	    return template.query("select * from dtkl left JOIN kltn ON dtkl.mdt = kltn.mdt where kltn.mdt is null",new RowMapper<Dtkl>(){    
	        public Dtkl mapRow(ResultSet rs, int row) throws SQLException {    
	        	Dtkl d=new Dtkl();    
	            d.setMdt(rs.getInt(1));    
	            d.setTendt(rs.getString(2));    
	            d.setMgv(rs.getString(3));    
	            d.setIdhk(rs.getInt(4));
	            
	            return d;    
	        }    
	    });    
	}
	

	
	public List<Dtkl> getDtgvs(String mgv, int id){    
	    return template.query("select * from dtkl LEFT JOIN giangvien ON dtkl.mgv = giangvien.mgv where dtkl.mgv='"+mgv+"' and idhk ="+id+"",new RowMapper<Dtkl>(){    
	        public Dtkl mapRow(ResultSet rs, int row) throws SQLException {    
	        	Dtkl d=new Dtkl();    
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
